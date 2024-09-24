package com.dog.shop.factory;

import com.dog.shop.models.Product;

import java.util.Map;

public interface ProductFactory {
    Product createProduct(Map<String, Object> productDetails);
}
