package com.automation.P0andP1;


import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;

public class NewIOSScript
{
    Actions act;
    IOSDriver driver;



    @Test
    public void steps() throws InterruptedException {
        try {
            String seleniumHubUrl = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=a31168ce-bf67-4a7a-bfa1-997fca75f65a&licenseId=LIC1026534&projectName=App+Management/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "iPhone 13");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("appium:platformVersion", "18.4.1");
            caps.setCapability("appium:app", "bigbasket.ipa");
            caps.setCapability("appium:bundleId", "com.bigbasket.mobileapp");
            caps.setCapability("appium:automationName", "XCUITest");
            caps.setCapability("appium:autoAcceptAlerts", true); // automatically tap Allow for popups
            caps.setCapability("appium:fullReset", true);
            driver = new IOSDriver(new URL(seleniumHubUrl), caps);


            act = new Actions(driver);
            act.moveByOffset(271, 520).click().build().perform();
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Continue as Guest']")).click();
            try {
                driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Home']/following::XCUIElementTypeStaticText[@value='Categories']")).click();
            } catch (NoSuchElementException e) {
                driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Categories']")).click();
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Element not found 1");
                e.printStackTrace();
            }
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Categories']/following::XCUIElementTypeStaticText[contains(@name,'Breakfast')][2]")).click();
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@value='All']/following::XCUIElementTypeOther[@name='offerTag'][1]")).click();
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='addButtonProduct']")).click();
            act.moveByOffset(344, 747).click().build().perform();
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='decrementProductButton']")).click();
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='backButton']")).click();
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='backButton']")).click();
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Breakfast Cereals']/following::XCUIElementTypeStaticText[@name='Flakes']")).click();
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@value='All']/following::XCUIElementTypeOther[@name='offerTag'][1]")).click();
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='addButtonProduct']")).click();
            act.moveByOffset(344, 747).click().build().perform();
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='decrementProductButton']")).click();
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='backButton']")).click();
        }catch (NoSuchElementException | MalformedURLException e){
            System.out.println("Main Catch block triggered");
            e.printStackTrace();
        }finally {
            if (driver != null) {
                driver.quit();
            } else {
                System.out.println("Driver not initialized. Session creation failed.");
            }
        }


    }

}
