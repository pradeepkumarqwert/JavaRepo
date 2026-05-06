package com.scripts.resource;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ScriptTwo_TestClass extends ScriptOne_BAClass {
    @Test
    public void run1(){
        driver.get("https://www.jiomart.com");
    }

    @Test
    public void run2(){
        driver.get("https://www.amazon.com");
    }
}
