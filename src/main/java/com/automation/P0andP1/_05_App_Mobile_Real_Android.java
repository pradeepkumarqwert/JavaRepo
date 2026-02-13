package com.automation.P0andP1;

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

public class _05_App_Mobile_Real_Android {
    AndroidDriver driver;
    BaseMethodsCloud baseMethod;
    BaseObjectsCloud objectCreate;
    GeneralStore_Repository GS_repo;

    @BeforeClass
    public void initializationApp() throws MalformedURLException {
    	 // For local Appium (uncomment this if you run locally)
        /*
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("SM_A135F");  // your real/emulator device
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.androidsample.generalstore");
        options.setAppActivity("com.androidsample.generalstore.SplashActivity");
        options.setNoReset(false);
        options.setAutoGrantPermissions(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        */


//        caps.setCapability("appium:appPackage", "com.google.android.calendar");
//        caps.setCapability("appium:appActivity", "com.android.calendar.AllInOneActivity");
//        caps.setCapability("appium:noReset", true);


        // For Fireflink Cloud


        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=vQRrDb67MMMVRTSuGmBVEeIGNiNDbpdfAwGxgbJApIXKOWnsYLOit0Lt-nQxfqwofzKgJSgMTKIBScsiKH1KQQiFOXqNpWyUHNfeGGTdTJ4_8_IrOb36YRGUcMJ-cKjW3P62TW8deuquV2qAYMU0IxskQQgvDYgUObbQTMsiByYd3hOUn-oSXZUguVXlBmmXa7mBMhrKmwtORd8jqVVwZsBDh6buRnnzEPLseZBrI-tDH15qkomQ2oEoKZgHEc0SVIVf1WP1ypuTRabZNjVoI5QfiDmcDenZfYYubO47wzlZEC7fOqmK69mLaN_JEgo&licenseId=LIC4139&projectName=Web+Project/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "Samsung Galaxy A12");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "12");
        caps.setCapability("appium:app", "General-Store-final (4).apk");
        caps.setCapability("appium:deviceType", "public");
        caps.setCapability("appium:isVirtual", false);
        driver = new AndroidDriver(new URL(device_farm_hub_url), caps);


        // Initialize helpers
        baseMethod = new BaseMethodsCloud(driver);
        objectCreate = new BaseObjectsCloud(driver);
        GS_repo = new GeneralStore_Repository(driver);
        System.out.println("Execution started");
    }

   

    @Test(dataProvider = "CountryName", invocationCount = 1)
    public void androidMainSteps(String countryName, String testerName, String gender) throws InterruptedException {
    	Thread.sleep(5000);
        baseMethod.Click(GS_repo.getGeneralStoreSelectionOfCountryDropDownElement());
        takeScreenshot(driver, "Android_MobileApp_RealDevice");
        Thread.sleep(1000);
        baseMethod.Click(GS_repo.CountryOptionInDropDown(countryName));
        takeScreenshot(driver, "Android_MobileApp_RealDevice");
        System.out.println(countryName);

        baseMethod.Click(GS_repo.getGeneralStoreYourNameTextFiledElement());
        takeScreenshot(driver, "Android_MobileApp_RealDevice");
        baseMethod.TypeText(GS_repo.getGeneralStoreYourNameTextFiledElement(), testerName);
        takeScreenshot(driver, "Android_MobileApp_RealDevice");
        Thread.sleep(10000);
        System.out.println(testerName);
        driver.hideKeyboard();
        takeScreenshot(driver, "Android_MobileApp_RealDevice");
        baseMethod.Click(GS_repo.GenderRadioButton(gender));
        takeScreenshot(driver, "Android_MobileApp_RealDevice");
        baseMethod.Click(GS_repo.getLetsShopButton());
        takeScreenshot(driver, "Android_MobileApp_RealDevice");

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(GS_repo.getProduct1AddToCartButton()));
        baseMethod.Click(GS_repo.getProduct1AddToCartButton());
        takeScreenshot(driver, "Android_MobileApp_RealDevice");

        String number_Of_Products_Added = baseMethod.GetText(GS_repo.getFetchNumberOfProductAddedToCart(),
                "Fetching Number of products added to cart");

        baseMethod.ElementIsDisplay(GS_repo.CheckNumberOfProductAddedToCart(number_Of_Products_Added));
        takeScreenshot(driver, "Android_MobileApp_RealDevice");


        baseMethod.Click(GS_repo.getCartButton());
        takeScreenshot(driver, "Android_MobileApp_RealDevice");
        wait.until(ExpectedConditions.visibilityOf(GS_repo.getVerifyCartPage()));
        baseMethod.ElementIsDisplay(GS_repo.getVerifyAddedProductInCartPage());
        takeScreenshot(driver, "Android_MobileApp_RealDevice");
    }
    
    

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("driver quit successfully");
        }
    }
    
    
    
    
    @DataProvider(name = "CountryName")
    public Object[][] options() {
        return new Object[][] {
            {"Afghanistan", "Tester1", "Male"}
//           ,{"Albania","Tester2","Female"},
//    	    {"Antarctica","Tester3","Male"},
//            {"American Samoa","Tester4","Female"},
//         	{"Andorra","Tester5","Male"},
//            {"Angola","Tester6","Female"},
//            {"Anguilla","Tester7","Male"},
//            {"Antarctica","Tester8","Female"},
//            {"Antigua and Barbuda","Tester9","Male"}
        };
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
