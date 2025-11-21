package com.web.allbrowser;

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

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

public class Web_5_PantaloonsHomepage_Windows10_Edge 
{
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;
	Web_5_PantaloonsHomepage_Windows10_Edge PHpage;


		@BeforeClass
		public void driverinitiation() throws InterruptedException, MalformedURLException
		{
			String seleniumHubUrl = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=a31168ce-bf67-4a7a-bfa1-997fca75f65a&licenseId=LIC1026534&projectName=Time+Zone/";
			SafariOptions browserOptions = new SafariOptions();
			browserOptions.setPlatformName("mac");
			browserOptions.setBrowserVersion("26.0.1");
			driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
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
