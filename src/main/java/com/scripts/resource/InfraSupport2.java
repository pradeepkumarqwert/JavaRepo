package com.scripts.resource;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;

import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Listeners(com.report.listener.ExtentReportManager.class)
public class InfraSupport2 {

    WebDriver driver;
    BaseMethodsCloud baseMethod;
    BaseObjectsCloud baseObject;
    BaseDataCloud baseData;
    PantaloonsLandingPage pantaloonsLandingPage;
    @BeforeMethod
    public void initialization()

    {
    	
    }
    @Test(dataProvider = "browserData")
    public void VerifyPantaloonsLandingPageMethod(String OS, String BrowserName, String BrowserVersion)
            throws InterruptedException, MalformedURLException {

    		String seleniumHubUrl = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=a31168ce-bf67-4a7a-bfa1-997fca75f65a&licenseId=LIC1026534&projectName=infraSupport3/";
            if (BrowserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName(OS);
            browserOptions.setBrowserVersion(BrowserVersion);
            driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));
        } else if (BrowserName.equalsIgnoreCase("Firefox")) {
            FirefoxOptions browserOptions = new FirefoxOptions();
            browserOptions.setPlatformName(OS);
            browserOptions.setBrowserVersion(BrowserVersion);
            driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));
        } else if (BrowserName.equalsIgnoreCase("Edge")) {
            EdgeOptions browserOptions = new EdgeOptions();
            browserOptions.setPlatformName(OS);
            browserOptions.setBrowserVersion(BrowserVersion);
            driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));
        }

        // Fetch system info
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = caps.getBrowserName();
        String browserVersion = caps.getBrowserVersion();
        Platform platform = caps.getPlatformName();

        System.out.println("-------------------------------------------");
        System.out.println("Browser: " + browserName);
        System.out.println("Version: " + browserVersion);
        System.out.println("Platform: " + platform);
        System.out.println("-------------------------------------------");

        this.baseMethod = new BaseMethodsCloud(driver);
        this.baseObject = new BaseObjectsCloud(driver);
        this.baseData = new BaseDataCloud();
        pantaloonsLandingPage = new PantaloonsLandingPage(driver);

        baseMethod.MaximizeBrowser(driver, "Browser is maximized");
        baseMethod.ImplicitWait(driver, 20, "Implicit wait is applied");
        baseMethod.HardWait(2000, "Hard wait applied");

        baseMethod.getString(baseData.getBrowserURL(), "Landed on Google website");
        takeScreenshot(driver, "04_After_Search_Result_Click");

        Thread.sleep(2000);
        
    }

    @AfterMethod
    public void tearDown()
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
    public Object[][] browserData() {


		   String[][] configs = {
		            { "Windows 10", "chrome", "91", "139" },
		            { "Windows 10", "edge", "102", "139" },
		            { "Windows 10", "firefox", "91", "141" },
		            { "Windows 11", "chrome", "91", "139" },
		            { "Windows 11", "edge", "102", "139" },
		            { "Windows 11", "firefox", "91", "144" },
		            { "Windows 8.1", "chrome", "91", "109" },
		            { "Windows 8.1", "edge", "102", "109" },
		            { "Windows 8.1", "firefox", "91", "115" }
		        };

    	
    	
      
        int repeatCount = 35;

        List<Object[]> dataList = new ArrayList<>();

        for (String[] cfg : configs) {
            String os = cfg[0];
            String browser = cfg[1];
            int start = Integer.parseInt(cfg[2]);
            int end = Integer.parseInt(cfg[3]);

            for (int v = start; v <= end; v++) {
                for (int i = 0; i < repeatCount; i++) {
                    dataList.add(new Object[]{ os, browser, String.valueOf(v) });
                }
            }
        }

        return dataList.toArray(new Object[0][0]);
    }
}
