package com.automation.P0andP1;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class _05_AndroidTablet_MobileBrowser_RealDevice {
@Test
    public void run() throws Exception {

    String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=uHnChthLrrZx7i3tjv6Atsi0rbbNFJI1L6EV9v-v4hJq4gij5X2bKAq75AfDVw1O5ZYv5VVRvt1kfAhFWREi3LqauNaCff0DDPYZe-LanCzWZDt2JrxKD7sjNJalFQOYru3OxKPddfBrPW1OUlqVSIi43sL2gAeyaExiJ7sGgEoY164NYts6axdWnu06sp2aWP3EquBR69Z-pYOQXlFOyLNmd4uKmcsOdpo-t8Dd6AR_gtWMcg3PLopnsAvteZos-m8dAfR3FNBDd6NaJL6JdFD8RUCAGhZJG5vi-fy41NKg-2jpeDbp&licenseId=LIC4014&projectName=Automation+Testing/";
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("appium:deviceName", "Pixel Tablet");
    caps.setCapability("platformName", "Android");
    caps.setCapability("appium:platformVersion", "16");
    caps.setCapability("appium:browserName", "Chrome");
    WebDriver driver = new RemoteWebDriver(new URL(device_farm_hub_url), caps);




    try {
            driver.get("https://www.wikipedia.org");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            long endTime = System.currentTimeMillis() + 30000;
            while (System.currentTimeMillis() < endTime) {
                WebElement searchBox = wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.id("searchInput"))
                );
                searchBox.clear();
                searchBox.sendKeys("Software Testing");
                takeScreenshot(driver, "Value Entered");
                searchBox.submit();
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.id("firstHeading"))
                );
                takeScreenshot(driver, "SS Captured");
                driver.get("https://www.wikipedia.org");
                takeScreenshot(driver, "Next iteration");

            }

        } finally {

            driver.quit();
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
