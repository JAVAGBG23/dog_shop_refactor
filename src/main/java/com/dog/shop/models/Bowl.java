package com.dog.shop.models;

import org.springframework.data.annotation.TypeAlias;

@TypeAlias("bowlProduct")
public class Bowl extends Product{
    private double capacity;

    public Bowl() {
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
