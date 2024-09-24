package com.dog.shop.services;


import com.dog.shop.models.*;
import com.dog.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FilterProductService {
    private final ProductRepository productRepository;

    @Autowired
    public FilterProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> filterProducts (Map<String, String>params) {
        String productTypeAlias = getProductType(params.get("productType"));
        Class<? extends  Product> productClass = getProductClassFromAlias(productTypeAlias);

        return productRepository.findProductByCriteria(params, productClass);
    }



    // hjälpmetod för att avgöra produktens typ alias från ens sträng
    private String getProductType(String typeName) {
        if (typeName == null || typeName.isEmpty()) {
            return Product.class.getSimpleName();
        }
        switch(typeName.toLowerCase()) {
            case "collar":
                return Collar.class.getSimpleName();
            case "leash":
                return Leash.class.getSimpleName();
            case "toy":
                return Toy.class.getSimpleName();
            case "bowl":
                return Bowl.class.getSimpleName();
            default:
                throw new IllegalArgumentException("Unknown product type " + typeName);
        }
    }

    // hjälpmetod som hjälper till att hämta klassen från alias (FilterRegistry lookup)
    private Class<? extends Product> getProductClassFromAlias(String alias) {
        switch (alias) {
            case "Collar":
                return Collar.class;
            case "Leash":
                return Leash.class;
            case "Toy":
                return Toy.class;
            case "Bowl":
                return Bowl.class;
            default:
                return Product.class;
        }
    }
}






























