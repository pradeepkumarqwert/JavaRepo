package com.scripts.resource;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class WatchScript1 {
    AndroidDriver driver;

    @Test
    public void run() throws MalformedURLException {
            String URL = "http://127.0.0.1:4723";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:automationName", "UiAutomator2");
            caps.setCapability("appium:deviceName", "sdk_gwear_x86_64");
            caps.setCapability("appium:udid", "emulator-5554");
            caps.setCapability("appium:platformVersion", "16");
            driver = new AndroidDriver(new URL(URL), caps);

            System.out.println("Driver Initialized");
            try {
                Dimension size = driver.manage().window().getSize();
                int watchHeight = size.getHeight();
                System.out.println("Watch height: "+ watchHeight);
                int watchWidth = size.getWidth();
                System.out.println("Watch Width: "+ watchWidth);



                //SwipeUp
                swipe(watchWidth/2, (int)(watchHeight*0.8), watchWidth/2,(int)(watchHeight*0.2));
                System.out.println("Swiped Up");
                Thread.sleep(2000);

                //SwipeDown
                swipe(watchWidth/2, (int)(watchHeight*0.2), watchWidth/2,(int)(watchHeight*0.8));
                System.out.println("Swiped Down");
                Thread.sleep(2000);



                //SwipeRight
                swipe((int)(watchWidth * 0.2), watchHeight / 2, (int)(watchWidth * 0.9), watchHeight / 2);
                System.out.println("Swiped Right");
                Thread.sleep(2000);



                //SwipeLift
                swipe((int)(watchWidth * 0.8), watchHeight / 2, (int)(watchWidth * 0.2), watchHeight / 2);
                System.out.println("Swiped Left");
                Thread.sleep(2000);

                //SwipeLift
                swipe((int)(watchWidth * 0.8), watchHeight / 2, (int)(watchWidth * 0.2), watchHeight / 2);
                System.out.println("Swiped Left");
                Thread.sleep(2000);


                driver.findElement(By.xpath("//android.widget.TextView[@text=\"New\"]")).click();


                swipe((int)(watchWidth * 0.2), watchHeight / 2, (int)(watchWidth * 0.2), (int) (watchHeight * 0.2));




            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                if(driver != null)
                {
                    driver.quit();
                    System.out.println("Driver quit successfully");
                }
            }
    }




    public void swipe(int startX, int startY, int endX, int endY) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }
}
