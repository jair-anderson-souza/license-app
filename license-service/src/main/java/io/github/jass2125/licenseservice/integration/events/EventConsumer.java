package io.github.jass2125.licenseservice.integration.events;

import io.github.jass2125.licenseservice.integration.kafka.KafkaPublisher;
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
        this.kafkaPublisher.handleNewOrder(licenseEvent.getLicense());
    }

}
