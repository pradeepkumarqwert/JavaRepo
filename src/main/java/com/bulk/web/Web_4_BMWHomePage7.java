package com.bulk.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.BMW_LandingPage;

public class Web_4_BMWHomePage7 
{
WebDriver driver;
BaseMethodsCloud baseMethod;
BaseObjectsCloud baseObject;
BaseDataCloud baseData;
BMW_LandingPage bmw_LandingPage;

	@BeforeClass
	public void driverinitiation() throws MalformedURLException
	{
//		//dev envi:
//		String seleniumHubUrl = "https://fireflinkclouddev.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=4f6f3903-4b38-43e3-9c29-38f5b66d8cb8&licenseId=LIC4630&projectName=TestProject_DonotDelete/";
//		ChromeOptions browserOptions = new ChromeOptions();
//		browserOptions.setPlatformName("Windows 11");
//		browserOptions.setBrowserVersion("133");
//		driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
//		driver.manage().window().setSize(new Dimension(1024, 768));



	
		//test envi:
		String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=736d95c1-64e3-46ba-8f86-cf4086a93045&licenseId=LIC3943&projectName=Sanity/";
		FirefoxOptions browserOptions = new FirefoxOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("125");
		driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
		driver.manage().window().setSize(new Dimension(1024, 768));

		
		//USer privilege test capabilities:
//		String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=b8b1f3a7-087c-4f79-9e75-bbef21e4c86a&licenseId=LIC3943&projectName=Sanity/";
//		ChromeOptions browserOptions = new ChromeOptions();
//		browserOptions.setPlatformName("Windows 11");
//		browserOptions.setBrowserVersion("133");
//		driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
//		driver.manage().window().setSize(new Dimension(1024, 768));





		

	    //Fetch system info
	    Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = caps.getBrowserName();
	    String browserVersion = caps.getBrowserVersion();
	    Platform platform = caps.getPlatformName();

	    System.out.println("Browser: " + browserName);
	    System.out.println("Version: " + browserVersion);
	    System.out.println("Platform: " + platform);
		
		
		
		baseMethod = new BaseMethodsCloud(driver);
		baseObject = new BaseObjectsCloud(driver);
		baseData = new BaseDataCloud();
		bmw_LandingPage = new BMW_LandingPage(driver); 
		
		
		
	}
	
	@Test(invocationCount = 1, dataProvider = "times")
	public void LaunchHomePage(String time) throws InterruptedException
	{
		
		System.out.println(time);
		baseMethod.MaximizeBrowser(driver,"Browser is maximized");
		baseMethod.getString(baseData.getBMWpageURL(),"Landed in BMW landing page");
		baseMethod.HardWait(5000,"Hard wait applied");
		baseMethod.ImplicitWait(driver, 20 ,"Implicit wait is applied");
		String currentPageTitle = baseMethod.FetchBrowserTitle("Website titke is fetched");
		
		try
		{
			currentPageTitle.contains("bmw-kunexclusive-bengaluru");
			baseMethod.PrintValue("Landed on BMW page");
		}
		catch (Exception e) {
			baseMethod.PrintValue("Unable to landed on BMW page");
		}
		baseMethod.MouseHoverOnElement(bmw_LandingPage.gettopNavBarElement("New Cars"),"Mouse hovered on New cars section in top nav bar");
		
		baseMethod.Click(bmw_LandingPage.gettopNavBarElement("New Cars"));
		
		String[] cars = {"2","3","5","7","M","X","Z","i"};
//		String[] cars2 = {"The New BMW 2 Series Gran Coupé"};
//		String[] cars3 = {"The BMW 3 Series Long Wheelbase","The BMW M340i"};
//		String[] cars5 = {"The BMW 5 Series Long Wheelbase "};
//		String[] cars7 = {"The BMW 7 Series Sedan"};
//		String[] carsM = {"The New BMW M2","The All-New BMW M5","The BMW M8 Competition Coupé","The BMW XM","The BMW M340i","The New M4 Competition Coupe with M xDrive","The New BMW Z4 M40i"};
//		String[] carsX = {"The BMW X1","THE ALL-NEW X3","The New BMW X5","The BMW X7"};
//		String[] carsZ = {"The New BMW Z4 M40i"};
//		String[] carsi = {"The New All-Electric BMW iX xDrive50","The Fully Electric BMW i4","The First-Ever BMW i5 M60 xDrive","The Fully Electric BMW i7","The BMW iX1 Long WheelBase","The First-Ever BMW i7 M70 xDrive"};
		//String[] casrList = {"cars2", "cars3", "cars5", "cars7", "carsM", "carsX", "carsZ", "carsi"};

		
		
				
		
		// 2. Wait until submenu items are visible
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> submenuItems = wait.until(
		    ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'navcatlevel1')]//span")
		    )
		   
		);
		String local;
		// 3. Fetch all submenu text
		List<String> actualOptions = new ArrayList<>();
		for (WebElement item : submenuItems) {
		    local = item.getText();
		    actualOptions.add(local);
		    
		    }
		

		// 4. Expected options (example)
		List<String> expectedOptions =
				Arrays.asList("2", "3", "5", "7", "M", "X", "Z", "I",
						"The New BMW 2 Series Gran Coupé","The BMW 3 Series Long Wheelbase",
						"The BMW M340i","The BMW 5 Series Long Wheelbase ","The BMW 7 Series Sedan",
						"The New BMW M2","The All-New BMW M5","The BMW M8 Competition Coupé",
						"The BMW XM","The BMW M340i","The New M4 Competition Coupe with M xDrive",
						"The New BMW Z4 M40i","The BMW X1","THE ALL-NEW X3","The New BMW X5",
						"The BMW X7","The New BMW Z4 M40i","The New All-Electric BMW iX xDrive50",
						"The Fully Electric BMW i4","The First-Ever BMW i5 M60 xDrive",
						"The Fully Electric BMW i7","The BMW iX1 Long WheelBase","The First-Ever BMW i7 M70 xDrive");

		// 5. Compare (check if all expected options are present)
		for (String expected : expectedOptions) {
		    if (actualOptions.contains(expected)) {
		        System.out.println(expected + " Present");
		    } else {
		        System.out.println(expected + " Missing");
		    }
		}
		
		for(String car: cars)
		{
			baseMethod.MouseHoverOnElement(bmw_LandingPage.getNewCarsListElement(car),"Mouse hovered on list of cars");
			baseMethod.HardWait(2000,"Hard wait applied");	
		}
		
		
		
	}
	
	
	
	@AfterClass
	public void ExitDriver()
	{
		driver.quit();
	}
	
	@DataProvider(name = "times")
	public Object[][] timeing()
	{
		Object[][] time = {{"1"}};
		return time;
	}
	
	
}
