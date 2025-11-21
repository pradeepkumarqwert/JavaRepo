package com.scripts.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ---------------------------------------------------------------
        // Example 1: switchTo().frame(int index)
        // ---------------------------------------------------------------
        driver.get("https://www.w3schools.com/html/html_iframe.asp");
        Thread.sleep(2000);

        // Count all iframes
        int totalFrames = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total frames on the page: " + totalFrames);

        // Switch to first iframe using index
        driver.switchTo().frame(0);
        System.out.println("Switched to first frame using index");

        // Perform an action inside the frame
        WebElement heading1 = driver.findElement(By.xpath("//h1"));
        System.out.println("Text inside first frame: " + heading1.getText());

        // Switch back to main page
        driver.switchTo().defaultContent();
        System.out.println("Returned to main page\n");

        // ---------------------------------------------------------------
        // Example 2: switchTo().frame(String nameOrId)
        // ---------------------------------------------------------------
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe/");
        Thread.sleep(2000);

        // Switch to outer frame using name/id
        driver.switchTo().frame("iframeResult");
        System.out.println("Switched to outer frame using name");

        // Perform action inside outer frame
        WebElement outerPara = driver.findElement(By.xpath("//p"));
        System.out.println("Text inside outer frame: " + outerPara.getText());

        // Switch back to main page
        driver.switchTo().defaultContent();
        System.out.println("Returned to main page\n");

        // ---------------------------------------------------------------
        // Example 3: switchTo().frame(WebElement element)
        // ---------------------------------------------------------------
        driver.get("https://www.w3schools.com/html/html_iframe.asp");
        Thread.sleep(2000);

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@title='W3Schools HTML Tutorial']"));
        driver.switchTo().frame(frameElement);
        System.out.println("Switched to frame using WebElement");

        WebElement insideH1 = driver.findElement(By.xpath("//h1"));
        System.out.println("Text inside frame (WebElement): " + insideH1.getText());

        driver.switchTo().defaultContent();
        System.out.println("Returned to main page\n");

        // ---------------------------------------------------------------
        // Example 4: Nested Frames + switchTo().parentFrame()
        // ---------------------------------------------------------------
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe");
        Thread.sleep(2000);

        // Switch to outer frame
        driver.switchTo().frame("iframeResult");
        System.out.println("Switched to outer frame");

        // Now switch to inner iframe
        WebElement innerFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(innerFrame);
        System.out.println("Switched to inner (nested) frame");

        // Perform action inside inner frame
        WebElement innerHeading = driver.findElement(By.xpath("//h1"));
        System.out.println("Text inside inner frame: " + innerHeading.getText());

        // Switch back to outer frame using parentFrame()
        driver.switchTo().parentFrame();
        System.out.println("Returned to outer frame using parentFrame()");
        WebElement outerText = driver.findElement(By.xpath("//p"));
        System.out.println("Outer frame text: " + outerText.getText());

        // ---------------------------------------------------------------
        // Example 5: switchTo().defaultContent()
        // ---------------------------------------------------------------
        driver.switchTo().defaultContent();
        System.out.println("Returned to main page using defaultContent()\n");

        System.out.println("All frame switching methods executed successfully!");
        Thread.sleep(3000);
        driver.quit();
    }
}
