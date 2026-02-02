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

public class _13_App_Tablet_Real_Android {
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
        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=38POQeInJdHhuT1LtwaXooJ2zBkiutf5JUZb6lEChNPORDu7hjD96aTphCcTtnmTHDvIqo9QVvdfD3qG02wmqXjMDm2eGxTb9NsZ1ANx5AU9bMAWAsvWIyQqm_euXcBVF2x2zlG-Ywljt7BbH5FVBY_R_F6YNNGHagJxekSUaZCe4MoaD6eHdItJ3vKBKAI8c-AkThezsaX2W0GemgYOjaTnyA6UzS5aiCVttAcvl9mPhlhbgc8pAEOMNaYeGpwh_0Vu5ptnSQ29gCAnWmmTGf7mCSgH35RanpkW2825qxtuMY0U_8_ElA&licenseId=LIC4045&projectName=Testing+21012026/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:isVirtual", false);
        caps.setCapability("appium:deviceType", "public");
        caps.setCapability("appium:deviceName", "Pixel Tablet");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "16");
        caps.setCapability("appium:app", "General-Store-final (4).apk");
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
        takeScreenshot(driver, "Android_MobileApp_Tablet");
        Thread.sleep(1000);
        baseMethod.Click(GS_repo.CountryOptionInDropDown(countryName));
        takeScreenshot(driver, "Android_MobileApp_Tablet");
        System.out.println(countryName);

        baseMethod.Click(GS_repo.getGeneralStoreYourNameTextFiledElement());
        takeScreenshot(driver, "Android_MobileApp_Tablet");
        baseMethod.TypeText(GS_repo.getGeneralStoreYourNameTextFiledElement(), testerName);
        takeScreenshot(driver, "Android_MobileApp_Tablet");
        Thread.sleep(10000);
        System.out.println(testerName);
        driver.hideKeyboard();
        baseMethod.Click(GS_repo.GenderRadioButton(gender));
        takeScreenshot(driver, "Android_MobileApp_Tablet");
        baseMethod.Click(GS_repo.getLetsShopButton());
        takeScreenshot(driver, "Android_MobileApp_Tablet");

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(GS_repo.getProduct1AddToCartButton()));
        baseMethod.Click(GS_repo.getProduct1AddToCartButton());
        takeScreenshot(driver, "Android_MobileApp_Tablet");

        String number_Of_Products_Added = baseMethod.GetText(GS_repo.getFetchNumberOfProductAddedToCart(),
                "Fetching Number of products added to cart");
        baseMethod.ElementIsDisplay(GS_repo.CheckNumberOfProductAddedToCart(number_Of_Products_Added));
        takeScreenshot(driver, "Android_MobileApp_Tablet");
        baseMethod.Click(GS_repo.getCartButton());
        takeScreenshot(driver, "Android_MobileApp_Tablet");
        wait.until(ExpectedConditions.visibilityOf(GS_repo.getVerifyCartPage()));
        baseMethod.ElementIsDisplay(GS_repo.getVerifyAddedProductInCartPage());
        takeScreenshot(driver, "Android_MobileApp_Tablet");
    }
    
    

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver closed.");
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
