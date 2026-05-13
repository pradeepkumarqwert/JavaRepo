package com.scripts.resource;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class testAppWork {

    AndroidDriver driver;

    @Test
    public void androidMainSteps() throws Exception {

        try {
            initializeDriver();
            log("Execution Started");

            Thread.sleep(3000);

            validateDateText();
            takeScreenshot(driver,"Captured");

            press(AndroidKey.DPAD_DOWN, 2);

            String randomText = RandomDataUtil.generateSentence(15);

            // Navigation continues (keeping your flow intact)
            press(AndroidKey.DPAD_UP, 2);
            press(AndroidKey.DPAD_RIGHT, 2);
            takeScreenshot(driver,"Failure_State");

            pressKey(AndroidKey.DPAD_CENTER);
            pressKey(AndroidKey.DPAD_UP);
            takeScreenshot(driver,"Failure_State");

            //  Long Press + Stress
            for (int i = 0; i <= 1; i++) {
                longPress(AndroidKey.DPAD_RIGHT);
                log("Long Press RIGHT (fast scroll)");

                pressKey(AndroidKey.DPAD_DOWN);
                pressKey(AndroidKey.DPAD_DOWN);
                pressKey(AndroidKey.DPAD_DOWN);
            }

//            pressKey(AndroidKey.BACK);

            // Volume actions
            pressKey(AndroidKey.VOLUME_UP);
            log("Volume Increased");

            pressKey(AndroidKey.VOLUME_DOWN);
            log("Volume Decreased");

            pressKey(AndroidKey.VOLUME_MUTE);
            log("Volume Muted");

            // Switch Layout Navigation
            handleSwitchLayout();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            quitDriver();
        }
    }

    //Set-up
    public void initializeDriver() throws Exception {
//        String url = "http://103.182.210.84:4444/";
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("appium:deviceName", "Redmi TV");
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("appium:platformVersion", "11");
//        caps.setCapability("appium:app", "https://testyantrademourl.s3.ap-south-1.amazonaws.com/dump/OG_Notes_TVAPP.apk");
//        caps.setCapability("appium:deviceType", "public");
//        caps.setCapability("appium:isVirtual", false);
//        driver = new AndroidDriver(new URL(url), caps);

        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=71HsbGkWHHq1x81k37LbPyqeZ53wOhpe-MDVHzWv_y2_p2z2reJBd6CyDdzML8Xl-SmNw_NJyykp8LzfHDbRmFXGLQCA4pmZXwiC4iPepm24aEv0inOYPSI0BRjw9sD6VVkCHj0kIh6BWw3zkL9EzJtV8IK9o6gMknNeSQ6UwXMDpkoJFBDupAtHDBLjDJH3PjhMm2u610yK3wdt3iDyxUUno2m_7CGaLx1HOEP-VKdAaXOd5ufc1f7WH3ptsC1iTMEOjuZmdve0jIK42vi4NOo7lqICkcrXtokA2QlAmag7jLCsQiWzKTwAK0HDy2w&licenseId=LIC4139&projectName=25032026_Sanity/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "Redmi TV");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "11");
        caps.setCapability("appium:app", "OG_Notes_TVAPP.apk");
        caps.setCapability("appium:deviceType", "public");
        caps.setCapability("appium:isVirtual", false);
        driver = new AndroidDriver(new URL(device_farm_hub_url), caps);



    }

    // Date Validation
    public void validateDateText() {
        try {
            WebElement dateElement = driver.findElement(
                    By.xpath("//android.widget.Button[contains(@text,'Today is')]")
            );

            if (isFocused(dateElement)) {

                LocalDate today = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy");
                String expectedDate = today.format(formatter);

                String actualText = dateElement.getText();

                log("Actual Text: " + actualText);
                log("Expected Date: " + expectedDate);

                if (!actualText.contains(expectedDate)) {
                    throw new RuntimeException("Date mismatch: " + actualText);
                }

                log("Date is correct");
            }

        } catch (Exception e) {
            log("Mismatch in text");
            throw new RuntimeException(e);
        }
    }

    // Key Actions
    public void pressKey(AndroidKey key) throws InterruptedException {
        driver.pressKey(new KeyEvent(key));
        log("Pressed: " + key);
        Thread.sleep(200);
    }

    public void press(AndroidKey key, int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            pressKey(key);
        }
    }

    public void longPress(AndroidKey key) {
        driver.longPressKey(new KeyEvent(key));
    }


    // Focus Utility
    public boolean isFocused(WebElement el) {
        try {
            return "true".equals(el.getAttribute("focused"));
        } catch (Exception e) {
            return false;
        }
    }


    // Switch Layout Handler
    public void handleSwitchLayout() throws InterruptedException {

        // Move to expected position
        press(AndroidKey.DPAD_DOWN, 3);

        WebElement btn = driver.findElement(
                By.xpath("//android.widget.Button[@text='SWITCH LAYOUT']")
        );

        if (isFocused(btn)) {
            btn.click();
            log("Clicked SWITCH LAYOUT");
        } else {
            log("SWITCH LAYOUT not focused");
        }
    }

    // Screenshot
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

    // Cleanup
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            log("Driver quit successfully");
        }
    }


    // Logger
    public void log(String msg) {
        System.out.println(msg);
    }

    // Random Data
    public static class RandomDataUtil {

        static String[] words = {
                "hello", "world", "automation", "testing", "tv", "appium",
                "selenium", "remote", "control", "video", "music", "search",
                "play", "pause", "settings", "network", "device", "cloud"
        };

        public static String generateSentence(int count) {
            Random r = new Random();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < count; i++) {
                sb.append(words[r.nextInt(words.length)]).append(" ");
            }
            return sb.toString().trim();
        }
    }
}