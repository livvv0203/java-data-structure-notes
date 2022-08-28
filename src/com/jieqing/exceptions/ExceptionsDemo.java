package com.jieqing.exceptions;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsDemo {

    public static void show() {

        FileReader reader = null;

        try {
            reader = new FileReader("file.txt");
            System.out.println("File opened.");
        } catch(FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}








