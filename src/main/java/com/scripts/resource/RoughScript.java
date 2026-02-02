package com.scripts.resource;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;

public class RoughScript {
    WebDriver driver ;
    AndroidDriver driver1;
    @Test
  public void run() throws InterruptedException, MalformedURLException {
        try{
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=gpLL6cBoP80wWRUOKCFToC2MAR0d40JVsseGS2O6RxXHMW441fBUR7CaCCOIZLcjAgkd8zUlVGp5S0rM7dZfKFgsW6ibAvOnGsjPNdPQx4icUanJ_1blqqgSKpEcGN4Da3zKrVaeiJRmoqHi5nZBXx_XM-7P0_y5rO4Y7IL5Jxq6xYxg36QvorAd3qsq9fUs_8lwmldA9H0PpSIvR61vPBP0NnNY8Cpumk4KNZHKj2xSnerRwChNKJVpOmhdufZtj-uvavtFYPLzY6YEDtxzcRv2ebU0NXOXBg1u-NRVnliB6N49pjQ&licenseId=LIC3996&projectName=Private+dev+23012026/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Samsung Galaxy A12");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "12");
            caps.setCapability("appium:browserName", "Chrome");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), caps);


            driver.get("https://www.google.com");
            driver.get("https://www.jiomart.com");
            callingNativeApp();
            System.out.println("Native app execution completed");
        }catch(Exception e){
            System.out.println("Expection Triggered");
        }finally {
            driver.quit();
        }
  }

  public void callingNativeApp(){
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appPackage", "com.google.android.apps.maps");
            caps.setCapability("appActivity", "com.google.android.maps.MapsActivity");
            driver1 = new AndroidDriver(caps);
            System.out.println("Native app Opened");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            driver1.quit();

        }

  }



}