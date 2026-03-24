package com.scripts.resource;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class RoughScript {

    AndroidDriver driver;


    @Test(invocationCount = 15)
    public void androidMainSteps() throws Exception {

        try {
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=IoSXgcnp1EZtUQxDMjZBnKRn--tSgRruqpAXT-hMho6g3dsGkU6kEmjmSA878nU1-ZjyMsTVF5g1FNS2HZOU6cK1g1rONHNcJTJspSOl9LYgo9E2cTDQmHmNwsRWufus7dgjmNdDQSmlp3jFbORNTzDtVL1DAsesr18Coi_wZfbS3s0zHR2hm2KHRYddPKWKLGh9htCqpYhghrXwpxgUWhD9wjmfJlNsJJcAkUjdEjXlRFgBaXaNmaApuAQdzm9p7y0LFEZVRyAu5e_T2tcYHrRNKu-dWQby-6AJwedt1-mcW9pPdBra7aasxjdOAu4&licenseId=LIC4139&projectName=05032026_DeviceBusy_Test/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Samsung Galaxy A12");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "12");
            caps.setCapability("appium:app", "General-Store-final (4).apk");
            caps.setCapability("appium:deviceType", "public");
            caps.setCapability("appium:isVirtual", false);
            driver = new AndroidDriver(new URL(device_farm_hub_url), caps);

            System.out.println("Execution Started");


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            Thread.sleep(3000);
            // 1. Select Country Dropdown
            driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']")).click();
            for(int i = 0; i<20; i++) {
                takeScreenshot("Step1_SelectCountryDropdown");
            }
            // 2. Select Country
//            Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Afghanistan']")).click();
            for(int i = 0; i<20; i++) {
                takeScreenshot("Step1_SelectCountryDropdown");
            }
            // 3. Enter Name
            WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']"));
            nameField.click();
            nameField.sendKeys("Tester1");
            for(int i = 0; i<20; i++) {
                takeScreenshot("Step1_SelectCountryDropdown");
            }
            driver.hideKeyboard();

            // 4. Select Gender
            driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioMale']")).click();
            for(int i = 0; i<20; i++) {
                takeScreenshot("Step1_SelectCountryDropdown");
            }
            // 5. Click Let's Shop
            driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")).click();
            takeScreenshot("Step5_ClickLetsShop");


        } catch (Exception e) {
            takeScreenshot("Step1_SelectCountryDropdown");
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (driver != null) {
                    driver.quit();
                    System.out.println("Driver quit successfully");
                }
            } catch (Exception e) {
                takeScreenshot("Step1_SelectCountryDropdown");
                System.out.println("driver did not closed");
                throw new RuntimeException(e);
            }

        }
    }



    public void takeScreenshot(String fileName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\Selenium Grid\\Screenshots\\" + fileName + ".png");
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Screenshot Failed: " + e.getMessage());
        }
    }
}