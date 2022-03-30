package com.clothingStore.products;

import com.clothingStore.enums.ShoeSize;

public class Shoe extends BaseProduct{
    public Shoe(String name, String brand, double price, String size, String color) {
        super(name, brand, price, size, color);
        this.setSize(size);
    }

    @Override
    protected void setSize(String size) {
        String sizeWithPrefix = "Size_" + size;
        ShoeSize shoeSize = ShoeSize.valueOf(sizeWithPrefix);
        super.setSize(shoeSize.name().split("_")[1]);

    }
}
