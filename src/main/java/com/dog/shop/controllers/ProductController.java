package com.dog.shop.controllers;

import com.dog.shop.dto.ProductDTO;
import com.dog.shop.models.Product;
import com.dog.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);  // Vidarebefordra DTO till servicelagret
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/price")
    public List<Product> getProductsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/color/{color}")
    public List<Product> getProductsByColor(@PathVariable String color) {
        return productService.getProductsByColor(color);
    }

    @GetMapping("/size-material")
    public List<Product> getProductsBySizeAndMaterial(@RequestParam String size, @RequestParam String material) {
        return productService.getProductsBySizeAndMaterial(size, material);
    }

    @GetMapping("/length/{length}")
    public List<Product> getCollarsByLength(@PathVariable double length) {
        return productService.getCollarsByLength(length);
    }

    @GetMapping("/type/{type}")
    public List<Product> getToysByType(@PathVariable String type) {
        return productService.getToysByType(type);
    }

    @GetMapping("/capacity/{capacity}")
    public List<Product> getBowlsByCapacity(@PathVariable double capacity) {
        return productService.getBowlsByCapacity(capacity);
    }
}

