package LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class _08_AddValuesFromTable {
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

        List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody//tr//td[4]"));

        int sum = 0;

        for(int i = 0 ; i<values.size(); i++)
        {
            sum = sum + Integer.parseInt(values.get(i).getText());
        }

        System.out.println(sum);


        String textvalue = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
        String[] textvalue2 = textvalue.split(":");
        int expecctedValue = Integer.parseInt(textvalue2[1].trim());
        Assert.assertEquals(sum, expecctedValue);

        driver.quit();

    }
}
