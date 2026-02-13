package com.automation.P0andP1;


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
        //XCUITestOptions options = new XCUITestOptions();
//	    options.setPlatformName("iOS");
//	    options.setAutomationName("XCUITest");
//	    options.setBundleId("com.myntra.myntra");
//	    options.setDeviceName("Fireflink Cloud 11 15.5");
//	    options.setPlatformVersion("15.5");
//	    options.setCapability("autoGrantPermissions", true);
//	    options.setCapability("autoAcceptAlerts", true);
//	    options.setUdid("00008030-001968812EF2402E");
//	    try {
//			driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), options);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


        //local capabilities:
        //---------------------------
//	    DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platformName", "iOS");
//        caps.setCapability("platformVersion", "15.5"); // your iOS version
//        caps.setCapability("deviceName", "Fireflink Cloud 11 15.5"); // exact device name or UDID
//        caps.setCapability("udid", "00008030-001968812EF2402E"); // required for real device
//        caps.setCapability("automationName", "XCUITest");
//        caps.setCapability("BundleID", "com.myntra.myntra");
//        caps.setCapability("autoGrantPermissions", true);
//        caps.setCapability("autoGrantPermissions", true);
//        //options.setBundleId("com.myntra.myntra");
//        //options.setCapability("autoGrantPermissions", true);
//	    //options.setCapability("autoAcceptAlerts", true);
//        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);


//		String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=9adfe132-9652-4329-a206-4c8ee67e0281&licenseId=LIC3943&projectName=Sanity/";
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability("appium:deviceName", "iPhone 11");
//		caps.setCapability("appium:platformName", "iOS");
//		caps.setCapability("appium:platformVersion", "18.3.1");
//
//		caps.setCapability("appium:bundleId", "null");//Pls change the bundleId value to proper value.
//		IOSDriver driver = new IOSDriver(new URL(seleniumHubUrl), caps);

        try {
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=2XpX0pCCa5sZ4t42o2SQX7vVo3eapYfPDT-9I23oKiqp_DvSuFM7Wm54CZ8w07m4S0Q5hrpgNjeLO-gLBOyum4dn2ZczCYUFb25CzoAaTITZGr6fdL_AAriC4iMwJOBx3Ym9GXYg0kNy7ijkRDtqUF12GB_gjeElLM6ilD7Wbc98mhpUJgnemzbel-dPbkDYUxvZ5HMvQhKG4VuQogRYrOPrd_NXXKGypsEY0Fj3B8Fhmr4yBFKBn3-ig1ia9gtwwW8iUXrHr4QXHWJJ5CF94ozXB3nDOnOiE00V8iiC7pH9gzqOk1GS&licenseId=LIC4047&projectName=Test+Check/";
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
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Continue as Guest']")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Categories']")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Categories']/following::XCUIElementTypeStaticText[contains(@name,'Breakfast')][2]")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            Thread.sleep(20000);
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@value='All']/following::XCUIElementTypeOther[@name='offerTag'][1]")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='addButtonProduct']")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            // Tap at x=344, y=747
            Sequence tap2 = new Sequence(finger, 2);
            tap2.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 344, 747));
            tap2.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap2.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");

            driver.perform(Arrays.asList(tap2));
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='decrementProductButton']")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='backButton']")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='backButton']")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            Thread.sleep(10000);
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Categories']/following::XCUIElementTypeStaticText[contains(@name,'Breakfast')][2]")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Breakfast Cereals']/following::XCUIElementTypeStaticText[@name='Flakes']")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            Thread.sleep(20000);
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@value='All']/following::XCUIElementTypeOther[@name='offerTag'][1]")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='addButtonProduct']")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            // Tap at x=344, y=747
            Sequence tap3 = new Sequence(finger, 2);
            tap2.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 344, 747));
            tap2.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap2.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            driver.perform(Arrays.asList(tap3));
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='decrementProductButton']")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='backButton']")).click();
            takeScreenshot(driver, "iOS_MobileApp_RealDevice");
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
