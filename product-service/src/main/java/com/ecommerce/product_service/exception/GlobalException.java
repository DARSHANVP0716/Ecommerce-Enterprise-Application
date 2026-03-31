package com.ecommerce.product_service.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ProductNotFound.class)
    public String handleProductNotFound(ProductNotFound ex) {
        return ex.getMessage();
    }

}
