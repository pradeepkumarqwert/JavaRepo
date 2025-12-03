	package com.scripts.resource;
	
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.Platform;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.remote.RemoteWebDriver;
	
	import java.io.File;
	import java.io.IOException;
    import java.net.MalformedURLException;
    import java.net.URL;
	import java.nio.file.Files;
	import java.nio.file.StandardCopyOption;
	
	public class GroundedScript {
	
	    public static void main(String[] args) throws InterruptedException, MalformedURLException {
	
	        WebDriver driver = null;
	

	            // --------------------------
                String device_farm_hub_url = "https://fireflinkclouddev.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=219f1975-be3b-489a-9813-8b75ec37a53c&licenseId=LIC4745&projectName=TestTedt/";
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("134");
                driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
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
