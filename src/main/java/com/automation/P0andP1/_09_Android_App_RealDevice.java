package com.automation.P0andP1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.GeneralStore_Repository;

import io.appium.java_client.android.AndroidDriver;

public class _09_Android_App_RealDevice {
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
    	String seleniumHubUrl = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=aeedf5e8-d698-4876-9ab0-aeab6a084b86&licenseId=LIC1026493&projectName=Project+for+Demo/";
    	DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability("appium:deviceName", "Vivo V40 Pro");
    	caps.setCapability("platformName", "Android");
    	caps.setCapability("appium:platformVersion", "14");
    	caps.setCapability("appium:app", "General-Store-final (1).apk");
    	driver = new AndroidDriver(new URL(seleniumHubUrl), caps);








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
        Thread.sleep(1000);
        baseMethod.Click(GS_repo.CountryOptionInDropDown(countryName));
        System.out.println(countryName);

        baseMethod.Click(GS_repo.getGeneralStoreYourNameTextFiledElement());
        baseMethod.TypeText(GS_repo.getGeneralStoreYourNameTextFiledElement(), testerName);
        Thread.sleep(10000);
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
}
