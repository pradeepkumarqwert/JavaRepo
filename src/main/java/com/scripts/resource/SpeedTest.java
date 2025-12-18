package com.scripts.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class SpeedTest {
    WebDriver driver;
    Actions act;
    ChromeOptions options;

    @Test
    public void run() throws InterruptedException {
        try {
            options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
            options.setAcceptInsecureCerts(true);
            String device_farm_hub_url = "https://fireflinkclouddev.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=8085832a-28e1-45ee-bf7c-30056258ba5e&licenseId=LIC4745&projectName=HotFix_SanityHotfix_V1013/";
            FirefoxOptions browserOptions = new FirefoxOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("137");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));

            act = new Actions(driver);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
            driver.get("https://www.speedtest.net/");
            waitTillPageLoad(driver, 20);

            Actions actions = new Actions(driver);

            Thread.sleep(10000);
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler' and text() = 'Continue']")).click();
            driver.findElement(By.xpath("//span[@class='start-text' and text() = 'Go']")).click();
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scroll(0,400)");

            Thread.sleep(40000);

        }catch (Exception e){
            System.out.println("Exception Triggered");
        }finally {
            driver.quit();
        }



    }

    public void waitTillPageLoad(WebDriver driver, int timeSet) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeSet));
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }


}
