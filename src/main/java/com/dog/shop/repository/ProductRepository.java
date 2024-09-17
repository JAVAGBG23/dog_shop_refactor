package com.dog.shop.repository;

import com.dog.shop.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    // Sökning efter produktens namn (generisk)
    List<Product> findByName(String name);

    // Sökning efter produkter inom ett prisspann
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    // Sökning efter produkter baserat på färg
    List<Product> findByColor(String color);

    // Sökning efter halsband baserat på storlek och material
    List<Product> findBySizeAndMaterial(String size, String material);

    // Sökning efter koppel baserat på längd
    List<Product> findByLength(double length);

    // Sökning efter leksaker baserat på typ (e.g. ball, chew toy)
    List<Product> findByType(String type);

    // Sökning efter matskålar baserat på kapacitet
    List<Product> findByCapacity(double capacity);
}

