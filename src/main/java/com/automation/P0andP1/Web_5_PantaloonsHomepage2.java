package com.automation.P0andP1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Web_5_PantaloonsHomepage2 {
	@Test
    public static void run(String[] args) throws InterruptedException {
        WebDriver driver = null;
        try {
        	String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=9adfe132-9652-4329-a206-4c8ee67e0281&licenseId=LIC3943&projectName=project+5/";
        	DesiredCapabilities caps = new DesiredCapabilities();
        	caps.setCapability("appium:deviceName", "iPhone 11");
        	caps.setCapability("platformName", "iOS");
        	caps.setCapability("appium:platformVersion", "15.5");
        	caps.setCapability("appium:browserName", "Safari");
        	driver = new RemoteWebDriver(new URL(seleniumHubUrl), caps);


            // caps.setCapability("appium:chromedriverAutodownload", true);


            driver.get("https://www.pantaloons.com/");
            System.out.println("Opened Pantaloons in mobile browser.");

            Thread.sleep(3000);
            driver.findElement(By.cssSelector("div.mobilesearchbox")).click();
            driver.findElement(By.xpath("//input[@placeholder=\"Search for products,brands and more...\"]")).sendKeys("Shirt");
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//mark[text()=\"Shirt\"])[1]")).click();
            System.out.println("Searched for item");

            Thread.sleep(4000);
            driver.findElement(By.cssSelector("span.cartSpriteIcon")).click();
            System.out.println("Opened Cart");

            System.out.println("Page Title: " + driver.getTitle());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
            System.out.println("Driver closed.");
        }
    }
    }