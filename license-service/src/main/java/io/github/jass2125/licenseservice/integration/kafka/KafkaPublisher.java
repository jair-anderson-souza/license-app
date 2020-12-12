package io.github.jass2125.licenseservice.integration.kafka;

import io.github.jass2125.licenseservice.model.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Processor.class)
public class KafkaPublisher {

    @Autowired
    private Processor processor;

    public void handleNewOrder(final License license) {
        this.processor.output().send(MessageBuilder.withPayload(license).build());
    }

}