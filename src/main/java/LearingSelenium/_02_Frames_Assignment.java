package LearingSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class _02_Frames_Assignment {
    WebDriver driver;
    @Test
    public void Assignment()
    {
        try {
            driver = new ChromeDriver();
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.navigate().to("https://the-internet.herokuapp.com/");
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(By.xpath("//a[text()='Nested Frames']"))).click().build().perform();
            System.out.println(driver.findElements(By.xpath("//frame")).size());
            driver.switchTo().frame("frame-top");
            driver.switchTo().frame("frame-middle");
            System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Catch Block Executed");
        }
        finally {
            driver.quit();
        }


    }
}
