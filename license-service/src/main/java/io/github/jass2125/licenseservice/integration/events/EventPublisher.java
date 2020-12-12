package io.github.jass2125.licenseservice.integration.events;

import io.github.jass2125.licenseservice.model.License;
import io.github.jass2125.licenseservice.model.LicenseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher implements ApplicationEventPublisherAware {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(final LicenseEvent licenseEvent) {
        System.out.println("2 - License: " + licenseEvent);
        this.applicationEventPublisher.publishEvent(licenseEvent);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}