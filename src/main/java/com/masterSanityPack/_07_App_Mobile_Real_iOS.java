package com.masterSanityPack;


import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Arrays;

public class _07_App_Mobile_Real_iOS
{
    Actions act;
    IOSDriver driver;



    @Test
    public void steps() throws InterruptedException {
        try {
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=71HsbGkWHHq1x81k37LbPyqeZ53wOhpe-MDVHzWv_y2_p2z2reJBd6CyDdzML8Xl-SmNw_NJyykp8LzfHDbRmFXGLQCA4pmZXwiC4iPepm24aEv0inOYPSI0BRjw9sD6VVkCHj0kIh6BWw3zkL9EzJtV8IK9o6gMknNeSQ6UwXMDpkoJFBDupAtHDBLjDJH3PjhMm2u610yK3wdt3iDyxUUno2m_7CGaLx1HOEP-VKdAaXOd5ufc1f7WH3ptsC1iTMEOjuZmdve0jIK42vi4NOo7lqICkcrXtokA2QlAmag7jLCsQiWzKTwAK0HDy2w&licenseId=LIC4139&projectName=20022016_Testing/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "iPhone 11");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("appium:platformVersion", "15.5");
            caps.setCapability("appium:app", "bigbasket.ipa");
            caps.setCapability("appium:deviceType", "public");
            caps.setCapability("appium:isVirtual", false);
            caps.setCapability("appium:bundleId", "com.bigbasket.mobileapp");

            caps.setCapability("appium:automationName", "XCUITest");
            caps.setCapability("appium:autoAcceptAlerts", true); // automatically tap Allow for popups
            caps.setCapability("appium:fullReset", true);
            driver = new IOSDriver(new URL(device_farm_hub_url), caps);

            act = new Actions(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence tap = new Sequence(finger, 1);
            tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 271, 520));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            takeScreenshot(driver, "Android_MobileApp_RealDevice");

            driver.perform(Arrays.asList(tap));
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Continue as Guest']")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Categories']")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Categories']/following::XCUIElementTypeStaticText[contains(@name,'Breakfast')][2]")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            Thread.sleep(20000);
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@value='All']/following::XCUIElementTypeOther[@name='offerTag'][1]")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='addButtonProduct']")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            // Tap at x=344, y=747
//            Sequence tap2 = new Sequence(finger, 2);
//            tap2.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 344, 747));
//            tap2.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            tap2.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//
//            driver.perform(Arrays.asList(tap2));
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='decrementProductButton']")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='backButton']")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='backButton']")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            Thread.sleep(10000);
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Categories']/following::XCUIElementTypeStaticText[contains(@name,'Breakfast')][2]")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Breakfast Cereals']/following::XCUIElementTypeStaticText[@name='Flakes']")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            Thread.sleep(20000);
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@value='All']/following::XCUIElementTypeOther[@name='offerTag'][1]")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='addButtonProduct']")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            // Tap at x=344, y=747
//            Sequence tap3 = new Sequence(finger, 2);
//            tap2.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 344, 747));
//            tap2.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            tap2.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            driver.perform(Arrays.asList(tap3));
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='decrementProductButton']")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='backButton']")).click();
//            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
        }catch (NoSuchElementException | MalformedURLException e){
            System.out.println("Main Catch block triggered");
            e.printStackTrace();
        }finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Driver closed.");
            } else {
                System.out.println("Driver not initialized. Session creation failed.");
            }
        }






    }

    public static void takeScreenshot(IOSDriver driver, String fileName)
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
