package com.infra.support;

import com.report.listener.ExtentReportManager;
import io.appium.java_client.ios.IOSDriver;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
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
public class Mobile_Parallel_SetOf_Device_iOS_Simulators {

    private static final String EXCEL_PATH = "C:\\Selenium Grid\\Excel\\AndroidAppBulkExecutionSimulator.xlsx"; // update path
    private static final String DEVICE_FARM_HUB_URL = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=bc45e508-f7f7-4acd-a3b9-54568f9d8b7b&licenseId=LIC1026562&projectName=Bulk+Execution+Mobile/";
    private static final int TOTAL_ITERATIONS = 2;
    private static final int DEVICE_TIMEOUT_MINUTES = 4;

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
                    f.get(DEVICE_TIMEOUT_MINUTES, TimeUnit.MINUTES);
                } catch (TimeoutException te) {
                    System.out.println("Timeout! Device " + device.deviceName + " exceeded " + DEVICE_TIMEOUT_MINUTES + " mins. Cancelling.");
                    f.cancel(true);
                } catch (Exception e) {
                    System.out.println("Execution error for device " + device.deviceName + ": " + e.getMessage());
                }
            }

            executor.shutdownNow();
            System.out.println("=== Iteration " + iteration + " completed ===\n");
        }

        System.out.println("All iterations finished.");
    }

    private void runDirectTestSteps(Device device) throws Exception {
        IOSDriver driver = null;
        Actions act = null;
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", device.deviceName);
            caps.setCapability("platformName", device.platformName);
            caps.setCapability("appium:platformVersion", device.platformVersion);
            caps.setCapability("appium:app", device.app);
            caps.setCapability("appium:automationName", "XCUITest");
            caps.setCapability("appium:autoAcceptAlerts", true);
            caps.setCapability("appium:fullReset", true);

            driver = new IOSDriver(new URL(DEVICE_FARM_HUB_URL), caps);
            act = new Actions(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            Thread.sleep(50000);

            System.out.println("Execution completed successfully for device: " + device.deviceName);

        } finally {
            if (driver != null) driver.quit();
        }
    }

    public static void takeScreenshot(IOSDriver driver, String fileName) {
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
