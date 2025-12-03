package LearingSelenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class _07_ScrollInTable {
    WebDriver driver;
    @Test
    public  void run()
    {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");

        js.executeScript("document.querySelector('.tableFixHead').scrollTop = 5000");

    }
}
