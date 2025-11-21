package com.bulk.androidapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.GeneralStore_Repository;

import io.appium.java_client.android.AndroidDriver;

public class ANDROID_2_GeneralStore_Script82 {
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
    	//instance 1:
//    	String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=736d95c1-64e3-46ba-8f86-cf4086a93045&licenseId=LIC3943&projectName=Sanity/";
//    	DesiredCapabilities caps = new DesiredCapabilities();
//    	caps.setCapability("appium:deviceName", "Samsung Galaxy A12");
//    	caps.setCapability("platformName", "Android");
//    	caps.setCapability("appium:platformVersion", "12");
//    	caps.setCapability("appium:app", "General-Store.apk");
//    	driver = new AndroidDriver(new URL(seleniumHubUrl), caps);

    	
    	//instance 2:
    	String seleniumHubUrl = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=fb9e37dd-df54-4577-b32c-5b3936d55c34&licenseId=LIC1026473&projectName=Bulk+execution/";
    	DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability("deviceName", "motorola edge 50");
    	caps.setCapability("platformName", "Android");
    	caps.setCapability("platformVersion", "15");
    	caps.setCapability("app", "General-Store.apk");
    	driver = new AndroidDriver(new URL(seleniumHubUrl), caps);







    	
    	
    	

        // Initialize helpers
        baseMethod = new BaseMethodsCloud(driver);
        objectCreate = new BaseObjectsCloud(driver);
        GS_repo = new GeneralStore_Repository(driver);
    }

   

    @Test(dataProvider = "CountryName", invocationCount = 1, retryAnalyzer = com.frameworks.utils.RetryAnalizer.class)
    public void androidMainSteps(String countryName, String testerName, String gender) throws InterruptedException {
    	Thread.sleep(5000);
        baseMethod.Click(GS_repo.getGeneralStoreSelectionOfCountryDropDownElement());
        Thread.sleep(1000);
        baseMethod.Click(GS_repo.CountryOptionInDropDown(countryName));
        System.out.println(countryName);

        baseMethod.Click(GS_repo.getGeneralStoreYourNameTextFiledElement());
        baseMethod.TypeText(GS_repo.getGeneralStoreYourNameTextFiledElement(), testerName);
        System.out.println(testerName);
        driver.hideKeyboard();
        baseMethod.Click(GS_repo.GenderRadioButton(gender));
        baseMethod.Click(GS_repo.getLetsShopButton());

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(GS_repo.getProduct1AddToCartButton()));
        baseMethod.Click(GS_repo.getProduct1AddToCartButton());

        String number_Of_Products_Added = baseMethod.GetText(GS_repo.getFetchNumberOfProductAddedToCart(),
                "Fetching Number of products added to cart");
        baseMethod.ElementIsDisplay(GS_repo.CheckNumberOfProductAddedToCart(number_Of_Products_Added));

        baseMethod.Click(GS_repo.getCartButton());
        wait.until(ExpectedConditions.visibilityOf(GS_repo.getVerifyCartPage()));
        baseMethod.ElementIsDisplay(GS_repo.getVerifyAddedProductInCartPage());
    }
    
    

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    
    
    
    @DataProvider(name = "CountryName")
    public Object[][] options() {
        return new Object[][] {
            {"Afghanistan", "Tester1", "Male"}
           ,{"Albania","Tester2","Female"},
    	    {"Antarctica","Tester3","Male"},
            {"American Samoa","Tester4","Female"},
         	{"Andorra","Tester5","Male"},
            {"Angola","Tester6","Female"},
            {"Anguilla","Tester7","Male"},
            {"Antarctica","Tester8","Female"},
            {"Antigua and Barbuda","Tester9","Male"}
        };
    }
}
