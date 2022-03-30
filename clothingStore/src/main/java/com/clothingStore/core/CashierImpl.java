package com.clothingStore.core;

import com.clothingStore.messages.OutputMessages;
import com.clothingStore.products.Product;
import com.clothingStore.products.Shirt;
import com.clothingStore.products.Shoe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CashierImpl implements Cashier {
    private static final int CALENDAR_CLASS_INDEX_OF_TUESDAY = 3;
    private static final int TUESDAY_SHIRTS_DISCOUNT = 10;
    private static final int TUESDAY_SHOES_DISCOUNT = 25;
    private static final int DISCOUNT_FOR_MORE_THAN_THREE_PRODUCTS = 20;
    private static final int INITIAL_PERCENTAGE_DISCOUNT = 0;

    private static double subtotalPrice = 0;
    private static double discountTotal = 0;
    

    @Override
    public String receipt(List<Product> products, String date) {
        StringBuilder stringBuilder = new StringBuilder();
        int percentageOfDiscount = INITIAL_PERCENTAGE_DISCOUNT;

        stringBuilder.append(OutputMessages.NEW_LINE);
        stringBuilder.append(String.format(OutputMessages.PRINT_DATE, date));
        stringBuilder.append(OutputMessages.NEW_LINE);

        stringBuilder.append(OutputMessages.PRINT_PRODUCTS_HEADER);
        stringBuilder.append(OutputMessages.NEW_LINE);
        stringBuilder.append(OutputMessages.NEW_LINE);

        for (Product product : products) {
            stringBuilder.append(product.toString());

            percentageOfDiscount = getPercentageOfDiscount(products, date, percentageOfDiscount, product);
            double discount = calculateDiscount(product,percentageOfDiscount);
            increaseTotalPrice(product);

            stringBuilder.append(String.format(OutputMessages.PRINT_DISCOUNT, percentageOfDiscount, discount));

            stringBuilder.append(OutputMessages.NEW_LINE);
            stringBuilder.append(OutputMessages.NEW_LINE);
        }
        stringBuilder.append(OutputMessages.SEPARATOR);
        stringBuilder.append(OutputMessages.NEW_LINE);

        stringBuilder.append(String.format(OutputMessages.PRINT_SUBTOTAL, subtotalPrice));
        stringBuilder.append(OutputMessages.NEW_LINE);
        stringBuilder.append(String.format(OutputMessages.PRINT_TOTAL_DISCOUNT, discountTotal));
        stringBuilder.append(OutputMessages.NEW_LINE);
        stringBuilder.append(OutputMessages.NEW_LINE);
        stringBuilder.append(String.format(OutputMessages.PRINT_TOTAL, subtotalPrice - discountTotal));


        return stringBuilder.toString();
    }

    private void increaseTotalPrice(Product product) {
        double productPrice = product.getPrice();
        subtotalPrice += productPrice;
    }

    private double calculateDiscount(Product product, int percentageOfDiscount) {
        double discountPrice = product.getPrice() * percentageOfDiscount / 100;
        discountTotal+=discountPrice;
        return discountPrice;
    }
    public int checkDiscountOfTuesday(Product product, String date) throws ParseException {

        int currentDiscount = 0;
        if (checkDayIsTuesday(date)) {
            if (product instanceof Shirt) {
                currentDiscount = TUESDAY_SHIRTS_DISCOUNT;
            } else if (product instanceof Shoe) {
                currentDiscount = TUESDAY_SHOES_DISCOUNT;
            }
        }
        return currentDiscount;
    }
    private int getPercentageOfDiscount(List<Product> products, String date, int percentageOfDiscount, Product product) {
        try {
             percentageOfDiscount = checkDiscountOfTuesday(product, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (products.size() >= 3) {
            if (percentageOfDiscount < DISCOUNT_FOR_MORE_THAN_THREE_PRODUCTS) {
                percentageOfDiscount = DISCOUNT_FOR_MORE_THAN_THREE_PRODUCTS;
            }
        }
        return percentageOfDiscount;
    }

    public boolean checkDayIsTuesday(String date) throws ParseException {
        Date currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        return dayOfWeek == CALENDAR_CLASS_INDEX_OF_TUESDAY;
    }


}
