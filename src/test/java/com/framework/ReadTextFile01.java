package com.framework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTextFile01 {

    public static void main(String[] args) {

        System.out.println("System.getProperty(\"user.dir\"): " + System.getProperty("user.dir"));

        String filePath = System.getProperty("user.dir") + "/src/test/resources/sample.txt";

        System.out.println("Reading file: " + filePath);

        BufferedReader reader = null;

        // Checked Exception: IOException
        // Unchecked Exception: NullPointerException, ArrayIndexOutOfBoundsException,
        // ClassCastException
        // Runtime Exception: ArithmeticException, IllegalArgumentException,
        // IllegalStateException
        try {

            // Create a BufferedReader to read the file line by line
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            String line;
            // Read each line of the file
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}