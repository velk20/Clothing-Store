package com.clothingStore.products;

import com.clothingStore.enums.TrouserSize;

public class Trouser extends BaseProduct{
    public Trouser(String name, String brand, double price, String size, String color) {
        super(name, brand, price, size, color);
        this.setSize(size);
    }

    @Override
    protected void setSize(String size) {
        String sizeWithPrefix = "Size_" + size;
        TrouserSize trouserSize = TrouserSize.valueOf(sizeWithPrefix);
        super.setSize(trouserSize.name().split("_")[1]);

    }
}
