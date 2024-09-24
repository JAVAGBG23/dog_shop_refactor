package com.dog.shop.factory;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductFactoryProvider {
    private final Map<String, ProductFactory> factoryMap;

    public ProductFactoryProvider(){
        factoryMap = new HashMap<>();
        factoryMap.put("collar", new CollarFactory());
        factoryMap.put("leash", new LeashFactory());
        factoryMap.put("bowl", new BowlFactory());
        factoryMap.put("toy", new ToyFactory());
    }

    public ProductFactory getFactory(String productType) {
        ProductFactory factory = factoryMap.get(productType.toLowerCase());
        if(factory == null) {
            throw new IllegalArgumentException("Unknown product type: " + productType);
        }
        return factory;
    }
}








