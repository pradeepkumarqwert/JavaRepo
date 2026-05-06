package com.scripts.resource;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AAA_AndroidCheckingCaps {

    @Test(invocationCount = 50)
    public void run() throws MalformedURLException {

        // Set ChromeDriver path if needed
        // System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=iQOuwQOGpGRqOJkdPL3H3H-Ti9XkQ9sxKOc6JEaQSmE4Ek7AhjMwEM2-PYwCmQgvD3atpN83a6CI7hRqNliptLL2Tk3j3V3ZKzvVazaNJ1QHiJcYTRqtlQ5W_2AfyCWgAAalEuYOLRUIMSMQri8LQ666cxhXIawmI8uLfYDWPgUmbh4-MrFn8v2e1lAAmwzdGhIs2RETFGBUuwjd1Jx5yLkoV2BMU5OlEnYcobzzVoB-60owlkydm0Ufsm9c7gF4Apn4oa-UU_y4jEbDSBlnwpZd6klzsVE9lMihb50R9dhq0qD9t7O5tx4pbbE6eG0&licenseId=LIC4341&projectName=Post_Refactor_Exceeded_AT/";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setCapability("fireflink:deviceType", "public");
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("122");
        WebDriver driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));


        try {
            // 1. Navigate to test website
            driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
            driver.manage().window().maximize();

            // 2. Total execution time = 8 minutes
            long endTime = System.currentTimeMillis() + (1 * 5 * 1000);
//            long endTime = System.currentTimeMillis() + (8 * 60 * 1000);


            // 3. Continuous clicking loop
            while (System.currentTimeMillis() < endTime) {
                try {
                    // Re-locate element every time (avoids stale issues)
                    takeScreenshot(driver, "04_After_Search_Result_Click");
                    System.out.println("Clicked at: " + System.currentTimeMillis());
                    driver.manage().window().minimize();
                    takeScreenshot(driver, "04_After_Search_Result_Click");
                    // Wait for 2 seconds
                    Thread.sleep(2000);

                } catch (Exception e) {
                    System.out.println("Retrying click...");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4. Close browser after execution
            driver.quit();
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