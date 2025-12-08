package com.infra.support;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.report.listener.ExtentReportManager;
import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Listeners(ExtentReportManager.class)
public class InfraAdvancedClass {

    private static final String EXCEL_PATH = "C:\\Selenium Grid\\Excel\\EnviData.xlsx";
    private static final String device_farm_hub_url = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=bc45e508-f7f7-4acd-a3b9-54568f9d8b7b&licenseId=LIC1026562&projectName=Bulk+execution+Web/";
   

    @Test
    public void runTestsFromExcel() throws Exception {

        // Read Excel
        FileInputStream fis = new FileInputStream(new File(EXCEL_PATH));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int rowNum = sheet.getFirstRowNum() + 1; // skip header
        int lastRow = sheet.getLastRowNum();

        for (; rowNum <= lastRow; rowNum++) {
            Row row = sheet.getRow(rowNum);

            String os = getCellStringValue(row, 0);
            String browser = getCellStringValue(row, 1);
            String version = getCellStringValue(row, 2);
            int repeatCount = Integer.parseInt(getCellStringValue(row, 3));
            long timeout = Long.parseLong(getCellStringValue(row, 4));

            System.out.println("Executing Row: OS=" + os + ", Browser=" + browser + ", Version=" + version);

            // ExecutorService for parallel runs of this row
            ExecutorService executor = Executors.newFixedThreadPool(repeatCount);
            List<Future<?>> futures = new ArrayList<>();

            for (int i = 0; i < repeatCount; i++) {
                futures.add(executor.submit(() -> {
                    try {
                        runSingleTest(os, browser, version, timeout);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }));
            }

            // Wait for all parallel runs of this row to finish
            for (Future<?> f : futures) {
                f.get(); // waits for thread to complete
            }

            executor.shutdown();
            System.out.println("Completed Row: " + version + "\n");
        }

        workbook.close();
        fis.close();
    }

    private void runSingleTest(String os, String browser, String version, long timeout) throws Exception {
        long startTime = System.currentTimeMillis();
        WebDriver driver = null;

        try {
            if (browser.equalsIgnoreCase("Chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.setPlatformName(os);
                options.setBrowserVersion(version);
                driver = new RemoteWebDriver(new URL(device_farm_hub_url), options);
            } else if (browser.equalsIgnoreCase("Firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.setPlatformName(os);
                options.setBrowserVersion(version);
                driver = new RemoteWebDriver(new URL(device_farm_hub_url), options);
            } else if (browser.equalsIgnoreCase("Edge")) {
                EdgeOptions options = new EdgeOptions();
                options.setPlatformName(os);
                options.setBrowserVersion(version);
                driver = new RemoteWebDriver(new URL(device_farm_hub_url), options);
            } else if(browser.equalsIgnoreCase("Safari")){
                SafariOptions options = new SafariOptions();
                options.setPlatformName(os);
                options.setBrowserVersion(version);
                driver = new RemoteWebDriver(new URL(device_farm_hub_url), options);
            }

            driver.manage().window().setSize(new Dimension(1024, 768));

            Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
            System.out.println("Browser: " + caps.getBrowserName() +
                    ", Version: " + caps.getBrowserVersion() +
                    ", Platform: " + caps.getPlatformName());

            BaseMethodsCloud baseMethod = new BaseMethodsCloud(driver);
            BaseObjectsCloud baseObject = new BaseObjectsCloud(driver);
            BaseDataCloud baseData = new BaseDataCloud();
            PantaloonsLandingPage pantaloonsLandingPage = new PantaloonsLandingPage(driver);

            baseMethod.MaximizeBrowser(driver, "Browser is maximized");
            takeScreenshot(driver, "After_Load_" + version + "_" + Thread.currentThread().getId());

            Thread.sleep(2000); // demo step

        } finally {
            long elapsed = System.currentTimeMillis() - startTime;
            if (elapsed > timeout) {
                System.out.println("Test exceeded timeout of " + timeout + " ms! Quitting browser.");
            }
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public static void takeScreenshot(WebDriver driver, String fileName) {
        if (driver == null) return;
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\Selenium Grid\\Screenshots\\" + fileName + ".png");
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }

    // Utility to safely get cell value as string (handles numeric cells too)
    private String getCellStringValue(Row row, int cellIndex) {
        Cell cell = row.getCell(cellIndex);
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                // Remove decimal if whole number
                double numericValue = cell.getNumericCellValue();
                if (numericValue == Math.floor(numericValue)) {
                    return String.valueOf((int) numericValue);
                } else {
                    return String.valueOf(numericValue);
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
