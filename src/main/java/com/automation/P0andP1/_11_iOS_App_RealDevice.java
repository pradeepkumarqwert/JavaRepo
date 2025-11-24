package com.automation.P0andP1;


import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class _11_iOS_App_RealDevice
{
	 IOSDriver driver;
	@DataProvider(name = "productSearchData")
    public Object[][] provideProductNames() {
        return new Object[][] {
            {"T-shirt"}, {"Jeans"}, {"Sneakers"}, {"Shirt"}, {"Jacket"},
        };
    }
	
	
	@BeforeClass
	public void initialization() throws MalformedURLException {
	    //XCUITestOptions options = new XCUITestOptions();
//	    options.setPlatformName("iOS");
//	    options.setAutomationName("XCUITest");
//	    options.setBundleId("com.myntra.myntra");
//	    options.setDeviceName("Fireflink Cloud 11 15.5");
//	    options.setPlatformVersion("15.5");
//	    options.setCapability("autoGrantPermissions", true);
//	    options.setCapability("autoAcceptAlerts", true);
//	    options.setUdid("00008030-001968812EF2402E");   
//	    try {
//			driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), options);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	   
		
		//local capabilities:
		//---------------------------
//	    DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platformName", "iOS");
//        caps.setCapability("platformVersion", "15.5"); // your iOS version
//        caps.setCapability("deviceName", "Fireflink Cloud 11 15.5"); // exact device name or UDID
//        caps.setCapability("udid", "00008030-001968812EF2402E"); // required for real device
//        caps.setCapability("automationName", "XCUITest");
//        caps.setCapability("BundleID", "com.myntra.myntra");
//        caps.setCapability("autoGrantPermissions", true);
//        caps.setCapability("autoGrantPermissions", true);
//        //options.setBundleId("com.myntra.myntra");
//        //options.setCapability("autoGrantPermissions", true);
//	    //options.setCapability("autoAcceptAlerts", true);
//        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	    
        
//		String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=9adfe132-9652-4329-a206-4c8ee67e0281&licenseId=LIC3943&projectName=Sanity/";
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability("appium:deviceName", "iPhone 11");
//		caps.setCapability("appium:platformName", "iOS");
//		caps.setCapability("appium:platformVersion", "18.3.1");
//	
//		caps.setCapability("appium:bundleId", "null");//Pls change the bundleId value to proper value.
//		IOSDriver driver = new IOSDriver(new URL(seleniumHubUrl), caps);
		
		
	
		String seleniumHubUrl = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=a31168ce-bf67-4a7a-bfa1-997fca75f65a&licenseId=LIC1026534&projectName=Time+Zone/";
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("appium:deviceName", "iPhone 14");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("appium:platformVersion", "18.5");
		caps.setCapability("appium:app", "iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1 (5).zip");



		caps.setCapability("appium:automationName", "XCUITest");
		caps.setCapability("appium:autoAcceptAlerts", true); // automatically tap Allow for popups
		caps.setCapability("appium:fullReset", true);
	
//Pls change the bundleId value to proper value.
		driver = new IOSDriver(new URL(seleniumHubUrl), caps);


	}

	@Test(dataProvider = "productSearchData")
	public void Steps(String productName) throws InterruptedException {
	   Thread.sleep(5000);
       // 2. Click on “Allow” location popup if visible (auto handled by capability)
	  

       // 3. Tap on the Search bar
       WebElement searchBar = driver.findElement(By.xpath("//XCUIElementTypeSearchField"));
       searchBar.click();

       // 4. Enter search text “Milk”
       searchBar.sendKeys("Milk");

       // 5. Wait for results and select the first product
       Thread.sleep(3000);
       WebElement firstProduct = driver.findElement(By.xpath("(//XCUIElementTypeStaticText[contains(@name,'Milk')])[1]"));
       firstProduct.click();

       // 6. Tap on “Add” button
       WebElement addButton = driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Add')]"));
       addButton.click();

       // 7. Open cart icon
       WebElement cartIcon = driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Cart')]"));
       cartIcon.click();

       // 8. Verify product is added
       WebElement cartItem = driver.findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Milk')]"));
       assert cartItem.isDisplayed() : "Product not added to cart";

       // 9. Navigate back to home screen
       driver.navigate().back();

       // 10. Print success message
       System.out.println("BigBasket app automation executed successfully!");

	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
