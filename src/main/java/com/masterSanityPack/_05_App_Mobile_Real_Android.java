package com.masterSanityPack;

import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.GeneralStore_Repository;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Base64;

public class _05_App_Mobile_Real_Android {

    AndroidDriver driver;
    BaseMethodsCloud baseMethod;
    BaseObjectsCloud objectCreate;
    GeneralStore_Repository GS_repo;

    @BeforeClass
    public void initializationApp() throws Exception {

        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=iQOuwQOGpGRqOJkdPL3H3H-Ti9XkQ9sxKOc6JEaQSmE4Ek7AhjMwEM2-PYwCmQgvD3atpN83a6CI7hRqNliptLL2Tk3j3V3ZKzvVazaNJ1QHiJcYTRqtlQ5W_2AfyCWgAAalEuYOLRUIMSMQri8LQ666cxhXIawmI8uLfYDWPgUmbh4-MrFn8v2e1lAAmwzdGhIs2RETFGBUuwjd1Jx5yLkoV2BMU5OlEnYcobzzVoB-60owlkydm0Ufsm9c7gF4Apn4oa-UU_y4jEbDSBlnwpZd6klzsVE9lMihb50R9dhq0qD9t7O5tx4pbbE6eG0&licenseId=LIC4341&projectName=05052026_Testing/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "Samsung Galaxy A12");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "12");
        caps.setCapability("appium:app", "General-Store-final (4) (1).apk");
        caps.setCapability("appium:deviceType", "public");
        caps.setCapability("appium:isVirtual", false);
        driver = new AndroidDriver(new URL(device_farm_hub_url), caps);




        baseMethod = new BaseMethodsCloud(driver);
        objectCreate = new BaseObjectsCloud(driver);
        GS_repo = new GeneralStore_Repository(driver);

        System.out.println("Execution started");
    }

    @Test(dataProvider = "CountryName")
    public void androidMainSteps(String countryName, String testerName, String gender) throws Exception {

        Thread.sleep(5000);

        baseMethod.Click(GS_repo.getGeneralStoreSelectionOfCountryDropDownElement());
        takeScreenshot("Step1_OpenDropdown");

        Thread.sleep(5000);

        baseMethod.Click(GS_repo.CountryOptionInDropDown(countryName));
        takeScreenshot("Step2_SelectCountry");

        System.out.println("Selected Country: " + countryName);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    @AfterClass
    public void teardown() {

        if (driver != null) {

            driver.quit();
            System.out.println("Driver quit successfully");
        }
    }

    @DataProvider(name = "CountryName")
    public Object[][] options() {
        return new Object[][]{
                {"Afghanistan", "Tester1", "Male"}
        };
    }

    // Screenshot Utility
    public void takeScreenshot(String fileName) {

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File folder = new File("C:\\Selenium Grid\\Screenshots\\");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            File dest = new File(folder + "\\" + fileName + ".png");

            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved: " + dest.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }
}