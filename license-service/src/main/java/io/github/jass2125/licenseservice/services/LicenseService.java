package io.github.jass2125.licenseservice.services;

import io.github.jass2125.licenseservice.mapper.LicenseMapper;
import io.github.jass2125.licenseservice.config.OrderFeignClient;
import io.github.jass2125.licenseservice.exceptions.LicenseNotFoundException;
import io.github.jass2125.licenseservice.integration.EventListener;
import io.github.jass2125.licenseservice.model.License;
import io.github.jass2125.licenseservice.model.LicenseDTO;
import io.github.jass2125.licenseservice.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    private OrderFeignClient orderFeignRepository;

    @Autowired
    private EventListener newOrderStreamListener;

    public List<LicenseDTO> findAll() {
        Iterable<License> iterable = this.licenseRepository.findAll();
        List<LicenseDTO> list = new ArrayList<>();

        iterable.forEach((license) -> { list.add(LicenseMapper.INSTANCE.toDTO(license)); });

        return list;
    }

    public LicenseDTO findById(Long id) {
        final var license = this.licenseRepository.findById(id);
        if (license.isEmpty()) {
            throw new LicenseNotFoundException("License not found");
        }
        final var l = license.get();
        final var orderDTO = this.orderFeignRepository.getOrder(id);

        var lic = new LicenseDTO();
        lic.setName(l.getName());
        lic.setOrderDTO(orderDTO);
        return lic;
    }


    public LicenseDTO save(final License license) {
        var lic = this.licenseRepository.save(license);
        this.newOrderStreamListener.handleNewOrder(lic);
        return LicenseMapper.INSTANCE.toDTO(lic);
    }
}

