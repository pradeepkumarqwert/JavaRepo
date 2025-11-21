package com.scripts.resource;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class testAppWork {
	
	@Test
	public void openAppNew() throws MalformedURLException {
		String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=6b5ae5fc-ea3e-4a82-94ca-294b4ac01604&licenseId=LIC3921&projectName=Project+1/";
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("appium:deviceName", "Samsung Galaxy A12");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:platformVersion", "12");
		caps.setCapability("appium:browserName", "Chrome");
		WebDriver driver = new RemoteWebDriver(new URL(seleniumHubUrl), caps);
		
		Reporter.log("App launched",true);
		driver.navigate().to("https://www.amazon.in");
	
		driver.quit();

	}
	

}
