package com.scripts.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class _01_MobileBrowser_BulkExecution {
    WebDriver driver;
    @Test(invocationCount = 15)
    public void run() throws InterruptedException {

        //            caps.setCapability("appium:deviceType","private");

        try {
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=UROp2NK1S1n2CqbwEB1NysiD2O0jfc3ewjD_y88BI0x3_cfq0TmCpS0H96diiXIZTP118ql7yAhYlPjCjeCBLDSaOmVFEKn5A2KVArnnNQ1bCD5e7e2mfjJxkJH_16ryVAG5clgaWCwTxd9v5tzHP5IwpkJ45aLrh4rcDmvb9o2k3YmnpJSNoHeaOn7OgaC0D1AV8Qb7clnwuUWIEpvwSZUBkWaWwNWLe-wHgCSxUvl1TwAjul628M_-RacvMslGiMODTaydLCe9iKPbSbysYpERdpM4jzf2-_HB_-it9ZCBT8CGs3C2fA&licenseId=LIC4340&projectName=Post_refactor_exceeded_AT/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Pixel 7 Pro");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "14");
            caps.setCapability("appium:browserName", "Chrome");
            caps.setCapability("appium:deviceType", "public");
            caps.setCapability("appium:isVirtual", true);
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), caps);

            //caps.setCapability("appium:chromedriverAutodownload", true);
            Thread.sleep(3000);

            for(int i = 0; i<=3; i++) {
                driver.get("https://www.pantaloons.com/");
                System.out.println("Opened Pantaloons in mobile browser.");
                takeScreenshot(driver, "04_After_Search_Result_Click");
                driver.findElement(By.cssSelector("div.mobilesearchbox")).click();
                takeScreenshot(driver, "04_After_Search_Result_Click");
            }


        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());

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
