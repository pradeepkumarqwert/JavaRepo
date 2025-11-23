package LearingSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class _05_Practice_Assignment {
    WebDriver driver ;
    Actions act;
    @Test
    public void test()
    {
        try {
            driver = new ChromeDriver();
            act = new Actions(driver);
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://www.rahulshettyacademy.com/AutomationPractice/");
            driver.findElement(By.xpath("//div[@id='checkbox-example']//legend/following-sibling::label//input[@id='checkBoxOption3' and @type = 'checkbox']")).click();
            String optionName = driver.findElement(By.xpath("//div[@id='checkbox-example']//legend/following-sibling::label//input[@id='checkBoxOption3' and @type = 'checkbox']/ancestor::label")).getText();
            System.out.println(optionName);
            WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
            Select select = new Select(dropdown);
            select.selectByVisibleText(optionName);
            driver.findElement(By.xpath("//input[@id='name']")).sendKeys(optionName);
            driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
            String alertText = driver.switchTo().alert().getText();
            if(alertText.contains(optionName))
            {
                System.out.println("Conditions Passed");
            }
            else{
                System.out.println("Conditions Failed");
            }

        }catch(NoSuchElementException e){
            System.out.println("Catch block triggered");
        }finally {
            driver.quit();
        }

    }
}
