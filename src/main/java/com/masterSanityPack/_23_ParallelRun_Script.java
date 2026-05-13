package com.masterSanityPack;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class _23_ParallelRun_Script {
    WebDriver driver ;
    @Test(invocationCount = 3, threadPoolSize = 3)
    public void run() throws InterruptedException, MalformedURLException {
        String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=kLEqWQPfj6rUNj_QhgkseUNyrrI87UKd6wWb1Z5RpCow_7hgLiWiw3iQpITpbiEP0cdPqq_9yj38TdC2gza1-uBXEAWkBBKNYjkaIeqQTa-7vUkoe_blS5vMhC21UQxfeC3LvUoykGUtxovpA9W8n6oB7H2cN-f5egaV3eyY6olQXUg9RIKVwOOMw7W2G4nXyXgbC-amhNiOyHwrOhpNxpeKxplSUykAVh3y9JPbqozuTgip4kkYNPBLKV7uTJqxwefeWaHusYbakK02YfABa4kSmivV42jyyYrdW9XABc-AYgl1VjrGUqBxTsOeTLyvEzExOpuv3MVsTA&licenseId=LIC2026615&projectName=02032026_Testing_103/";
        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setCapability("fireflink:deviceType", "public");
        browserOptions.setPlatformName("mac Tahoe");
        browserOptions.setBrowserVersion("26.2");
        driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com");
        driver.get("https://www.pantaloons.com");
        Thread.sleep(10000);
        driver.quit();
    }
}
