package com.automation.P0andP1;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.repository.PantaloonsLandingPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Listeners(com.report.listener.ExtentReportManager.class)
public class _21_HybridScript {

    WebDriver webDriver;
    WebDriver mobileDriver;
    BaseMethodsCloud baseMethodWeb;
    BaseMethodsCloud baseMethodMobile;
    BaseDataCloud baseData;
    PantaloonsLandingPage pantaloonsPage;

    @Test
    public void interleavedExecution() throws InterruptedException, MalformedURLException {
        try {
            // --------------------------
            // 1. Initialize Web Driver
            // --------------------------
            String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=9MMh2mjlAPKWJLBo1BzQryyBWyM4eHaeQql5TPgDLdwErVkf91Lq2FnwHBZxxozlUKyWshr47fXsP-r67wq47HHvJw16A9CW0bkf9wzVJiT0NwSsjjI-wilkjacGKoGXdZDOOZjQfAb2Vlt73GL2vFZXciFJVR75N9z3dRr6-0W5kXTWvNT5gqTEHnsBH1Cr2RVNgJk3ibzctJCLWkgl5g3mMPVK-a_wnaWm4n3vcvem2i3mpyZN0fTy538Ai7djqzC30NQeNcHHs7UbhV6vFKWwbgWr3CViMNZPs11pPfm0WZkOBcIDFvyRbZhosKZ9&licenseId=LIC2026617&projectName=Private+Devices/";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("139");
            webDriver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
            webDriver.manage().window().setSize(new Dimension(1024, 768));

            baseMethodWeb = new BaseMethodsCloud(webDriver);

            // --------------------------
            // 2. Initialize Mobile Driver
            // --------------------------
            String device_farm_hub_url1 = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=9MMh2mjlAPKWJLBo1BzQryyBWyM4eHaeQql5TPgDLdwErVkf91Lq2FnwHBZxxozlUKyWshr47fXsP-r67wq47HHvJw16A9CW0bkf9wzVJiT0NwSsjjI-wilkjacGKoGXdZDOOZjQfAb2Vlt73GL2vFZXciFJVR75N9z3dRr6-0W5kXTWvNT5gqTEHnsBH1Cr2RVNgJk3ibzctJCLWkgl5g3mMPVK-a_wnaWm4n3vcvem2i3mpyZN0fTy538Ai7djqzC30NQeNcHHs7UbhV6vFKWwbgWr3CViMNZPs11pPfm0WZkOBcIDFvyRbZhosKZ9&licenseId=LIC2026617&projectName=Private+Devices/";
            DesiredCapabilities caps2 = new DesiredCapabilities();
            caps2.setCapability("appium:deviceName", "iQOO Neo7 Pro");
            caps2.setCapability("platformName", "Android");
            caps2.setCapability("appium:platformVersion", "15");
            caps2.setCapability("appium:browserName", "Chrome");
            mobileDriver = new RemoteWebDriver(new URL(device_farm_hub_url1), caps2);

            baseMethodMobile = new BaseMethodsCloud(mobileDriver);

            // --------------------------
            // 3. Initialize common objects
            // --------------------------
            baseData = new BaseDataCloud();
            pantaloonsPage = new PantaloonsLandingPage(webDriver); // Use webDriver for object locators

            // --------------------------
            // 4. Execute Steps Interleaved
            // --------------------------

            // -------- Web Step 1 --------
            baseMethodWeb.getString(baseData.getBrowserURL(), "Landed on Google website");
            takeScreenshot(webDriver, "Web_01_Google");

            // -------- Web Step 2 --------
            baseMethodWeb.Navigateinto(baseData.getPantaloonspageURL(), "Navigate to Pantaloons landing page");
            baseMethodWeb.waitForPageLoad(webDriver);
            baseMethodWeb.ElementIsDisplay(pantaloonsPage.getPantaloonsLogoElement());
            takeScreenshot(webDriver, "Web_02_Pantaloons_Landing");

            // -------- Mobile Step 1 --------
            mobileDriver.get("https://www.pantaloons.com/");
            takeScreenshot(mobileDriver, "Mobile_01_HomePage");

            // -------- Mobile Step 2 --------
            mobileDriver.findElement(By.cssSelector("div.mobilesearchbox")).click();
            takeScreenshot(mobileDriver, "Mobile_02_ClickSearch");

            // -------- Mobile Step 3 --------
            Thread.sleep(2000);
            mobileDriver.findElement(By.xpath("//input[@placeholder='Search for products,brands and more...']")).sendKeys("Shirt");
            takeScreenshot(mobileDriver, "Mobile_03_EnterSearch");

            // -------- Mobile Step 4 --------
            Thread.sleep(2000);
            mobileDriver.findElement(By.xpath("(//mark[text()='Shirt'])[1]")).click();
            takeScreenshot(mobileDriver, "Mobile_04_SelectSearchResult");

            // -------- Mobile Step 5 --------
            Thread.sleep(2000);
            mobileDriver.findElement(By.cssSelector("span.cartSpriteIcon")).click();
            takeScreenshot(mobileDriver, "Mobile_05_CartPage");

            // -------- Web Step 3 --------
            baseMethodWeb.Click(pantaloonsPage.getPantaloonsMainSearchBarElement());
            baseMethodWeb.TypeText(pantaloonsPage.getPantaloonsMainSearchBarElement(), "Shirts");
            baseMethodWeb.presskeys(pantaloonsPage.getPantaloonsMainSearchBarElement(), Keys.ENTER,
                    "Search Shirts on Web");
            takeScreenshot(webDriver, "Web_03_SearchShirts");

            // -------- Web Step 4 --------
            baseMethodWeb.MouseHoverOnElement(pantaloonsPage.PantaloonsSearchFilterOptionsElement("Gender"),
                    "Mouse hover on Gender filter");
            baseMethodWeb.Click(pantaloonsPage.PantaloonsSearchFilterOptionsElement("Gender"));
            baseMethodWeb.ClickByPresenceString(pantaloonsPage.PantaloonsSearchedSubFilterOptionsElement("Boys"));
            takeScreenshot(webDriver, "Web_04_FilterBoys");

            // -------- Mobile Step 6 --------
            mobileDriver.navigate().refresh(); // Example: continue mobile steps
            takeScreenshot(mobileDriver, "Mobile_06_AfterRefresh");

            // -------- Mobile Step 7 --------
            System.out.println("Final mobile page title: " + mobileDriver.getTitle());
            takeScreenshot(mobileDriver, "Mobile_07_PageTitle");

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            takeScreenshot(webDriver, "99_Exception_Web");
            takeScreenshot(mobileDriver, "99_Exception_Mobile");
        } finally {
            if (webDriver != null) webDriver.quit();
            if (mobileDriver != null) mobileDriver.quit();
        }
    }

    public static void takeScreenshot(WebDriver driver, String fileName) {
        if (driver == null) return;
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\Selenium Grid\\Screenshots\\" + fileName + ".png");
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }
}
