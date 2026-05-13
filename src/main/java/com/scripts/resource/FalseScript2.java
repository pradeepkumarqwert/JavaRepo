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

public class FalseScript2 {

    AndroidDriver driver=null;



    @Test(invocationCount = 400)
    public void androidMainSteps() throws Exception {

        try {
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=71HsbGkWHHq1x81k37LbPyqeZ53wOhpe-MDVHzWv_y2_p2z2reJBd6CyDdzML8Xl-SmNw_NJyykp8LzfHDbRmFXGLQCA4pmZXwiC4iPepm24aEv0inOYPSI0BRjw9sD6VVkCHj0kIh6BWw3zkL9EzJtV8IK9o6gMknNeSQ6UwXMDpkoJFBDupAtHDBLjDJH3PjhMm2u610yK3wdt3iDyxUUno2m_7CGaLx1HOEP-VKdAaXOd5ufc1f7WH3ptsC1iTMEOjuZmdve0jIK42vi4NOo7lqICkcrXtokA2QlAmag7jLCsQiWzKTwAK0HDy2w&licenseId=LIC4139&projectName=25032026_Sanity/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "OnePlus Nord CE 2 Lite 5G");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "14");
            caps.setCapability("appium:app", "General-Store-final (4).apk");
            caps.setCapability("appium:deviceType", "public");
            caps.setCapability("appium:isVirtual", false);
            driver = new AndroidDriver(new URL(device_farm_hub_url), caps);

            System.out.println("Execution Started");


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            Thread.sleep(3000);
            // 1. Select Country Dropdown
            for (int i = 0; i < 50; i++) {
                driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']")).click();


                takeScreenshot("Step1_SelectCountryDropdown");

                // 2. Select Country
            Thread.sleep(5000);


                driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Afghanistan']")).click();

                Thread.sleep(5000);
            }

            for (int i = 0; i < 1; i++) {
                takeScreenshot("Step1_SelectCountryDropdown");
            }
//            // 3. Enter Name
            WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']"));

//            for (int i = 0; i < 201; i++) {
//                nameField.click();
//            }
//            nameField.sendKeys("Tester1");
//            for(int i = 0; i<10; i++) {
//                takeScreenshot("Step1_SelectCountryDropdown");
//            }
//            driver.hideKeyboard();
//
//            // 4. Select Gender
//            driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioMale']")).click();
//            for(int i = 0; i<3; i++) {
//                takeScreenshot("Step1_SelectCountryDropdown");
//            }
//            // 5. Click Let's Shop
//            driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")).click();
//            takeScreenshot("Step5_ClickLetsShop");


        } catch (Exception e) {

            throw new RuntimeException(e);
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Driver quit successfully");
                Thread.sleep(8000);


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