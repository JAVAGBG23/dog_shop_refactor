package com.dog.shop.models;

import org.springframework.data.annotation.TypeAlias;

@TypeAlias("toyProduct")
public class Toy extends Product{
    private String type;

    public Toy() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
