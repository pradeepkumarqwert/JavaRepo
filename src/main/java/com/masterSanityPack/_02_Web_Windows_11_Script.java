package com.masterSanityPack;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
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

public class _02_Web_Windows_11_Script
{
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;
	_02_Web_Windows_11_Script PHpage;


		@BeforeClass
		public void driverinitiation() throws InterruptedException, MalformedURLException
		{
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=Gt6gz02GkedJu08-wHUIMJJ6sFn9OyhX1hTvUwes35cvBY5gHXaykeTJqQu2bv1RUfWbUFi1Zu02F52IfGqLuyoVVi8vZcK3n6DDgxuF2Zt3DxDpmsKg-SKQpzDFybW5Aa8lEf3Wrp6IRbdCehP_x_Zy1PWAbl4vKzQmw1rttK6pS67jPv6dTitziqtgnB_6w1pwQ3S5GjSBNOUQfeNV3PzGzezbBDLZ6RDnYKQhymFpFCS1Yepg2L2hSt0qypokaqDBULk7TWIllGyvRApjVwNlt7luTtwG3PzuwIHHFYRat3rytxpKTi4Hh_mosIc&licenseId=LIC4341&projectName=Project7th+May/";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setCapability("fireflink:deviceType", "public");
            browserOptions.setPlatformName("mac Tahoe");
            browserOptions.setBrowserVersion("140");
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
		public void VerifyPantaloonsLandingPageMethod() throws InterruptedException {
            String sessionIdrepeat = ((RemoteWebDriver) driver).getSessionId().toString();
            String text = (String) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0];", sessionIdrepeat);
            System.out.println(text);

            System.out.println(text);
            baseMethod.getString(baseData.getBrowserURL(),"Landed on Google website");
            takeScreenshot(driver, "04_After_Search_Result_Click");
            baseMethod.Navigateinto(baseData.getPantaloonspageURL(),"Navigate to pantaloons landing page");
            for(int i = 0 ; i<=1 ; i++) {
                takeScreenshot(driver, "04_After_Search_Result_Click");
            }
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
