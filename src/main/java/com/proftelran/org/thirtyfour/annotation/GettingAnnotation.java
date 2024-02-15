package com.proftelran.org.thirtyfour.annotation;

@HelloAnnotation(value = "Hello", greetTo = "Universe")
public class GettingAnnotation {

    @HelloAnnotation(value = "Hi", greetTo = "Alex")
    private void sayHi() {
        //
    }

    @HelloAnnotation(value = "Hello", greetTo = "Max")
    @ByeAnnotation(byeTo = "Max")
    private void sayHello() {
        //
    }
}
