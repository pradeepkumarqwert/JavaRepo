package com.scripts.resource;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;

@Listeners(com.report.listener.ExtentReportManager.class)
public class HybridClassOfWebAndMibileAndroid 
{
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;
	Web_5_PantaloonsHomepage2 PHpage;
	@Test(invocationCount = 1, priority = 1, retryAnalyzer = com.frameworks.utils.RetryAnalizer.class)
	public void web() throws InterruptedException, MalformedURLException
	{
		String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=736d95c1-64e3-46ba-8f86-cf4086a93045&licenseId=LIC3943&projectName=Sanity/";
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("128");
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


		
		baseMethod.getString(baseData.getBrowserURL(),"Landed on Google website");
		baseMethod.Navigateinto(baseData.getPantaloonspageURL(),"Navigate to pantaloons landing page");
		baseMethod.waitForPageLoad(driver);
		baseMethod.ElementIsDisplay(pantaloonsLandingPage.getPantaloonsLogoElement());
		String product = "Shirts";
		
		
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
	
	
	
	@Test(retryAnalyzer = com.frameworks.utils.RetryAnalizer.class , invocationCount = 1, priority = 2)
    public void run() throws InterruptedException {
    	
        try {
        	//String seleniumHubUrl = "http://103.182.210.85:4444";

        	String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=736d95c1-64e3-46ba-8f86-cf4086a93045&licenseId=LIC3943&projectName=Sanity/";
        	DesiredCapabilities caps = new DesiredCapabilities();
        	caps.setCapability("appium:deviceName", "Samsung Galaxy A12");
        	caps.setCapability("platformName", "Android");
        	caps.setCapability("appium:platformVersion", "12");
        	caps.setCapability("appium:browserName", "Chrome");
        	driver = new RemoteWebDriver(new URL(seleniumHubUrl), caps);


        	
        	
           //caps.setCapability("appium:chromedriverAutodownload", true);

            driver.get("https://www.pantaloons.com/");
            System.out.println("Opened Pantaloons in mobile browser.");
            takeScreenshot(driver, "01_HomePage");

            Thread.sleep(3000);

            driver.findElement(By.cssSelector("div.mobilesearchbox")).click();
            System.out.println("Clicked.");
            takeScreenshot(driver, "02_After_Click_Search_Icon");

            Thread.sleep(5000);

            driver.findElement(By.xpath("//input[@placeholder='Search for products,brands and more...']")).sendKeys("Shirt");
            System.out.println("Entered.");
            takeScreenshot(driver, "03_After_Entering_Search");

            Thread.sleep(2000);

            driver.findElement(By.xpath("(//mark[text()='Shirt'])[1]")).click();
            System.out.println("Searched for item");
            takeScreenshot(driver, "04_After_Search_Result_Click");

            Thread.sleep(4000);
            driver.findElement(By.cssSelector("span.cartSpriteIcon")).click();
            System.out.println("Opened Cart");
            takeScreenshot(driver, "05_Cart_Page");

            System.out.println("Page Title: " + driver.getTitle());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            takeScreenshot(driver, "99_Exception_Occurred");
        } finally {
            if (driver != null) {
                driver.quit();
            }
            System.out.println("Driver closed.");
        }
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
