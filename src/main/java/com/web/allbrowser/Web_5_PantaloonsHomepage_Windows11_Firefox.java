package com.web.allbrowser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.context.annotation.DependsOn;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class Web_5_PantaloonsHomepage_Windows11_Firefox 
{
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;
	Web_5_PantaloonsHomepage_Windows11_Firefox PHpage;


		@BeforeClass
		public void driverinitiation() throws InterruptedException, MalformedURLException
		{

			String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=736d95c1-64e3-46ba-8f86-cf4086a93045&licenseId=LIC3943&projectName=functional/";
			FirefoxOptions browserOptions = new FirefoxOptions();
			browserOptions.setPlatformName("Windows 11");
			browserOptions.setBrowserVersion("119");
			WebDriver driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
			driver.manage().window().setSize(new Dimension(1024, 768));








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
			
		}
		
		@Test(invocationCount = 1)
		public void VerifyPantaloonsLandingPageMethod() throws InterruptedException
		{
			
			baseMethod.getString(baseData.getBrowserURL(),"Landed on Google website");
			baseMethod.Navigateinto(baseData.getPantaloonspageURL(),"Navigate to pantaloons landing page");
			baseMethod.waitForPageLoad(driver);
			baseMethod.ElementIsDisplay(pantaloonsLandingPage.getPantaloonsLogoElement());
			String products = "Shirts";
			SearchScenarios(products);
			
			
			
		}
		public void SearchScenarios(String product) throws InterruptedException
		{
			baseMethod.Click(pantaloonsLandingPage.getPantaloonsMainSearchBarElement());
			baseMethod.TypeText(pantaloonsLandingPage.getPantaloonsMainSearchBarElement(), product);
			baseMethod.presskeys(pantaloonsLandingPage.getPantaloonsMainSearchBarElement(), Keys.ENTER,"Enter button is pressed after search product in search product");
			baseMethod.MouseHoverOnElement(pantaloonsLandingPage.PantaloonsSearchFilterOptionsElement("Gender"),"Mouse hover on gender filter option on searched product list");
			baseMethod.Click(pantaloonsLandingPage.PantaloonsSearchFilterOptionsElement("Gender"));
			baseMethod.ClickByPresenceString(pantaloonsLandingPage.PantaloonsSearchedSubFilterOptionsElement("Boys"));
			Thread.sleep(2000);
			//baseMethod.MouseHoverOnElement(pantaloonsLandingPage.getPantaloonsProductShirt1(),"Mouse hovered on the Shirt product on searched product list");
			//baseMethod.MouseHoverOnElementAndClick(pantaloonsLandingPage.getPantaloonsProductShirt1(),"Mouse hovered and clicked on the Shirt product on searched product list");
			baseMethod.ClickByPresenceString(pantaloonsLandingPage.PantaloonsFilterClearAllandSelectAllElement(6));
			
			
			
		}
		@AfterClass
		public void QuitBrowser()
		{
			driver.quit();
		}
		
		

}
