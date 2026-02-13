package com.automation.P0andP1.BulkExecutions.Mobile;

import com.report.listener.ExtentReportManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
public class _01_Mobile_App_Parallel__Android {

    private static final String EXCEL_PATH = "C:\\Selenium Grid\\Excel\\AppBulkExecutionAndroid.xlsx";
    private static final String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=vK-JO6U-sXEZzMi5z7p3b6Q2RZkUv6ugZQm_Ap4eCAvIpdFtfF3AGEv6Uahw0U9XX2kz2rqdTTa6iHP-hDgOlMnutXrAxYkjAkaq_UglUWzVmFX7p2GldzbWG5jNTP_Xhf0lu6epgN_YBmq8UkSzczCPn9DgYO_zHwLIV2TXCQXDrKljzvNSz7hGRB9lT3LfKREmjbqv3gcNwPv5di1Wfk0VtA_4RIozgn6l_WTGZ8blrUFwf0lLVty0w7qYdG_dO6TL1f6cjCHOJJD99MLalNSNl9gzip1luJV7QpuH5ds_WDM_FofmCEwKscjCSDBT&licenseId=LIC2026658&projectName=Sanity_20012026/";

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
            options.setApp(device.app);
            options.setAutomationName("UiAutomator2");

            driver = new AndroidDriver(new URL(device_farm_hub_url), options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Test steps
            WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']")));
            countryDropdown.click();
            takeScreenshot(driver, device.deviceName + "_01_CountryDropdown_Click");
            Thread.sleep(1000);

            WebElement countryOption = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Afghanistan']"));
            countryOption.click();
            takeScreenshot(driver, device.deviceName + "_02_Country_Selected");

//            WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']"));
//            nameField.sendKeys("Tester1");
//            takeScreenshot(driver, device.deviceName + "_03_Name_Entered");
//            driver.hideKeyboard();
//
//            driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioMale']")).click();
//            takeScreenshot(driver, device.deviceName + "_04_Gender_Selected");
//
//            driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")).click();
//            takeScreenshot(driver, device.deviceName + "_05_LetsShop_Clicked");
//            Thread.sleep(2000);
//
//            driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
//            takeScreenshot(driver, device.deviceName + "_06_Product_Added");
//            Thread.sleep(1000);
//
//            driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']")).click();
//            takeScreenshot(driver, device.deviceName + "_07_Cart_Page");

            System.out.println("Execution completed successfully for device: " + device.deviceName);

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
