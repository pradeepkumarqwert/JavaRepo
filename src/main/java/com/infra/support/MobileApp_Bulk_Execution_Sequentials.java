package com.infra.support;

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

@Listeners(ExtentReportManager.class)
public class MobileApp_Bulk_Execution_Sequentials {

    private static final String EXCEL_PATH = "C:\\Selenium Grid\\Excel\\CheckMobileAppExecution.xlsx";
    private static final String SELENIUM_HUB_URL = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=bc45e508-f7f7-4acd-a3b9-54568f9d8b7b&licenseId=LIC1026562&projectName=Web+Bulk+Execution/";

    @Test
    public void runTestsFromExcel() throws Exception {
        FileInputStream fis = new FileInputStream(new File(EXCEL_PATH));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int rowNum = sheet.getFirstRowNum() + 1; // skip header
        int lastRow = sheet.getLastRowNum();

        for (; rowNum <= lastRow; rowNum++) {
            Row row = sheet.getRow(rowNum);

            String deviceName = getCellStringValue(row, 0);
            String platformName = getCellStringValue(row, 1);
            String platformVersion = getCellStringValue(row, 2);
            String app = getCellStringValue(row, 3);
            int repeatCount = Integer.parseInt(getCellStringValue(row, 4));

            System.out.println("\n==============================");
            System.out.println("Executing Row: Device=" + deviceName + ", Platform=" + platformName + ", Version=" + platformVersion);
            System.out.println("==============================");

            // Sequential iterations for the row
            for (int i = 0; i < repeatCount; i++) {
                System.out.println("Iteration: " + (i + 1) + " of " + repeatCount);
                runDirectTestSteps(deviceName, platformName, platformVersion, app);
                System.out.println("Iteration " + (i + 1) + " completed.\n");
            }
        }

        workbook.close();
        fis.close();
    }

    private void runDirectTestSteps(String deviceName, String platformName, String platformVersion, String app) throws Exception {
        AndroidDriver driver = null;
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(deviceName);
            options.setPlatformName(platformName);
            options.setPlatformVersion(platformVersion);
            options.setApp(app);
            options.setAutomationName("UiAutomator2");

            driver = new AndroidDriver(new URL(SELENIUM_HUB_URL), options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Select country
            WebElement countryDropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']"))
            );
            countryDropdown.click();
            takeScreenshot(driver, deviceName + "_01_CountryDropdown_Click");
            Thread.sleep(1000);

            WebElement countryOption = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Afghanistan']"));
            countryOption.click();
            takeScreenshot(driver, deviceName + "_02_Country_Selected");

            // Enter name
            WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']"));
            nameField.sendKeys("Tester1");
            takeScreenshot(driver, deviceName + "_03_Name_Entered");
            driver.hideKeyboard();

            // Select gender
            driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioMale']")).click();
            takeScreenshot(driver, deviceName + "_04_Gender_Selected");

            // Click Lets Shop
            driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")).click();
            takeScreenshot(driver, deviceName + "_05_LetsShop_Clicked");
            Thread.sleep(2000);

            // Add product to cart
            driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
            takeScreenshot(driver, deviceName + "_06_Product_Added");
            Thread.sleep(1000);

            // Open Cart
            driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']")).click();
            takeScreenshot(driver, deviceName + "_07_Cart_Page");

            System.out.println("Test execution completed successfully for device: " + deviceName);

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
}
