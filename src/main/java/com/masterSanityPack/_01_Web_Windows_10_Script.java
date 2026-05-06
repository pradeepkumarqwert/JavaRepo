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
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class _01_Web_Windows_10_Script
{
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;
	_01_Web_Windows_10_Script PHpage;


		@BeforeMethod
		public void driverinitiation() throws InterruptedException, MalformedURLException
		{

            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=A9A_W80UzCX7oIThY0TQJVbaP06-DCNWlSMsd7PLrSld0j9ikwg0iXk7Nf0ygfoyMsQu2P-cTW5owbSjIF87dXasZm2uMlccp7KDISsIj0FE5Xx_Mp6yA99ggod6AM7HtNLjuiuYxnqLUxa-FrxY_Hyf0YZgh-eRPkgzFL3EsrufkTVt0k7DVQEV-jlBZPiYvrWxxfgHg4gYV4XQgcWEYfOGC9RKUSoaqQo7mIb3LjQJi6O1ZYSM9GVxfkE8xkHrE6WAoGp-PoIg0qgZm6GW9SWk_GHQ6cidTzS5XnTb_U95G1B_4Il644shRmUBeM8&licenseId=LIC4341&projectName=05052026_Testing/";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setCapability("fireflink:deviceType", "public");
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("136");
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
            baseMethod.getString(baseData.getBrowserURL(),"Landed on Google website");
            for(int i = 0; i < 1; i++)
            {
            takeScreenshot(driver, "04_After_Search_Result_Click");
        }
            baseMethod.Navigateinto(baseData.getPantaloonspageURL(),"Navigate to pantaloons landing page");
            for(int i = 0; i < 1; i++)
            {
                takeScreenshot(driver, "04_After_Search_Result_Click");
            }
            baseMethod.waitForPageLoad(driver);
            for(int i = 0; i < 1; i++)
            {
                takeScreenshot(driver, "04_After_Search_Result_Click");
            }


		}


		@AfterMethod
		public void QuitBrowser() throws InterruptedException {
//            Thread.sleep(10000);
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
