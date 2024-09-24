package com.dog.shop.factory;

import com.dog.shop.models.Product;
import com.dog.shop.models.Toy;

import java.util.Map;

public class ToyFactory extends BaseProductFactory {

    @Override
    public Product createProduct(Map<String, Object> productDetails) {
        Toy toy = new Toy();
        toy.setType((String) productDetails.get("type"));
        configureCommonProductAttributes(toy, productDetails);
        return toy;
    }
}