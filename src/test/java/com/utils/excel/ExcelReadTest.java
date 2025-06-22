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

    String dir = System.getProperty("user.dir") + "/src/test/resources";
    String excelPath = System.getProperty("user.dir") + "/src/test/resources/sample.xlsx";

    @Test
    void testRead() {
        System.out.println("Current Directory: " + dir);
    }

    @Test
    void testOpenWorkbook() {
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            assertNotNull(workbook);
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
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
    }

    @Test
    void testReadFirstRow() {
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(0);
            assertNotNull(row);
            List<String> rowValues = new ArrayList<>();
            for (Cell cell : row) {
                rowValues.add(cell.getStringCellValue());
            }
            assertEquals(List.of("Name", "Age", "City"), rowValues);
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
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
    }

    @Test
    void testReadSingleCell() {
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Cell cell = sheet.getRow(1).getCell(1); // B2: Age of Alice
            assertEquals(30, (int) cell.getNumericCellValue());
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
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
    }

    @Test
    void testReadColumn() {
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            List<String> names = new ArrayList<>();
            for (int i = 1; i <= 2; i++) {
                names.add(sheet.getRow(i).getCell(0).getStringCellValue());
            }
            assertEquals(List.of("Alice", "Bob"), names);
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
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
    }

    @Test
    void testSheetName() {
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            String sheetName = workbook.getSheetName(0);
            assertNotNull(sheetName);
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
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
    }
}
