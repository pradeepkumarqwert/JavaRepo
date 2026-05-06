package com.parallelrun;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class _02_Mobile_Script5 {
    WebDriver driver;
    @Test(invocationCount = 1)
    public void run() throws InterruptedException {

        //            caps.setCapability("appium:deviceType","private");

        try {
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=nda34o_Rf62saNBRQazErasUOBBg5_a1rpr5H2uo0-Iilfy-7qXP3RgjMTPmWT9vqoE6Rhe3lix85QuUVLYyAoNWGX1-ob-GjsXleVv8LAFqg0oWxsx46r7Q75memXV33l7H_U3nN2H4fqNQmrRVSW8zq52lq8O-Fq_YsCPKJtCXSWVic6VcfE4PnWFUEvtTSs5Y2DRURj1mpuvkDF_RKrD7vjCfohr1sondvPQG8L6rUa-e459bkPp0SSlr2VmZ416deFidkyFm428vEs8gIzVyAnwq_trvFtO5AaJDzKlri2g5SjxrsQ&licenseId=LIC4148&projectName=26032026/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Samsung Galaxy A12");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "12");
            caps.setCapability("appium:browserName", "Chrome");
            caps.setCapability("appium:deviceType", "public");
            caps.setCapability("appium:isVirtual", false);
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), caps);


            //caps.setCapability("appium:chromedriverAutodownload", true);
            driver.get("https://www.pantaloons.com/");
            System.out.println("Opened Pantaloons in mobile browser.");
            takeScreenshot(driver, "01_HomePage");
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("div.mobilesearchbox")).click();
            System.out.println("Clicked.");
            takeScreenshot(driver, "02_After_Click_Search_Icon");

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            takeScreenshot(driver, "99_Exception_Occurred");

        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Driver closed.");
            }
        }
    }



    public static void takeScreenshot(WebDriver driver, String fileName)
    {
        if (driver == null) {
            return;
        }
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\Selenium Grid\\Screenshots\\" + fileName + ".png");
            dest.getParentFile().mkdirs(); // Ensure folder exists
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }
}
