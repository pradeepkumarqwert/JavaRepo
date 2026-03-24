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

public class _19_App_Tablet_Virtual_iOS
{
    IOSDriver driver;

    @BeforeClass
    public void initialize() throws MalformedURLException {
        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=71HsbGkWHHq1x81k37LbPyqeZ53wOhpe-MDVHzWv_y2_p2z2reJBd6CyDdzML8Xl-SmNw_NJyykp8LzfHDbRmFXGLQCA4pmZXwiC4iPepm24aEv0inOYPSI0BRjw9sD6VVkCHj0kIh6BWw3zkL9EzJtV8IK9o6gMknNeSQ6UwXMDpkoJFBDupAtHDBLjDJH3PjhMm2u610yK3wdt3iDyxUUno2m_7CGaLx1HOEP-VKdAaXOd5ufc1f7WH3ptsC1iTMEOjuZmdve0jIK42vi4NOo7lqICkcrXtokA2QlAmag7jLCsQiWzKTwAK0HDy2w&licenseId=LIC4139&projectName=23+web+and+Mobile/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "Simulator iPad Air 13inch M3");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:platformVersion", "18.4");
        caps.setCapability("appium:app", "iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1 (1) (1) (1) (1) (1) (1) (1).zip");
        caps.setCapability("appium:deviceType", "public");
        caps.setCapability("appium:isVirtual", true);
        caps.setCapability("appium:bundleId", "com.saucelabs.SwagLabsMobileApp");

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
            takeScreenshot(driver, "iOS_MobileApp_Simulator");
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

            driver.findElement(AppiumBy.accessibilityId("test-standard_user")).click();
            takeScreenshot(driver, "iOS_MobileApp_Simulator");
            driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
            takeScreenshot(driver, "iOS_MobileApp_Simulator");
            driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='test-ADD TO CART'])[1]")).click();
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
