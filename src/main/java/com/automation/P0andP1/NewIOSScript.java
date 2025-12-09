package com.automation.P0andP1;


import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class NewIOSScript
{
    Actions act;
    IOSDriver driver;



    @Test
    public void steps() throws InterruptedException {
        try {


            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=215e3152-58d0-4a88-a3ac-de34cf8372cb&licenseId=LIC3996&projectName=Sanity/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "iPhone 11");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("appium:platformVersion", "18.3.1");
            caps.setCapability("appium:app", "bigbasket.ipa");
            caps.setCapability("appium:bundleId", "com.bigbasket.mobileapp");

            caps.setCapability("appium:automationName", "XCUITest");
            caps.setCapability("appium:autoAcceptAlerts", true); // automatically tap Allow for popups
            caps.setCapability("appium:fullReset", true);
            driver = new IOSDriver(new URL(device_farm_hub_url), caps);


            act = new Actions(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence tap = new Sequence(finger, 1);
            tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 271, 520));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(tap));
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
            Thread.sleep(20000);
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@value='All']/following::XCUIElementTypeOther[@name='offerTag'][1]")).click();
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='addButtonProduct']")).click();
            // Tap at x=344, y=747
            Sequence tap2 = new Sequence(finger, 2);
            tap2.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 344, 747));
            tap2.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap2.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(tap2));
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='decrementProductButton']")).click();
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='backButton']")).click();
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='backButton']")).click();
            Thread.sleep(10000);
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Breakfast Cereals']/following::XCUIElementTypeStaticText[@name='Flakes']")).click();
            Thread.sleep(20000);
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@value='All']/following::XCUIElementTypeOther[@name='offerTag'][1]")).click();
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='addButtonProduct']")).click();
            // Tap at x=344, y=747
            Sequence tap3 = new Sequence(finger, 2);
            tap2.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 344, 747));
            tap2.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap2.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(tap3));
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
