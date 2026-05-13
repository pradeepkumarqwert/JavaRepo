package com.scripts.resource;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class ScriptOne_BAClass {
    protected WebDriver driver;
    @BeforeClass
    public void initialize() throws MalformedURLException {
        String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=8Tcsdwspy69KdKXw6ambPGMs6LQazDAA8okbIssJb7YGMDCKJMTB7VsBrV4hUIOuGV6I3wCwpK2CbuNIwIVnSswS5CbMRArfP5qm59IgrRxHwhSx_RywypctI-EwuF2TlQs7Dsq38CpF24sHUVJrCSi8v1VvwYjO3LKlPp5054Ji4dtzt3EtbdVyIAlwauBFkx-1YufbwuVWT-AOLN0MlQLdqjA0bzHDwpSZUzk2LeE7GFJ6rBwsOsTQrpU6HNU2W3kRm70a6nvLdV91z6Hm-kxlb_Rd8l4i_Pt52_nZUtFT5BYDEGZiGIrR_yOMRSnQtp5ojsY6bWnoVA&licenseId=LIC2026615&projectName=30032026_Testing/";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setCapability("fireflink:deviceType", "public");
        browserOptions.setPlatformName("mac Tahoe");
        browserOptions.setBrowserVersion("143");
        driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));


    }


    @AfterClass
    public void tearDown(){
        if(driver!=null){
            driver.quit();
            System.out.println("Driver quit successfully");
        }
    }
}
