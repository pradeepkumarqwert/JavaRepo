package com.automation.P0andP1;


import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class _12_iOS_App_Simulator
{
	 @Test
	 public void test() throws MalformedURLException, InterruptedException
	 {
		 String seleniumHubUrl = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=a31168ce-bf67-4a7a-bfa1-997fca75f65a&licenseId=LIC1026534&projectName=Time+Zone/";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("appium:deviceName", "Simulator iPhone 16");
		 caps.setCapability("platformName", "iOS");
		 caps.setCapability("appium:platformVersion", "18.4");
		 caps.setCapability("appium:app", "iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1 (5).zip");
		 IOSDriver driver = new IOSDriver(new URL(seleniumHubUrl), caps);



			caps.setCapability("appium:automationName", "XCUITest");
			caps.setCapability("appium:autoAcceptAlerts", true); // automatically tap Allow for popups
			caps.setCapability("appium:fullReset", true);
			
			Thread.sleep(1000);
			
			driver.quit();
		
	 }

}
