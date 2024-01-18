package com.proftelran.org.lessontwentyfour;

public class ArrayApp {

    public static void main(String[] args) {
        ArrayOperation aop = new ArrayOperation();

        System.out.println("Max = " + aop.findMax(new int[]{1, 3, 4, 2, 7, 3}));
        System.out.println("Min = " + aop.findMin(new int[]{-1, 3, -4, 2, 7, -3}));
    }
}
