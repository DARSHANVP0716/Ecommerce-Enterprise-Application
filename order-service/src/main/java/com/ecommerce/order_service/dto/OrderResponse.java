package com.ecommerce.order_service.dto;

import com.ecommerce.order_service.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private Long orderId;
    private Order order;
    private String status;
    private int quantity;
    private long totalPrice;
}
