package com.automation.P0andP1;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class _12_iOS_App_Simulator
{
    IOSDriver driver;

    @BeforeClass
    public void initialize() throws MalformedURLException {
        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=uHnChthLrrZx7i3tjv6Atsi0rbbNFJI1L6EV9v-v4hJq4gij5X2bKAq75AfDVw1O5ZYv5VVRvt1kfAhFWREi3LqauNaCff0DDPYZe-LanCzWZDt2JrxKD7sjNJalFQOYru3OxKPddfBrPW1OUlqVSIi43sL2gAeyaExiJ7sGgEoY164NYts6axdWnu06sp2aWP3EquBR69Z-pYOQXlFOyLNmd4uKmcsOdpo-t8Dd6AR_gtWMcg3PLopnsAvteZos-m8dAfR3FNBDd6NaJL6JdFD8RUCAGhZJG5vi-fy41NKg-2jpeDbp&licenseId=LIC4014&projectName=Automation+Testing/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "Simulator iPad Air 13inch M3");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:platformVersion", "18.4");
        caps.setCapability("appium:app", "iOS.Simulator.SauceLabs.Mobile.Sample.app.zip");

        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:autoAcceptAlerts", true); // automatically tap Allow for popups
        caps.setCapability("appium:fullReset", true);
        driver = new IOSDriver(new URL(device_farm_hub_url), caps);

    }


	 @Test
	 public void test() throws MalformedURLException, InterruptedException
	 {
            try {
                Thread.sleep(10000);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

                driver.findElement(AppiumBy.accessibilityId("test-standard_user")).click();
                driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
                driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='test-ADD TO CART'])[1]")).click();
                Sequence tap = new Sequence(finger, 1);
                tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 362, 57));
                tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                driver.perform(Arrays.asList(tap));
                Thread.sleep(2000);
                driver.findElement(By.xpath("//XCUIElementTypeOther[@name='test-CHECKOUT']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='test-First Name']")).sendKeys("Pradeep");
                driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='test-Last Name']")).click();
                driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='test-Last Name']")).sendKeys("Kumar");
                driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='test-Zip/Postal Code']")).click();
                driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='test-Zip/Postal Code']")).sendKeys("56473");
                driver.findElement(By.xpath("//XCUIElementTypeOther[@name='test-CONTINUE']")).click();
                Thread.sleep(2000);
                Sequence dragAndDrop = new Sequence(finger, 1);
                dragAndDrop.addAction(finger.createPointerMove(Duration.ZERO,
                        PointerInput.Origin.viewport(), 157, 728));
                dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                dragAndDrop.addAction(new Pause(finger, Duration.ofMillis(500)));
                dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(800),
                        PointerInput.Origin.viewport(), 155, 374));
                dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                driver.perform(List.of(dragAndDrop));
                Thread.sleep(2000);
                driver.findElement(By.xpath("//XCUIElementTypeOther[@name='test-FINISH']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//XCUIElementTypeOther[@name='test-BACK HOME']")).click();
                Thread.sleep(2000);
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
         }
     }

}
