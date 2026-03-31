package com.ecommerce.order_service.service;

import com.ecommerce.order_service.client.ProductClient;
import com.ecommerce.order_service.dto.OrderRequest;
import com.ecommerce.order_service.dto.OrderResponse;
import com.ecommerce.order_service.dto.ProductResponse;
import com.ecommerce.order_service.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private ProductClient productClient;

    //Call the product service to get the product details for the orderID and return the order response
    public OrderResponse getOrders(OrderRequest orderRequest){
        // Call the product service or product client to get product details for the orderId
        ProductResponse productDetails = productClient.getProductById((orderRequest.getOrderId()));
        log.info("Product details for orderId {}: {}", orderRequest.getOrderId(), productDetails);

        Order order = Order.builder()
                .productId(productDetails.getId())
                .productName(productDetails.getProduct_name())
                .price(productDetails.getPrice())
                .description((productDetails.getDescription()))
                .build();

        OrderResponse orderResponse = OrderResponse.builder()
                .orderId(orderRequest.getOrderId())
                .order(order)
                .quantity(orderRequest.getQuantity())
                .status(order.getProductName()+" order data retrieved successfully")
                .totalPrice((long) (productDetails.getPrice() * orderRequest.getQuantity()))
                .build();

        return orderResponse;
    }

}
