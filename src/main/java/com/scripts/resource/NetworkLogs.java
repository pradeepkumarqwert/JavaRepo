package com.scripts.resource;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;

import java.util.Optional;

public class NetworkLogs {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);

        // Start DevTools
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Enable network logs
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Capture request logs
        devTools.addListener(Network.requestWillBeSent(), request -> {
            System.out.println("REQUEST → " + request.getRequest().getUrl());
        });

        // Capture response logs
        devTools.addListener(Network.responseReceived(), response -> {
            System.out.println("RESPONSE → " + response.getResponse().getUrl() +
                    " | Status: " + response.getResponse().getStatus());
        });

        driver.get("https://example.com");

        driver.quit();
    }
}
