package com.framework;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTest07 {

    // Provide 2D array data from Excel as a list of Arguments
    static List<Arguments> provideArrayData() {
        List<Arguments> data = new ArrayList<Arguments>();
        String excelPath = System.getProperty("user.dir") + "/src/test/resources/sample.xlsx";
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) {
                rowIterator.next(); // Skip header row
            }
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String name = row.getCell(0).getStringCellValue();
                int age = (int) row.getCell(1).getNumericCellValue();
                String city = row.getCell(2).getStringCellValue();
                data.add(Arguments.of(name, age, city));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file: " + e.getMessage(), e);
        } finally {
            try {
                if (workbook != null)
                    workbook.close();
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                // ignore
            }
        }
        return data;
    }

    @ParameterizedTest
    @MethodSource("provideArrayData")
    void testArrayData(String name, int age, String city) {
        assertNotNull(name);
        assertTrue(age > 0);
        assertNotNull(city);
        System.out.println(name + " | " + age + " | " + city);
    }
}