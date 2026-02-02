package com.automation.P0andP1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class _23_Sequential_Script {
    WebDriver driver ;
    @Test(invocationCount = 35)
    public void run() throws InterruptedException, MalformedURLException {
        String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=vK-JO6U-sXEZzMi5z7p3b6Q2RZkUv6ugZQm_Ap4eCAvIpdFtfF3AGEv6Uahw0U9XX2kz2rqdTTa6iHP-hDgOlMnutXrAxYkjAkaq_UglUWzVmFX7p2GldzbWG5jNTP_Xhf0lu6epgN_YBmq8UkSzczCPn9DgYO_zHwLIV2TXCQXDrKljzvNSz7hGRB9lT3LfKREmjbqv3gcNwPv5di1Wfk0VtA_4RIozgn6l_WTGZ8blrUFwf0lLVty0w7qYdG_dO6TL1f6cjCHOJJD99MLalNSNl9gzip1luJV7QpuH5ds_WDM_FofmCEwKscjCSDBT&licenseId=LIC2026658&projectName=Sanity_20012026/";
        FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", true);
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("142");
        driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.quit();
    }
}
