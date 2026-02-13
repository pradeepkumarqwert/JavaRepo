package com.scripts.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

public class iphone {
    WebDriver driver;
    ChromeOptions options;
    WebDriverWait wait;
    Actions act;
    JavascriptExecutor js;

    @BeforeClass
    public void initialization(){
        options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver , Duration.ofSeconds(20));
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;

    }

    @Test
    public void run(){
        driver.get("https://www.apple.com/");
        js.executeScript("""
                window.scrollTo({
                top: document.body.scrollHeight,
                behavior: "smooth"
                });
                """);
        act.moveToElement(driver.findElement(By.xpath("//div[@id='tv-media-gallery']"))).perform();

    }

}
