package LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _018_Filter_Web_Table {
    WebDriver driver;
    ChromeOptions options;
    Actions act;
    List<String> price;
    @BeforeClass
    public void initializer()
    {
        options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        act = new Actions(driver);
    }

    @Test
    public void TableSorting() {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//input[@id='search-field']")).click();
        driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("er");

        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> afterFilterList = elementList.stream().filter(s->s.getText().contains("er")).collect(Collectors.toList());
        Assert.assertEquals(elementList.size(),afterFilterList.size());


    }
    @AfterClass
    public void tearDown()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }

}
