package com.proftelran.org.thirtyfour.reflection;

public class TestNewObject {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String name = Sample.class.getName();
        System.out.println(name);

        Class clazz = Class.forName(name);

        Sample sample = (Sample)clazz.newInstance();

        sample.methodOne();
    }
}
