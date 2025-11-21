package com.scripts.resource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
public class iOSMobileBrowser {
	
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
    	
//        String seleniumHubUrl = "https://fireflinkclouddev.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=4f6f3903-4b38-43e3-9c29-38f5b66d8cb8&licenseId=LIC4630&projectName=dont_delete_plz/";
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("appium:deviceName", "Simulator iPhone 16 Pro");
//        caps.setCapability("platformName", "iOS");
//        caps.setCapability("appium:platformVersion", "18.3.1");
//        caps.setCapability("appium:browserName", "Safari");
//        driver = new RemoteWebDriver(new URL(seleniumHubUrl), caps);
//        caps.setCapability("appium:chromedriverAutodownload", true);
        
        
        //Local execution capabilities:
//    	  IOSDriver driver = null;
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platformName", "iOS");
//        caps.setCapability("platformVersion", "15.5"); // your iOS version
//        caps.setCapability("deviceName", "Fireflink Cloud 11 15.5"); // exact device name or UDID
//        caps.setCapability("udid", "00008030-001968812EF2402E"); // required for real device
//        caps.setCapability("automationName", "XCUITest");
//        caps.setCapability("browserName", "Safari"); // important for mobile browser testing
//        caps.setCapability("startIWDP", true); // starts ios-webkit-debug-proxy automatically
//        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        
        
    	String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=736d95c1-64e3-46ba-8f86-cf4086a93045&licenseId=LIC3943&projectName=Sanity/";
    	DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability("appium:deviceName", "Simulator iPad Air 13inch M3");
    	caps.setCapability("platformName", "iOS");
    	caps.setCapability("appium:platformVersion", "18.4");
    	caps.setCapability("appium:browserName", "Safari");
    	WebDriver driver = new RemoteWebDriver(new URL(seleniumHubUrl), caps);





        
        
        
        
//        driver.get("https://www.pantaloons.com/");
//        System.out.println("Opened Pantaloons in mobile browser.");
//        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("div.mobilesearchbox")).click();
//        driver.findElement(By.xpath("//input[@placeholder=\"Search for products,brands and more...\"]")).sendKeys("Shirt");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("(//mark[text()=\"Shirt\"])[1]")).click();
//        System.out.println("Searched for item");
//        Thread.sleep(4000);
//        driver.findElement(By.cssSelector("span.cartSpriteIcon")).click();
//        System.out.println("Opened Cart");
//        System.out.println("Page Title: " + driver.getTitle());
//        driver.quit();
        
        
        
     // Step 1: Open Google
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().contains("Google"));

        // Step 2: Search for "Example Domain"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Example Domain");
        searchBox.submit();

        // Step 3: Validate search results loaded
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Example Domain"));

        // Step 4: Click first result
        List<WebElement> results = driver.findElements(By.cssSelector("h3"));
        results.get(0).click();

        // Step 5: Validate Example.com page loaded
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains("Example Domain"));

        // Step 6: Validate heading text
        WebElement heading = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(heading.getText(), "Example Domain");

        // Step 7: Validate paragraph text
        WebElement para = driver.findElement(By.tagName("p"));
        Assert.assertTrue(para.getText().contains("illustrative examples"));

        // Step 8: Click "More information" link
        WebElement moreInfo = driver.findElement(By.cssSelector("a"));
        moreInfo.click();

        // Step 9: Validate IANA page loaded
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains("IANA"));

        // Step 10: Navigate back to Example.com
        driver.navigate().back();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains("Example Domain"));

        // Step 11: Open W3Schools homepage
        driver.navigate().to("https://www.w3schools.com");
        Assert.assertTrue(driver.getTitle().contains("W3Schools"));

        // Step 12: Click "Learn HTML" link
        WebElement learnHTML = driver.findElement(By.linkText("Learn HTML"));
        learnHTML.click();

        // Step 13: Validate HTML tutorial page
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains("HTML Tutorial"));

        // Step 14: Scroll down
        ((IOSDriver) driver).executeScript("window.scrollBy(0,600)");

        // Step 15: Click "Try it Yourself" button
        WebElement tryIt = driver.findElement(By.linkText("Try it Yourself »"));
        tryIt.click();

        // Step 16: Switch to new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("tryit"));

        // Step 17: Validate iframe editor present
        driver.switchTo().frame("iframeResult");
        Assert.assertTrue(driver.getPageSource().contains("<h1"));

        driver.switchTo().defaultContent();

        // Step 18: Close TryIt tab and switch back
        driver.close();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Step 19: Validate still on W3Schools HTML tutorial
        Assert.assertTrue(driver.getTitle().contains("HTML Tutorial"));

        // Step 20: Go back to Google and validate
        driver.navigate().to("https://www.google.com");
        Assert.assertTrue(driver.getTitle().contains("Google"));

        System.out.println("20 steps executed successfully without exceptions.");
    }
}