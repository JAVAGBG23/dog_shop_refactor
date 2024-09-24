package com.dog.shop.repository;

import com.dog.shop.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>, CustomProductRepository {

}

