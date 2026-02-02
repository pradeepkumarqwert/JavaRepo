package com.automation.P0andP1;

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

    String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=38POQeInJdHhuT1LtwaXooJ2zBkiutf5JUZb6lEChNPORDu7hjD96aTphCcTtnmTHDvIqo9QVvdfD3qG02wmqXjMDm2eGxTb9NsZ1ANx5AU9bMAWAsvWIyQqm_euXcBVF2x2zlG-Ywljt7BbH5FVBY_R_F6YNNGHagJxekSUaZCe4MoaD6eHdItJ3vKBKAI8c-AkThezsaX2W0GemgYOjaTnyA6UzS5aiCVttAcvl9mPhlhbgc8pAEOMNaYeGpwh_0Vu5ptnSQ29gCAnWmmTGf7mCSgH35RanpkW2825qxtuMY0U_8_ElA&licenseId=LIC4045&projectName=Testing+21012026/";
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("appium:deviceName", "Simulator iPad Air 13inch M3");
    caps.setCapability("platformName", "iOS");
    caps.setCapability("appium:platformVersion", "18.4");
    caps.setCapability("appium:browserName", "Safari");
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
