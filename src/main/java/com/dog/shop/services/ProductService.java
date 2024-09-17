package com.dog.shop.services;

import com.dog.shop.dto.ProductDTO;
import com.dog.shop.models.Product;
import com.dog.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(ProductDTO productDTO) {
        // Omvandla DTO till en Product-entity
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setColor(productDTO.getColor());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());

        // Kategorispecifika egenskaper
        product.setSize(productDTO.getSize());
        product.setMaterial(productDTO.getMaterial());
        product.setLength(productDTO.getLength());
        product.setType(productDTO.getType());
        product.setCapacity(productDTO.getCapacity());

        // Spara produkten i databasen
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Product> getProductsByColor(String color) {
        return productRepository.findByColor(color);
    }

    public List<Product> getProductsBySizeAndMaterial(String size, String material) {
        return productRepository.findBySizeAndMaterial(size, material);
    }

    public List<Product> getCollarsByLength(double length) {
        return productRepository.findByLength(length);
    }

    public List<Product> getToysByType(String type) {
        return productRepository.findByType(type);
    }

    public List<Product> getBowlsByCapacity(double capacity) {
        return productRepository.findByCapacity(capacity);
    }
}

