package LearningSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class _010_SSLCertificateHandling
{
    WebDriver driver;
    @Test
    public void run() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //options.setAcceptInsecureCerts(true); This will handle the SSL certificate issue by default
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://expired.badssl.com/");
        Thread.sleep(1000);
        driver.quit();

    }
}
