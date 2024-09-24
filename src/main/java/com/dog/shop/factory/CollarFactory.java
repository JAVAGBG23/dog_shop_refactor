package com.dog.shop.factory;

import com.dog.shop.models.Collar;
import com.dog.shop.models.Product;

import java.util.Map;

public class CollarFactory extends BaseProductFactory {

    @Override
    public Product createProduct(Map<String, Object> productDetails) {
        Collar collar = new Collar();
        collar.setSize((String) productDetails.get("size"));
        collar.setMaterial((String) productDetails.get("material"));
        configureCommonProductAttributes(collar, productDetails);
        return collar;
    }
}
