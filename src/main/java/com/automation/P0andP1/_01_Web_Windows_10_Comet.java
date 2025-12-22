package com.automation.P0andP1;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
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

public class _01_Web_Windows_10_Comet
{
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;
	_01_Web_Windows_10_Comet PHpage;


		@BeforeClass
		public void driverinitiation() throws InterruptedException, MalformedURLException
		{
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=uHnChthLrrZx7i3tjv6Atsi0rbbNFJI1L6EV9v-v4hJq4gij5X2bKAq75AfDVw1O5ZYv5VVRvt1kfAhFWREi3LqauNaCff0DDPYZe-LanCzWZDt2JrxKD7sjNJalFQOYru3OxKPddfBrPW1OUlqVSIi43sL2gAeyaExiJ7sGgEoY164NYts6axdWnu06sp2aWP3EquBR69Z-pYOQXlFOyLNmd4uKmcsOdpo-t8Dd6AR_gtWMcg3PLopnsAvteZos-m8dAfR3FNBDd6NaJL6JdFD8RUCAGhZJG5vi-fy41NKg-2jpeDbp&licenseId=LIC4014&projectName=Automation+Testing/";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("142.0");
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
			Thread.sleep(8000);
			baseMethod.waitForPageLoad(driver);
			Thread.sleep(2000);
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
			Thread.sleep(5000);
			baseMethod.presskeys(pantaloonsLandingPage.getPantaloonsMainSearchBarElement(), Keys.ENTER,"Enter button is pressed after search product in search product");
			takeScreenshot(driver, "04_After_Search_Result_Click");
			Thread.sleep(5000);
			baseMethod.MouseHoverOnElement(pantaloonsLandingPage.PantaloonsSearchFilterOptionsElement("Gender"),"Mouse hover on gender filter option on searched product list");
			takeScreenshot(driver, "04_After_Search_Result_Click");
			baseMethod.Click(pantaloonsLandingPage.PantaloonsSearchFilterOptionsElement("Gender"));
			takeScreenshot(driver, "04_After_Search_Result_Click");
			baseMethod.ClickByPresenceString(pantaloonsLandingPage.PantaloonsSearchedSubFilterOptionsElement("Boys"));
			takeScreenshot(driver, "04_After_Search_Result_Click");
			Thread.sleep(5000);
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
