package com.masterSanityPack;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class _22_ParallelRun_Script {
    WebDriver driver ;
    @Test(invocationCount = 10, threadPoolSize = 10)
    public void run() throws InterruptedException, MalformedURLException {
        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=gpLL6cBoP80wWRUOKCFToC2MAR0d40JVsseGS2O6RxXHMW441fBUR7CaCCOIZLcjAgkd8zUlVGp5S0rM7dZfKFgsW6ibAvOnGsjPNdPQx4icUanJ_1blqqgSKpEcGN4Da3zKrVaeiJRmoqHi5nZBXx_XM-7P0_y5rO4Y7IL5Jxq6xYxg36QvorAd3qsq9fUs_8lwmldA9H0PpSIvR61vPBP0NnNY8Cpumk4KNZHKj2xSnerRwChNKJVpOmhdufZtj-uvavtFYPLzY6YEDtxzcRv2ebU0NXOXBg1u-NRVnliB6N49pjQ&licenseId=LIC3996&projectName=Admin+project+2/";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setCapability("fireflink:deviceType", "public");
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("136");
        WebDriver driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com");
        driver.get("https://www.pantaloons.com");
        Thread.sleep(10000);
        driver.quit();
    }
}
