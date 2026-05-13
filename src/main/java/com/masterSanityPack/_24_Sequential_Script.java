package com.masterSanityPack;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class _24_Sequential_Script {
    WebDriver driver ;
    @Test(invocationCount = 5)
    public void run() throws InterruptedException, MalformedURLException {
        String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=kLEqWQPfj6rUNj_QhgkseUNyrrI87UKd6wWb1Z5RpCow_7hgLiWiw3iQpITpbiEP0cdPqq_9yj38TdC2gza1-uBXEAWkBBKNYjkaIeqQTa-7vUkoe_blS5vMhC21UQxfeC3LvUoykGUtxovpA9W8n6oB7H2cN-f5egaV3eyY6olQXUg9RIKVwOOMw7W2G4nXyXgbC-amhNiOyHwrOhpNxpeKxplSUykAVh3y9JPbqozuTgip4kkYNPBLKV7uTJqxwefeWaHusYbakK02YfABa4kSmivV42jyyYrdW9XABc-AYgl1VjrGUqBxTsOeTLyvEzExOpuv3MVsTA&licenseId=LIC2026615&projectName=02032026_Testing_103/";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setCapability("fireflink:deviceType", "public");
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("137");
        driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.quit();
    }
}
