package io.github.jass2125.orderservice.controller;

import io.github.jass2125.orderservice.model.Order;
import io.github.jass2125.orderservice.model.OrderDTO;
import io.github.jass2125.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(value = "/{id}")
	public OrderDTO findById(@PathVariable("id") Long id) {
		return this.orderService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void sendOrder(@RequestBody Order order) {
		this.orderService.sendOrder(order);
	}

}
