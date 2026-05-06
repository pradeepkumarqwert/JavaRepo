package com.scripts.resource;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;

public class RoughScript2 {
@Test
    public void run() {
        AndroidDriver driver = null;

        try {
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=71HsbGkWHHq1x81k37LbPyqeZ53wOhpe-MDVHzWv_y2_p2z2reJBd6CyDdzML8Xl-SmNw_NJyykp8LzfHDbRmFXGLQCA4pmZXwiC4iPepm24aEv0inOYPSI0BRjw9sD6VVkCHj0kIh6BWw3zkL9EzJtV8IK9o6gMknNeSQ6UwXMDpkoJFBDupAtHDBLjDJH3PjhMm2u610yK3wdt3iDyxUUno2m_7CGaLx1HOEP-VKdAaXOd5ufc1f7WH3ptsC1iTMEOjuZmdve0jIK42vi4NOo7lqICkcrXtokA2QlAmag7jLCsQiWzKTwAK0HDy2w&licenseId=LIC4139&projectName=25032026_Sanity/";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", "Google TV");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "16");
            caps.setCapability("appium:app", "OG_Notes_TVAPP.apk");
            caps.setCapability("appium:deviceType", "public");
            caps.setCapability("appium:isVirtual", true);
            driver = new AndroidDriver(new URL(device_farm_hub_url), caps);

            // Call all actions
            pressKey(driver, AndroidKey.DPAD_UP, "DPAD_UP");
            pressKey(driver, AndroidKey.DPAD_DOWN, "DPAD_DOWN");
            pressKey(driver, AndroidKey.DPAD_LEFT, "DPAD_LEFT");
            pressKey(driver, AndroidKey.DPAD_RIGHT, "DPAD_RIGHT");
            pressKey(driver, AndroidKey.DPAD_CENTER, "DPAD_CENTER");

            pressKey(driver, AndroidKey.BACK, "BACK");
            pressKey(driver, AndroidKey.HOME, "HOME");
            pressKey(driver, AndroidKey.MENU, "MENU");
            pressKey(driver, AndroidKey.ENTER, "ENTER");
            pressKey(driver, AndroidKey.ESCAPE, "ESCAPE");

            pressKey(driver, AndroidKey.VOLUME_UP, "VOLUME_UP");
            pressKey(driver, AndroidKey.VOLUME_DOWN, "VOLUME_DOWN");
            pressKey(driver, AndroidKey.VOLUME_MUTE, "VOLUME_MUTE");

            pressKey(driver, AndroidKey.MEDIA_PLAY_PAUSE, "PLAY_PAUSE");
            pressKey(driver, AndroidKey.MEDIA_PLAY, "PLAY");
            pressKey(driver, AndroidKey.MEDIA_PAUSE, "PAUSE");
            pressKey(driver, AndroidKey.MEDIA_NEXT, "NEXT");
            pressKey(driver, AndroidKey.MEDIA_PREVIOUS, "PREVIOUS");
            pressKey(driver, AndroidKey.MEDIA_STOP, "STOP");
            pressKey(driver, AndroidKey.MEDIA_FAST_FORWARD, "FAST_FORWARD");
            pressKey(driver, AndroidKey.MEDIA_REWIND, "REWIND");

            pressKey(driver, AndroidKey.DEL, "DELETE");
            pressKey(driver, AndroidKey.SPACE, "SPACE");
            pressKey(driver, AndroidKey.SEARCH, "SEARCH");

            // Some TV-specific keys may not be supported on all devices
            pressKey(driver, AndroidKey.TV_POWER, "TV_POWER");
            pressKey(driver, AndroidKey.TV_INPUT, "TV_INPUT");

        } catch (Exception e) {
            System.out.println("Driver initialization failed: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    // Reusable method with exception handling
    public static void pressKey(AndroidDriver driver, AndroidKey key, String actionName) {
        try {
            driver.pressKey(new KeyEvent(key));
            System.out.println("SUCCESS: " + actionName);
            Thread.sleep(1000); // small wait for visibility
        } catch (Exception e) {
            System.out.println("FAILED: " + actionName + " -> " + e.getMessage());
        }
    }
}