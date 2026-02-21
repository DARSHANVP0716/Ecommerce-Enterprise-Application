package com.ecommerce.product_service.exception;

public class ProductNotFound extends RuntimeException {
        private String message;

        public ProductNotFound(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
}
