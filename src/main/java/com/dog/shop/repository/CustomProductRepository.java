package com.dog.shop.repository;

import com.dog.shop.models.Product;

import java.util.List;
import java.util.Map;

public interface CustomProductRepository {
    List<Product> findProductByCriteria(Map<String, String> filters, Class<? extends Product> productclass);
}
