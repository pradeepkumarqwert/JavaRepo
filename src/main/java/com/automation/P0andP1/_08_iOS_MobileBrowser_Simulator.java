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

public class _08_iOS_MobileBrowser_Simulator {
	WebDriver driver;
	@Test(retryAnalyzer = com.frameworks.utils.RetryAnalizer.class , invocationCount = 1)
    public void run() throws InterruptedException {
    	
        try {
        	//String seleniumHubUrl = "http://103.182.210.85:4444";
            String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=vK-JO6U-sXEZzMi5z7p3b6Q2RZkUv6ugZQm_Ap4eCAvIpdFtfF3AGEv6Uahw0U9XX2kz2rqdTTa6iHP-hDgOlMnutXrAxYkjAkaq_UglUWzVmFX7p2GldzbWG5jNTP_Xhf0lu6epgN_YBmq8UkSzczCPn9DgYO_zHwLIV2TXCQXDrKljzvNSz7hGRB9lT3LfKREmjbqv3gcNwPv5di1Wfk0VtA_4RIozgn6l_WTGZ8blrUFwf0lLVty0w7qYdG_dO6TL1f6cjCHOJJD99MLalNSNl9gzip1luJV7QpuH5ds_WDM_FofmCEwKscjCSDBT&licenseId=LIC2026658&projectName=Sanity_20012026/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Simulator iPhone 15");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("appium:platformVersion", "17.5");
            caps.setCapability("appium:browserName", "Safari");
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
