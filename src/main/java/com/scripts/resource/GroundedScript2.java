package com.scripts.resource;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.HashMap;

public class GroundedScript2 {

    WebElement logo;
    WebElement searchBar;
    WebDriver driver = null;
    WebElement boysCheckbox;
    WebElement filterGender;
    WebElement element;





    @Test(invocationCount = 6)
    public void run() throws InterruptedException, MalformedURLException {


        try{
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=JUe4dK-Z7GZFsWV-o6SNT8zl-AqhunphBxJJuawuqGBrFLR5oDIgYYuWw-ZWC_4D8gD8xiBkms728Kw8PcR5qB4YufpntfPb-x8sOWdRT-JRyqw9hKVweIwJo-bxIentbLUIfDG6LIZjkx8ofrI-HDRNTbqzcF8cUEzC6ZwuT_ldjSHoz5jEarR8jtiPCDeV6VCmzJTSf01Jm2GGnFOXpSsHUcvrE-1pFlzaFv9j0ypdIx0swgN9KhLZ1SCrahufx4vuzepGoI1jgnjqxsnJ9pNJy12I9kItW1AJCVtPOgKYMl8CB0zmgwB666xjT2c&licenseId=LIC4045&projectName=10042026/";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setCapability("fireflink:deviceType", "public");
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("131");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));



            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            // --------------------------
            // 2. Navigate to Google
            // --------------------------
            driver.get("https://www.google.com");
            Thread.sleep(2000);
            System.out.println("Navigated to 1 URL");
            for(int i = 0 ; i<=1 ; i++) {
                driver.get("https://www.jiomart.com");
            }
            Thread.sleep(3000);
            System.out.println("Navigated to 2 URL");



            System.out.println("Test execution completed successfully.");

            if(driver != null){
                driver.quit();
                System.out.println("Driver Quited successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
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
