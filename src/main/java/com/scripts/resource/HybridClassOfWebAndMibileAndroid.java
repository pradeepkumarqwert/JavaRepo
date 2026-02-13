package com.scripts.resource;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;

@Listeners(com.report.listener.ExtentReportManager.class)
public class HybridClassOfWebAndMibileAndroid 
{
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;



	@Test(invocationCount = 1)
	public void web1() throws InterruptedException, MalformedURLException
	{
        try {
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=uHnChthLrrZx7i3tjv6Atsi0rbbNFJI1L6EV9v-v4hJq4gij5X2bKAq75AfDVw1O5ZYv5VVRvt1kfAhFWREi3LqauNaCff0DDPYZe-LanCzWZDt2JrxKD7sjNJalFQOYru3OxKPddfBrPW1OUlqVSIi43sL2gAeyaExiJ7sGgEoY164NYts6axdWnu06sp2aWP3EquBR69Z-pYOQXlFOyLNmd4uKmcsOdpo-t8Dd6AR_gtWMcg3PLopnsAvteZos-m8dAfR3FNBDd6NaJL6JdFD8RUCAGhZJG5vi-fy41NKg-2jpeDbp&licenseId=LIC4014&projectName=ProjectSanity_17-12/";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("133");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));


            //Fetch system info
            Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
            String browserName = caps.getBrowserName();
            String browserVersion = caps.getBrowserVersion();
            Platform platform = caps.getPlatformName();

            System.out.println("Browser: " + browserName);
            System.out.println("Version: " + browserVersion);
            System.out.println("Platform: " + platform);

            this.baseMethod = new BaseMethodsCloud(driver);
            this.baseObject = new BaseObjectsCloud(driver);
            this.baseData = new BaseDataCloud();

            pantaloonsLandingPage = new PantaloonsLandingPage(driver);
            // --------------------------
            // 2. Navigate to Google
            // --------------------------
            driver.get("https://www.google.com");
            takeScreenshot(driver, "01_Google_Page");
            driver.manage().window().maximize();

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


        }catch (Exception e){
            System.out.println("Web Exception Triggered");
        }finally {
            driver.quit();
        }
	}
	
	
	
	@Test(invocationCount = 1)
    public void mobile1() throws InterruptedException {
    	
        try {
        	//String seleniumHubUrl = "http://103.182.210.85:4444";

            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=uHnChthLrrZx7i3tjv6Atsi0rbbNFJI1L6EV9v-v4hJq4gij5X2bKAq75AfDVw1O5ZYv5VVRvt1kfAhFWREi3LqauNaCff0DDPYZe-LanCzWZDt2JrxKD7sjNJalFQOYru3OxKPddfBrPW1OUlqVSIi43sL2gAeyaExiJ7sGgEoY164NYts6axdWnu06sp2aWP3EquBR69Z-pYOQXlFOyLNmd4uKmcsOdpo-t8Dd6AR_gtWMcg3PLopnsAvteZos-m8dAfR3FNBDd6NaJL6JdFD8RUCAGhZJG5vi-fy41NKg-2jpeDbp&licenseId=LIC4014&projectName=ProjectSanity_17-12/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Samsung Galaxy A12");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "12");
            caps.setCapability("appium:browserName", "Chrome");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), caps);




            //caps.setCapability("appium:chromedriverAutodownload", true);

            driver.get("https://www.pantaloons.com/");
            System.out.println("Opened Pantaloons in mobile browser.");
            takeScreenshot(driver, "01_HomePage");

            Thread.sleep(3000);

            driver.findElement(By.cssSelector("div.mobilesearchbox")).click();
            System.out.println("Clicked.");
            takeScreenshot(driver, "02_After_Click_Search_Icon");

            Thread.sleep(5000);

            driver.findElement(By.xpath("//input[@placeholder='Search for products,brands and more...']")).sendKeys("Shirt");
            System.out.println("Entered.");
            takeScreenshot(driver, "03_After_Entering_Search");

            Thread.sleep(2000);

            driver.findElement(By.xpath("(//mark[text()='Shirt'])[1]")).click();
            System.out.println("Searched for item");
            takeScreenshot(driver, "04_After_Search_Result_Click");

            Thread.sleep(4000);
            driver.findElement(By.cssSelector("span.cartSpriteIcon")).click();
            System.out.println("Opened Cart");
            takeScreenshot(driver, "05_Cart_Page");

            System.out.println("Page Title: " + driver.getTitle());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            takeScreenshot(driver, "99_Exception_Occurred");
        } finally {
            if (driver != null) {
                driver.quit();
            }
            System.out.println("Driver closed.");
        }
    }

    @Test(invocationCount = 1)
    public void web2() throws InterruptedException, MalformedURLException
    {
        try {
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=uHnChthLrrZx7i3tjv6Atsi0rbbNFJI1L6EV9v-v4hJq4gij5X2bKAq75AfDVw1O5ZYv5VVRvt1kfAhFWREi3LqauNaCff0DDPYZe-LanCzWZDt2JrxKD7sjNJalFQOYru3OxKPddfBrPW1OUlqVSIi43sL2gAeyaExiJ7sGgEoY164NYts6axdWnu06sp2aWP3EquBR69Z-pYOQXlFOyLNmd4uKmcsOdpo-t8Dd6AR_gtWMcg3PLopnsAvteZos-m8dAfR3FNBDd6NaJL6JdFD8RUCAGhZJG5vi-fy41NKg-2jpeDbp&licenseId=LIC4014&projectName=ProjectSanity_17-12/";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("133");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));


            //Fetch system info
            Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
            String browserName = caps.getBrowserName();
            String browserVersion = caps.getBrowserVersion();
            Platform platform = caps.getPlatformName();

            System.out.println("Browser: " + browserName);
            System.out.println("Version: " + browserVersion);
            System.out.println("Platform: " + platform);

            this.baseMethod = new BaseMethodsCloud(driver);
            this.baseObject = new BaseObjectsCloud(driver);
            this.baseData = new BaseDataCloud();

            pantaloonsLandingPage = new PantaloonsLandingPage(driver);
            // --------------------------
            // 2. Navigate to Google
            // --------------------------
            driver.get("https://www.google.com");
            takeScreenshot(driver, "01_Google_Page");
            driver.manage().window().maximize();

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


        }catch (Exception e){
            System.out.println("Web Exception Triggered");
        }finally {
            driver.quit();
        }
    }



    @Test(invocationCount = 1)
    public void mobile2() throws InterruptedException {

        try {
            //String seleniumHubUrl = "http://103.182.210.85:4444";

            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=uHnChthLrrZx7i3tjv6Atsi0rbbNFJI1L6EV9v-v4hJq4gij5X2bKAq75AfDVw1O5ZYv5VVRvt1kfAhFWREi3LqauNaCff0DDPYZe-LanCzWZDt2JrxKD7sjNJalFQOYru3OxKPddfBrPW1OUlqVSIi43sL2gAeyaExiJ7sGgEoY164NYts6axdWnu06sp2aWP3EquBR69Z-pYOQXlFOyLNmd4uKmcsOdpo-t8Dd6AR_gtWMcg3PLopnsAvteZos-m8dAfR3FNBDd6NaJL6JdFD8RUCAGhZJG5vi-fy41NKg-2jpeDbp&licenseId=LIC4014&projectName=ProjectSanity_17-12/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Samsung Galaxy A12");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "12");
            caps.setCapability("appium:browserName", "Chrome");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), caps);




            //caps.setCapability("appium:chromedriverAutodownload", true);

            driver.get("https://www.pantaloons.com/");
            System.out.println("Opened Pantaloons in mobile browser.");
            takeScreenshot(driver, "01_HomePage");

            Thread.sleep(3000);

            driver.findElement(By.cssSelector("div.mobilesearchbox")).click();
            System.out.println("Clicked.");
            takeScreenshot(driver, "02_After_Click_Search_Icon");

            Thread.sleep(5000);

            driver.findElement(By.xpath("//input[@placeholder='Search for products,brands and more...']")).sendKeys("Shirt");
            System.out.println("Entered.");
            takeScreenshot(driver, "03_After_Entering_Search");

            Thread.sleep(2000);

            driver.findElement(By.xpath("(//mark[text()='Shirt'])[1]")).click();
            System.out.println("Searched for item");
            takeScreenshot(driver, "04_After_Search_Result_Click");

            Thread.sleep(4000);
            driver.findElement(By.cssSelector("span.cartSpriteIcon")).click();
            System.out.println("Opened Cart");
            takeScreenshot(driver, "05_Cart_Page");

            System.out.println("Page Title: " + driver.getTitle());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            takeScreenshot(driver, "99_Exception_Occurred");
        } finally {
            if (driver != null) {
                driver.quit();
            }
            System.out.println("Driver closed.");
        }
    }

    @Test(invocationCount = 1)
    public void web3() throws InterruptedException, MalformedURLException
    {
        try {
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=uHnChthLrrZx7i3tjv6Atsi0rbbNFJI1L6EV9v-v4hJq4gij5X2bKAq75AfDVw1O5ZYv5VVRvt1kfAhFWREi3LqauNaCff0DDPYZe-LanCzWZDt2JrxKD7sjNJalFQOYru3OxKPddfBrPW1OUlqVSIi43sL2gAeyaExiJ7sGgEoY164NYts6axdWnu06sp2aWP3EquBR69Z-pYOQXlFOyLNmd4uKmcsOdpo-t8Dd6AR_gtWMcg3PLopnsAvteZos-m8dAfR3FNBDd6NaJL6JdFD8RUCAGhZJG5vi-fy41NKg-2jpeDbp&licenseId=LIC4014&projectName=ProjectSanity_17-12/";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("133");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));


            //Fetch system info
            Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
            String browserName = caps.getBrowserName();
            String browserVersion = caps.getBrowserVersion();
            Platform platform = caps.getPlatformName();

            System.out.println("Browser: " + browserName);
            System.out.println("Version: " + browserVersion);
            System.out.println("Platform: " + platform);

            this.baseMethod = new BaseMethodsCloud(driver);
            this.baseObject = new BaseObjectsCloud(driver);
            this.baseData = new BaseDataCloud();

            pantaloonsLandingPage = new PantaloonsLandingPage(driver);
            // --------------------------
            // 2. Navigate to Google
            // --------------------------
            driver.get("https://www.google.com");
            takeScreenshot(driver, "01_Google_Page");
            driver.manage().window().maximize();

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


        }catch (Exception e){
            System.out.println("Web Exception Triggered");
        }finally {
            driver.quit();
        }
    }



    @Test(invocationCount = 1)
    public void mobile3() throws InterruptedException {

        try {
            //String seleniumHubUrl = "http://103.182.210.85:4444";

            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=uHnChthLrrZx7i3tjv6Atsi0rbbNFJI1L6EV9v-v4hJq4gij5X2bKAq75AfDVw1O5ZYv5VVRvt1kfAhFWREi3LqauNaCff0DDPYZe-LanCzWZDt2JrxKD7sjNJalFQOYru3OxKPddfBrPW1OUlqVSIi43sL2gAeyaExiJ7sGgEoY164NYts6axdWnu06sp2aWP3EquBR69Z-pYOQXlFOyLNmd4uKmcsOdpo-t8Dd6AR_gtWMcg3PLopnsAvteZos-m8dAfR3FNBDd6NaJL6JdFD8RUCAGhZJG5vi-fy41NKg-2jpeDbp&licenseId=LIC4014&projectName=ProjectSanity_17-12/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Samsung Galaxy A12");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "12");
            caps.setCapability("appium:browserName", "Chrome");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), caps);




            //caps.setCapability("appium:chromedriverAutodownload", true);

            driver.get("https://www.pantaloons.com/");
            System.out.println("Opened Pantaloons in mobile browser.");
            takeScreenshot(driver, "01_HomePage");

            Thread.sleep(3000);

            driver.findElement(By.cssSelector("div.mobilesearchbox")).click();
            System.out.println("Clicked.");
            takeScreenshot(driver, "02_After_Click_Search_Icon");

            Thread.sleep(5000);

            driver.findElement(By.xpath("//input[@placeholder='Search for products,brands and more...']")).sendKeys("Shirt");
            System.out.println("Entered.");
            takeScreenshot(driver, "03_After_Entering_Search");

            Thread.sleep(2000);

            driver.findElement(By.xpath("(//mark[text()='Shirt'])[1]")).click();
            System.out.println("Searched for item");
            takeScreenshot(driver, "04_After_Search_Result_Click");

            Thread.sleep(4000);
            driver.findElement(By.cssSelector("span.cartSpriteIcon")).click();
            System.out.println("Opened Cart");
            takeScreenshot(driver, "05_Cart_Page");

            System.out.println("Page Title: " + driver.getTitle());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            takeScreenshot(driver, "99_Exception_Occurred");
        } finally {
            if (driver != null) {
                driver.quit();
            }
            System.out.println("Driver closed.");
        }
    }

    @Test(invocationCount = 1)
    public void web4() throws InterruptedException, MalformedURLException
    {
        try {
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=uHnChthLrrZx7i3tjv6Atsi0rbbNFJI1L6EV9v-v4hJq4gij5X2bKAq75AfDVw1O5ZYv5VVRvt1kfAhFWREi3LqauNaCff0DDPYZe-LanCzWZDt2JrxKD7sjNJalFQOYru3OxKPddfBrPW1OUlqVSIi43sL2gAeyaExiJ7sGgEoY164NYts6axdWnu06sp2aWP3EquBR69Z-pYOQXlFOyLNmd4uKmcsOdpo-t8Dd6AR_gtWMcg3PLopnsAvteZos-m8dAfR3FNBDd6NaJL6JdFD8RUCAGhZJG5vi-fy41NKg-2jpeDbp&licenseId=LIC4014&projectName=ProjectSanity_17-12/";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("133");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));


            //Fetch system info
            Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
            String browserName = caps.getBrowserName();
            String browserVersion = caps.getBrowserVersion();
            Platform platform = caps.getPlatformName();

            System.out.println("Browser: " + browserName);
            System.out.println("Version: " + browserVersion);
            System.out.println("Platform: " + platform);

            this.baseMethod = new BaseMethodsCloud(driver);
            this.baseObject = new BaseObjectsCloud(driver);
            this.baseData = new BaseDataCloud();

            pantaloonsLandingPage = new PantaloonsLandingPage(driver);
            // --------------------------
            // 2. Navigate to Google
            // --------------------------
            driver.get("https://www.google.com");
            takeScreenshot(driver, "01_Google_Page");
            driver.manage().window().maximize();

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


        }catch (Exception e){
            System.out.println("Web Exception Triggered");
        }finally {
            driver.quit();
        }
    }



    @Test(invocationCount = 1)
    public void mobile4() throws InterruptedException {

        try {
            //String seleniumHubUrl = "http://103.182.210.85:4444";

            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=uHnChthLrrZx7i3tjv6Atsi0rbbNFJI1L6EV9v-v4hJq4gij5X2bKAq75AfDVw1O5ZYv5VVRvt1kfAhFWREi3LqauNaCff0DDPYZe-LanCzWZDt2JrxKD7sjNJalFQOYru3OxKPddfBrPW1OUlqVSIi43sL2gAeyaExiJ7sGgEoY164NYts6axdWnu06sp2aWP3EquBR69Z-pYOQXlFOyLNmd4uKmcsOdpo-t8Dd6AR_gtWMcg3PLopnsAvteZos-m8dAfR3FNBDd6NaJL6JdFD8RUCAGhZJG5vi-fy41NKg-2jpeDbp&licenseId=LIC4014&projectName=ProjectSanity_17-12/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Samsung Galaxy A12");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "12");
            caps.setCapability("appium:browserName", "Chrome");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), caps);




            //caps.setCapability("appium:chromedriverAutodownload", true);

            driver.get("https://www.pantaloons.com/");
            System.out.println("Opened Pantaloons in mobile browser.");
            takeScreenshot(driver, "01_HomePage");

            Thread.sleep(3000);

            driver.findElement(By.cssSelector("div.mobilesearchbox")).click();
            System.out.println("Clicked.");
            takeScreenshot(driver, "02_After_Click_Search_Icon");

            Thread.sleep(5000);

            driver.findElement(By.xpath("//input[@placeholder='Search for products,brands and more...']")).sendKeys("Shirt");
            System.out.println("Entered.");
            takeScreenshot(driver, "03_After_Entering_Search");

            Thread.sleep(2000);

            driver.findElement(By.xpath("(//mark[text()='Shirt'])[1]")).click();
            System.out.println("Searched for item");
            takeScreenshot(driver, "04_After_Search_Result_Click");

            Thread.sleep(4000);
            driver.findElement(By.cssSelector("span.cartSpriteIcon")).click();
            System.out.println("Opened Cart");
            takeScreenshot(driver, "05_Cart_Page");

            System.out.println("Page Title: " + driver.getTitle());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            takeScreenshot(driver, "99_Exception_Occurred");
        } finally {
            if (driver != null) {
                driver.quit();
            }
            System.out.println("Driver closed.");
        }
    }




    public static void takeScreenshot(WebDriver driver, String fileName) 
    {
        if (driver == null) {
			return;
		}
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\Selenium Grid\\Screenshots\\" + fileName + ".png");
            dest.getParentFile().mkdirs(); // Ensure folder exists
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }
	
}
