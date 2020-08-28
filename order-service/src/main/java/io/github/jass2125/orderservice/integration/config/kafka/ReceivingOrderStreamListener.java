package io.github.jass2125.orderservice.integration.config.kafka;

import io.github.jass2125.orderservice.model.License;
import io.github.jass2125.orderservice.model.Order;
import io.github.jass2125.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;


@Component
@EnableBinding(Processor.class)
public class ReceivingOrderStreamListener {

    @Autowired
    private OrderService orderService;

    @StreamListener(Processor.INPUT)
    public void handleNewOrder(License license) {
        System.out.println("License:" + license);
//        log.info("Receiving {}", license);
//        final var order = Order.builder().licenseId(license.getId()).status(StatusEnum.CREATED).build();
        this.orderService.sendOrder(new Order());
    }

}