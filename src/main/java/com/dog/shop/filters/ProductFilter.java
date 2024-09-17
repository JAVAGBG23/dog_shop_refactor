package com.dog.shop.filters;

import com.dog.shop.models.Product;

import java.util.function.Predicate;

@FunctionalInterface
public interface ProductFilter<T extends Product>{
    Predicate<T> apply(String value);
}
