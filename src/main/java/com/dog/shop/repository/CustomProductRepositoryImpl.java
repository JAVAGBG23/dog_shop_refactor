package com.dog.shop.repository;

import com.dog.shop.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class CustomProductRepositoryImpl implements CustomProductRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    private static final Map<Class<? extends Product>, String> PRODUCT_TYPE_ALIAS_MAP = Map.of(
            Collar.class, "collarProduct",
            Leash.class, "leashProduct",
            Toy.class, "toyProduct",
            Bowl.class, "bowlProduct"
    );

    private String getProductTypeAlias(Class<? extends Product> productClass) {
        return PRODUCT_TYPE_ALIAS_MAP.getOrDefault(productClass, "product");
    }

    @Override
    public List<Product> findProductByCriteria(Map<String, String> filters, Class<? extends Product> productclass) {
        Query query = new Query();
        Criteria criteria = new Criteria();

        if(filters.containsKey("minPrice") || filters.containsKey("maxPrice")) {
            double minPrice = filters.containsKey("minPrice") ? Double.parseDouble(filters.get("minPrice"))
                    : Double.MIN_VALUE;
            double maxPrice = filters.containsKey("maxPrice") ? Double.parseDouble(filters.get("maxPrice"))
                    : Double.MAX_VALUE;

            criteria.and("price").gte(minPrice).lte(maxPrice);
        }

        Map<String, BiConsumer<Criteria, String>> filterHandlers = new HashMap<>();
        // gemensamma filter
        filterHandlers.put("name", (crit, value) -> crit.and("name").regex(value, "i"));

        filterHandlers.put("color", (crit, value) -> crit.and("color").is(value));

        // specifika filter för varje klass
        if(Collar.class.equals(productclass)) {
            filterHandlers.put("size", (crit, value) -> crit.and("size").is(value));
        }

        if(Leash.class.equals(productclass)) {
            filterHandlers.put("length", (crit, value) -> crit.and("length").is(Double.parseDouble(value)));
        }

        if(Leash.class.equals(productclass) || Collar.class.equals(productclass)) {
            filterHandlers.put("material", (crit, value) -> crit.and("material").is(value));
        }

        filters.forEach((key, value) -> {
            if(filterHandlers.containsKey(key)) {
                filterHandlers.get(key).accept(criteria, value);
            }
        });

        String producTypeAlias = getProductTypeAlias(productclass);
        criteria.and("_class").is(producTypeAlias);

        query.addCriteria(criteria);

        return mongoTemplate.find(query, (Class<Product>) productclass);
    }
}















