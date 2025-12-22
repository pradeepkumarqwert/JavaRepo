package com.scripts.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

public class ExplicitWait {
    WebDriver driver;
    ChromeOptions options;

    @BeforeClass
    public void initializeDriver() throws MalformedURLException {

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
//        capabilities.setCapability("browserName", "Chrome");
//        bstackOptions.put("os", "Windows");
//        bstackOptions.put("osVersion", "11");
//        bstackOptions.put("browserVersion", "139.0");
//        bstackOptions.put("userName", "superadmin_vNb40A");
//        bstackOptions.put("accessKey", "bRxwxK6C7FjHbZiyayzZ");
//        bstackOptions.put("consoleLogs", "info");
//        capabilities.setCapability("bstack:options", bstackOptions);
//        driver = new RemoteWebDriver(
//                new URL("https://hub-cloud.browserstack.com/wd/hub"),
//                capabilities
//        );




        String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=i4lHFzS8kfmtNycLT5h_CA-h-aGD3COqml1jvwJ_dS3TjO1plYzCl92_1_k7dsA6_5GlrmLuPHBNd3x1moc3k6oybvdjgyRZeYSqVil6Kly7rj_oXzk7NV_3P-J2Xh6Gs3tYlDLFf2DVSh6ZsRvrwafgO5lkaw7liKtb51irQew4rLsw-YUL7hc-ofeso9zKlKHXxdfBk2WGEKjtRiWl6vdh2mogswJhr4n3Nr1P5FloGUFxwocqDiZDrrJAQ127rBveTHJKZoXTMSrZZmLePuiofrwumL_je_IhVliZQ1-EmTzv8P7p51TWJe0QPR-k&licenseId=LIC2026610&projectName=Automation+Testing/";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("131");
        browserOptions.setAcceptInsecureCerts(true);
        browserOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        browserOptions.addArguments("--incognito");
        browserOptions.addArguments("--start-maximized");
        browserOptions.addArguments("--disable-infobars");
        browserOptions.addArguments("--disable-notifications");
        driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));


//        options = new ChromeOptions();
//        options.setAcceptInsecureCerts(true);
//        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
//        options.addArguments("--incognito");
//        options.addArguments("--start-maximized");
//        options.addArguments("--disable-infobars");
//        options.addArguments("--disable-notifications");
//        driver = new ChromeDriver(options);

    }

    @Test
    public void run(){
        //steps to check wait until visibility of element(Expected condition Passed)
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(By.xpath("//button[text() = 'Start']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4[text() = 'Hello World!']")));


        //steps to check wait until element to be clickable of element(Expected condition Passed)
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text() = 'Remove']")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text() = 'Add']"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Add']")));

        //Step to check wait until the presence of element in DOM(Expected condition Passed)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text() = 'Dynamic Controls']")));

        //Steps to check response for checking waiting until the unavailable element in DOM but which is not available(Expected conditions Failed)
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text() = 'Dynas']")));
        } catch (Exception e) {
            System.out.println("Element is not Displayed in DOM");
            System.out.println(e);
        }

        //Steps to check response for disabled button to be clickable(Expected result should be fail)
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_disabled");
        try{
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button']")));
        }catch (Exception e){
            System.out.println("Element is not clickable");
            System.out.println(e);
        }


        //Steps to check response for the wait until the element for be disappeared in DOM(Expected condition Passed)
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text() = 'Remove']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text() = 'Remove']")));


        //Steps to check response for what if wait until the element disappeared but actually it won't(Expected result Failed)
        try {
            driver.findElement(By.xpath("//button[text() = 'Remove']")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text() = 'Remove']")));
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Element is not disappeared");
        }
    }

    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
