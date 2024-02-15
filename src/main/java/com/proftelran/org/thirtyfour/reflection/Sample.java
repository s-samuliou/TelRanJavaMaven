package com.proftelran.org.thirtyfour.reflection;

public class Sample {

    private String sampleString;

    public Sample() {
        this.sampleString = "Java Reflection API";
    }

    public void methodOne() {
        System.out.println("Information in string: " + sampleString);
    }

    public void methodTwo(int digit) {
        System.out.println("Digit is: " + digit);
    }

    private void methodThree() {
        System.out.println("Call private method");
    }
}
