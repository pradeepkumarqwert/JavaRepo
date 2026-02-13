package com.scripts.resource;

import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.GeneralStore_Repository;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
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

public class RoughScript2 {
    AndroidDriver driver;
    IOSDriver driver1;
    BaseMethodsCloud baseMethod;
    BaseObjectsCloud objectCreate;
    GeneralStore_Repository GS_repo;

//Samsung A12 lower envi
//            caps.setCapability("appium:appPackage", "com.yum.kfc");
//            caps.setCapability("appium:appActivity", "com.cognizantorderserv.kfcindiadroid.MainActivity");


//
//            caps.setCapability("appium:appPackage", "com.sec.android.app.camera");
//            caps.setCapability("appium:appActivity", "com.sec.android.app.camera.Camera");


    @Test(invocationCount = 1)
    public void androidMainSteps() throws InterruptedException, MalformedURLException {
        try {

            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=vQRrDb67MMMVRTSuGmBVEeIGNiNDbpdfAwGxgbJApIXKOWnsYLOit0Lt-nQxfqwofzKgJSgMTKIBScsiKH1KQQiFOXqNpWyUHNfeGGTdTJ4_8_IrOb36YRGUcMJ-cKjW3P62TW8deuquV2qAYMU0IxskQQgvDYgUObbQTMsiByYd3hOUn-oSXZUguVXlBmmXa7mBMhrKmwtORd8jqVVwZsBDh6buRnnzEPLseZBrI-tDH15qkomQ2oEoKZgHEc0SVIVf1WP1ypuTRabZNjVoI5QfiDmcDenZfYYubO47wzlZEC7fOqmK69mLaN_JEgo&licenseId=LIC4139&projectName=Web+Project/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Simulator iPad Air 13inch M3");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("appium:platformVersion", "18.4");
            caps.setCapability("appium:bundleId", "com.apple.AppStore");
            caps.setCapability("appium:deviceType", "public");
            caps.setCapability("appium:isVirtual", true);
            driver1 = new IOSDriver(new URL(device_farm_hub_url), caps);





            takeScreenshot(driver1, "Android_MobileApp_RealDevice");
            Thread.sleep(5000);
            takeScreenshot(driver1, "Android_MobileApp_RealDevice");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if(driver1 != null){
                driver1.quit();
                System.out.println("Driver is quited successfully");
            }
        }

    }



    public static void takeScreenshot(IOSDriver driver, String fileName)
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
