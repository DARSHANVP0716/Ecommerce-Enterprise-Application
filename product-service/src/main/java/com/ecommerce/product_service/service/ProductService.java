package com.ecommerce.product_service.service;

import com.ecommerce.product_service.Repository.ProductRepository;
import com.ecommerce.product_service.dto.ProductRequest;
import com.ecommerce.product_service.entity.ProductEntity;
import com.ecommerce.product_service.exception.ProductNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    //Add a new product to the database
    public Object addProduct(ProductRequest productRequest){
        //map request dto into entity using builder pattern
        ProductEntity productEntity = ProductEntity.builder()
                .id(productRequest.getId())
                .product_name(productRequest.getProductName())
                .price((productRequest.getPrice()))
                .description(productRequest.getDescription())
                .build();

        ProductEntity response = productRepository.save(productEntity);
        if (response.equals(null)) {
            return "Product not added";
        }
        return response;
    }


    //Get a product by id from the DB
    public Object getProductById(Long id){
        ProductEntity response = productRepository.findById(id).orElse(null);
        if (response.equals(null)) {
            log.warn("Product with id: {} not found", id);
            throw new ProductNotFound("Product with id " + id + " not found");
        }
        return response;
    }

}
