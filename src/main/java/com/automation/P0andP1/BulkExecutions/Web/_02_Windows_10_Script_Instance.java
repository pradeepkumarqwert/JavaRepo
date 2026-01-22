package com.automation.P0andP1.BulkExecutions.Web;


import com.report.listener.ExtentReportManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

@Listeners(ExtentReportManager.class)
public class _02_Windows_10_Script_Instance {
    @Test(invocationCount = 600)
    public void run() {

        WebDriver driver = null;

        try {

            // --------------------------
            // 1. Set Hub URL + Capabilities
            // --------------------------
            String device_farm_hub_url = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=3a927cad-ad15-4906-b318-40ac249bd12a&licenseId=LIC1026562&projectName=New+testing/";
            FirefoxOptions browserOptions = new FirefoxOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("145");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));


            // --------------------------
            // 2. Navigate to Google
            // --------------------------
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            takeScreenshot(driver, "01_Google_Page");

            // --------------------------
            // 3. Navigate to Pantaloons Landing Page
            // --------------------------
            driver.navigate().to("https://www.pantaloons.com");
            takeScreenshot(driver, "02_Pantaloons_Landing");

            Thread.sleep(2000);

            // --------------------------
            // 4. Validate Pantaloons Logo
            // --------------------------
            WebElement logo = driver.findElement(By.xpath("//div[@class='nav-header-container']//img[@class='svgIconImg' and @alt='logoIcon']"));
            if (logo.isDisplayed()) {
                System.out.println("Pantaloons logo is displayed");
            }
            takeScreenshot(driver, "03_Logo_Visible");

            // --------------------------
            // 5. Search for Shirts
            // --------------------------
            WebElement searchBar = driver.findElement(By.xpath("//div[@class='nav-links']//input[@placeholder='Search']"));
            searchBar.click();
            searchBar.sendKeys("Shirts");
            takeScreenshot(driver, "04_Typed_Search");

            Thread.sleep(2000);
            searchBar.sendKeys(Keys.ENTER);
            takeScreenshot(driver, "05_Search_Results");

            Thread.sleep(10000);

            System.out.println("Test execution completed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // --------------------------
            // 8. Quit Browser
            // --------------------------
            if (driver != null) {
                driver.quit();
            }
        }

    }

    // --------------------------
    // Save Screenshot Method
    // --------------------------
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\SimpleRunScreenshots\\" + fileName + ".png");
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }
}
