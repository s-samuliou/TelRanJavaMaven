package com.proftelran.org.thirtythree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestHomework {

    public static void main(String[] args) {
        String pathToFile = "";

        try {
            FileInputStream fileInputStream = new FileInputStream(pathToFile);
            char[] buffer = new char[255];

            while (fileInputStream.available() > 0) {
                int count = fileInputStream.read();

                for (int i = 0; i < count; i++) {
                    char temp = buffer[i];

                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
