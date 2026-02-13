package com.scripts.resource;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeOptionUpdationInCapabilities2ios
{

    IOSDriver driver;
    @Test
    public void initialization() throws MalformedURLException, InterruptedException {
        String device_farm_hub_url = "https://fireflinkclouddev.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=cd67524c-e292-4bd6-993f-e9d420da0f4d&licenseId=LIC4745&projectName=TestingProject/";
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("Simulator iPad Air 13inch M3");
	    options.setPlatformName("iOS");
        options.setPlatformVersion("18.4");
        options.setApp("iOS.Simulator.SauceLabs.Mobile.Sample.app.zip");
	    options.setAutomationName("XCUITest");
        driver = new IOSDriver(new URL(device_farm_hub_url), options);

        Thread.sleep(50000);

        driver.findElement(By.xpath("ewqrtyfbs")).click();




    }

    @AfterClass
    public void teardown()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }


}
