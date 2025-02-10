package com.test.testtechnique.repository;

import com.test.testtechnique.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Product entity.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}