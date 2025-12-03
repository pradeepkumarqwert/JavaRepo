package com.scripts.resource;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class SandeepsiOSScript {
    public static void main(String[] args) throws MalformedURLException {
        String device_farm_hub_url = "https://fireflinkclouddev.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=cd67524c-e292-4bd6-993f-e9d420da0f4d&licenseId=LIC4745&projectName=web_mob_SP/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "iPhone 11");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:platformVersion", "15.5");
        caps.setCapability("appium:app", "SideStore.ipa");
        IOSDriver driver = new IOSDriver(new URL(device_farm_hub_url), caps);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.findElement(By.xpath("//*[@name=\"Allow\"]")).click();
        driver.findElement(By.xpath("//*[@name=\"OK\"]")).click();
        driver.findElement(By.xpath("//*[@name=\"Cancel\" and @type=\"XCUIElementTypeOther\"]")).click();
        driver.findElement(By.xpath("//*[@value=\"Error launching SideStore\"]")).getText();
//          driver.findElement(By.xpath("//*[@name=\"My Diary\"]")).click();
//          driver.findElement(By.xpath("")).click();
//
    }
}