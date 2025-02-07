package com.test.testtechnique.mapper;

import com.test.testtechnique.dto.ProductDTO;
import com.test.testtechnique.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(Product product);
    Product toEntity(ProductDTO productDto);
    void updateEntity(ProductDTO productDto, @MappingTarget Product product);
}