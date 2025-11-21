package com.infra.support;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
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

@Listeners(com.report.listener.ExtentReportManager.class)
public class InfraClass {

    WebDriver driver;
    BaseMethodsCloud baseMethod;
    BaseObjectsCloud baseObject;
    BaseDataCloud baseData;
    PantaloonsLandingPage pantaloonsLandingPage;

    private String os;
    private String browser;
    private String version;
    private long timeout;

    @Parameters({"os", "browser", "version", "timeout"})
    @BeforeClass
    public void setup(String os, String browser, String version, String timeout) {
        this.os = os;
        this.browser = browser;
        this.version = version;
        this.timeout = Long.parseLong(timeout); // convert to long
    }

    // Use invocationCount and threadPoolSize for N parallel runs
    @Test(invocationCount = 3, threadPoolSize = 4, timeOut = 60000) // timeOut default, overridden below
    public void testB() throws InterruptedException, MalformedURLException {
        long startTime = System.currentTimeMillis();
        try {
            // Create RemoteWebDriver based on browser
        	String seleniumHubUrl = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=a31168ce-bf67-4a7a-bfa1-997fca75f65a&licenseId=LIC1026534&projectName=infra/";
                 if (browser.equalsIgnoreCase("Chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName(os);
                browserOptions.setBrowserVersion(version);
                driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
            } else if (browser.equalsIgnoreCase("Firefox")) {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName(os);
                browserOptions.setBrowserVersion(version);
                driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
            } else if (browser.equalsIgnoreCase("Edge")) {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setPlatformName(os);
                browserOptions.setBrowserVersion(version);
                driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
            }

            driver.manage().window().setSize(new Dimension(1024, 768));

            // Browser operations
            Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
            System.out.println("Browser: " + caps.getBrowserName() +
                               ", Version: " + caps.getBrowserVersion() +
                               ", Platform: " + caps.getPlatformName());

            this.baseMethod = new BaseMethodsCloud(driver);
            this.baseObject = new BaseObjectsCloud(driver);
            this.baseData = new BaseDataCloud();
            pantaloonsLandingPage = new PantaloonsLandingPage(driver);

            baseMethod.MaximizeBrowser(driver, "Browser is maximized");
            takeScreenshot(driver, "After_Load");

            Thread.sleep(2000);

        } finally {
            // Force quit browser if test exceeds configured timeout
            long elapsed = System.currentTimeMillis() - startTime;
            if (elapsed > timeout) {
                System.out.println("Test exceeded timeout of " + timeout + " ms! Quitting browser.");
            }
            if (driver != null) {
                driver.quit();
            }
        }
    }
    public static void takeScreenshot(WebDriver driver, String fileName) {
        if (driver == null) return;
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\Selenium Grid\\Screenshots\\" + fileName + ".png");
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }
}
	

