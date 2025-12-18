package com.scripts.resource;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class vivo {
    WebDriver driver;
    Actions act;
    ChromeOptions options;

    @Test
    public void run() throws InterruptedException {
        try {
            options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
            options.addArguments("--incognito");
            options.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(options);
            act = new Actions(driver);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
            driver.get("https://www.vivo.com/");
            waitForPageLoad(driver, 30);
            try{
                driver.findElement(By.xpath("//button[@id='vcm-v-close-btn']")).click();
            }catch (Exception e){
                System.out.println("Element not found");
            }
            act.moveToElement(driver.findElement(By.xpath("//p[contains(@class,'vep-pc-search-icon')]"))).perform();
            driver.findElement(By.xpath("//p[contains(@class,'vep-pc-search-icon')]")).click();
            List<WebElement> suggestedDropdownOptions = driver.findElements(By.xpath("//a[contains(@class,'vep-pc-search-hot-link')]"));
            List<String> deviceNames = suggestedDropdownOptions.stream().map(a -> a.getText()).collect(Collectors.toList());
            System.out.println(deviceNames.size());
            System.out.println("Device names Extracted successfully");

            for (String names : deviceNames) {
                System.out.println(names);
                act.moveToElement(driver.findElement(By.xpath("//a[contains(@class,'vep-pc-search-hot-link') and text() = '"+names+"']"))).pause(Duration.ofSeconds(2)).perform();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[contains(@class,'vep-pc-search-hot-link') and text() = '"+names+"']")).click();
                eachDeviceOverviewDetails();
                eachDevicegalleryDetails();
                eachDeviceParameterDetails();
            }

            Thread.sleep(5000);


        } catch (Exception e) {
            System.out.println("Exception Triggered");
            System.out.println(e);
        } finally {
            if (driver != null) {

            }
        }


    }


    public void eachDeviceOverviewDetails() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("""
                    window.scrollTo({
                        top: document.body.scrollHeight,
                        behavior: 'smooth'
                    });
                """);
        Thread.sleep(4000);
    }

    public void eachDevicegalleryDetails() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.xpath("//button[contains(@class,'vicon-back-top')]")).click();
        driver.findElement(By.xpath("//a[@class='no-flip-over' and text() = 'Gallery']")).click();
        js.executeScript("""
                    window.scrollTo({
                        top: document.body.scrollHeight,
                        behavior: 'smooth'
                    });
                """);
        Thread.sleep(3000);
    }

    public void eachDeviceParameterDetails() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(@class,'vicon-back-top')]")).click();
        driver.findElement(By.xpath("//a[@class='no-flip-over' and text() = 'Parameter']")).click();
        List<WebElement> colorsAvailable = driver.findElements(By.xpath("//li[contains(@class,'color-button')]"));
        for(WebElement colorOfDevice:colorsAvailable)
        {
            colorOfDevice.click();
            Thread.sleep(2000);
        }

        driver.findElement(By.xpath("//p[@class='vep-pc-logo-box no-flip-over']")).click();
        Thread.sleep(2000);

        act.moveToElement(driver.findElement(By.xpath("//p[contains(@class,'vep-pc-search-icon')]"))).perform();
        driver.findElement(By.xpath("//p[contains(@class,'vep-pc-search-icon')]")).click();

    }



    public static void waitForPageLoad(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }


    @AfterClass
    public void tearDown()
    {
        if(driver != null)
        {
        }
    }


}
