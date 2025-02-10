package com.test.testtechnique;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.testtechnique.controller.ProductController;
import com.test.testtechnique.dto.ProductDTO;
import com.test.testtechnique.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@Import(ProductControllerTestConfig.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createProduct_ValidInput_ReturnsCreated() throws Exception {
        ProductDTO inputDto = new ProductDTO();
        inputDto.setName("Test Product");
        inputDto.setImage("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500&q=80");
        inputDto.setPrice(99.99);

        ProductDTO savedDto = new ProductDTO();
        savedDto.setId(1L);
        savedDto.setName("Test Product");
        savedDto.setImage("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500&q=80");
        savedDto.setPrice(99.99);

        when(productService.createProduct(any(ProductDTO.class))).thenReturn(savedDto);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Test Product"));
    }

    @Test
    public void getProduct_ExistingId_ReturnsProduct() throws Exception {
        ProductDTO dto = new ProductDTO();
        dto.setId(1L);
        dto.setName("Test Product");
        dto.setImage("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500&q=80");
        dto.setPrice(99.99);

        when(productService.getProduct(1L)).thenReturn(dto);

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Test Product"));
    }
}