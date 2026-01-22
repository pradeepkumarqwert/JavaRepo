package com.automation.P0andP1;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

public class TestDuration {

    @Test(invocationCount = 1)
    public static void run() {

        WebDriver driver = null;

        try {

            // --------------------------
            // 1. Set Hub URL + Capabilities
            // --------------------------
            //            String device_farm_hub_url = "http://103.182.210.84:4444";
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//			HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
//			capabilities.setCapability("browserName", "Chrome");
//			bstackOptions.put("os", "Windows");
//			bstackOptions.put("osVersion", "11");
//			bstackOptions.put("browserVersion", "139.0");
//			bstackOptions.put("userName", "pratapmnaik_Gbgctm");
//			bstackOptions.put("accessKey", "sjXEsrqbDxp9vzc4vCjK");
//			bstackOptions.put("video", true);
//			bstackOptions.put("networkLogs",true);
//			bstackOptions.put("consoleLogs", "info");
//			capabilities.setCapability("bstack:options", bstackOptions);
//
//			driver = new RemoteWebDriver(
//					new URL("https://hub-cloud.browserstack.com/wd/hub"),
//					capabilities
//			);
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=QWgkKT6DGIR2iG74EUlW7deRNRYzgxHmiT9mNT2qYfatAtZNLMy3Jmwcc7SKuyaEUTGnty30p1C47JclhmbT46vs54qV_r8LM1Ij_zz50kuSdaWB0aNLFu9CKqwbPxYI5e9sTakYruZQ3rSVVKjdXrWERTWp9lYC2e-n9CNQoMhbZiTF-2GQ5sJvjD-570Mhh04qbLhLMk0gqzNS_mSRV2RmBAnZRsILfQvO1waWPC_q4I72O-lD7T1zk4Mh_5eT8wRYnXjcHXyneO4g19Avmq4zK6dYxbbmh5CBiyqWRxmwBGurdS0U&licenseId=LIC4045&projectName=Testing_19012026/";
            EdgeOptions browserOptions = new EdgeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("129");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));


            // --------------------------
            // 2. Navigate to Google
            // --------------------------
            driver.get("https://www.google.com");
//            takeScreenshot(driver, "01_Google_Page");
//            driver.manage().window().maximize();

//
////                 --------------------------
////                 3. Navigate to Pantaloons Landing Page
////                 --------------------------
//            driver.navigate().to("https://www.pantaloons.com");
////                Thread.sleep(15000);
//            takeScreenshot(driver, "02_Pantaloons_Landing");
////                Thread.sleep(15000);
//
////                Thread.sleep(2000);
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
////                Thread.sleep(15000);
//            takeScreenshot(driver, "04_Typed_Search");
////                Thread.sleep(15000);
//
////                Thread.sleep(2000);
//            searchBar.sendKeys(Keys.ENTER);
//            takeScreenshot(driver, "05_Search_Results");

//                Thread.sleep(4000);

//                // --------------------------
//                // 6. Apply Gender Filter → Boys
//                // --------------------------
//            WebElement filterGender = driver.findElement(By.xpath("//p[text()='Gender']"));
//            filterGender.click();
//            takeScreenshot(driver, "06_Gender_Filter_Clicked");
//
//            WebElement boysCheckbox = driver.findElement(By.xpath("//p[text()='Boys']//ancestor::div[contains(@class,'PlpWeb_filter-values')]//input"));
//            boysCheckbox.click();
//            takeScreenshot(driver, "07_Boys_Filter_Clicked");

//                Thread.sleep(3000);


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
