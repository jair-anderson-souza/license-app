package io.github.jass2125.licenseservice.integration.events;

import io.github.jass2125.licenseservice.integration.kafka.producer.KafkaPublisher;
import io.github.jass2125.licenseservice.model.License;
import io.github.jass2125.licenseservice.model.LicenseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {

    @Autowired
    private KafkaPublisher kafkaPublisher;

    @Async
    @EventListener
    public void consumer(LicenseEvent licenseEvent){
        System.out.println("3 - License" + licenseEvent);
        this.kafkaPublisher.handleNewOrder(licenseEvent.getLicense());
    }

}
