package LearningSelenium;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ZZZZZZZZZ_Practice {
    WebDriver driver;
    ChromeOptions options;
    Actions act;

    @Test
    public void run() throws IOException, InterruptedException {
        options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("discard-popup-blocking"));
        driver = new ChromeDriver(options);
        act = new Actions(driver);
        SoftAssert sAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com/");
        takeSS();
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);
        takeSS();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000)");
        takeSS();
        act.moveToElement(driver.findElement(By.xpath("//div[@id='gf-BIG']")));
        WebElement footerDom = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        List<WebElement> allLink = footerDom.findElements(By.tagName("a"));
        for (WebElement links : allLink) {
            String link = links.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(link).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int status = conn.getResponseCode();
            System.out.println(status);
            sAssert.assertTrue(status > 400, "The broken link is: " + links.getText());
        }
        sAssert.assertAll();

    }

    public void takeSS() throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Selenium\\SeleniumScreenShot\\JioMartHomeScreen.png"));
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
