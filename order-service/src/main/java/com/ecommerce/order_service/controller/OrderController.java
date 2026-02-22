package com.ecommerce.order_service.controller;

import com.ecommerce.order_service.dto.OrderRequest;
import com.ecommerce.order_service.dto.OrderResponse;
import com.ecommerce.order_service.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/get-orders")
    public ResponseEntity<OrderResponse> getOrders(@Valid @RequestBody OrderRequest orderRequest) {
        log.info("Received order request: {}", orderRequest);
        OrderResponse orderResponse = orderService.getOrders(orderRequest);

        log.info("Returning order response: {}", orderResponse);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }
}
