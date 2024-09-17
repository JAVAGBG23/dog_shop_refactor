package com.dog.shop.services;

import com.dog.shop.exceptions.ResourceNotFoundException;
import com.dog.shop.models.Product;
import com.dog.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService <T extends Product> {
   // innehålla basic crud operationer
    private final ProductRepository<T> productRepository;

    @Autowired
    public ProductService(ProductRepository<T> productRepository) {
        this.productRepository = productRepository;
    }

    // getAll
    public List<T> getAllProducts() {
        return productRepository.findAll();
    }

    // create
    public T createProduct(T product) {
        return productRepository.save(product);
    }

    // productById
    public Optional<T> getProductById(String id) {
        return productRepository.findById(id);
    }

    // update
    public T updateProduct(String id, T product) {
        if(!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id " + id);
        }
        product.setId(id);
        return productRepository.save(product);
    }

    // delete
    public void deleteProduct(String id) {
        if(!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id " + id);
        }
        productRepository.deleteById(id);
    }
}
































