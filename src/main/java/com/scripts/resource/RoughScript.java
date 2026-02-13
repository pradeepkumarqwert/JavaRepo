package com.scripts.resource;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.HttpCommandExecutor;

import java.net.URL;

public class RoughScript {

    public static void main(String[] args) throws Exception {

        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=XXXXX&licenseId=LIC3996&projectName=11022026_Testing/";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setCapability("fireflink:deviceType", "public");
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("136");
        // Create driver ONLY ONCE
        RemoteWebDriver driver = new RemoteWebDriver(
                new URL(device_farm_hub_url),
                browserOptions
        );

        driver.manage().window().setSize(new Dimension(1024, 768));
        // Fetch Hub URL dynamically
        HttpCommandExecutor executor =
                (HttpCommandExecutor) driver.getCommandExecutor();

        URL hubURL = executor.getAddressOfRemoteServer();

        System.out.println("Connected Selenium Hub URL: " + hubURL);

        driver.quit();
    }
}
