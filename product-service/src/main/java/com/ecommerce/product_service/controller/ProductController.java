package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.dto.ProductRequest;
import com.ecommerce.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/add")
    public ResponseEntity<Object> addProduct(@Valid @RequestBody ProductRequest productRequest){
        Object response = productService.addProduct(productRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("findProductById/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id){
        log.info("Getting product with id: {}", id);
        Object response = productService.getProductById(id);

        log.info("Product with id: {} found: {}", id, response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
