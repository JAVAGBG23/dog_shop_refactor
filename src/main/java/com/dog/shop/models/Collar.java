package com.dog.shop.models;

import org.springframework.data.annotation.TypeAlias;

@TypeAlias("collarProduct")
public class Collar extends Product{
    private String size;
    private String material;

    public Collar() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
