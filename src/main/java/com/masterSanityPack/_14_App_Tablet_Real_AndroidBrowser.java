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
    String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=8Tcsdwspy69KdKXw6ambPGMs6LQazDAA8okbIssJb7YGMDCKJMTB7VsBrV4hUIOuGV6I3wCwpK2CbuNIwIVnSswS5CbMRArfP5qm59IgrRxHwhSx_RywypctI-EwuF2TlQs7Dsq38CpF24sHUVJrCSi8v1VvwYjO3LKlPp5054Ji4dtzt3EtbdVyIAlwauBFkx-1YufbwuVWT-AOLN0MlQLdqjA0bzHDwpSZUzk2LeE7GFJ6rBwsOsTQrpU6HNU2W3kRm70a6nvLdV91z6Hm-kxlb_Rd8l4i_Pt52_nZUtFT5BYDEGZiGIrR_yOMRSnQtp5ojsY6bWnoVA&licenseId=LIC2026615&projectName=06042026_Testing/";
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("appium:deviceName", "Samsung Galaxy Tab A11");
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
