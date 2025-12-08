package LearningSelenium;

import org.apache.commons.io.FileUtils;
import org.junit.After;
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

public class _014_HandleBrokenLink {
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
        SoftAssert softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com/");
        takeSS();
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        takeSS();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000)");
        takeSS();
        act.moveToElement(driver.findElement(By.xpath("//div[@id='gf-BIG']")));
        WebElement footerDom = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        List<WebElement> allLinks = footerDom.findElements(By.tagName("a"));

        for (WebElement linkN : allLinks) {
            String oneByOneLink = linkN.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(oneByOneLink).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int status = conn.getResponseCode();
            System.out.println(status);
            softAssert.assertTrue(status > 400, "Broken link is:" + linkN.getText());

        }
        softAssert.assertAll();
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
