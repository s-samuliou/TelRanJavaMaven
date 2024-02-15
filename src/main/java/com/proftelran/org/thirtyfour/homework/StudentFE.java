package com.proftelran.org.thirtyfour.homework;

//В данном классе должно быть получено только поле surname
//префикс FE
public class StudentFE extends AbstractStudent {

    private final String name;
    @StudentInformation(prefix = "FE")
    private final String surname;

    public StudentFE() {
        name = NameUtil.getRandomName();
        surname = NameUtil.getRandomName();
    }
}