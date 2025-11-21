package com.scripts.resource;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ExcelScript {

    static String filePath = System.getProperty("user.dir") + "\\TestData.xlsx";

    public static void main(String[] args) throws IOException, InterruptedException {
        // STEP 1: Create Excel and write some test data
        writeExcelData();

        // STEP 2: Read data and perform web actions
        readAndRunTest();

        System.out.println("✅ Execution completed successfully!");
    }

    // Write sample search terms into Excel
    public static void writeExcelData() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("SearchData");

        String[] searchTerms = {"Selenium WebDriver", "TestNG Tutorial", "Apache POI Example", "Extent Reports"};

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Search Term");
        header.createCell(1).setCellValue("Page Title");

        for (int i = 0; i < searchTerms.length; i++) {
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(searchTerms[i]);
        }

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
        workbook.close();

        System.out.println("Excel file created with search terms");
    }

    // Read from Excel and perform Google searches
    public static void readAndRunTest() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("SearchData");

        String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=736d95c1-64e3-46ba-8f86-cf4086a93045&licenseId=LIC3943&projectName=Sanity/";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("130");
        WebDriver driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));



        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String searchTerm = row.getCell(0).getStringCellValue();

            // Perform Google Search
            driver.get("https://www.google.com");
            driver.findElement(By.name("q")).sendKeys(searchTerm);
            driver.findElement(By.name("q")).submit();
            Thread.sleep(2000);

            String pageTitle = driver.getTitle();
            System.out.println("Searched: " + searchTerm + " | Title: " + pageTitle);

            // Write page title back to Excel
            row.createCell(1).setCellValue(pageTitle);
        }

        // Save updated Excel
        fis.close();
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
        workbook.close();

        driver.quit();
    }
}
