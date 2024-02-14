package com.proftelran.org.thitryfour.annotation;

public class Main {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        //Самые основные
        //@Override
        //@Deprecated
        //@SuppressWarnings()
        //@FunctionalInterface
        //@SafeVarargs

        Child child = new Child();
        child.print();

        Parent parent = new Parent();
        parent.print();

        //Integer integer = new Integer(5);
    }
}
