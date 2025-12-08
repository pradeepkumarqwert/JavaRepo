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
    import org.openqa.selenium.safari.SafariOptions;

    import java.io.File;
	import java.io.IOException;
    import java.net.MalformedURLException;
    import java.net.URL;
	import java.nio.file.Files;
	import java.nio.file.StandardCopyOption;
	
	public class GroundedScript {
	
	    public static void main(String[] args) throws InterruptedException, MalformedURLException {
	
	        WebDriver driver = null;


            String device_farm_hub_url = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=a318d063-eab5-488a-bd38-dbac1c2a8758&licenseId=LIC1026562&projectName=Web+Bulk+Execution/";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("140");
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
