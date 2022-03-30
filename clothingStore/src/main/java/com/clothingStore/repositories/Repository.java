package com.clothingStore.repositories;

import java.util.List;

public interface Repository<T> {

    void addProduct(T product);

    List<T> getProducts();

}
