	package com.automation.P0andP1;


    import org.openqa.selenium.*;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.edge.EdgeOptions;
    import org.openqa.selenium.firefox.FirefoxOptions;
    import org.openqa.selenium.remote.RemoteWebDriver;
    import org.openqa.selenium.safari.SafariOptions;
    import org.testng.annotations.Test;

    import java.io.File;
    import java.io.IOException;
    import java.net.URL;
    import java.nio.file.Files;
    import java.nio.file.StandardCopyOption;

    public class _00_GroundedScript {

        //4 parallel run
        @Test(invocationCount = 3, threadPoolSize = 3)
        public static void run() {

            WebDriver driver = null;

            try {

                // --------------------------
                // 1. Set Hub URL + Capabilities
                // --------------------------
    //            String device_farm_hub_url = "http://103.182.210.84:4444";
                String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=gpLL6cBoP80wWRUOKCFToC2MAR0d40JVsseGS2O6RxXHMW441fBUR7CaCCOIZLcjAgkd8zUlVGp5S0rM7dZfKFgsW6ibAvOnGsjPNdPQx4icUanJ_1blqqgSKpEcGN4Da3zKrVaeiJRmoqHi5nZBXx_XM-7P0_y5rO4Y7IL5Jxq6xYxg36QvorAd3qsq9fUs_8lwmldA9H0PpSIvR61vPBP0NnNY8Cpumk4KNZHKj2xSnerRwChNKJVpOmhdufZtj-uvavtFYPLzY6YEDtxzcRv2ebU0NXOXBg1u-NRVnliB6N49pjQ&licenseId=LIC3996&projectName=Testing_27012026/";
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setCapability("devicefarm:networkLogEnable", true);
                browserOptions.setCapability("fireflink:deviceType", "public");
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("136");
                driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
                driver.manage().window().setSize(new Dimension(1024, 768));

                // --------------------------
                // 2. Navigate to Google
                // --------------------------
                driver.get("https://www.google.com");
                takeScreenshot(driver, "01_Google_Page");
                driver.manage().window().maximize();

//                 --------------------------
//                 3. Navigate to Pantaloons Landing Page
//                 --------------------------
                driver.navigate().to("https://www.pantaloons.com");
                Thread.sleep(150000);
                takeScreenshot(driver, "02_Pantaloons_Landing");
                Thread.sleep(150000);

                Thread.sleep(150000);

                // --------------------------
                // 4. Validate Pantaloons Logo
                // --------------------------
                WebElement logo = driver.findElement(By.xpath("//div[@class='nav-header-container']//img[@class='svgIconImg' and @alt='logoIcon']"));
                if (logo.isDisplayed()) {
                    System.out.println("Pantaloons logo is displayed");
                }
                takeScreenshot(driver, "03_Logo_Visible");

//                // --------------------------
//                // 5. Search for Shirts
//                // --------------------------
                WebElement searchBar = driver.findElement(By.xpath("//div[@class='nav-links']//input[@placeholder='Search']"));
                searchBar.click();
                searchBar.sendKeys("Shirts");
                Thread.sleep(15000);
                takeScreenshot(driver, "04_Typed_Search");
                Thread.sleep(15000);

                searchBar.sendKeys(Keys.ENTER);
                takeScreenshot(driver, "05_Search_Results");

                Thread.sleep(150000);

//                // --------------------------
//                // 6. Apply Gender Filter → Boys
//                // --------------------------
                WebElement filterGender = driver.findElement(By.xpath("//p[text()='Gender']"));
                filterGender.click();
                takeScreenshot(driver, "06_Gender_Filter_Clicked");
                Thread.sleep(150000);

                WebElement boysCheckbox = driver.findElement(By.xpath("//p[text()='Boys']//ancestor::div[contains(@class,'PlpWeb_filter-values')]//input"));
                boysCheckbox.click();
                takeScreenshot(driver, "07_Boys_Filter_Clicked");

                Thread.sleep(150000);


                System.out.println("Test execution completed successfully.");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // --------------------------
                // 8. Quit Browser
                // --------------------------
                if (driver != null) {
                    driver.quit();
                     System.out.println("Driver quit");
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
