package com.scripts.resource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.android.AndroidDriver;
public class Android3_Script {
    
    public static void main(String[] args) throws Exception {
        //String seleniumHubUrl = "http://0.0.0.0:8250/fireflinkcloud/wd/hub?accessKey=1b2ed4ac-80ad-4db9-9c7c-f2ca334cd5bc&licenseId=LIC4654&projectName=testing/";
        //String seleniumHubUrl="http://0.0.0.0:8250/fireflinkcloud/wd/hub?accessKey=1b2ed4ac-80ad-4db9-9c7c-f2ca334cd5bc&licenseId=LIC4654&projectName=Project+Demo+Only+Akash/";
        //String seleniumHubUrl = "https://fireflinkclouddev.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=1b2ed4ac-80ad-4db9-9c7c-f2ca334cd5bc&licenseId=LIC4654&projectName=testing/";
    	String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=a0d63af2-5b26-4109-ba61-cbe7d6035113&licenseId=LIC3925&projectName=ABCS/";
    	DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability("deviceName", "Samsung Galaxy A12");
    	caps.setCapability("platformName", "Android");
    	caps.setCapability("platformVersion", "12");
    	caps.setCapability("app", "General-Store.apk");
    	AndroidDriver driver = new AndroidDriver(new URL(seleniumHubUrl), caps);

        System.out.println("open browser done ");
    
        System.out.println("1waiting for input ");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter to contienue 1");
        
    
        driver.quit();
        System.out.println("closed browser");
    }
}