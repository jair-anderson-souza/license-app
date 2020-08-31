package io.github.jass2125.licenseservice.integration.feign;

import io.github.jass2125.licenseservice.model.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("order-service")
public interface OrderFeignClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/order/{orderId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    OrderDTO getOrder(@PathVariable("orderId") Long orderId);


}
