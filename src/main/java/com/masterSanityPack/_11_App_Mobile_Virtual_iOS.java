package com.masterSanityPack;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class _11_App_Mobile_Virtual_iOS
{
    IOSDriver driver;

    @BeforeClass
    public void initialize() throws MalformedURLException {
        String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=8Tcsdwspy69KdKXw6ambPGMs6LQazDAA8okbIssJb7YGMDCKJMTB7VsBrV4hUIOuGV6I3wCwpK2CbuNIwIVnSswS5CbMRArfP5qm59IgrRxHwhSx_RywypctI-EwuF2TlQs7Dsq38CpF24sHUVJrCSi8v1VvwYjO3LKlPp5054Ji4dtzt3EtbdVyIAlwauBFkx-1YufbwuVWT-AOLN0MlQLdqjA0bzHDwpSZUzk2LeE7GFJ6rBwsOsTQrpU6HNU2W3kRm70a6nvLdV91z6Hm-kxlb_Rd8l4i_Pt52_nZUtFT5BYDEGZiGIrR_yOMRSnQtp5ojsY6bWnoVA&licenseId=LIC2026615&projectName=16-03-2026_Testing/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "Simulator iPhone 16 Pro");
            caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:platformVersion", "18.4");
        caps.setCapability("appium:app", "iOS.Simulator.SauceLabs.Mobile.Sample.app.zip");
        caps.setCapability("appium:deviceType", "public");
        caps.setCapability("appium:isVirtual", true);
        caps.setCapability("appium:bundleId", "com.saucelabs.SwagLabsMobileApp");

        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:autoAcceptAlerts", true); // automatically tap Allow for popups
//        caps.setCapability("appium:fullReset", true);
        driver = new IOSDriver(new URL(device_farm_hub_url), caps);

    }


	 @Test
	 public void test() throws MalformedURLException, InterruptedException
	 {
            try {
                Thread.sleep(10000);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

                driver.findElement(AppiumBy.accessibilityId("test-standard_user")).click();
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='test-ADD TO CART'])[1]")).click();
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                Sequence tap = new Sequence(finger, 1);
                tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 362, 57));
                tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                driver.perform(Arrays.asList(tap));
                Thread.sleep(2000);
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                driver.findElement(By.xpath("//XCUIElementTypeOther[@name='test-CHECKOUT']")).click();
                Thread.sleep(2000);
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='test-First Name']")).sendKeys("Pradeep");
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='test-Last Name']")).click();
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='test-Last Name']")).sendKeys("Kumar");
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='test-Zip/Postal Code']")).click();
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='test-Zip/Postal Code']")).sendKeys("56473");
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                driver.findElement(By.xpath("//XCUIElementTypeOther[@name='test-CONTINUE']")).click();
                Thread.sleep(2000);
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                Sequence dragAndDrop = new Sequence(finger, 1);
                dragAndDrop.addAction(finger.createPointerMove(Duration.ZERO,
                        PointerInput.Origin.viewport(), 157, 728));
                dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                dragAndDrop.addAction(new Pause(finger, Duration.ofMillis(500)));
                dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(800),
                        PointerInput.Origin.viewport(), 155, 374));
                dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                driver.perform(List.of(dragAndDrop));
                Thread.sleep(2000);
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                driver.findElement(By.xpath("//XCUIElementTypeOther[@name='test-FINISH']")).click();
                Thread.sleep(2000);
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
                driver.findElement(By.xpath("//XCUIElementTypeOther[@name='test-BACK HOME']")).click();
                Thread.sleep(2000);
                takeScreenshot(driver, "iOS_MobileApp_Simulator");
            }catch (Exception e){
                System.out.println("Expection Triggered");
                System.out.println(e);
            }finally {
                System.out.println("Executing tearDown Method");
            }

	 }

     @AfterClass
    public void tearDown()
     {
         if(driver != null)
         {
             driver.quit();
             System.out.println("Driver closed.");
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
