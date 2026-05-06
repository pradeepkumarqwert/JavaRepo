package com.parallelrun;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class _01_Web_Script1 {

    @Test(invocationCount = 1)
    public void run() throws MalformedURLException {

        // Set ChromeDriver path if needed
        // System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        String device_farm_hub_url = "https://devicefarm.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=EIPDY6DjKJ3-e_kzgjU2Tk2oU6r2iKHQW0WfG5WykPRGXc01su4EJ8xDeXQtgxB_KYFgglRGNI0QPVvKgd3hI-SxS0IWg_EBuJoxd6mHBSGwMQBb3xybY5Lyn1bLv632sqGFlDOZiCvYs1r4dnLaQXQiLLaserMHq8CSOVR15qJ_EtPkAV5Ry_m1jti0r3YN34nz0AF0euNI_fY4h9xaa0v6lt8pmL3aQ_XWXBBcyDPCR5-U-Fu1jf09lesZyfziiJ9crZcaQf50Tp-x4JXodoytr52vAFA36Qyg9bQYLXCcoPUNeIkHaVlZvjNL2dqY&licenseId=LIC2026587&projectName=31032026_Testing/";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("devicefarm:networkLogEnable", false);
        browserOptions.setCapability("fireflink:deviceType", "public");
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("146");
        WebDriver driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
        driver.manage().window().setSize(new Dimension(1024, 768));


        try {
            // 1. Navigate to test website
            driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
            driver.manage().window().maximize();

            // 2. Total execution time = 30 Seconds
            long endTime = System.currentTimeMillis() + (30 * 1000);

            // 3. Continuous clicking loop
            while (System.currentTimeMillis() < endTime) {
                try {
                    // Re-locate element every time (avoids stale issues)
                    WebElement addButton = driver.findElement(
                            By.xpath("//button[text()='Add Element']")
                    );

                    // Click action
                    addButton.click();
                    System.out.println("Clicked at: " + System.currentTimeMillis());

                    // Wait for 2 seconds
                    Thread.sleep(2000);

                } catch (Exception e) {
                    System.out.println("Retrying click...");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4. Close browser after execution
            driver.quit();
        }
    }
}