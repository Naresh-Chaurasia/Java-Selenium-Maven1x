package com.utils.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExcelReadTest {

    static String excelPath = "src/test/resources/sample.xlsx";
    String dir = System.getProperty("user.dir") + "/src/test/resources";

    @Test
    void testRead() {
        System.out.println("Current Directory: " + dir);
    }

    @Test
    void testReadExcel() {
        try (FileInputStream fis = new FileInputStream(excelPath);
                Workbook workbook = new XSSFWorkbook(dir + "/sample.xlsx")) {

            Sheet sheet = workbook.getSheetAt(0);

            // Read a row (first row)
            Row row = sheet.getRow(0);
            assertNotNull(row);
            List<String> rowValues = new ArrayList<>();
            for (Cell cell : row) {
                rowValues.add(cell.getStringCellValue());
            }
            assertEquals(List.of("Name", "Age", "City"), rowValues);

            // Read a cell (B2, which is Age of Alice)
            Cell cell = sheet.getRow(1).getCell(1);
            assertEquals(30, (int) cell.getNumericCellValue());

            // Read a column (all names)
            List<String> names = new ArrayList<>();
            for (int i = 1; i <= 2; i++) {
                names.add(sheet.getRow(i).getCell(0).getStringCellValue());
            }
            assertEquals(List.of("Alice", "Bob"), names);

        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException occurred: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
