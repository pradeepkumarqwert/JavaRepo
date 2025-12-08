package LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class _06_Handleing_calender {
    WebDriver driver;
    Actions act;
    String date;
    String month;
    String year;
    String[] expectedList;
    @Test
    public void calender()
    {
        date = "19";
        month = "10";
        year = "2027";
        expectedList = new String[]{month,date, year};


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
        driver.findElements(By.xpath("//button[contains(@class ,'react-calendar__year-view__months__month')]")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text() = '"+date+"']")).click();

        List<WebElement> actualList = driver.findElements(By.xpath("//input[contains(@class,'react-date-picker__inputGroup__input')]"));
        for(int i = 0 ; i< actualList.size() ; i++)
        {
            System.out.println(actualList.get(i).getAttribute("value"));
            Assert.assertEquals(actualList.get(i).getAttribute("value"),expectedList[i]);
        }
        driver.quit();

    }
}
