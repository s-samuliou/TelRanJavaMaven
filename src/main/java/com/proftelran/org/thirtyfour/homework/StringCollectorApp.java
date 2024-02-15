package com.proftelran.org.thirtyfour.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/*
1.В классы можно добавлять только аннотации над методами или полями и классам
Добавлять что-то еще нельзя.
2.Определять какие поля должны быть использованы в результате, можно только
по аннотациям. Аналогично , какой метод нужно вызвать только по аннотации.
3. instanceof _ не используем
4. Указывать явно имена классов или полей и методов - нельзя. Только по аннотации
Для того что бы понять есть ли там аннотация - используйте isAnnotationPresent
5. Должна быть только одна собственная аннотация для всех полей, классов и метода.
 */

public class StringCollectorApp {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        List<String> strings = Arrays.asList(
                "com.proftelran.org.thirtyfour.homework.StudentBE",
                "com.proftelran.org.thirtyfour.homework.StudentFE",
                "com.proftelran.org.thirtyfour.homework.StudentQA");

        List<AbstractStudent> studentList = new ArrayList<>();

        //Создаем список из 20 студентов с помощью reflection
        for ( int i = 0; i < 20; i++ ) {
            int index = ThreadLocalRandom.current().nextInt(0, 3);
            String className = strings.get(index);
            AbstractStudent student = (AbstractStudent) Class.forName(className).getDeclaredConstructor().newInstance();
            studentList.add(student);
        }

        //Здесь написать логику, которая переберет все объекты в списке
        //определит по аннотации к какому типу относится данный объект
        //(каждый класс помеченный аннотацией, должен иметь поле префикс в аннотации)
        StringBuilder studentsInformation = new StringBuilder();

        for (AbstractStudent student : studentList) {
            Class studentClass = student.getClass();

            Field[] declaredFields = studentClass.getDeclaredFields();

            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(StudentInformation.class)) {
                    field.setAccessible(true);

                    StudentInformation annotation = field.getAnnotation(StudentInformation.class);

                    String prefix = annotation.prefix();

                    studentsInformation
                            .append("Объект типа: ").append(studentClass.getSimpleName())
                            .append(" -> префикс из аннотации класса: ").append(prefix)
                            .append(" -> значение из поля: ").append(field.get(student))
                            .append('\n');
                }
            }
        }

        //Вся собранная информация должна добавиться в одну строку.
        //Например : из объекта типа StudentBE - берем префикс из аннотации класса + добавляем
        //значение из поля , которое должно быть помечено этой же аннотацией в классе
        //(внутри каждого класса прописано, какие поля нужно пометить и какой префикс должен быть)
        //что бы получить значение поля через reflection api - используем метод get у поля, в который
        //передаем тот объект у которого получаем. Не забывайте, если поли приватное, то нужно дать к нему доступ.

        //После того как вся информация из полей будет добавлена в результирующую строку, создать
        //объект типа Result и вызвать у него метод помеченный аннотацией.
        //в метод передать результирующую строку
        Result result = new Result();
        Class resClass = result.getClass();

        Method printStudentsInfo = resClass.getDeclaredMethod("printStudentsInfo", String.class);
        printStudentsInfo.setAccessible(true);
        printStudentsInfo.invoke(result, studentsInformation.toString());
    }
}