package com.dog.shop.services;

import com.dog.shop.models.*;
import com.dog.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterProductService {
    private final ProductRepository<Product> productRepository;

    @Autowired
    public FilterProductService(ProductRepository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    // metod för att filtrera produkter baserat på parametrar


    // hjälpmetod för att avgöra produktens typ alias från ens sträng
    private String getProductType(String typeName) {
        if (typeName == null || typeName.isEmpty()) {
            return "product";
        }
        switch(typeName.toLowerCase()) {
            case "collar":
                return "collarProduct";
            case "leash":
                return "leashProduct";
            case "toy":
                return "toyProduct";
            case "bowl":
                return "bowlProduct";
            default:
                throw new IllegalArgumentException("Unknown product type " + typeName);
        }
    }

    // hjälpmetod för att hämta produkter by type alias
    private List<Product> fetchProductsByType (String productTypeAlias) {
        return productRepository.findByProductType(productTypeAlias);
    }

    // hjälpmetod som hjälper till att hämta klassen från alias (GilterRegistry lookup)
    private Class<? extends Product> getProductClassFromAlias(String alias) {
        switch (alias) {
            case "collarProduct":
                return Collar.class;
            case "leashProduct":
                return Leash.class;
            case "toyProduct":
                return Toy.class;
            case "bowlProduct":
                return Bowl.class;
            default:
                return Product.class;
        }
    }
}





























