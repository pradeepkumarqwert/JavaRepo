package com.scripts.resource;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class IOS_1_iOS_App2 {

    public static void main(String[] args) throws Exception {

    	String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=8a3f9c56-a039-40d8-a65c-7b4f779977dc&licenseId=LIC3996&projectName=Autoamtion+Testing/";
    	DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability("appium:deviceName", "iPhone 11");
    	caps.setCapability("platformName", "iOS");
    	caps.setCapability("appium:platformVersion", "18.3.1");
    	caps.setCapability("appium:app", "Myntra1.ipa");
    	caps.setCapability("appium:bundleId", "com.myntra.Myntra");
    	IOSDriver driver = new IOSDriver(new URL(seleniumHubUrl), caps);

      

        Thread.sleep(5000);

        // --- Sample validations ---

        // Validate Home Screen is visible
        WebElement home = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Home' or @label='Home']"));
        System.out.println("✅ Home button displayed: " + home.isDisplayed());

        // Click on Search bar
        WebElement searchBar = driver.findElement(By.xpath("//XCUIElementTypeSearchField"));
        searchBar.click();
        Thread.sleep(1000);

        // Enter search text
        searchBar.sendKeys("Shoes");
        Thread.sleep(1000);

        // Click Search button on keyboard
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Search']")).click();
        Thread.sleep(3000);

        System.out.println("✅ Search executed successfully!");

        // Close app
        driver.quit();
    }
}
