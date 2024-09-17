package com.dog.shop.repository;

import com.dog.shop.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository<T extends Product> extends MongoRepository<T, String> {
    @Query("{ '_class' : ?0 }")
    List<Product> findByProductType(String typeAlias);


}

