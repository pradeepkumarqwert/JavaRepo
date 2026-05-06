package com.masterSanityPack;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class _04_Web_Linux_Script
{
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;
	_04_Web_Linux_Script PHpage;


		@BeforeClass
		public void driverinitiation() throws InterruptedException, MalformedURLException
		{
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=iQOuwQOGpGRqOJkdPL3H3H-Ti9XkQ9sxKOc6JEaQSmE4Ek7AhjMwEM2-PYwCmQgvD3atpN83a6CI7hRqNliptLL2Tk3j3V3ZKzvVazaNJ1QHiJcYTRqtlQ5W_2AfyCWgAAalEuYOLRUIMSMQri8LQ666cxhXIawmI8uLfYDWPgUmbh4-MrFn8v2e1lAAmwzdGhIs2RETFGBUuwjd1Jx5yLkoV2BMU5OlEnYcobzzVoB-60owlkydm0Ufsm9c7gF4Apn4oa-UU_y4jEbDSBlnwpZd6klzsVE9lMihb50R9dhq0qD9t7O5tx4pbbE6eG0&licenseId=LIC4341&projectName=05052026_Testing/";
            FirefoxOptions browserOptions = new FirefoxOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setCapability("fireflink:deviceType", "public");
            browserOptions.setPlatformName("linux");
            browserOptions.setBrowserVersion("141");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));



            //Fetch system info
            Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
            String browserName = caps.getBrowserName();
            String browserVersion = caps.getBrowserVersion();
            Platform platform = caps.getPlatformName();
             String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();


            System.out.println("Browser: " + browserName);
            System.out.println("Version: " + browserVersion);
            System.out.println("Platform: " + platform);
            System.out.println("Session ID is: " + sessionId);
			
			
			
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

            String sessionIdrepeat = ((RemoteWebDriver) driver).getSessionId().toString();
            String text = (String) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0];", sessionIdrepeat);
            System.out.println(text);
            baseMethod.getString(baseData.getBrowserURL(),"Landed on Google website");
            takeScreenshot(driver, "04_After_Search_Result_Click");
            baseMethod.Navigateinto(baseData.getPantaloonspageURL(),"Navigate to pantaloons landing page");
            takeScreenshot(driver, "04_After_Search_Result_Click");
            baseMethod.waitForPageLoad(driver);
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
