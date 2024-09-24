package com.dog.shop.factory;

import com.dog.shop.models.Product;

import java.util.Map;

public abstract class BaseProductFactory implements ProductFactory {
    protected void configureCommonProductAttributes(Product product, Map<String, Object> productDetails) {
        product.setName((String) productDetails.get("name"));
        product.setDescription((String) productDetails.get("description"));
        product.setPrice((Double) productDetails.get("price"));
        product.setStockQuantity((Integer) productDetails.get("stockQuantity"));
        product.setColor((String) productDetails.get("color"));
    }
}
