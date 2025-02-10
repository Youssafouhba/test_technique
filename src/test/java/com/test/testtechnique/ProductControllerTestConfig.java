package com.test.testtechnique;

import com.test.testtechnique.service.ProductService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class ProductControllerTestConfig {

    @Bean
    @Primary
    public ProductService productService() {
        return mock(ProductService.class);
    }
}