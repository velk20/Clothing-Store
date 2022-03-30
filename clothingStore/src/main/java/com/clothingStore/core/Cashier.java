package com.clothingStore.core;

import com.clothingStore.products.Product;

import java.util.List;

public interface Cashier {
    String receipt(List<Product> products, String date);
}
