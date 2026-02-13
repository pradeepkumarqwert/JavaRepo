package com.scripts.resource;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class RoughScript3 {
    WebDriver driver;
    @Test(invocationCount = 3)
    public void run() throws MalformedURLException, InterruptedException {
        try {
            String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=8ziM7bzhaC-idi7IeYcWiBgI7qkBRpHTD2p2M3jQwTg-8OOvFPasONh06zcsqc-8MMQSxy_KtAxDGDocpnanvLlyOa5_07AA4j2Qka11h0h7O_DLOu3Jz05TcHJxn6kbYCjQguG-NZZ0zmPcpYlKm48w054fKKXuGgVRGh9XJKgoKPQfn5hlSEU3bIqkILYPN0tCgfwQjBwKLrXRq0Yowm240Jl7eL8aYhm3rTqe30cJjsd01ygNIwRkCLRW_u0AtEIYrMYa41XWw2Mdv2JH-xWz2ferVomCHzfVwofDr0VxCtONHFDp5nkdgJKErH7Enw&licenseId=LIC2026708&projectName=CSOD/";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setCapability("fireflink:deviceType", "public");
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("141");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));

            driver.get("https://www.jiomart.com");
            Thread.sleep(10000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if(driver != null){
                driver.quit();
            }
        }



    }


}