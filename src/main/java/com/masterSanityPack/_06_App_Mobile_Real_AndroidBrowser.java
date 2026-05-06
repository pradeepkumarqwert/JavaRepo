package com.masterSanityPack;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class _06_App_Mobile_Real_AndroidBrowser {
	WebDriver driver;
	@Test(invocationCount = 1)
    public void run() throws InterruptedException {

        //            caps.setCapability("appium:deviceType","private");

        try {
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=iQOuwQOGpGRqOJkdPL3H3H-Ti9XkQ9sxKOc6JEaQSmE4Ek7AhjMwEM2-PYwCmQgvD3atpN83a6CI7hRqNliptLL2Tk3j3V3ZKzvVazaNJ1QHiJcYTRqtlQ5W_2AfyCWgAAalEuYOLRUIMSMQri8LQ666cxhXIawmI8uLfYDWPgUmbh4-MrFn8v2e1lAAmwzdGhIs2RETFGBUuwjd1Jx5yLkoV2BMU5OlEnYcobzzVoB-60owlkydm0Ufsm9c7gF4Apn4oa-UU_y4jEbDSBlnwpZd6klzsVE9lMihb50R9dhq0qD9t7O5tx4pbbE6eG0&licenseId=LIC4341&projectName=05052026_Testing/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "OnePlus Nord CE 2 Lite 5G");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "14");
            caps.setCapability("appium:browserName", "Chrome");
            caps.setCapability("appium:deviceType", "public");
            caps.setCapability("appium:isVirtual", false);
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), caps);



            //caps.setCapability("appium:chromedriverAutodownload", true);
            for(int i = 0 ; i< 1 ; i++) {
                driver.get("https://www.pantaloons.com/");
//                driver.get("https://www.jiomart.com");
            }
            System.out.println("Opened Pantaloons in mobile browser.");
            takeScreenshot(driver, "01_HomePage");
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("div.mobilesearchbox")).click();
            System.out.println("Clicked.");
            takeScreenshot(driver, "02_After_Click_Search_Icon");

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
