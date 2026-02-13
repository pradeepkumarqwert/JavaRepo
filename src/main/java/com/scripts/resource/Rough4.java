package com.scripts.resource;

import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.GeneralStore_Repository;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class Rough4 {
    AndroidDriver driver;
    BaseMethodsCloud baseMethod;
    BaseObjectsCloud objectCreate;
    GeneralStore_Repository GS_repo;

//Samsung A12 lower envi
//            caps.setCapability("appium:appPackage", "com.yum.kfc");
//            caps.setCapability("appium:appActivity", "com.cognizantorderserv.kfcindiadroid.MainActivity");


//
//            caps.setCapability("appium:appPackage", "com.sec.android.app.camera");
//            caps.setCapability("appium:appActivity", "com.sec.android.app.camera.Camera");


    @Test(invocationCount =1)
    public void androidMainSteps() throws InterruptedException, MalformedURLException {
        try {

            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=gpLL6cBoP80wWRUOKCFToC2MAR0d40JVsseGS2O6RxXHMW441fBUR7CaCCOIZLcjAgkd8zUlVGp5S0rM7dZfKFgsW6ibAvOnGsjPNdPQx4icUanJ_1blqqgSKpEcGN4Da3zKrVaeiJRmoqHi5nZBXx_XM-7P0_y5rO4Y7IL5Jxq6xYxg36QvorAd3qsq9fUs_8lwmldA9H0PpSIvR61vPBP0NnNY8Cpumk4KNZHKj2xSnerRwChNKJVpOmhdufZtj-uvavtFYPLzY6YEDtxzcRv2ebU0NXOXBg1u-NRVnliB6N49pjQ&licenseId=LIC3996&projectName=Testing_27012026/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Samsung Galaxy M13");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "13");
            caps.setCapability("appium:appPackage", "com.sec.android.app.popupcalculator");
            caps.setCapability("appium:appActivity", "com.sec.android.app.popupcalculator.Calculator");
            caps.setCapability("appium:deviceType", "private");
            caps.setCapability("appium:isVirtual", false);
            driver = new AndroidDriver(new URL(device_farm_hub_url), caps);


//            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=gpLL6cBoP80wWRUOKCFToC2MAR0d40JVsseGS2O6RxXHMW441fBUR7CaCCOIZLcjAgkd8zUlVGp5S0rM7dZfKFgsW6ibAvOnGsjPNdPQx4icUanJ_1blqqgSKpEcGN4Da3zKrVaeiJRmoqHi5nZBXx_XM-7P0_y5rO4Y7IL5Jxq6xYxg36QvorAd3qsq9fUs_8lwmldA9H0PpSIvR61vPBP0NnNY8Cpumk4KNZHKj2xSnerRwChNKJVpOmhdufZtj-uvavtFYPLzY6YEDtxzcRv2ebU0NXOXBg1u-NRVnliB6N49pjQ&licenseId=LIC3996&projectName=Testing_27012026/";
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("appium:deviceName", "Pixel 7 Pro");
//            caps.setCapability("platformName", "Android");
//            caps.setCapability("appium:platformVersion", "15");
//            caps.setCapability("appium:appPackage", "com.google.android.gm");
//            caps.setCapability("appium:appActivity", "com.google.android.gm.ConversationListActivityGmail");
//            caps.setCapability("appium:noReset", "true");
//            caps.setCapability("appium:deviceType", "public");
//            caps.setCapability("appium:isVirtual", true);
//            driver = new AndroidDriver(new URL(device_farm_hub_url), caps);
//



            takeScreenshot(driver, "Android_MobileApp_RealDevice");
            Thread.sleep(5000);
            takeScreenshot(driver, "Android_MobileApp_RealDevice");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if(driver != null){
                driver.quit();
                System.out.println("Driver is quited successfully");
            }
        }

    }



    public static void takeScreenshot(AndroidDriver driver, String fileName)
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
