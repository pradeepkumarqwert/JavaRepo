package com.automation.P0andP1;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class _12_App_Mobile_Virtual_iOSBrowser {
	WebDriver driver;
	@Test(retryAnalyzer = com.frameworks.utils.RetryAnalizer.class , invocationCount = 1)
    public void run() throws InterruptedException {
    	
        try {
        	//String seleniumHubUrl = "http://103.182.210.85:4444";
            String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=NCIy1e_-zEgG-15AuI-i6cZJRAOZxsq1p9r8-SjfEPrDwDn-oPLlFAcz4je4MS3pfaWQX3BMlhj3q1QHPNeDXcvGGf7RI7fnEHQThJbAxqTuql-pJYRld_Vr-eaGuxTtagWXNZstVZY5zOrGvpWYzCNQXVyA8EihmlqQ79t9l5vchVYC1doULHptVZpGXarEeENHvHf8MCqNwiFLRiekfD6H24oVlrtc0zuk43i9REA6FQJP1wPb1lm4Mm22xLihHRdL1MT1W3PsT3LMR_GkNM3jWDr-W7f6ggIjCPCoZFHJ16bHvLf_5ugkmIPaL8av&licenseId=LIC2026615&projectName=04022026_Card_Testing/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Simulator iPad Pro 13inch");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("appium:platformVersion", "18.4");
            caps.setCapability("appium:browserName", "Safari");
            caps.setCapability("appium:deviceType", "public");
            caps.setCapability("appium:isVirtual", true);
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), caps);


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            Actions actions = new Actions(driver);
    		  
            driver.get("https://www.wikipedia.org/");
            Thread.sleep(2000);
           
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));

            Thread.sleep(2000);
            searchInput.sendKeys("iPhone");
            takeScreenshot(driver, "Captured");



            Thread.sleep(2000);
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            takeScreenshot(driver, "Captured");

            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
            takeScreenshot(driver, "Captured");

            Thread.sleep(2000);
            System.out.println("Title after search: " + driver.getTitle());
            takeScreenshot(driver, "Captured");

            Thread.sleep(2000);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(1000);
            takeScreenshot(driver, "Captured");

            Thread.sleep(2000);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            takeScreenshot(driver, "Captured");

            Thread.sleep(2000);
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href,'Apple')])[1]")));
            link.click();
            takeScreenshot(driver, "Captured");

            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
            takeScreenshot(driver, "Captured");

            Thread.sleep(2000);
            WebElement heading = driver.findElement(By.tagName("h1"));
            System.out.println("Opened page: " + heading.getText());

            Thread.sleep(2000);
            driver.navigate().back();

            Thread.sleep(2000);
            System.out.println("Now on: " + driver.getCurrentUrl());

            Thread.sleep(2000);
            driver.navigate().refresh();




        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            takeScreenshot(driver, "99_Exception_Occurred");
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Driver closed.");
            }
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
