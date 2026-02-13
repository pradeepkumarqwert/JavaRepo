package com.scripts.resource;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class Bata {
    AndroidDriver driver;
    @Test
    public void run1() throws Exception {

//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setDeviceName("SM-A135F");
//        options.setPlatformName("Android");
//        options.setPlatformVersion("14");
//        options.setAutomationName("UiAutomator2");
//        options.setAppPackage("com.developer.bata");
//        options.setAppActivity("com.developer.bata.MainActivity");
//        options.setNoReset(true);
//        options.setAutoGrantPermissions(true);
//        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=INVj9-YlVrgmxOKEhZEJK_qR6NQMB9736SdoHAlESbkx62r-aa7PIGUVL1nJr-VeZ1_ZV34S-tEnN8HdJ4wC3U-4_-bLn2ve3EGvN7v7di268WJsZe0peA_xRel8diHD8h9hWKsc8ABbEB19CeB5o8m92sByoWMkCz-eu-E1lW55EmUA_SOU9pnHPny79urpjMOm0GEkTAXqmi2Mvwtf5rTnE3erZ-g_k24tbeZQKwdZejDLMt7lux75Thp4gr9ZrqTJNV3kyKhNiGzQAG28cXPMFtyCutv4nErebztShHV6n__Z--4IOtxOpmZ2-6Mn&licenseId=LIC2026616&projectName=HL+sanity/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "motorola edge 50");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "15");
        caps.setCapability("appium:app", "Bata.apk");
        driver = new AndroidDriver(new URL(device_farm_hub_url), caps);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Close promo banner
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Close Promo Banner Small")
        )).click();

        // Click first button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@package='com.developer.bata']")
        )).click();

        // Click Men category
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.View[@text='men']")
        )).click();

        // Select product
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.View[@resource-id='product-search-results']//android.widget.Image")
        )).click();

        // Price filter
        driver.findElement(By.id("fromInput")).sendKeys("1000");
        driver.findElement(By.id("toInput")).sendKeys("20000");

        driver.findElement(
                By.xpath("//android.view.View[@text='Price']/android.widget.Button")
        ).click();

        driver.quit();
    }
}
