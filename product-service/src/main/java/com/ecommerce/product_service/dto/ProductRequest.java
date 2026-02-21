package com.ecommerce.product_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private Long id;

    @NotNull
    @JsonProperty("productName")
    @Size(min=2, max = 30, message = "Product name characters should not exceed 20")
    private String productName;

    @NotNull
    private double price;

    @NotNull
    @Size(max = 30, message = "Description should not exceed 30 characters")
    private String description;
}
