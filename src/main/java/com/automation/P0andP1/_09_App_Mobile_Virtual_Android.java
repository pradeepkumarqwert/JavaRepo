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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class _09_App_Mobile_Virtual_Android {
    AndroidDriver driver;
    BaseMethodsCloud baseMethod;
    BaseObjectsCloud objectCreate;
    GeneralStore_Repository GS_repo;

    @BeforeMethod
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

        // For Fireflink Cloud
        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=9SSxXZs9tf_boR37zBzxRORa5mNA0bWvgO3fdAKqIDub7-RkDTsaw4C1KscNSK1awAxG6Ir5vzMuTgRFPMLxTDvNJDJAWYaQikuHtJQ-FCu1DQoQNrUP_Zy8RWF-FisLOYBgw2WNzNtMmrzOGZylLkWkLzywDs32QKiHow0M0akxEsE7il7xaxWixaMt1RdS8NRLCUyIYXjIhgOa6pdOKHc95oqmsenHwo_0iHjHJfUWZFX3-i34X784ah2CPighR9T6vHQ6RVvMWbjz_Hjh-v4SHG8Z79TkZ2aFhrycUUkztfIcdAFT&licenseId=LIC4033&projectName=C_Basic_Sanity_30012026/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "Pixel 7");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "15");
        caps.setCapability("appium:app", "General-Store-final (4).apk");
        caps.setCapability("appium:deviceType", "public");
        caps.setCapability("appium:isVirtual", true);
        driver = new AndroidDriver(new URL(device_farm_hub_url), caps);


        // Initialize helpers
        baseMethod = new BaseMethodsCloud(driver);
        objectCreate = new BaseObjectsCloud(driver);
        GS_repo = new GeneralStore_Repository(driver);
        System.out.println("Execution started");
    }

   

    @Test(dataProvider = "CountryName", invocationCount = 1)
    public void androidMainSteps(String countryName, String testerName, String gender) throws InterruptedException {
    	Thread.sleep(2000);
        baseMethod.Click(GS_repo.getGeneralStoreSelectionOfCountryDropDownElement());
        takeScreenshot(driver, "Android_MobileApp_Emulators");
        Thread.sleep(1000);
        baseMethod.Click(GS_repo.CountryOptionInDropDown(countryName));
        takeScreenshot(driver, "Android_MobileApp_Emulators");
        System.out.println(countryName);

        baseMethod.Click(GS_repo.getGeneralStoreYourNameTextFiledElement());
        takeScreenshot(driver, "Android_MobileApp_Emulators");
        baseMethod.TypeText(GS_repo.getGeneralStoreYourNameTextFiledElement(), testerName);
        takeScreenshot(driver, "Android_MobileApp_Emulators");
        Thread.sleep(10000);
        System.out.println(testerName);
        driver.hideKeyboard();
        baseMethod.Click(GS_repo.GenderRadioButton(gender));
        baseMethod.Click(GS_repo.getLetsShopButton());
        takeScreenshot(driver, "Android_MobileApp_Emulators");

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(GS_repo.getProduct1AddToCartButton()));
        baseMethod.Click(GS_repo.getProduct1AddToCartButton());
        takeScreenshot(driver, "Android_MobileApp_Emulators");

        String number_Of_Products_Added = baseMethod.GetText(GS_repo.getFetchNumberOfProductAddedToCart(),
                "Fetching Number of products added to cart");
        baseMethod.ElementIsDisplay(GS_repo.CheckNumberOfProductAddedToCart(number_Of_Products_Added));
        takeScreenshot(driver, "Android_MobileApp_Emulators");
        baseMethod.Click(GS_repo.getCartButton());
        takeScreenshot(driver, "Android_MobileApp_Emulators");
        wait.until(ExpectedConditions.visibilityOf(GS_repo.getVerifyCartPage()));
        baseMethod.ElementIsDisplay(GS_repo.getVerifyAddedProductInCartPage());
        takeScreenshot(driver, "Android_MobileApp_Emulators");
    }
    
    

    @AfterMethod
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
