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
         String device_farm_hub_url = "https://fireflinkclouddev.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=cd67524c-e292-4bd6-993f-e9d420da0f4d&licenseId=LIC4745&projectName=TestingProject/";
         DesiredCapabilities caps = new DesiredCapabilities();
         caps.setCapability("appium:deviceName", "Simulator iPad Air 13inch M3");
         caps.setCapability("platformName", "iOS");
         caps.setCapability("appium:platformVersion", "18.4");
         caps.setCapability("appium:app", "iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.zip");





         caps.setCapability("appium:automationName", "XCUITest");
         caps.setCapability("appium:autoAcceptAlerts", true); // automatically tap Allow for popups
         caps.setCapability("appium:fullReset", true);
         IOSDriver driver = new IOSDriver(new URL(device_farm_hub_url), caps);
			
			Thread.sleep(100000);
			
			driver.quit();
		
	 }

}
