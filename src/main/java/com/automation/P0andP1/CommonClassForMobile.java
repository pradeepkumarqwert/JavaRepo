package com.automation.P0andP1;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CommonClassForMobile {
    AndroidDriver driver;


    @BeforeClass
    public void initializationApp() throws MalformedURLException, InterruptedException {



        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=QWgkKT6DGIR2iG74EUlW7deRNRYzgxHmiT9mNT2qYfatAtZNLMy3Jmwcc7SKuyaEUTGnty30p1C47JclhmbT46vs54qV_r8LM1Ij_zz50kuSdaWB0aNLFu9CKqwbPxYI5e9sTakYruZQ3rSVVKjdXrWERTWp9lYC2e-n9CNQoMhbZiTF-2GQ5sJvjD-570Mhh04qbLhLMk0gqzNS_mSRV2RmBAnZRsILfQvO1waWPC_q4I72O-lD7T1zk4Mh_5eT8wRYnXjcHXyneO4g19Avmq4zK6dYxbbmh5CBiyqWRxmwBGurdS0U&licenseId=LIC4045&projectName=PostRefactoring/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "Pixel Tablet");
        caps.setCapability("appium:platformName", "Android");
        caps.setCapability("appium:platformVersion", "16");
        caps.setCapability("appium:app", "Kuza_One_2.0.71.apk");
        driver = new AndroidDriver(new URL(device_farm_hub_url), caps);

    }

    @Test
    public void run() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(AppiumBy.accessibilityId("asdghjfhdgfd")).click();
    }

    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
            System.out.println("Driver Quit Successfully");
        }
    }




}
