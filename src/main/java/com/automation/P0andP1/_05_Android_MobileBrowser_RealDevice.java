package com.automation.P0andP1;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class _05_Android_MobileBrowser_RealDevice {
	WebDriver driver;
	@Test(retryAnalyzer = com.frameworks.utils.RetryAnalizer.class , invocationCount = 1)
    public void run() throws InterruptedException {
    	
        try {

            String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=e2mZRKEkfTrekbX8bjKBW1Ey2uVnC98y4SNUvKWW0AcrVmGA58Kn3Ks2wJYJPnLNs_1QAY40zpgEv2qUxfj7HZ9LajWiPpKC9AfQ9PMGBsXewnZ_fKpyqmxN8M_2okrPZQAXE5XtQZUCMrb1jqM8A-EQ5T-8OD8JQd79RL0oEb4xpWlbX_ReLAxQVMr_lsOyGK9tbEmwfYLH75Mr1xkooPMI57NuYr9gZp1scSCnhnAubcdZBMYY5UcOlVWiFOAcT75t3F8wv4G11pXXd_GyZQQmBbKCep_xqu2IvIgi1puHMKOwmjbiqf8dTMpeL0rf&licenseId=LIC2026610&projectName=29122025_Sanity_Testing/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Vivo V30 Pro");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "14");
            caps.setCapability("appium:browserName", "Chrome");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), caps);




            //caps.setCapability("appium:chromedriverAutodownload", true);

            driver.get("https://www.pantaloons.com/");
            System.out.println("Opened Pantaloons in mobile browser.");
            takeScreenshot(driver, "01_HomePage");

            Thread.sleep(30000);


            driver.findElement(By.cssSelector("div.mobilesearchbox")).click();
            System.out.println("Clicked.");
            takeScreenshot(driver, "02_After_Click_Search_Icon");

            Thread.sleep(5000);

            driver.findElement(By.xpath("//input[@placeholder='Search for products,brands and more...']")).sendKeys("Shirt");
            System.out.println("Entered.");
            takeScreenshot(driver, "03_After_Entering_Search");

            Thread.sleep(2000);

            driver.findElement(By.xpath("(//mark[text()='Shirt'])[1]")).click();
            System.out.println("Searched for item");
            takeScreenshot(driver, "04_After_Search_Result_Click");

            Thread.sleep(4000);
            driver.findElement(By.cssSelector("span.cartSpriteIcon")).click();
            System.out.println("Opened Cart");
            takeScreenshot(driver, "05_Cart_Page");

            System.out.println("Page Title: " + driver.getTitle());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            takeScreenshot(driver, "99_Exception_Occurred");
        } finally {
            if (driver != null) {
                driver.quit();
            }
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
