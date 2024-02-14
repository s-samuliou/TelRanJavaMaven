package com.proftelran.org.thitryfour.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@HelloAnnotation(value = "Hello", greetTo = "Universe")
public class GettingAnnotation {

    @HelloAnnotation(value = "Hi", greetTo = "Alex")
    private void sayHi() {
        //
    }

    @HelloAnnotation(value = "Hello", greetTo = "Max")
    @ByeAnnotation(byeTo = "Max")
    public void sayHello() {
        //
    }
}
