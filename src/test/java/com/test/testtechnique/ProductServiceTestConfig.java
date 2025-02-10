package com.test.testtechnique;

import com.test.testtechnique.mapper.ProductMapper;
import com.test.testtechnique.repository.ProductRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class ProductServiceTestConfig {

    @Bean
    @Primary
    public ProductRepository productRepository() {
        return mock(ProductRepository.class);
    }

    @Bean
    @Primary
    public ProductMapper productMapper() {
        return mock(ProductMapper.class);
    }
}
