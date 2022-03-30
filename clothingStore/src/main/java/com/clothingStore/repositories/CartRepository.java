package com.clothingStore.repositories;

import com.clothingStore.messages.ExceptionMessages;
import com.clothingStore.products.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartRepository implements Repository<Product>{
    private List<Product> products;

    public CartRepository() {
        this.products = new ArrayList<>();
    }


    @Override
    public void addProduct(Product product) {
        if (product == null) {
            throw new NullPointerException(ExceptionMessages.PRODUCT_CANT_BE_NULL);
        }

        this.products.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
