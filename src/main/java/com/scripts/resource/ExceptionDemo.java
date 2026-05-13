package com.scripts.resource;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ExceptionDemo {


    public static void main(String[] args) throws MalformedURLException {

        String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=71HsbGkWHHq1x81k37LbPyqeZ53wOhpe-MDVHzWv_y2_p2z2reJBd6CyDdzML8Xl-SmNw_NJyykp8LzfHDbRmFXGLQCA4pmZXwiC4iPepm24aEv0inOYPSI0BRjw9sD6VVkCHj0kIh6BWw3zkL9EzJtV8IK9o6gMknNeSQ6UwXMDpkoJFBDupAtHDBLjDJH3PjhMm2u610yK3wdt3iDyxUUno2m_7CGaLx1HOEP-VKdAaXOd5ufc1f7WH3ptsC1iTMEOjuZmdve0jIK42vi4NOo7lqICkcrXtokA2QlAmag7jLCsQiWzKTwAK0HDy2w&licenseId=LIC4139&projectName=WebCHeckGUest/";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setCapability("fireflink:deviceType", "public");
        browserOptions.setPlatformName("mac Tahoe");
        browserOptions.setBrowserVersion("140");
        WebDriver driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://example.com");

        // 1. NoSuchElementException
        try {
            driver.findElement(By.id("notPresent")).click();
        } catch (Exception e) {
            System.out.println("NoSuchElementException: " + e.getClass().getSimpleName());
        }

        // 2. TimeoutException
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("neverVisible")));
        } catch (Exception e) {
            System.out.println("TimeoutException: " + e.getClass().getSimpleName());
        }

        // 3. StaleElementReferenceException
        try {
            WebElement element = driver.findElement(By.tagName("h1"));
            driver.navigate().refresh();
            element.getText(); // stale reference
        } catch (Exception e) {
            System.out.println("StaleElementReferenceException: " + e.getClass().getSimpleName());
        }

        // 4. ElementNotInteractableException
        try {
            driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_hidden");
            driver.switchTo().frame("iframeResult");
            WebElement hidden = driver.findElement(By.name("fname"));
            hidden.click(); // hidden element
        } catch (Exception e) {
            System.out.println("ElementNotInteractableException: " + e.getClass().getSimpleName());
        }

        // 5. InvalidSelectorException
        try {
            driver.findElement(By.xpath("//invalid[@]"));
        } catch (Exception e) {
            System.out.println("InvalidSelectorException: " + e.getClass().getSimpleName());
        }

        // 6. NoSuchWindowException
        try {
            driver.switchTo().window("invalidWindow");
        } catch (Exception e) {
            System.out.println("NoSuchWindowException: " + e.getClass().getSimpleName());
        }

        // 7. NoSuchFrameException
        try {
            driver.switchTo().frame("wrongFrame");
        } catch (Exception e) {
            System.out.println("NoSuchFrameException: " + e.getClass().getSimpleName());
        }

        // 8. JavascriptException
        try {
            ((JavascriptExecutor) driver).executeScript("invalid javascript code");
        } catch (Exception e) {
            System.out.println("JavascriptException: " + e.getClass().getSimpleName());
        }

        driver.quit();
    }


}
