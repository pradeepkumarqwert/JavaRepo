package com.automation.P0andP1.BulkExecutions.Web;


import com.report.listener.ExtentReportManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
public class _01_Windows_11_Script_Instance {
    @Test(invocationCount = 5)
    public void run() {

        WebDriver driver = null;

        try {

            // --------------------------
            // 1. Set Hub URL + Capabilities
            // --------------------------
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=uHnChthLrrZx7i3tjv6Atsi0rbbNFJI1L6EV9v-v4hJq4gij5X2bKAq75AfDVw1O5ZYv5VVRvt1kfAhFWREi3LqauNaCff0DDPYZe-LanCzWZDt2JrxKD7sjNJalFQOYru3OxKPddfBrPW1OUlqVSIi43sL2gAeyaExiJ7sGgEoY164NYts6axdWnu06sp2aWP3EquBR69Z-pYOQXlFOyLNmd4uKmcsOdpo-t8Dd6AR_gtWMcg3PLopnsAvteZos-m8dAfR3FNBDd6NaJL6JdFD8RUCAGhZJG5vi-fy41NKg-2jpeDbp&licenseId=LIC4014&projectName=New+project/";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", true);
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("132");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));



            // --------------------------
            // 2. Navigate to Google
            // --------------------------
            driver.get("https://www.pantaloons.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            takeScreenshot(driver, "02_Pantaloons_Landing");
//
//            // --------------------------
//            // 3. Navigate to Pantaloons Landing Page
//            // --------------------------
//            Thread.sleep(2000);
//
//            // --------------------------
//            // 4. Validate Pantaloons Logo
//            // --------------------------
//            WebElement logo = driver.findElement(By.xpath("//div[@class='nav-header-container']//img[@class='svgIconImg' and @alt='logoIcon']"));
//            if (logo.isDisplayed()) {
//                System.out.println("Pantaloons logo is displayed");
//            }
//            takeScreenshot(driver, "03_Logo_Visible");
//
//            // --------------------------
//            // 5. Search for Shirts
//            // --------------------------
//            WebElement searchBar = driver.findElement(By.xpath("//div[@class='nav-links']//input[@placeholder='Search']"));
//            searchBar.click();
//            searchBar.sendKeys("Shirts");
//            takeScreenshot(driver, "04_Typed_Search");
//
//            Thread.sleep(2000);
//            searchBar.sendKeys(Keys.ENTER);
//            takeScreenshot(driver, "05_Search_Results");
//
//            Thread.sleep(10000);

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
