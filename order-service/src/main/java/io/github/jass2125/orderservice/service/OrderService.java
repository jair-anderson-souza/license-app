package io.github.jass2125.orderservice.service;

import io.github.jass2125.orderservice.mapper.OrderMapper;
import io.github.jass2125.orderservice.model.Order;
import io.github.jass2125.orderservice.model.OrderDTO;
import io.github.jass2125.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void sendOrder(final Order order) {
        this.orderRepository.save(order);
    }

    public OrderDTO findById(Long id) {
        final var order = this.orderRepository.findById(id).orElse(null);
        return OrderMapper.INSTANCE.toDTO(order);
    }

}
