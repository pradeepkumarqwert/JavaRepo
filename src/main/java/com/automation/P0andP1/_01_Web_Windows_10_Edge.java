package com.automation.P0andP1;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class _01_Web_Windows_10_Edge
{
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;
	_01_Web_Windows_10_Edge PHpage;


		@BeforeClass
		public void driverinitiation() throws InterruptedException, MalformedURLException
		{
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=QWgkKT6DGIR2iG74EUlW7deRNRYzgxHmiT9mNT2qYfatAtZNLMy3Jmwcc7SKuyaEUTGnty30p1C47JclhmbT46vs54qV_r8LM1Ij_zz50kuSdaWB0aNLFu9CKqwbPxYI5e9sTakYruZQ3rSVVKjdXrWERTWp9lYC2e-n9CNQoMhbZiTF-2GQ5sJvjD-570Mhh04qbLhLMk0gqzNS_mSRV2RmBAnZRsILfQvO1waWPC_q4I72O-lD7T1zk4Mh_5eT8wRYnXjcHXyneO4g19Avmq4zK6dYxbbmh5CBiyqWRxmwBGurdS0U&licenseId=LIC4045&projectName=HL+Sanity+Jan/";
            EdgeOptions browserOptions = new EdgeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("136");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
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
			takeScreenshot(driver, "04_After_Search_Result_Click");
			baseMethod.Navigateinto(baseData.getPantaloonspageURL(),"Navigate to pantaloons landing page");
			takeScreenshot(driver, "04_After_Search_Result_Click");
			baseMethod.waitForPageLoad(driver);
			takeScreenshot(driver, "04_After_Search_Result_Click");
			baseMethod.ElementIsDisplay(pantaloonsLandingPage.getPantaloonsLogoElement());
			takeScreenshot(driver, "04_After_Search_Result_Click");
			String products = "Shirts";
			takeScreenshot(driver, "04_After_Search_Result_Click");
			SearchScenarios(products);
			takeScreenshot(driver, "04_After_Search_Result_Click");
			
			
			
		}
		public void SearchScenarios(String product) throws InterruptedException
		{
			baseMethod.Click(pantaloonsLandingPage.getPantaloonsMainSearchBarElement());
			takeScreenshot(driver, "04_After_Search_Result_Click");
			baseMethod.TypeText(pantaloonsLandingPage.getPantaloonsMainSearchBarElement(), product);
			takeScreenshot(driver, "04_After_Search_Result_Click");
			baseMethod.presskeys(pantaloonsLandingPage.getPantaloonsMainSearchBarElement(), Keys.ENTER,"Enter button is pressed after search product in search product");
			takeScreenshot(driver, "04_After_Search_Result_Click");
			baseMethod.MouseHoverOnElement(pantaloonsLandingPage.PantaloonsSearchFilterOptionsElement("Gender"),"Mouse hover on gender filter option on searched product list");
			takeScreenshot(driver, "04_After_Search_Result_Click");
			baseMethod.Click(pantaloonsLandingPage.PantaloonsSearchFilterOptionsElement("Gender"));
			takeScreenshot(driver, "04_After_Search_Result_Click");
			baseMethod.ClickByPresenceString(pantaloonsLandingPage.PantaloonsSearchedSubFilterOptionsElement("Boys"));
			takeScreenshot(driver, "04_After_Search_Result_Click");
			Thread.sleep(2000);
			takeScreenshot(driver, "04_After_Search_Result_Click");
			//baseMethod.MouseHoverOnElement(pantaloonsLandingPage.getPantaloonsProductShirt1(),"Mouse hovered on the Shirt product on searched product list");
			//baseMethod.MouseHoverOnElementAndClick(pantaloonsLandingPage.getPantaloonsProductShirt1(),"Mouse hovered and clicked on the Shirt product on searched product list");
			baseMethod.ClickByPresenceString(pantaloonsLandingPage.PantaloonsFilterClearAllandSelectAllElement(6));
			takeScreenshot(driver, "04_After_Search_Result_Click");
			
			
			
		}
		@AfterClass
		public void QuitBrowser()
		{
            driver.quit();
            System.out.println("driver quit successfully");
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
		

}
