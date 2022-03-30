package com.clothingStore.products;

import com.clothingStore.enums.ShirtSize;

public class Shirt extends BaseProduct{

    public Shirt(String name, String brand, double price, String size, String color) {
        super(name, brand, price, size, color);
        this.setSize(size);

    }

    @Override
    protected void setSize(String size) {
        String sizeWithPrefix = "Size_" + size;
        ShirtSize shirtSize = ShirtSize.valueOf(sizeWithPrefix);
        super.setSize(shirtSize.name().split("_")[1]);

    }
}
