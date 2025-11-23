package LearingSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class _04_ClickOnMultipleLinksWithoutOutSwitchPages {
    WebDriver driver;
    @Test
    public void LimitScope()
    {

        try {
            driver = new ChromeDriver();
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.navigate().to("https://www.rahulshettyacademy.com/AutomationPractice/");
            Actions act = new Actions(driver);
            //limiting the footer section
            WebElement footerDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));//limiting DOM scope
            act.moveToElement(footerDriver);
            System.out.println(footerDriver.findElements(By.tagName("a")).size());
            //Limiting the sub footer section
            WebElement SubFooterDriver1 = driver.findElement(By.xpath("(//div[@id='gf-BIG']//ul)[1]"));
            System.out.println("The Count of link in sub footer section 1 is :"+SubFooterDriver1.findElements(By.tagName("a")).size());

            //Now click all available links in the first column of sub footer

            for(int i = 1; i< SubFooterDriver1.findElements(By.tagName("a")).size(); i++)
            {
                String clickonLink = Keys.chord(Keys.CONTROL,Keys.ENTER);

                SubFooterDriver1.findElements(By.tagName("a")).get(i).sendKeys(clickonLink);
                Thread.sleep(2000);
            }
            Set<String> windowsHands = driver.getWindowHandles();
            Iterator<String> it = windowsHands.iterator();

            while(it.hasNext())
            {
                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());

            }


        }catch(NoSuchElementException | InterruptedException e){
            System.out.println("Catch block triggered");
        }finally {
            driver.quit();
        }



    }
}
