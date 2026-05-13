package com.masterSanityPack;

import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.GeneralStore_Repository;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class _25_Native_Application {
    AndroidDriver driver;
    BaseMethodsCloud baseMethod;
    BaseObjectsCloud objectCreate;
    GeneralStore_Repository GS_repo;

    @Test()
    public void initializationApp() throws MalformedURLException, InterruptedException {
        String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=NCIy1e_-zEgG-15AuI-i6cZJRAOZxsq1p9r8-SjfEPrDwDn-oPLlFAcz4je4MS3pfaWQX3BMlhj3q1QHPNeDXcvGGf7RI7fnEHQThJbAxqTuql-pJYRld_Vr-eaGuxTtagWXNZstVZY5zOrGvpWYzCNQXVyA8EihmlqQ79t9l5vchVYC1doULHptVZpGXarEeENHvHf8MCqNwiFLRiekfD6H24oVlrtc0zuk43i9REA6FQJP1wPb1lm4Mm22xLihHRdL1MT1W3PsT3LMR_GkNM3jWDr-W7f6ggIjCPCoZFHJ16bHvLf_5ugkmIPaL8av&licenseId=LIC2026615&projectName=02032026_Testing_103/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "iQOO Neo7 Pro");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "15");
        caps.setCapability("appium:appPackage", "com.medplus.mobile.android");
        caps.setCapability("appium:appActivity", "com.medplus.mobile.android.MainActivity");
        caps.setCapability("appium:noReset", "true");
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












//        Lower envi:
//        ------------
//                Samsung Galaxy A12:
//        --------------------
//                App Name: Clock
//                ------------------
//        caps.setCapability("appium:appPackage", "com.sec.android.app.clockpackage");
//        caps.setCapability("appium:appActivity", "com.sec.android.app.clockpackage.ClockPackage");
//        caps.setCapability("appium:noReset", "true");
//
//        App Name: Camera
//                ------------------
//        caps.setCapability("appium:appPackage", "com.sec.android.app.camera");
//        caps.setCapability("appium:appActivity", "com.sec.android.app.camera.Camera");
//        caps.setCapability("appium:noReset", true);
//
//
//        App Name: KFC
//                -------------------
//            caps.setCapability("appium:appPackage", "com.yum.kfc");
//            caps.setCapability("appium:appActivity", "com.cognizantorderserv.kfcindiadroid.MainActivity");
//
//        caps.setCapability("appium:appPackage", "com.Dominos");
//        caps.setCapability("appium:appActivity", "com.Dominos.activity.alias.LauncherDefaultAlias");
//        caps.setCapability("appium:noReset", "true");
//
//
//
//
//                App Name: Gmail
//                ------------------
//        caps.setCapability("appium:appPackage", "com.google.android.gm");
//        caps.setCapability("appium:appActivity", "com.google.android.gm.ConversationListActivityGmail");
//        caps.setCapability("appium:noReset", "true");
//        App Name: Chrome
//                ------------------
//        caps.setCapability("appium:appPackage", "com.android.chrome");
//        caps.setCapability("appium:appActivity", "com.google.android.apps.chrome.Main");
//        caps.setCapability("appium:noReset", "true");
//
//        App Name: Groww
//                ------------------
//        caps.setCapability("appium:appPackage", "com.nextbillion.groww");
//        caps.setCapability("appium:appActivity", "com.nextbillion.groww.genesys.loginsignup.activities.LoginActivity");
//        caps.setCapability("appium:noReset", "true");
//
//
//        App Name: Messages
//                ------------------
//        caps.setCapability("appium:appPackage", "com.google.android.apps.messaging");
//        caps.setCapability("appium:appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
//        caps.setCapability("appium:noReset", "true");
//
//
//        App Name: Package Names
//        ------------------
//                caps.setCapability("appium:appPackage", "com.sec.android.app.camera");
//        caps.setCapability("appium:appActivity", "com.sec.android.app.camera.Camera");
//        caps.setCapability("appium:noReset", true);
//
//
//        ----------------------------------------------------------------------------
//
//                Lower envi:
//        ------------
//                Samsung Galaxy M13:
//        --------------------
//                App Name: Calculator
//                ------------------
//
//
//        caps.setCapability("appium:appPackage", "com.sec.android.app.popupcalculator");
//        caps.setCapability("appium:appActivity", "com.sec.android.app.popupcalculator.Calculator");
//        caps.setCapability("appium:noReset", true);



//        caps.setCapability("appium:appPackage", "com.google.android.calendar");
//        caps.setCapability("appium:appActivity", "com.android.calendar.AllInOneActivity");


//        caps.setCapability("appium:appPackage", "com.pl.pp");
//        caps.setCapability("appium:appActivity", "com.pl.pp.MainActivity");
//        caps.setCapability("appium:noReset", true);

//        caps.setCapability("appium:appPackage", "com.androidsample.generalstore");
//        caps.setCapability("appium:appActivity", "com.androidsample.generalstore.SplashActivity");
//        caps.setCapability("appium:noReset", true);









//Prod:
//iQOO Neo7 Pro:
//        caps.setCapability("appium:appPackage", "com.medplus.mobile.android");
//        caps.setCapability("appium:appActivity", "com.medplus.mobile.android.MainActivity");
//        caps.setCapability("appium:noReset", "true");