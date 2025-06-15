package com.m1;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.se.helper.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Test11_GetTableDataDemo {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "/web/";

    @Test
    public void getTableData() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(PREFIX + "savings.html");

        WebElement table = driver.findElement(By.id("rates"));
        System.out.println("Table Data:");
        System.out.println(table.getText());

        System.out.println("Single row data:");
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println(rows.get(0).getText());

        System.out.println("Single cell data:");
        List<WebElement> cells = rows.get(1).findElements(By.tagName("td"));
        System.out.println(cells.get(0).getText());

        driver.quit();
    }

    // @Test
    public void scrapeTableData() {

        WebDriver driver = DriverFactory.newDriver();
        driver.get(PREFIX + "savings.html");

        Table<Integer, Integer, String> tableObj = HashBasedTable.create();

        WebElement table = driver.findElement(By.id("rates"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        int rowIndex = 0;
        int colIndex = 0;
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                tableObj.put(rowIndex, colIndex++, col.getText());
            }
            rowIndex++;
            colIndex = 0;
        }

        System.out.println(tableObj);
        System.out.println("Best rate: " + tableObj.get(1, 3));
        driver.quit();
    }

}
