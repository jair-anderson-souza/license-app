package io.github.jass2125.licenseservice.services;

import io.github.jass2125.licenseservice.exceptions.LicenseNotFoundException;
import io.github.jass2125.licenseservice.integration.kafka.producer.KafkaPublisher;
import io.github.jass2125.licenseservice.integration.events.EventPublisher;
import io.github.jass2125.licenseservice.integration.feign.OrderFeignClient;
import io.github.jass2125.licenseservice.mapper.LicenseMapper;
import io.github.jass2125.licenseservice.model.License;
import io.github.jass2125.licenseservice.model.LicenseDTO;
import io.github.jass2125.licenseservice.model.LicenseEvent;
import io.github.jass2125.licenseservice.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;

import java.util.ArrayList;
import java.util.List;

@Service
public class LicenseService {

    @Autowired
    private EventPublisher eventPublisher;

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    private OrderFeignClient orderFeignRepository;



    @Cacheable(cacheNames = "License", key = "#root.method.name")
    public List<LicenseDTO> findAll() {
        Iterable<License> iterable = this.licenseRepository.findAll();
        List<LicenseDTO> list = new ArrayList<>();

        iterable.forEach((license) -> { list.add(LicenseMapper.INSTANCE.toDTO(license)); });

        return list;
    }

    @Cacheable(cacheNames = "License", key = "#id")
    public LicenseDTO findById(Long id) {
        final var license = this.licenseRepository.findById(id).orElseThrow(() -> new LicenseNotFoundException("License not found") );
        final var orderDTO = this.orderFeignRepository.getOrder(id);

        var licenseDTO = LicenseMapper.INSTANCE.toDTO(license);
        licenseDTO.setOrderDTO(orderDTO);
        return licenseDTO;
    }

    @CacheEvict(cacheNames = "License", allEntries = true)
    public LicenseDTO save(final License license) {
        var lic = this.licenseRepository.save(license);
        System.out.println("1 - License: " + lic);
        var licEvent = new LicenseEvent(license);
        this.eventPublisher.publish(licEvent);
//        this.eventPublisher.handleNewOrder(lic);
        return LicenseMapper.INSTANCE.toDTO(lic);
    }
}

