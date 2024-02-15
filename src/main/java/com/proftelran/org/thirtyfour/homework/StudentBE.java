package com.proftelran.org.thirtyfour.homework;

//В данном классе должно быть получено только поле name
//префикс BE

public class StudentBE extends AbstractStudent {

    @StudentInformation(prefix = "BE")
    private final String name;
    private final String surname;

    public StudentBE() {
        name = NameUtil.getRandomName();
        surname = NameUtil.getRandomName();
    }
}