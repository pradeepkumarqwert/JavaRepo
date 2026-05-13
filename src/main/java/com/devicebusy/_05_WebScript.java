package com.devicebusy;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
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

public class _05_WebScript {

    WebElement logo;
    WebElement searchBar;
    WebDriver driver = null;
    WebElement boysCheckbox;
    WebElement filterGender;
    WebElement element;


    public boolean waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


    @BeforeClass
    public void initialization() throws MalformedURLException {
        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=IoSXgcnp1EZtUQxDMjZBnKRn--tSgRruqpAXT-hMho6g3dsGkU6kEmjmSA878nU1-ZjyMsTVF5g1FNS2HZOU6cK1g1rONHNcJTJspSOl9LYgo9E2cTDQmHmNwsRWufus7dgjmNdDQSmlp3jFbORNTzDtVL1DAsesr18Coi_wZfbS3s0zHR2hm2KHRYddPKWKLGh9htCqpYhghrXwpxgUWhD9wjmfJlNsJJcAkUjdEjXlRFgBaXaNmaApuAQdzm9p7y0LFEZVRyAu5e_T2tcYHrRNKu-dWQby-6AJwedt1-mcW9pPdBra7aasxjdOAu4&licenseId=LIC4139&projectName=06032026/";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setCapability("fireflink:deviceType", "public");
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("131");
        driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));


    }

    @Test(invocationCount = 1)
    public void run() {


        try {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            // --------------------------
            // 2. Navigate to Google
            // --------------------------
            driver.get("https://www.google.com");
            Thread.sleep(100000);
//            takeScreenshot(driver, "01_Google_Page");
//            driver.manage().window().maximize();
//
////                 --------------------------
////                 3. Navigate to Pantaloons Landing Page
////                 --------------------------
//            driver.navigate().to("https://www.pantaloons.com");
//            takeScreenshot(driver, "02_Pantaloons_Landing");
//
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
//            Thread.sleep(4000);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//            // Wait until element is clickable
//
//            element = wait.until(
//                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Gender']"))
//            );
//
//            filterGender = driver.findElement(By.xpath("//p[text()='Gender']"));
//            filterGender.click();
//            takeScreenshot(driver, "06_Gender_Filter_Clicked");
//
//            boysCheckbox = driver.findElement(By.xpath("//p[text()='Boys']//ancestor::div[contains(@class,'PlpWeb_filter-values')]//input"));
//            boysCheckbox.click();
//            takeScreenshot(driver, "07_Boys_Filter_Clicked");



            System.out.println("Test execution completed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
            System.out.println("Driver Quited successfully");
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
