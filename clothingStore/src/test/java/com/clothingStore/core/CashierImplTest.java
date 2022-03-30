package com.clothingStore.core;

import com.clothingStore.products.*;
import com.clothingStore.repositories.CartRepository;
import com.clothingStore.repositories.Repository;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

public class CashierImplTest {
    private CashierImpl cashier;
    private  List<Product> allCartProducts;
    private String date;

    @Before
    public void setUp(){
        cashier = new CashierImpl();
        Product shirt1 = new Shirt("Blue Cotton Shirt", "BrandS", 14.99, "M", "blue");
        Product shirt2 = new Shirt("White Cotton Shirt", "BrandS", 15.99, "M", "white");
        Product trouser = new Trouser("Black Cotton Trousers", "BrandT", 29.99, "50", "black");
        Product shoe = new Shoe("Black Leather Shoes", "BrandS", 59.99, "43", "black");
        Product jacket = new Jacket("Black Cotton Suit Jacket", "BrandJ", 99.99, "50", "black");

        Repository<Product> cart = new CartRepository();
        cart.addProduct(shirt1);
        cart.addProduct(shirt2);
        cart.addProduct(trouser);
        cart.addProduct(shoe);
        cart.addProduct(jacket);

        allCartProducts = cart.getProducts();
         date = "2022-02-01 12:34:56";
    }

    @Test
    public void testCashierIfDayOfWeekIsTuesday() throws ParseException {

        assertTrue(cashier.checkDayIsTuesday(date));

    }

}