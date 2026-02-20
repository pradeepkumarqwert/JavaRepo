package com.masterSanityPack;

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

public class _14_App_Tablet_Real_AndroidBrowser {

    WebDriver driver;
@Test(invocationCount = 1)
    public void run() throws Exception {
    String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=NCIy1e_-zEgG-15AuI-i6cZJRAOZxsq1p9r8-SjfEPrDwDn-oPLlFAcz4je4MS3pfaWQX3BMlhj3q1QHPNeDXcvGGf7RI7fnEHQThJbAxqTuql-pJYRld_Vr-eaGuxTtagWXNZstVZY5zOrGvpWYzCNQXVyA8EihmlqQ79t9l5vchVYC1doULHptVZpGXarEeENHvHf8MCqNwiFLRiekfD6H24oVlrtc0zuk43i9REA6FQJP1wPb1lm4Mm22xLihHRdL1MT1W3PsT3LMR_GkNM3jWDr-W7f6ggIjCPCoZFHJ16bHvLf_5ugkmIPaL8av&licenseId=LIC2026615&projectName=04022026_Card_Testing/";
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("appium:deviceName", "Galaxy Tab A11");
    caps.setCapability("platformName", "Android");
    caps.setCapability("appium:platformVersion", "15");
    caps.setCapability("appium:browserName", "Chrome");
    caps.setCapability("appium:deviceType", "public");
    caps.setCapability("appium:isVirtual", false);
    driver = new RemoteWebDriver(new URL(device_farm_hub_url), caps);



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
            System.out.println("Driver closed.");
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
