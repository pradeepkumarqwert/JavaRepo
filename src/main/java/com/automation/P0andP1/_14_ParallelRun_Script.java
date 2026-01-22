package com.automation.P0andP1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class _14_ParallelRun_Script {
    WebDriver driver ;
    @Test(invocationCount = 10, threadPoolSize = 10)
    public void run() throws InterruptedException, MalformedURLException {
        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=2XpX0pCCa5sZ4t42o2SQX7vVo3eapYfPDT-9I23oKiqp_DvSuFM7Wm54CZ8w07m4S0Q5hrpgNjeLO-gLBOyum4dn2ZczCYUFb25CzoAaTITZGr6fdL_AAriC4iMwJOBx3Ym9GXYg0kNy7ijkRDtqUF12GB_gjeElLM6ilD7Wbc98mhpUJgnemzbel-dPbkDYUxvZ5HMvQhKG4VuQogRYrOPrd_NXXKGypsEY0Fj3B8Fhmr4yBFKBn3-ig1ia9gtwwW8iUXrHr4QXHWJJ5CF94ozXB3nDOnOiE00V8iiC7pH9gzqOk1GS&licenseId=LIC4047&projectName=Testing+project+1/";
        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setPlatformName("mac Sequoia");
        browserOptions.setBrowserVersion("18.2");
        driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com");
        Thread.sleep(100000);
        driver.quit();
    }
}
