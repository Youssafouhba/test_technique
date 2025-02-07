package com.test.testtechnique.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Price must be positive")
    private Double price;

    private String description;
}
