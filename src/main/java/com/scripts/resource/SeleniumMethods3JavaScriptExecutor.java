package com.scripts.resource;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class SeleniumMethods3JavaScriptExecutor {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Get Page Title
        String title = (String) js.executeScript("return document.title;");
        System.out.println("Page Title: " + title);

        // Get Current URL
        String url = (String) js.executeScript("return document.URL;");
        System.out.println("Page URL: " + url);

        // Scroll down
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(1000);

        // Scroll to bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1000);

        // Scroll back to top
        js.executeScript("window.scrollTo(0, 0);");

        // Switch to iframe and trigger alert
        driver.switchTo().frame("iframeResult");
        js.executeScript("myFunction()"); // executes JS function defined on page
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();
        driver.switchTo().defaultContent();

        // Click an element using JS (works even if normal click fails)
        driver.navigate().to("https://www.w3schools.com/html/html_forms.asp");
        WebElement tryItButton = driver.findElement(By.xpath("//a[@class='w3-btn w3-margin-bottom']"));
        js.executeScript("arguments[0].click();", tryItButton);

        // Send keys into input field using JS
        driver.navigate().to("https://www.w3schools.com/html/html_forms.asp");
        WebElement fnameInput = driver.findElement(By.id("fname"));
        js.executeScript("arguments[0].value='Pradeep';", fnameInput);
        System.out.println("Entered Name via JS");

        // Highlight an element
        js.executeScript("arguments[0].style.border='3px solid red';", fnameInput);
        Thread.sleep(2000);

        // Get inner text of body
        String bodyText = (String) js.executeScript("return document.body.innerText;");
        System.out.println("Body Text Length: " + bodyText.length());

        // Get total links on page
        Long linksCount = (Long) js.executeScript("return document.getElementsByTagName('a').length;");
        System.out.println("Total links: " + linksCount);

        // Navigate using JS
        js.executeScript("window.location='https://www.google.com';");
        Thread.sleep(3000);

        // Refresh page using JS
        js.executeScript("history.go(0);");

        // Get Page Load State
        String readyState = (String) js.executeScript("return document.readyState;");
        System.out.println("Page Ready State: " + readyState);

        // Zoom Page
        js.executeScript("document.body.style.zoom='80%';");

        Thread.sleep(3000);
        driver.quit();
    }
}
