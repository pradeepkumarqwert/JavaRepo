package LearningSelenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _017_Get_Adjustant_Value_Of_Cell {
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
    public void TableSorting()
    {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr//th//span[text()='Veg/fruit name']")).click();

        do {
            List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
            List<String> originalOrder = elementList.stream().map(WebElement::getText).collect(Collectors.toList());
            List<String> sortedOder = elementList.stream().map(WebElement::getText).sorted().collect(Collectors.toList());
            Assert.assertTrue(originalOrder.equals(sortedOder));
            price = elementList.stream().filter(s -> s.getText().contains("Cherry"))
                    .map(s -> getPriceOfVeggies(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));

            if (price.size() < 1) {
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        }while(price.size() < 1);

    }

    public static String getPriceOfVeggies(WebElement s)
    {
        String value = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return value;
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
