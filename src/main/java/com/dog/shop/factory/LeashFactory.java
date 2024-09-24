package com.dog.shop.factory;

import com.dog.shop.models.Leash;
import com.dog.shop.models.Product;

import java.util.Map;

public class LeashFactory extends BaseProductFactory {

    @Override
    public Product createProduct(Map<String, Object> productDetails) {
        Leash leash = new Leash();
        leash.setLength((Double) productDetails.get("length"));
        leash.setMaterial((String) productDetails.get("material"));
        configureCommonProductAttributes(leash, productDetails);
        return leash;
    }
}
