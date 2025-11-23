package com.scripts.resource;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Web_5_PantaloonsHomepage 
{
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;
	Web_5_PantaloonsHomepage PHpage;


		@BeforeClass()
		public void driverinitiation() throws InterruptedException, MalformedURLException
		{

			String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=736d95c1-64e3-46ba-8f86-cf4086a93045&licenseId=LIC3943&projectName=project+3/";
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName("linux");
			browserOptions.setBrowserVersion("140");
			WebDriver driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
			driver.manage().window().setSize(new Dimension(1024, 768));




		}
		
		@Test(invocationCount = 1,dataProvider = "browserData")
		public void VerifyPantaloonsLandingPageMethod(String OS , String BrowserName, String BrowserVersion) throws InterruptedException, MalformedURLException
		{
			
			String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=736d95c1-64e3-46ba-8f86-cf4086a93045&licenseId=LIC3943&projectName=project+3/";
			
			if(BrowserName.equalsIgnoreCase("Chrome"))
			{
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName(OS);
			browserOptions.setBrowserVersion(BrowserVersion);
			driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
			driver.manage().window().setSize(new Dimension(1024, 768));
			}
			
			
			if(BrowserName.equalsIgnoreCase("Firefox"))
			{
				FirefoxOptions browserOptions = new FirefoxOptions();
				browserOptions.setPlatformName(OS);
				browserOptions.setBrowserVersion(BrowserVersion);
				driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
				driver.manage().window().setSize(new Dimension(1024, 768));
			}
			
			
			if(BrowserName.equalsIgnoreCase("Edge"))
			{
				EdgeOptions browserOptions = new EdgeOptions();
				browserOptions.setPlatformName(OS);
				browserOptions.setBrowserVersion(BrowserVersion);
				driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
				driver.manage().window().setSize(new Dimension(1024, 768));
			}
			
			
			if(BrowserName.equalsIgnoreCase("Safari"))
			{
				SafariOptions browserOptions = new SafariOptions();
				browserOptions.setPlatformName(OS);
				browserOptions.setBrowserVersion(BrowserVersion);
				driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
				driver.manage().window().setSize(new Dimension(1024, 768));	
			}
			

			 //Fetch system info
		    Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		    String browserName = caps.getBrowserName();
		    String browserVersion = caps.getBrowserVersion();
		    Platform platform = caps.getPlatformName();

		    System.out.println("Browser: " + browserName);
		    System.out.println("Version: " + browserVersion);
		    System.out.println("Platform: " + platform);
			

			this.baseMethod = new BaseMethodsCloud(driver);
			this.baseObject = new BaseObjectsCloud(driver);
			this.baseData = new BaseDataCloud();
			
			pantaloonsLandingPage = new PantaloonsLandingPage(driver);
			baseMethod.MaximizeBrowser(driver,"Browser is maximized");
			baseMethod.ImplicitWait(driver, 20,"Implicit wait is applied");
			baseMethod.HardWait(2000,"Hard wait applied");
			
			
			
			baseMethod.getString(baseData.getBrowserURL(),"Landed on Google website");
			takeScreenshot(driver, "01_HomePage");
			baseMethod.Navigateinto(baseData.getPantaloonspageURL(),"Navigate to pantaloons landing page");
			takeScreenshot(driver, "01_HomePage");
			baseMethod.waitForPageLoad(driver);
			takeScreenshot(driver, "01_HomePage");
			baseMethod.ElementIsDisplay(pantaloonsLandingPage.getPantaloonsLogoElement());
			takeScreenshot(driver, "01_HomePage");
			String products = "Shirts";
			SearchScenarios(products);
			takeScreenshot(driver, "01_HomePage");
			
			
			
		}
		public void SearchScenarios(String product) throws InterruptedException
		{
			baseMethod.Click(pantaloonsLandingPage.getPantaloonsMainSearchBarElement());
			takeScreenshot(driver, "01_HomePage");
			baseMethod.TypeText(pantaloonsLandingPage.getPantaloonsMainSearchBarElement(), product);
			takeScreenshot(driver, "01_HomePage");
			baseMethod.presskeys(pantaloonsLandingPage.getPantaloonsMainSearchBarElement(), Keys.ENTER,"Enter button is pressed after search product in search product");
			takeScreenshot(driver, "01_HomePage");
			baseMethod.MouseHoverOnElement(pantaloonsLandingPage.PantaloonsSearchFilterOptionsElement("Gender"),"Mouse hover on gender filter option on searched product list");
			takeScreenshot(driver, "01_HomePage");
			baseMethod.Click(pantaloonsLandingPage.PantaloonsSearchFilterOptionsElement("Gender"));
			takeScreenshot(driver, "01_HomePage");
			baseMethod.ClickByPresenceString(pantaloonsLandingPage.PantaloonsSearchedSubFilterOptionsElement("Boys"));
			Thread.sleep(2000);
			takeScreenshot(driver, "01_HomePage");
			//baseMethod.MouseHoverOnElement(pantaloonsLandingPage.getPantaloonsProductShirt1(),"Mouse hovered on the Shirt product on searched product list");
			//baseMethod.MouseHoverOnElementAndClick(pantaloonsLandingPage.getPantaloonsProductShirt1(),"Mouse hovered and clicked on the Shirt product on searched product list");
			baseMethod.ClickByPresenceString(pantaloonsLandingPage.PantaloonsFilterClearAllandSelectAllElement(6));
			takeScreenshot(driver, "01_HomePage");
			driver.quit();
			
		}
		@AfterClass
		public void QuitBrowser()
		{
			driver.quit();
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
		
		@DataProvider(name = "browserData")
		public Object[][] browserData() 
		{
		     Object[][] cap = {
		        // Windows 11 - Chrome 91 to 136
		        { "Windows 11", "chrome", "91" }, { "Windows 11", "chrome", "92" }, { "Windows 11", "chrome", "93" },
		        { "Windows 11", "chrome", "94" }, { "Windows 11", "chrome", "95" }, { "Windows 11", "chrome", "96" },
		        { "Windows 11", "chrome", "97" }, { "Windows 11", "chrome", "98" }, { "Windows 11", "chrome", "99" },
		        { "Windows 11", "chrome", "100" }, { "Windows 11", "chrome", "101" }, { "Windows 11", "chrome", "102" },
		        { "Windows 11", "chrome", "103" }, { "Windows 11", "chrome", "104" }, { "Windows 11", "chrome", "105" },
		        { "Windows 11", "chrome", "106" }, { "Windows 11", "chrome", "107" }, { "Windows 11", "chrome", "108" },
		        { "Windows 11", "chrome", "109" }, { "Windows 11", "chrome", "110" }, { "Windows 11", "chrome", "111" },
		        { "Windows 11", "chrome", "112" }, { "Windows 11", "chrome", "113" }, { "Windows 11", "chrome", "114" },
		        { "Windows 11", "chrome", "115" }, { "Windows 11", "chrome", "116" }, { "Windows 11", "chrome", "117" },
		        { "Windows 11", "chrome", "118" }, { "Windows 11", "chrome", "119" }, { "Windows 11", "chrome", "120" },
		        { "Windows 11", "chrome", "121" }, { "Windows 11", "chrome", "122" }, { "Windows 11", "chrome", "123" },
		        { "Windows 11", "chrome", "124" }, { "Windows 11", "chrome", "125" }, { "Windows 11", "chrome", "126" },
		        { "Windows 11", "chrome", "127" }, { "Windows 11", "chrome", "128" }, { "Windows 11", "chrome", "129" },
		        { "Windows 11", "chrome", "130" }, { "Windows 11", "chrome", "131" }, { "Windows 11", "chrome", "132" },
		        { "Windows 11", "chrome", "133" }, { "Windows 11", "chrome", "134" }, { "Windows 11", "chrome", "135" },
		        { "Windows 11", "chrome", "136" },

		        // Windows 10 - Chrome 91 to 136
		        { "Windows 10", "chrome", "91" }, { "Windows 10", "chrome", "92" }, { "Windows 10", "chrome", "93" },
		        { "Windows 10", "chrome", "94" }, { "Windows 10", "chrome", "95" }, { "Windows 10", "chrome", "96" },
		        { "Windows 10", "chrome", "97" }, { "Windows 10", "chrome", "98" }, { "Windows 10", "chrome", "99" },
		        { "Windows 10", "chrome", "100" }, { "Windows 10", "chrome", "101" }, { "Windows 10", "chrome", "102" },
		        { "Windows 10", "chrome", "103" }, { "Windows 10", "chrome", "104" }, { "Windows 10", "chrome", "105" },
		        { "Windows 10", "chrome", "106" }, { "Windows 10", "chrome", "107" }, { "Windows 10", "chrome", "108" },
		        { "Windows 10", "chrome", "109" }, { "Windows 10", "chrome", "110" }, { "Windows 10", "chrome", "111" },
		        { "Windows 10", "chrome", "112" }, { "Windows 10", "chrome", "113" }, { "Windows 10", "chrome", "114" },
		        { "Windows 10", "chrome", "115" }, { "Windows 10", "chrome", "116" }, { "Windows 10", "chrome", "117" },
		        { "Windows 10", "chrome", "118" }, { "Windows 10", "chrome", "119" }, { "Windows 10", "chrome", "120" },
		        { "Windows 10", "chrome", "121" }, { "Windows 10", "chrome", "122" }, { "Windows 10", "chrome", "123" },
		        { "Windows 10", "chrome", "124" }, { "Windows 10", "chrome", "125" }, { "Windows 10", "chrome", "126" },
		        { "Windows 10", "chrome", "127" }, { "Windows 10", "chrome", "128" }, { "Windows 10", "chrome", "129" },
		        { "Windows 10", "chrome", "130" }, { "Windows 10", "chrome", "131" }, { "Windows 10", "chrome", "132" },
		        { "Windows 10", "chrome", "133" }, { "Windows 10", "chrome", "134" }, { "Windows 10", "chrome", "135" },
		        { "Windows 10", "chrome", "136" },

		        // Windows 11 - Firefox 91 to 139
		        { "Windows 11", "firefox", "91" }, { "Windows 11", "firefox", "92" }, { "Windows 11", "firefox", "93" },
		        { "Windows 11", "firefox", "94" }, { "Windows 11", "firefox", "95" }, { "Windows 11", "firefox", "96" },
		        { "Windows 11", "firefox", "97" }, { "Windows 11", "firefox", "98" }, { "Windows 11", "firefox", "99" },
		        { "Windows 11", "firefox", "100" }, { "Windows 11", "firefox", "101" }, { "Windows 11", "firefox", "102" },
		        { "Windows 11", "firefox", "103" }, { "Windows 11", "firefox", "104" }, { "Windows 11", "firefox", "105" },
		        { "Windows 11", "firefox", "106" }, { "Windows 11", "firefox", "107" }, { "Windows 11", "firefox", "108" },
		        { "Windows 11", "firefox", "109" }, { "Windows 11", "firefox", "110" }, { "Windows 11", "firefox", "111" },
		        { "Windows 11", "firefox", "112" }, { "Windows 11", "firefox", "113" }, { "Windows 11", "firefox", "114" },
		        { "Windows 11", "firefox", "115" }, { "Windows 11", "firefox", "116" }, { "Windows 11", "firefox", "117" },
		        { "Windows 11", "firefox", "118" }, { "Windows 11", "firefox", "119" }, { "Windows 11", "firefox", "120" },
		        { "Windows 11", "firefox", "121" }, { "Windows 11", "firefox", "122" }, { "Windows 11", "firefox", "123" },
		        { "Windows 11", "firefox", "124" }, { "Windows 11", "firefox", "125" }, { "Windows 11", "firefox", "126" },
		        { "Windows 11", "firefox", "127" }, { "Windows 11", "firefox", "128" }, { "Windows 11", "firefox", "129" },
		        { "Windows 11", "firefox", "130" }, { "Windows 11", "firefox", "131" }, { "Windows 11", "firefox", "132" },
		        { "Windows 11", "firefox", "133" }, { "Windows 11", "firefox", "134" }, { "Windows 11", "firefox", "135" },
		        { "Windows 11", "firefox", "136" }, { "Windows 11", "firefox", "137" }, { "Windows 11", "firefox", "138" },
		        { "Windows 11", "firefox", "139" },

		        // Windows 10 - Firefox 91 to 139
		        { "Windows 10", "firefox", "91" }, { "Windows 10", "firefox", "92" }, { "Windows 10", "firefox", "93" },
		        { "Windows 10", "firefox", "94" }, { "Windows 10", "firefox", "95" }, { "Windows 10", "firefox", "96" },
		        { "Windows 10", "firefox", "97" }, { "Windows 10", "firefox", "98" }, { "Windows 10", "firefox", "99" },
		        { "Windows 10", "firefox", "100" }, { "Windows 10", "firefox", "101" }, { "Windows 10", "firefox", "102" },
		        { "Windows 10", "firefox", "103" }, { "Windows 10", "firefox", "104" }, { "Windows 10", "firefox", "105" },
		        { "Windows 10", "firefox", "106" }, { "Windows 10", "firefox", "107" }, { "Windows 10", "firefox", "108" },
		        { "Windows 10", "firefox", "109" }, { "Windows 10", "firefox", "110" }, { "Windows 10", "firefox", "111" },
		        { "Windows 10", "firefox", "112" }, { "Windows 10", "firefox", "113" }, { "Windows 10", "firefox", "114" },
		        { "Windows 10", "firefox", "115" }, { "Windows 10", "firefox", "116" }, { "Windows 10", "firefox", "117" },
		        { "Windows 10", "firefox", "118" }, { "Windows 10", "firefox", "119" }, { "Windows 10", "firefox", "120" },
		        { "Windows 10", "firefox", "121" }, { "Windows 10", "firefox", "122" }, { "Windows 10", "firefox", "123" },
		        { "Windows 10", "firefox", "124" }, { "Windows 10", "firefox", "125" }, { "Windows 10", "firefox", "126" },
		        { "Windows 10", "firefox", "127" }, { "Windows 10", "firefox", "128" }, { "Windows 10", "firefox", "129" },
		        { "Windows 10", "firefox", "130" }, { "Windows 10", "firefox", "131" }, { "Windows 10", "firefox", "132" },
		        { "Windows 10", "firefox", "133" }, { "Windows 10", "firefox", "134" }, { "Windows 10", "firefox", "135" },
		        { "Windows 10", "firefox", "136" }, { "Windows 10", "firefox", "137" }, { "Windows 10", "firefox", "138" },
		        { "Windows 10", "firefox", "139" },

		        // Windows 11 - Edge 102 to 136
		        { "Windows 11", "edge", "102" }, { "Windows 11", "edge", "103" }, { "Windows 11", "edge", "104" },
		        { "Windows 11", "edge", "105" }, { "Windows 11", "edge", "106" }, { "Windows 11", "edge", "107" },
		        { "Windows 11", "edge", "108" }, { "Windows 11", "edge", "109" }, { "Windows 11", "edge", "110" },
		        { "Windows 11", "edge", "111" }, { "Windows 11", "edge", "112" }, { "Windows 11", "edge", "113" },
		        { "Windows 11", "edge", "114" }, { "Windows 11", "edge", "115" }, { "Windows 11", "edge", "116" },
		        { "Windows 11", "edge", "117" }, { "Windows 11", "edge", "118" }, { "Windows 11", "edge", "119" },
		        { "Windows 11", "edge", "120" }, { "Windows 11", "edge", "121" }, { "Windows 11", "edge", "122" },
		        { "Windows 11", "edge", "123" }, { "Windows 11", "edge", "124" }, { "Windows 11", "edge", "125" },
		        { "Windows 11", "edge", "126" }, { "Windows 11", "edge", "127" }, { "Windows 11", "edge", "128" },
		        { "Windows 11", "edge", "129" }, { "Windows 11", "edge", "130" }, { "Windows 11", "edge", "131" },
		        { "Windows 11", "edge", "132" }, { "Windows 11", "edge", "133" }, { "Windows 11", "edge", "134" },
		        { "Windows 11", "edge", "135" }, { "Windows 11", "edge", "136" },

		        // Windows 10 - Edge 102 to 136
		        { "Windows 10", "edge", "102" }, { "Windows 10", "edge", "103" }, { "Windows 10", "edge", "104" },
		        { "Windows 10", "edge", "105" }, { "Windows 10", "edge", "106" }, { "Windows 10", "edge", "107" },
		        { "Windows 10", "edge", "108" }, { "Windows 10", "edge", "109" }, { "Windows 10", "edge", "110" },
		        { "Windows 10", "edge", "111" }, { "Windows 10", "edge", "112" }, { "Windows 10", "edge", "113" },
		        { "Windows 10", "edge", "114" }, { "Windows 10", "edge", "115" }, { "Windows 10", "edge", "116" },
		        { "Windows 10", "edge", "117" }, { "Windows 10", "edge", "118" }, { "Windows 10", "edge", "119" },
		        { "Windows 10", "edge", "120" }, { "Windows 10", "edge", "121" }, { "Windows 10", "edge", "122" },
		        { "Windows 10", "edge", "123" }, { "Windows 10", "edge", "124" }, { "Windows 10", "edge", "125" },
		        { "Windows 10", "edge", "126" }, { "Windows 10", "edge", "127" }, { "Windows 10", "edge", "128" },
		        { "Windows 10", "edge", "129" }, { "Windows 10", "edge", "130" }, { "Windows 10", "edge", "131" },
		        { "Windows 10", "edge", "132" }, { "Windows 10", "edge", "133" }, { "Windows 10", "edge", "134" },
		        { "Windows 10", "edge", "135" }, { "Windows 10", "edge", "136" }
		        };
		     return cap;
		}
}
