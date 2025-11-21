package com.scripts.resource;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods4JavaScriptExecutorExecuteAsyncScript {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        System.out.println("Starting async JavaScript execution...");

        // Simple async callback after 3 seconds
        Long result1 = (Long) js.executeAsyncScript(
                "var callback = arguments[arguments.length - 1];" +
                "window.setTimeout(function(){callback(123);}, 3000);"
        );
        System.out.println("Async Script 1 completed with result: " + result1);

        // Simulate waiting for AJAX response
        Long result2 = (Long) js.executeAsyncScript(
                "var callback = arguments[arguments.length - 1];" +
                "var xhr = new XMLHttpRequest();" +
                "xhr.open('GET', 'https://jsonplaceholder.typicode.com/posts/1', true);" +
                "xhr.onreadystatechange = function() {" +
                "  if (xhr.readyState == 4) {" +
                "    console.log('AJAX completed');" +
                "    callback(xhr.status);" +
                "  }" +
                "};" +
                "xhr.send();"
        );
        System.out.println("AJAX call status code: " + result2);

        // Delay execution and scroll asynchronously
        js.executeAsyncScript(
                "var callback = arguments[arguments.length - 1];" +
                "window.scrollBy(0, 500);" +
                "window.setTimeout(callback, 2000);"
        );
        System.out.println("Scrolled down asynchronously");

        // Asynchronous DOM check
        String state = (String) js.executeAsyncScript(
                "var callback = arguments[arguments.length - 1];" +
                "window.setTimeout(function() {" +
                "  callback(document.readyState);" +
                "}, 2000);"
        );
        System.out.println("Async Document Ready State: " + state);

        // Measure async time taken
        Long duration = (Long) js.executeAsyncScript(
                "var callback = arguments[arguments.length - 1];" +
                "var start = Date.now();" +
                "setTimeout(function(){" +
                "  var end = Date.now();" +
                "  callback(end - start);" +
                "}, 2500);"
        );
        System.out.println("Async operation duration: " + duration + " ms");

        driver.quit();
    }
}
