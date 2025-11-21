package com.scripts.resource;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class ANDROID_1_Hamleys {
  AppiumDriver driver=null;
  
  
   @SuppressWarnings("deprecation")
  public AppiumDriver initialiseDriver() throws MalformedURLException {
	   UiAutomator2Options options = new UiAutomator2Options();
       options.setDeviceName("SM_A135F");  // your real/emulator device
       options.setPlatformName("Android");
       options.setAutomationName("UiAutomator2");
       options.setAppPackage("com.androidsample.generalstore");
       options.setAppActivity("com.androidsample.generalstore.SplashActivity");
       options.setNoReset(false);
       options.setAutoGrantPermissions(true);

       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

      

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

          return driver;

      }
   
      @Test
      public void openApp () throws InterruptedException, MalformedURLException {
          
      
//      launchApp();
      driver = initialiseDriver();
      captureStep("App_Launched");

      driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"in.hamleys.www:id/et_search\"]")).click();
      captureStep("Clicked_SearchBox");

      driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"in.hamleys.www:id/et_search\"]")).sendKeys("Teddy Bear");
      driver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"in.hamleys.www:id/iv_search\"]")).click();
      captureStep("Searched_Teddy_Bear");

      driver.findElement(By.xpath("//android.widget.GridView[@resource-id=\"in.hamleys.www:id/rv_list\"]/android.widget.RelativeLayout[1]/androidx.appcompat.widget.LinearLayoutCompat[1]")).click();
      captureStep("Selected_Item");

      String selectedItem = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"in.hamleys.www:id/tv_name\"]")).getText();
      System.out.println("Selected item is: " + selectedItem);
      captureStep("Viewed_Item_Details");

      driver.findElement(By.xpath("//android.widget.RatingBar[@resource-id=\"in.hamleys.www:id/rBar\"]")).click();
      captureStep("Rated_Item");

      By pincodeField = By.xpath("//android.widget.EditText[@resource-id=\"in.hamleys.www:id/et_pincode\"]");
      driver.findElement(pincodeField).sendKeys("560010");
      captureStep("Entered_Pincode");

      driver.findElement(By.xpath("//android.widget.TextView[@text=\"Add to Cart\"]")).click();
      captureStep("Clicked_Add_To_Cart");

      driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"in.hamleys.www:id/fl_bag\"]/android.widget.ImageView")).click();
      captureStep("Opened_Cart");

      Thread.sleep(4000);
      driver.findElement(By.xpath("//android.widget.TextView[@text=\"Add Address\"]")).click();
      captureStep("Clicked_Add_Address");

      driver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"in.hamleys.www:id/iv_close\"]")).click();
      captureStep("Closed_Popup");

      driver.navigate().back();
      captureStep("Navigated_Back_Once");

      driver.navigate().back();
      captureStep("Navigated_Back_Twice");

      driver.findElement(By.xpath("//android.widget.TextView[@text=\"Filter\"]")).click();
      captureStep("Clicked_Filter");

      driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"in.hamleys.www:id/tv_title\" and @text=\"Price\"]")).click();
      captureStep("Selected_Price_Filter");

      driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"in.hamleys.www:id/cv_checkbox\" and @text=\"500-1000\"]")).click();
      driver.findElement(By.xpath("//android.widget.TextView[@text=\"Apply\"]")).click();
      captureStep("Applied_Price_Filter");
  }

      
        public void captureStep(String stepName) {
             String filePath = "screenshots/" + System.currentTimeMillis() + "_" + stepName.replaceAll("\\s+", "_") + ".png";
             takeScreenshot(driver, filePath);

         }
        public static void takeScreenshot(AppiumDriver driver, String filePath) {
             File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//           try {
//               File target = new File(filePath);
//               target.getParentFile().mkdirs();  // Create directories if not exist
//               FileUtils.copyFile(screenshot, target);
//               System.out.println("✅ Screenshot saved to: " + filePath);
//           } catch (IOException e) {
//               System.out.println("❌ Failed to save screenshot: " + e.getMessage());
//           }
        
     }

     
     @AfterClass(alwaysRun=true)
     public void tearDown() {
        if(driver!=null) {
           driver.quit();
        }
     }
     
        
     }
     