package com.proftelran.org.lessontwentyfour;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOperationTest {

    private ArrayOperation aop;

    @BeforeEach
    private void init() {
        aop = new ArrayOperation();
    }

    @Test
    public void testFindMax() {
        assertEquals(7, aop.findMax(1, 3, 4, 2, 7, 3));
        assertEquals(-1, aop.findMax(new int[]{-1, -3, -4, -2, -7, -3}));
    }

    @Test
    public void testFindMaxVersionTwo() {
        assertEquals(20, aop.findMax(10,15,20));
    }

    @Test
    public void testFindMin() {
        assertEquals(-4, aop.findMin(-1, 3, -4, 2, 7, -3));
        assertEquals(1, aop.findMin(1, 3, 4, 2, 7, 3));
    }

    @Test
    public void testFindMaxWhenArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> aop.findMax(null));
    }

    @Test
    public void testFindMinWhenArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> aop.findMin(null));
    }

    @AfterEach
    private void destroy() {
        aop = null;
    }
}