package com.clothingStore.products;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ShoeTest extends TestCase {
    private Shoe shoe;

    @Before
    public void setUp() {
        shoe = new Shoe("Shoe", "Addidas", 105.5, "44", "Blue");
    }

    @Test
    public void testSetSize() {
        shoe.setSize("44");
        assertEquals(shoe.getSize(), "44");
    }

}