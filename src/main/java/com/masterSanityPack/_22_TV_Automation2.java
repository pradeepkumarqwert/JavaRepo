package com.masterSanityPack;

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

public class _22_TV_Automation2 {

    AndroidDriver driver;

    @Test
    public void androidMainSteps() throws Exception {

        try {
            initializeDriver();
            log("Execution Started");

            Thread.sleep(3000);
            takeScreenshot(driver,"Captured");

            press(AndroidKey.DPAD_DOWN, 4);

            String randomText = RandomDataUtil.generateSentence(15);

            // Navigation continues (keeping your flow intact)
            press(AndroidKey.DPAD_DOWN, 3);
            Thread.sleep(1000);
            press(AndroidKey.DPAD_RIGHT, 1);
            takeScreenshot(driver,"Failure_State");

            pressKey(AndroidKey.DPAD_CENTER);

            press(AndroidKey.DPAD_DOWN, 3);
            Thread.sleep(2000);

            pressKey(AndroidKey.DPAD_UP);
            takeScreenshot(driver,"Failure_State");

            pressKey(AndroidKey.DPAD_CENTER);
            takeScreenshot(driver,"State_Check");



            //  Long Press + Stress
            for (int i = 0; i <= 3; i++) {
                longPress(AndroidKey.DPAD_RIGHT);
                log("Long Press RIGHT (fast scroll)");

            }

            pressKey(AndroidKey.BACK);
            Thread.sleep(3000);


            // Volume actions


            for(int i=0 ; i<=10 ; i++) {
                pressKey(AndroidKey.VOLUME_DOWN);
                log("Volume Increased");
            }

            for(int i=0 ; i<=10 ; i++) {
                pressKey(AndroidKey.VOLUME_UP);
                log("Volume Increased");
            }

            pressKey(AndroidKey.VOLUME_MUTE);
            log("Volume Muted");
            Thread.sleep(3000);



            pressKey(AndroidKey.VOLUME_MUTE);
            log("Volume Muted");
            Thread.sleep(3000);


            // Switch Layout Navigation
            //handleSwitchLayout();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            quitDriver();
        }
    }

    //Set-up
    public void initializeDriver() throws Exception {
        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=UZ2zbf2ONZU1gd9OyP1wdpPEASZq7gtP4b0CUFKq0pRweJhkopEmSOxJgrMfvzUJYOZocBrQM4R_Ut9DR_T0Oi7qYA72GYz4D3TVdTuLwEA8YIn_9ndVop2e8zyQakR65GBu2LT6Ua84jlxJQnKzZ5y2VjZd8ArQqP4R6wsM06rcQLvEeL7uvjnFZPUfyPEdIoEhyvetYYBuiotWZPYSqYat575kDEW-LBP9WEcsaBpaHX7I1ghd_7_-GoDeUVc1ca6_M7TxkuECpHVyhJh2fxKIMuRkxwv7FN3HAcE_suFmnHKc6T9qzQ&licenseId=LIC4255&projectName=Mobile+Project/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "Google TV");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "16");
        caps.setCapability("appium:app", "OG_Notes_TVAPP.apk");
        caps.setCapability("appium:deviceType", "public");
        caps.setCapability("appium:isVirtual", true);
        driver = new AndroidDriver(new URL(device_farm_hub_url), caps);

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