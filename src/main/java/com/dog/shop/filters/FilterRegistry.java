package com.dog.shop.filters;

import com.dog.shop.models.Product;

import java.util.HashMap;
import java.util.Map;

public class FilterRegistry {
    private static final Map<Class<? extends Product>, Map<String, ProductFilter<Product>>> FILTERS = new HashMap<>();

    static {
        Map<String, ProductFilter<Product>> commonFilters = new HashMap<>();
        commonFilters.put("name", value -> product ->
                product.getName().toLowerCase().contains(value.toLowerCase()));
    }
}
