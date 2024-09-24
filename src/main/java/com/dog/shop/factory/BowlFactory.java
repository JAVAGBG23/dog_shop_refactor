package com.dog.shop.factory;

import com.dog.shop.models.Bowl;
import com.dog.shop.models.Product;

import java.util.Map;

public class BowlFactory extends BaseProductFactory {

    @Override
    public Product createProduct(Map<String, Object> productDetails) {
        Bowl bowl = new Bowl();
        bowl.setCapacity((Double) productDetails.get("capacity"));
        configureCommonProductAttributes(bowl, productDetails);
        return bowl;
    }
}
