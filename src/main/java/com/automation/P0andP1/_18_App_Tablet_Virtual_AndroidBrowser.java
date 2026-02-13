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

public class _18_App_Tablet_Virtual_AndroidBrowser {

    WebDriver driver;
@Test(invocationCount = 1)
    public void run() throws Exception {
    String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=2XpX0pCCa5sZ4t42o2SQX7vVo3eapYfPDT-9I23oKiqp_DvSuFM7Wm54CZ8w07m4S0Q5hrpgNjeLO-gLBOyum4dn2ZczCYUFb25CzoAaTITZGr6fdL_AAriC4iMwJOBx3Ym9GXYg0kNy7ijkRDtqUF12GB_gjeElLM6ilD7Wbc98mhpUJgnemzbel-dPbkDYUxvZ5HMvQhKG4VuQogRYrOPrd_NXXKGypsEY0Fj3B8Fhmr4yBFKBn3-ig1ia9gtwwW8iUXrHr4QXHWJJ5CF94ozXB3nDOnOiE00V8iiC7pH9gzqOk1GS&licenseId=LIC4047&projectName=12022026_Testing/";
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("appium:deviceName", "Pixel Tablet");
    caps.setCapability("platformName", "Android");
    caps.setCapability("appium:platformVersion", "16");
    caps.setCapability("appium:browserName", "Chrome");
    caps.setCapability("appium:deviceType", "public");
    caps.setCapability("appium:isVirtual", true);
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
