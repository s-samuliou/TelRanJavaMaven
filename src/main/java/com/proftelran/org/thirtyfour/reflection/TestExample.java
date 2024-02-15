package com.proftelran.org.thirtyfour.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestExample {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Sample sample = new Sample();

        Class cls = sample.getClass();
        System.out.println("Name of class " + cls.getName());

        Constructor constructor = cls.getConstructor();
        System.out.println("Constructor name is: " + constructor.getName());

        Method[] methods = cls.getMethods();
        System.out.println("\nPublic methods info:");
        Arrays.stream(methods).forEach(method -> {
            System.out.println("Method name is: " + method.getName());
        });

        Method methodTwo = cls.getDeclaredMethod("methodTwo", int.class);
        methodTwo.invoke(sample, 45);

        System.out.println("\nAll fields in class: ");
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
        }

        Field sampleString = cls.getDeclaredField("sampleString");
        sampleString.setAccessible(true);
        sampleString.set(sample, "Tel-Ran");

        Method methodOne = cls.getDeclaredMethod("methodOne");
        methodOne.invoke(sample);

        Method methodThree = cls.getDeclaredMethod("methodThree");
        methodThree.setAccessible(true);
        methodThree.invoke(sample);
    }
}
