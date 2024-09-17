package com.dog.shop.dto;

public class ProductDTO {

    private String id;
    private String name;
    private String description;
    private String color;
    private double price;
    private int stockQuantity;

    // Specifika egenskaper för olika produktkategorier
    private String size;      // Halsband (Collar)
    private String material;  // Halsband och Koppel (Collar och Leash)
    private double length;    // Koppel (Leash)
    private String type;      // Leksak (Toy)
    private double capacity;  // Matskål (Bowl)

    // Constructors
    public ProductDTO() {}

    public ProductDTO(String id, String name, String description, String color, double price, int stockQuantity,
                      String size, String material, double length, String type, double capacity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.size = size;
        this.material = material;
        this.length = length;
        this.type = type;
        this.capacity = capacity;
    }

    // Getters and Setters

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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
