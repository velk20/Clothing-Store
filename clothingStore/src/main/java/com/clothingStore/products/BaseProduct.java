package com.clothingStore.products;

import com.clothingStore.messages.ExceptionMessages;

public abstract class BaseProduct implements Product{
    private String name;
    private String brand;
    private double price;
    private String size;
    private String color;

    public BaseProduct(String name, String brand, double price, String size, String color) {
        this.setName(name);
        this.setBrand(brand);
        this.setPrice(price);
        this.setSize(size);
        this.setColor(color);
    }

    protected void setName(String name) {
        if (name == null||name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRODUCT_NAME);
        }
        this.name = name;
    }

    protected void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRODUCT_BRAND);
        }
        this.brand = brand;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRODUCT_PRICE);
        }
        this.price = price;
    }

    protected  void setSize(String size){
        this.size = size;
    }

    protected void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRODUCT_COLOR);
        }
        this.color = color;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s - %s", this.getName(), this.getBrand()));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format("$%.2f", this.getPrice()));
        stringBuilder.append(System.lineSeparator());

        return stringBuilder.toString();
    }
}
