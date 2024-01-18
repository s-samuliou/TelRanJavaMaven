package com.proftelran.org.lessontwentyfour;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach //буит вызван перед началом каждого теста
    private void init() {
        calculator = new Calculator();
        System.out.println("Call method init");
    }

    @Test
    public void testAdd() {
        //Calculator calculator = new Calculator();
        int expectedResult = 10;
        int realResult = calculator.add(5,5);

        Assertions.assertEquals(expectedResult, realResult);
    }

    @Test
    public void testSub() {
        //Calculator calculator = new Calculator();

        assertEquals(5, calculator.sub(10,5));
    }

    @AfterEach //буит вызван после окончания каждого теста
    private void destroy() {
        calculator = null;
    }
}