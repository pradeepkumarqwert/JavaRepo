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

public class _02_Web_Windows_11_Edge
{
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;
	_02_Web_Windows_11_Edge PHpage;


		@BeforeClass
		public void driverinitiation() throws InterruptedException, MalformedURLException
		{
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=aL-4N8cIdycxuzVhMkTTB2iEBrjsUnIH1vd86DDL-W7jn8KqCxObf_4dp_yn8AONM2sRtu73HV_twh2f42xiWfJKSJMfGpo-IWPqqtTqplrosm_WYDOtPIE3FwrD3Yg-lR6U9MqqdNHGooq16JCq3t1hm6y5RCpTVli-6EvTjzzjC7hZ1XQMYz3xYqTOKR8y9bWogR2lwaflZBseFzl0wWKwFoQoGj3_HOCTSRbiZdHbuY8BkJanG8DOXyoBatSH8XjY0HFWFZptlIrGp3WYAup1k8P9ky4PMMDJMQC8MdZZMbg8L0xV&licenseId=LIC4047&projectName=12022026_Testing/";
            EdgeOptions browserOptions = new EdgeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", true);
            browserOptions.setCapability("fireflink:deviceType", "public");
            browserOptions.setPlatformName("Windows 10");
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
