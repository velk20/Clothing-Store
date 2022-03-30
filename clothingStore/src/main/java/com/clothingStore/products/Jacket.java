package com.clothingStore.products;

import com.clothingStore.enums.JacketSize;

public class Jacket extends BaseProduct{
    public Jacket(String name, String brand, double price, String size, String color) {
        super(name, brand, price, size, color);
        this.setSize(size);

    }

    @Override
    protected void setSize(String size) {
        String sizeWithPrefix = "Size_" + size;
        JacketSize jacketSize = JacketSize.valueOf(sizeWithPrefix);
        super.setSize(jacketSize.name().split("_")[1]);

    }
}
