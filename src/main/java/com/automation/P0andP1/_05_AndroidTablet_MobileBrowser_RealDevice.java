package com.automation.P0andP1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
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

    WebDriver driver;
@Test(invocationCount = 1)
    public void run() throws Exception {

    String device_farm_hub_url = "http://103.182.210.90:4444";
//    String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=vK-JO6U-sXEZzMi5z7p3b6Q2RZkUv6ugZQm_Ap4eCAvIpdFtfF3AGEv6Uahw0U9XX2kz2rqdTTa6iHP-hDgOlMnutXrAxYkjAkaq_UglUWzVmFX7p2GldzbWG5jNTP_Xhf0lu6epgN_YBmq8UkSzczCPn9DgYO_zHwLIV2TXCQXDrKljzvNSz7hGRB9lT3LfKREmjbqv3gcNwPv5di1Wfk0VtA_4RIozgn6l_WTGZ8blrUFwf0lLVty0w7qYdG_dO6TL1f6cjCHOJJD99MLalNSNl9gzip1luJV7QpuH5ds_WDM_FofmCEwKscjCSDBT&licenseId=LIC2026658&projectName=Sanity_20012026/";
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("appium:deviceName", "Pixel Tablet");
    caps.setCapability("platformName", "Android");
    caps.setCapability("appium:platformVersion", "15");
    caps.setCapability("appium:browserName", "Chrome");
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
