package com.proftelran.org.thitryfour.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestGreatingAnnotation {

    public static void main(String[] args) {
        GettingAnnotation gettingAnnotation = new GettingAnnotation();

        Class cls = gettingAnnotation.getClass();

        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Annotation type: " + annotation.annotationType());
        }

        HelloAnnotation annotation = (HelloAnnotation) cls.getAnnotation(HelloAnnotation.class);
        System.out.println("Value = " + annotation.value());
        System.out.println("GreatTo = " + annotation.greetTo());

        try {
            Method method = cls.getDeclaredMethod("sayHi");
            annotation = method.getAnnotation(HelloAnnotation.class);
            System.out.println("Value in method = " + annotation.value());
            System.out.println("GretTo in method = " + annotation.greetTo());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        Method methodTwo = null;
        try {
            methodTwo = cls.getDeclaredMethod("sayHello");

            boolean annotationPresent = methodTwo.isAnnotationPresent(ByeAnnotation.class);

            if (annotationPresent) {
                ByeAnnotation byeAnnotation = methodTwo.getAnnotation(ByeAnnotation.class);
                System.out.println("Bye to = " + byeAnnotation.byeTo());
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
