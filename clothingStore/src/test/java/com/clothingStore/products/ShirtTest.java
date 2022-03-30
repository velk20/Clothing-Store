package com.clothingStore.products;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ShirtTest extends TestCase {
    private Shirt shirt;

    @Before
    public void setUp() {
        shirt = new Shirt("Shirt", "Addidas", 105.5, "M", "Blue");
    }

    @Test
    public void testSetSize() {
        shirt.setSize("M");
        assertEquals(shirt.getSize(), "M");
    }
}