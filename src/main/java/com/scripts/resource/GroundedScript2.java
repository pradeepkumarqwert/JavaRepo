	package com.scripts.resource;


    import org.openqa.selenium.*;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.remote.RemoteWebDriver;

    import java.io.File;
    import java.io.IOException;
    import java.net.URL;
    import java.nio.file.Files;
    import java.nio.file.StandardCopyOption;

    public class GroundedScript2 {

        public static void main(String[] args) {

            WebDriver driver = null;

            try {

                // --------------------------
                // 1. Set Hub URL + Capabilities
                // --------------------------
                String seleniumHubUrl = "https://your-grid-url/wd/hub";

                ChromeOptions options = new ChromeOptions();
                options.setPlatformName("Windows 11");
                options.setBrowserVersion("133");

                driver = new RemoteWebDriver(new URL(seleniumHubUrl), options);
                driver.manage().window().setSize(new Dimension(1024, 768));

                // --------------------------
                // 2. Navigate to Google
                // --------------------------
                driver.get("https://www.google.com");
                takeScreenshot(driver, "01_Google_Page");

                // --------------------------
                // 3. Navigate to Pantaloons Landing Page
                // --------------------------
                driver.navigate().to("https://www.pantaloons.com");
                takeScreenshot(driver, "02_Pantaloons_Landing");

                Thread.sleep(2000);

                // --------------------------
                // 4. Validate Pantaloons Logo
                // --------------------------
                WebElement logo = driver.findElement(By.xpath("//div[@class='nav-header-container']//img[@class='svgIconImg' and @alt='logoIcon']"));
                if (logo.isDisplayed()) {
                    System.out.println("Pantaloons logo is displayed");
                }
                takeScreenshot(driver, "03_Logo_Visible");

                // --------------------------
                // 5. Search for Shirts
                // --------------------------
                WebElement searchBar = driver.findElement(By.xpath("//div[@class='nav-links']//input[@placeholder='Search']"));
                searchBar.click();
                searchBar.sendKeys("Shirts");
                takeScreenshot(driver, "04_Typed_Search");

                Thread.sleep(2000);
                searchBar.sendKeys(Keys.ENTER);
                takeScreenshot(driver, "05_Search_Results");

                Thread.sleep(4000);

                // --------------------------
                // 6. Apply Gender Filter → Boys
                // --------------------------
                WebElement filterGender = driver.findElement(By.xpath("//p[text()='Gender']"));
                filterGender.click();
                takeScreenshot(driver, "06_Gender_Filter_Clicked");

                WebElement boysCheckbox = driver.findElement(By.xpath("//p[text()='Boys']//ancestor::div[contains(@class,'PlpWeb_filter-values')]//input"));
                boysCheckbox.click();
                takeScreenshot(driver, "07_Boys_Filter_Clicked");

                Thread.sleep(3000);

                // --------------------------
                // 7. Clear / Select filters
                // --------------------------
                WebElement clearBtn = driver.findElement(By.xpath("//button[@id=':r6:']"));
                clearBtn.click();
                takeScreenshot(driver, "08_Filter_Clear");

                System.out.println("Test execution completed successfully.");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // --------------------------
                // 8. Quit Browser
                // --------------------------
                if (driver != null) {
                    driver.quit();
                }
            }

        }

        // --------------------------
        // Save Screenshot Method
        // --------------------------
        public static void takeScreenshot(WebDriver driver, String fileName) {
            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest = new File("C:\\SimpleRunScreenshots\\" + fileName + ".png");
                dest.getParentFile().mkdirs();
                Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Screenshot saved: " + dest.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Screenshot failed: " + e.getMessage());
            }
        }
    }
