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

public class _15_App_Tablet_Real_iOS {
	WebDriver driver;
	@Test(retryAnalyzer = com.frameworks.utils.RetryAnalizer.class , invocationCount = 1)
    public void run() throws InterruptedException {
    	
        try {
            String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=yfAa_w199cJge2Gezsgb2Jnu7hKdqER1tExY5kKvgSvXfi1lRUelFsbTFI5pMq7zQuwwNXXnsLTkjKhvWcKDWsUoGLi9KjUV6gbUNDhqj0jWYFyW9h_0LIDEg5qXigwZdqzQqAvWwHin3gBhzGndeROtixv_VFhnseGSWRAHTajZzE-Zl0d8BP6gl0TEBUfoNgqBtAQVDLP6wAQzPfcyjjGFsdHkXWeHFkKmA78D7rKlnNuN2WgjIUlhYheDRDeqZ98Ig_PyS1GbUvjwJ73L38sr_cD4Y9lrKyWJV-m5RmtKhmkqRM8uk5gEfjzgwy30&licenseId=LIC2026658&projectName=Sanity_20012026/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "iPhone 13");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("appium:platformVersion", "18.4.1");
            caps.setCapability("appium:browserName", "Safari");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), caps);



            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            Actions actions = new Actions(driver);
    		  
            driver.get("https://www.wikipedia.org/");
            Thread.sleep(2000);
            takeScreenshot(driver, "Navigate to wikipedia");
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));

            Thread.sleep(2000);
            searchInput.sendKeys("iPhone");
            takeScreenshot(driver, "Wikipedia_Type_iPhone");

            Thread.sleep(2000);
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            takeScreenshot(driver, "Wikipedia_Click_On_Element");

            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));

            Thread.sleep(2000);
            System.out.println("Title after search: " + driver.getTitle());


            Thread.sleep(2000);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(1000);
            takeScreenshot(driver, "Wikipedia_PageDown");

            Thread.sleep(2000);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            takeScreenshot(driver, "Wikipedia_PageDown");

            Thread.sleep(2000);
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href,'Apple')])[1]")));
            link.click();
            takeScreenshot(driver, "Wikipedia_Wait_UntilElementToBE_Clickable");

            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

            Thread.sleep(2000);
            WebElement heading = driver.findElement(By.tagName("h1"));
            System.out.println("Opened page: " + heading.getText());
            takeScreenshot(driver, "Wikipedia_find Element");

            Thread.sleep(2000);
            driver.navigate().back();

            Thread.sleep(2000);
            System.out.println("Now on: " + driver.getCurrentUrl());
            takeScreenshot(driver, "Wikipedia_GetCurrent_URL");

            Thread.sleep(2000);
            driver.navigate().refresh();
            takeScreenshot(driver, "Wikipedia_Refresh page");

            Thread.sleep(2000);
            driver.quit();


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
