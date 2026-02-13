package com.automation.P0andP1;

import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.GeneralStore_Repository;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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

public class _27_Native_Application {
    AndroidDriver driver;
    BaseMethodsCloud baseMethod;
    BaseObjectsCloud objectCreate;
    GeneralStore_Repository GS_repo;

    @Test()
    public void initializationApp() throws MalformedURLException, InterruptedException {
//
//        caps.setCapability("appium:appPackage", "com.google.android.calendar");
//        caps.setCapability("appium:appActivity", "com.android.calendar.AllInOneActivity");


//        caps.setCapability("appium:appPackage", "com.pl.pp");
//        caps.setCapability("appium:appActivity", "com.pl.pp.MainActivity");
//        caps.setCapability("appium:noReset", true);

//        caps.setCapability("appium:appPackage", "com.androidsample.generalstore");
//        caps.setCapability("appium:appActivity", "com.androidsample.generalstore.SplashActivity");
//        caps.setCapability("appium:noReset", true);




        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=2XpX0pCCa5sZ4t42o2SQX7vVo3eapYfPDT-9I23oKiqp_DvSuFM7Wm54CZ8w07m4S0Q5hrpgNjeLO-gLBOyum4dn2ZczCYUFb25CzoAaTITZGr6fdL_AAriC4iMwJOBx3Ym9GXYg0kNy7ijkRDtqUF12GB_gjeElLM6ilD7Wbc98mhpUJgnemzbel-dPbkDYUxvZ5HMvQhKG4VuQogRYrOPrd_NXXKGypsEY0Fj3B8Fhmr4yBFKBn3-ig1ia9gtwwW8iUXrHr4QXHWJJ5CF94ozXB3nDOnOiE00V8iiC7pH9gzqOk1GS&licenseId=LIC4047&projectName=12022026_Testing/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "Samsung Galaxy A12");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "12");
        caps.setCapability("appium:appPackage", "com.androidsample.generalstore");
        caps.setCapability("appium:appActivity", "com.androidsample.generalstore.SplashActivity");
        caps.setCapability("appium:noReset", true);
        caps.setCapability("appium:deviceType", "public");
        caps.setCapability("appium:isVirtual", false);
        driver = new AndroidDriver(new URL(device_farm_hub_url), caps);

        System.out.println("Execution started");


        Thread.sleep(25000);
        takeScreenshot(driver, "Android_MobileApp_RealDevice");

        if (driver != null) {
            driver.quit();
            System.out.println("driver quit successfully");
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
