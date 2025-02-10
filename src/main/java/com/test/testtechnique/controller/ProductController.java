package com.test.testtechnique.controller;

import com.test.testtechnique.dto.ProductDTO;
import com.test.testtechnique.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller pour les opérations CRUD sur les produits
 */
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:8081/")
public class ProductController {
    private final ProductService productService;

    // Méthode pour créer un produit
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO ProductDTO) {
        return new ResponseEntity<>(productService.createProduct(ProductDTO), HttpStatus.CREATED);
    }

    // Méthode pour récupérer un produit par ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    // Méthode pour récupérer tous les produits
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // Méthode pour mettre à jour un produit
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO ProductDTO) {
        return ResponseEntity.ok(productService.updateProduct(id, ProductDTO));
    }

    // Méthode pour supprimer un produit
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
