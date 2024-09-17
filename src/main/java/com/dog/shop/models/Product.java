package com.dog.shop.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
// basklass
@Document(collection = "products")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "productType")
@JsonSubTypes({
       @JsonSubTypes.Type(value = Collar.class, name = "collar"),
        @JsonSubTypes.Type(value = Leash.class, name = "leash"),
        @JsonSubTypes.Type(value = Toy.class, name = "toy"),
        @JsonSubTypes.Type(value = Bowl.class, name = "bowl"),
})
public abstract class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private String color;
    private double price;
    private int stockQuantity;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
