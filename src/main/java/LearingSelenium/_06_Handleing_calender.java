package LearingSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class _06_Handleing_calender {
    WebDriver driver;
    Actions act;
    String date;
    String month;
    String year;
    @Test
    public void calender()
    {
        date = "27";
        month = "5";
        year = "2027";
        driver = new ChromeDriver();
        act = new Actions(driver);
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        List<WebElement> monthsList = driver.findElements(By.xpath("//button[contains(@class ,'react-calendar__year-view__months__month')]"));
        System.out.println("year selected");
        for(int i = 1 ; i<= monthsList.size() ; i++)
        {
            monthsList.get(Integer.parseInt(month)-1).click();
        }
        System.out.println("Month clicked");
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
        driver.quit();

    }
}
