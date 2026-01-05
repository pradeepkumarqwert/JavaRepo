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

    String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=e2mZRKEkfTrekbX8bjKBW1Ey2uVnC98y4SNUvKWW0AcrVmGA58Kn3Ks2wJYJPnLNs_1QAY40zpgEv2qUxfj7HZ9LajWiPpKC9AfQ9PMGBsXewnZ_fKpyqmxN8M_2okrPZQAXE5XtQZUCMrb1jqM8A-EQ5T-8OD8JQd79RL0oEb4xpWlbX_ReLAxQVMr_lsOyGK9tbEmwfYLH75Mr1xkooPMI57NuYr9gZp1scSCnhnAubcdZBMYY5UcOlVWiFOAcT75t3F8wv4G11pXXd_GyZQQmBbKCep_xqu2IvIgi1puHMKOwmjbiqf8dTMpeL0rf&licenseId=LIC2026610&projectName=29122025_Sanity_Testing/";
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("appium:deviceName", "Pixel Tablet");
    caps.setCapability("platformName", "Android");
    caps.setCapability("appium:platformVersion", "15");
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
