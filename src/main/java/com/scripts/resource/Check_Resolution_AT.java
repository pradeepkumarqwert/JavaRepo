package com.scripts.resource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Check_Resolution_AT {

    public static void main(String[] args) throws MalformedURLException {

        // Launch browser
        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=wce601tlUT7iEexPfpyXAhU70xTORiDS4n78ySzYRdrBE9umfvY9Zb04tTkRJVSQich1g63fSOisGocDcntIDSq7Md3gWX0m9BDZa3N_5dGWSa031UMyQ3SAUfhmoxNTmifqycQ4-6tNjFdIa0Mb5rpfe3QmtqkLQQ1K_SpGapIsq5Su-NtXnntB6M6ZVPkW8kIch7iL7-AixyXa5689RYLYR2aLz7dQMvshF7bNNl7hNKeStnQ59mKqDXZIIE82VEbu4zW3gGswrT2WJijOqsUXEFjKJwPdF2sYM71K5wmYudPpzZ1Ffg&licenseId=LIC4322&projectName=Project+1/";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setCapability("fireflink:deviceType", "public");
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("136");
        WebDriver driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1280, 1024));


        // Open any URL
        driver.get("https://www.google.com");

        // Get window size
        Dimension size = driver.manage().window().getSize();

        int width = size.getWidth();   // X
        int height = size.getHeight(); // Y

        // Print resolution
        System.out.println("Browser Resolution:");
        System.out.println("Width (X): " + width);
        System.out.println("Height (Y): " + height);

        // Close browser
        driver.quit();
    }
}