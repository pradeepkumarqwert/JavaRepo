package com.scripts.resource;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RoughScript3 {
    WebDriver driver;

    @Test(invocationCount = 1)
    public void run() throws InterruptedException, MalformedURLException {
        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=lAJ5eXJ0gS5WFnBQPbhhbQpNm7NfNqLZR8iWIfN4AwliqyDtNLeMTDZOPBeJXXejXJA81keImrVPRaZ2bAla-uruffkqtqXiDBnQ_-VdeZK280DJD8H14gL4iNT4hL0lk6cQ4wACSv1UQwks43Us4kN7-6BD38jYoMNbVym1YYcR37s0faj4l20zG-n4fZPTshsgtz2mUiXYEcRAwIVTxCn4cGAt9LI3j0LwCv2clVTPUts-5q9RqxjmCw7vfQFphh1XNx-p9y7N-TRytcZFovvDGELxT1VYJHY5woZmBZIaCqWZttQ&licenseId=LIC3996&projectName=Testing_27012026/";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setCapability("fireflink:deviceType", "public");
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("136");
        WebDriver driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));

        driver.get("https://www.google.com");
            Thread.sleep(25000);







    }
}