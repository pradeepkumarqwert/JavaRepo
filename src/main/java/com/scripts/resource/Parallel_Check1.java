package com.masterSanityPack;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class Parallel_Check1{
    @Test(invocationCount = 1)
    public void run() throws Exception {
//        DesiredCapabilities cap = new DesiredCapabilities();
//
//        cap.setCapability("appium:platformName", "Android");
//        cap.setCapability("appium:automationName", "UIAutomator2");
//        cap.setCapability("appium:deviceName", "Redmi TV");
//        cap.setCapability("appium:platformVersion", "11");
//        cap.setCapability("appium:app", "https://testyantrademourl.s3.ap-south-1.amazonaws.com/ApiDemos-debug.apk");
//        AndroidDriver driver = new AndroidDriver(new URL("  http://103.182.210.84:4444"), cap);



//        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=71HsbGkWHHq1x81k37LbPyqeZ53wOhpe-MDVHzWv_y2_p2z2reJBd6CyDdzML8Xl-SmNw_NJyykp8LzfHDbRmFXGLQCA4pmZXwiC4iPepm24aEv0inOYPSI0BRjw9sD6VVkCHj0kIh6BWw3zkL9EzJtV8IK9o6gMknNeSQ6UwXMDpkoJFBDupAtHDBLjDJH3PjhMm2u610yK3wdt3iDyxUUno2m_7CGaLx1HOEP-VKdAaXOd5ufc1f7WH3ptsC1iTMEOjuZmdve0jIK42vi4NOo7lqICkcrXtokA2QlAmag7jLCsQiWzKTwAK0HDy2w&licenseId=LIC4139&projectName=23+web+and+Mobile/";
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("appium:deviceName", "Google TV");
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("appium:platformVersion", "16");
//        caps.setCapability("appium:appPackage", "com.google.android.youtube.tv");
//        caps.setCapability("appium:appActivity", "com.google.android.apps.youtube.tv.activity.ShellActivity");
//        caps.setCapability("appium:noReset", true);
//        caps.setCapability("appium:deviceType", "public");
//        caps.setCapability("appium:isVirtual", true);
//        AndroidDriver driver = new AndroidDriver(new URL(device_farm_hub_url), caps);


        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=71HsbGkWHHq1x81k37LbPyqeZ53wOhpe-MDVHzWv_y2_p2z2reJBd6CyDdzML8Xl-SmNw_NJyykp8LzfHDbRmFXGLQCA4pmZXwiC4iPepm24aEv0inOYPSI0BRjw9sD6VVkCHj0kIh6BWw3zkL9EzJtV8IK9o6gMknNeSQ6UwXMDpkoJFBDupAtHDBLjDJH3PjhMm2u610yK3wdt3iDyxUUno2m_7CGaLx1HOEP-VKdAaXOd5ufc1f7WH3ptsC1iTMEOjuZmdve0jIK42vi4NOo7lqICkcrXtokA2QlAmag7jLCsQiWzKTwAK0HDy2w&licenseId=LIC4139&projectName=240326_TVTEsting/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "Google TV");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "16");
        caps.setCapability("appium:app", "ApiDemos-debug.apk");
        caps.setCapability("appium:deviceType", "public");
        caps.setCapability("appium:isVirtual", true);
        AndroidDriver driver = new AndroidDriver(new URL(device_farm_hub_url), caps);

        try {
            System.out.println("Android TV launched successfully!");
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
            System.out.println("Pressed DPAD_DOWN");


            driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
            System.out.println("Pressed DPAD_CENTER");

            Thread.sleep(1000);

            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
            WebElement focusedElement = driver.findElement(By.xpath("//*[@focused='true']"));
            String focusedText = focusedElement.getText();

            System.out.println("Focused Element Text: " + focusedText);

            if (focusedText != null && !focusedText.isEmpty()) {
                System.out.println("Verification Passed: Focused element contains text");
            } else {
                System.out.println("Verification Failed: No text found");
            }

            try {
                WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
                System.out.println("Element Found: " + element.getText());
            } catch (Exception e) {
                System.out.println("Element 'Views' not found");
            }

            // Back Navigation
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            System.out.println("Pressed BACK twice");

            // More Navigation
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
            takeScreenshot(driver, "Captured");
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
            takeScreenshot(driver, "Captured");
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
            takeScreenshot(driver, "Captured");

            // Scroll through items

            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
            takeScreenshot(driver, "Captured");
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
            takeScreenshot(driver, "Captured");
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
            takeScreenshot(driver, "Captured");
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
            takeScreenshot(driver, "Captured");
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
            takeScreenshot(driver, "Captured");
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
            System.out.println("Pressed LEFT");
            takeScreenshot(driver, "Captured");



            driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
            System.out.println("Pressed RIGHT");
            takeScreenshot(driver, "Captured");


            driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));
            System.out.println("Pressed UP");
            takeScreenshot(driver, "Captured");


            // Open Menu
            driver.pressKey(new KeyEvent(AndroidKey.MENU));
            System.out.println("Pressed MENU");
            takeScreenshot(driver, "Captured");


            driver.pressKey(new KeyEvent(AndroidKey.HOME));
            System.out.println("Pressed HOME");
            takeScreenshot(driver, "Captured");



        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (driver != null) {
//                driver.removeApp("io.appium.android.apis");
                driver.quit();
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