package com.test.testtechnique;


import com.test.testtechnique.dto.ProductDTO;
import com.test.testtechnique.entity.Product;
import com.test.testtechnique.exception.ResourceNotFoundException;
import com.test.testtechnique.mapper.ProductMapper;
import com.test.testtechnique.repository.ProductRepository;
import com.test.testtechnique.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Import(ProductServiceTestConfig.class)
public class ProductServiceTest {

    private ProductRepository productRepository;
    private ProductMapper productMapper;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productMapper = mock(ProductMapper.class);
        productService = new ProductService(productRepository, productMapper);
    }

    @Test
    public void createProduct_ValidInput_ReturnsCreatedProduct() {
        // Arrange
        ProductDTO inputDto = new ProductDTO();
        inputDto.setName("Test Product");
        inputDto.setPrice(99.99);

        Product product = new Product();
        product.setName("Test Product");
        product.setImage("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500&q=80");
        product.setPrice(99.99);

        Product savedProduct = new Product();
        savedProduct.setId(1L);
        savedProduct.setName("Test Product");
        savedProduct.setImage("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500&q=80");
        savedProduct.setPrice(99.99);

        ProductDTO expectedDto = new ProductDTO();
        expectedDto.setId(1L);
        expectedDto.setName("Test Product");
        expectedDto.setImage("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500&q=80");
        expectedDto.setPrice(99.99);

        when(productMapper.toEntity(inputDto)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(savedProduct);
        when(productMapper.toDto(savedProduct)).thenReturn(expectedDto);

        // Act
        ProductDTO result = productService.createProduct(inputDto);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Test Product", result.getName());
        assertEquals(99.99, result.getPrice());
    }

    @Test
    public void getProduct_NonExistingId_ThrowsException() {
        // Arrange
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> productService.getProduct(1L));
    }
}
