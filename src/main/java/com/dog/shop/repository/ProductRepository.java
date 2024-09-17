package com.dog.shop.repository;

import com.dog.shop.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByName(String name);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Product> findByColor(String color);

    List<Product> findBySizeAndMaterial(String size, String material);

    List<Product> findByLength(double length);

    List<Product> findByType(String type);

    List<Product> findByCapacity(double capacity);
}

