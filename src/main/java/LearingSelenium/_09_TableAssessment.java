package LearingSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class _09_TableAssessment {
    WebDriver driver;
    @Test
    public void run()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com/");
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");
        List<WebElement> rows =  driver.findElements(By.xpath("//table[@id='product' and @name='courses']//tbody//tr"));

        System.out.println("Number of rows in the table: "+rows.size());

        System.out.println("Number of Columns in the table: "+driver.findElements(By.xpath("//table[@id='product' and @name='courses']//tbody//tr[3]//td")).size());

        List<WebElement> secondRowValues = driver.findElements(By.xpath("//table[@id='product' and @name='courses']//tbody//tr[3]//td"));
        for (WebElement secondRowValue : secondRowValues) {
            System.out.println("Value in the Cell "+secondRowValue.getText());
        }
        driver.quit();


    }
}
