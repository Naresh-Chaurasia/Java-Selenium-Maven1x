package com.utils.excel;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadTextFile {

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/sample.txt";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            int ch;
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }
}