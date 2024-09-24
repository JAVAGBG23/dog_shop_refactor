package com.dog.shop.controllers;

import com.dog.shop.models.Product;
import com.dog.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Map<String, Object> productDetails) {
        try {
            String productType = (String) productDetails.get("productType");
            Product product = productService.createProduct(productType, productDetails);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

 /*   @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable String id) {
        Optional<Product> product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }*/

}







































