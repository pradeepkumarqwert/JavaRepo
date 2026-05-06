package com.scripts.resource;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RoughScript3 {

    AndroidDriver driver;

    @Test
    public void androidMainSteps() throws Exception {

        try {
            String device_farm_hub_url = "http://103.182.210.84:4444/";

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Redmi TV");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "11");
            caps.setCapability("appium:app", "https://testyantrademourl.s3.ap-south-1.amazonaws.com/dump/OG_Notes_TVAPP.apk");
            caps.setCapability("appium:deviceType", "public");
            caps.setCapability("appium:isVirtual", false);

            driver = new AndroidDriver(new URL(device_farm_hub_url), caps);

            System.out.println("Execution Started");

            Thread.sleep(3000);

            // ✅ Date Validation
            WebElement dateElement = driver.findElement(
                    By.xpath("//android.widget.Button[contains(@text,'Today is')]")
            );

            if (isFocused(dateElement)) {

                LocalDate today = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy");
                String expectedDate = today.format(formatter);

                String actualText = dateElement.getText();

                System.out.println("Actual Text: " + actualText);
                System.out.println("Expected Date: " + expectedDate);

                if (actualText.contains(expectedDate)) {
                    System.out.println("Date is correct");
                } else {
                    throw new RuntimeException("Date mismatch: " + actualText);
                }
            }

            // ✅ Navigate to message box
            pressMultiple(AndroidKey.DPAD_DOWN, 2);

            WebElement messageBox = driver.findElement(
                    By.id("io.github.visnkmr.kagaz:id/message")
            );

            if (isFocused(messageBox)) {
                String randomText = RandomDataUtil.generateSentence(15);
                messageBox.sendKeys(randomText);
            }

            driver.pressKey(new KeyEvent(AndroidKey.BACK));

            // ✅ Navigate to next section
            pressMultiple(AndroidKey.DPAD_UP, 2);
            pressMultiple(AndroidKey.DPAD_RIGHT, 2);
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));

            driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));

            WebElement titleBox = driver.findElement(
                    By.id("io.github.visnkmr.kagaz:id/text")
            );
            titleBox.sendKeys("Demo Script");

            // ✅ Stress Test
            for (int i = 0; i < 10; i++) {
                pressMultiple(AndroidKey.DPAD_RIGHT, 20);
                pressMultiple(AndroidKey.DPAD_DOWN, 3);
            }

            driver.pressKey(new KeyEvent(AndroidKey.BACK));

            // ✅ Volume Actions
            driver.pressKey(new KeyEvent(AndroidKey.VOLUME_UP));
            driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
            driver.pressKey(new KeyEvent(AndroidKey.VOLUME_MUTE));

            // ✅ Switch Layout Navigation
            navigateAndClickSwitchLayout();

        } catch (Exception e) {
            takeScreenshot("Failure_State");
            throw new RuntimeException(e);
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Driver quit successfully");
            }
        }
    }

    // ✅ Utility: Check focus
    public boolean isFocused(WebElement element) {
        try {
            return "true".equals(element.getAttribute("focused"));
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ Utility: Press key multiple times
    public void pressMultiple(AndroidKey key, int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            driver.pressKey(new KeyEvent(key));
            Thread.sleep(200); // stability for TV
        }
    }

    // ✅ Utility: Navigate & click SWITCH LAYOUT
    public void navigateAndClickSwitchLayout() throws InterruptedException {
        for (int i = 0; i < 6; i++) {
            try {
                WebElement btn = driver.findElement(
                        By.xpath("//android.widget.Button[@text='SWITCH LAYOUT']")
                );
                btn.click();
                System.out.println("Clicked SWITCH LAYOUT");
                break;
            } catch (Exception e) {
                driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
                Thread.sleep(300);
            }
        }
    }

    // ✅ Random Data Generator
    public static class RandomDataUtil {

        static String[] words = {
                "hello", "world", "automation", "testing", "tv", "appium",
                "selenium", "remote", "control", "video", "music", "search",
                "play", "pause", "settings", "network", "device", "cloud"
        };

        public static String generateSentence(int wordCount) {
            Random random = new Random();
            StringBuilder sentence = new StringBuilder();

            for (int i = 0; i < wordCount; i++) {
                sentence.append(words[random.nextInt(words.length)]).append(" ");
            }
            return sentence.toString().trim();
        }
    }

    // ✅ Screenshot Utility
    public void takeScreenshot(String fileName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\Selenium Grid\\Screenshots\\" + fileName + ".png");
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Screenshot Failed: " + e.getMessage());
        }
    }
}