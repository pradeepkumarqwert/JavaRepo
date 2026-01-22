package com.automation.P0andP1.BulkExecutions.Mobile;

import com.report.listener.ExtentReportManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Listeners(ExtentReportManager.class)
public class _03_Mobile_Browser_Parallel__Android {

    private static final String EXCEL_PATH = "C:\\Selenium Grid\\Excel\\AndroidAppBulkExecutionAndroid.xlsx";
    private static final String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=f37aa61d-7ea3-4356-90d5-cf65de8cb8c0&licenseId=LIC2026595&projectName=Automation+Testing/";

    private static final int TOTAL_ITERATIONS = 1;          // total iterations
    private static final int DEVICE_TIMEOUT_MINUTES = 4;    // max time per device execution

    @Test
    public void runTestsOnAllDevicesPeriodically() throws Exception {
        FileInputStream fis = new FileInputStream(new File(EXCEL_PATH));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        List<Device> devices = new ArrayList<>();
        int rowNum = sheet.getFirstRowNum() + 1; // skip header
        int lastRow = sheet.getLastRowNum();

        for (; rowNum <= lastRow; rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row == null) continue;

            String deviceName = getCellStringValue(row, 0);
            String platformName = getCellStringValue(row, 1);
            String platformVersion = getCellStringValue(row, 2);
            String app = getCellStringValue(row, 3);

            devices.add(new Device(deviceName, platformName, platformVersion, app));
        }

        workbook.close();
        fis.close();

        for (int iteration = 1; iteration <= TOTAL_ITERATIONS; iteration++) {
            System.out.println("\n=== Starting Iteration " + iteration + " ===");

            ExecutorService executor = Executors.newFixedThreadPool(devices.size());
            List<Future<?>> futures = new ArrayList<>();

            for (Device device : devices) {
                futures.add(executor.submit(() -> {
                    try {
                        runDirectTestSteps(device);
                    } catch (Exception e) {
                        System.out.println("Execution failed for device " + device.deviceName + ": " + e.getMessage());
                    }
                }));
            }

            // Wait for all devices with timeout individually
            for (int i = 0; i < futures.size(); i++) {
                Future<?> f = futures.get(i);
                Device device = devices.get(i);
                try {
                    f.get(DEVICE_TIMEOUT_MINUTES, TimeUnit.MINUTES); // max wait per device
                } catch (TimeoutException te) {
                    System.out.println("Timeout! Device " + device.deviceName + " took more than " + DEVICE_TIMEOUT_MINUTES + " mins. Marking as fail.");
                    f.cancel(true); // cancel task
                } catch (Exception e) {
                    System.out.println("Execution error for device " + device.deviceName + ": " + e.getMessage());
                }
            }

            executor.shutdownNow(); // ensure all threads are stopped
            System.out.println("=== Iteration " + iteration + " completed ===\n");
            // No fixed wait here: next iteration starts immediately
        }

        System.out.println("All iterations finished.");
    }

    private void runDirectTestSteps(Device device) throws Exception {
        AndroidDriver driver = null;
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(device.deviceName);
            options.setPlatformName(device.platformName);
            options.setPlatformVersion(device.platformVersion);
            options.setCapability("appium:browserName", "Chrome");
            options.setAutomationName("UiAutomator2");

            driver = new AndroidDriver(new URL(device_farm_hub_url), options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            driver.get("https://www.pantaloons.com/");
            System.out.println("Opened Pantaloons in mobile browser.");
            takeScreenshot(driver, "01_HomePage");

            Thread.sleep(30000);


            driver.findElement(By.cssSelector("div.mobilesearchbox")).click();
            System.out.println("Clicked.");
            takeScreenshot(driver, "02_After_Click_Search_Icon");

            Thread.sleep(5000);

            driver.findElement(By.xpath("//input[@placeholder='Search for products,brands and more...']")).sendKeys("Shirt");
            System.out.println("Entered.");
            takeScreenshot(driver, "03_After_Entering_Search");

            Thread.sleep(2000);

            driver.findElement(By.xpath("(//mark[text()='Shirt'])[1]")).click();
            System.out.println("Searched for item");
            takeScreenshot(driver, "04_After_Search_Result_Click");

            Thread.sleep(4000);
            driver.findElement(By.cssSelector("span.cartSpriteIcon")).click();
            System.out.println("Opened Cart");
            takeScreenshot(driver, "05_Cart_Page");

            System.out.println("Page Title: " + driver.getTitle());
        } finally {
            if (driver != null) driver.quit();
        }
    }

    public static void takeScreenshot(AndroidDriver driver, String fileName) {
        if (driver == null) return;
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\Selenium Grid\\Screenshots\\" + fileName + ".png");
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }

    private String getCellStringValue(Row row, int cellIndex) {
        Cell cell = row.getCell(cellIndex);
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC:
                double num = cell.getNumericCellValue();
                return num == Math.floor(num) ? String.valueOf((int) num) : String.valueOf(num);
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            default: return "";
        }
    }

    static class Device {
        String deviceName;
        String platformName;
        String platformVersion;
        String app;

        Device(String deviceName, String platformName, String platformVersion, String app) {
            this.deviceName = deviceName;
            this.platformName = platformName;
            this.platformVersion = platformVersion;
            this.app = app;
        }
    }
}
