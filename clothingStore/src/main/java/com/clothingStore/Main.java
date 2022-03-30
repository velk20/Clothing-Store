package com.clothingStore;

import com.clothingStore.core.Cashier;
import com.clothingStore.core.CashierImpl;
import com.clothingStore.products.*;
import com.clothingStore.repositories.CartRepository;
import com.clothingStore.repositories.Repository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Example #1
        /*
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

        List<Product> allCartProducts = cart.getProducts();
        String date = "2022-02-02 12:34:56";

        Cashier cashier = new CashierImpl();
        System.out.println(cashier.receipt(allCartProducts, date));
*/

        //Example #2
        /*

        Product shirt1 = new Shirt("Black Silk Shirt", "BrandS", 29.99, "L", "black");
        Product shirt2 = new Shirt("White Silk Shirt", "BrandS", 29.99, "L", "white");

        Repository<Product> cart = new CartRepository();
        cart.addProduct(shirt1);
        cart.addProduct(shirt2);

        List<Product> allCartProducts = cart.getProducts();
        String date = "2022-02-01 12:34:56";

        Cashier cashier = new CashierImpl();
        System.out.println(cashier.receipt(allCartProducts, date));

        */

        //Example #3

        Product shirt = new Shirt("White Linen Shirt", "BrandS", 29.99, "L", "white");
        Product trouser = new Trouser("Red Linen Trousers", "BrandT", 49.99, "56", "red");
        Product shoe = new Shoe("Red Suede Shoes", "BrandS", 59.99, "44", "red");
        Product shoe1 = new Shoe("Black Suede Shoes", "BrandS", 59.99, "44", "black");
        Product jacket = new Jacket("Red Linen Suit Jacket", "BrandJ", 99.99, "56", "red");

        Repository<Product> cart = new CartRepository();
        cart.addProduct(trouser);
        cart.addProduct(shoe);
        cart.addProduct(shoe1);
        cart.addProduct(jacket);
        cart.addProduct(shirt);

        List<Product> allCartProducts = cart.getProducts();
        String date = "2022-02-01 12:34:56";

        Cashier cashier = new CashierImpl();
        System.out.println(cashier.receipt(allCartProducts, date));


    }
}
