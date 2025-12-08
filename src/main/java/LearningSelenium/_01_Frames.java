    package LearningSelenium;

    import org.openqa.selenium.By;
    import org.openqa.selenium.NoSuchElementException;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.interactions.Actions;
    import org.testng.annotations.Test;

    public class _01_Frames {
        WebDriver driver;
        @Test
        public void frames()
        {
            try {
                driver = new ChromeDriver();
                driver.get("https://www.google.com");
                driver.navigate().to("https://www.jqueryui.com/droppable");
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
                Actions act = new Actions(driver);
                WebElement source = driver.findElement(By.cssSelector("div[id='draggable']"));
                WebElement target = driver.findElement(By.cssSelector("div[id='droppable']"));
                act.dragAndDrop(source,target);
                System.out.println("TestExecution Passed");
                driver.switchTo().defaultContent();

            }
            catch(NoSuchElementException e) {
                System.out.println("Catch block executed");
            }
            finally {
                driver.quit();
            }
        }


    }
