package com.scripts.resource;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Open_closing {

	public static void main(String[] args) throws InterruptedException, MalformedURLException
	{
		String seleniumHubUrl = "https://fireflinkclouddev.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=4f6f3903-4b38-43e3-9c29-38f5b66d8cb8&licenseId=LIC4630&projectName=dont_delete_plz/";
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("132");
		WebDriver driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
		driver.manage().window().setSize(new Dimension(1024, 768));




		driver.manage().window().maximize();
		driver.get("https://google.com/");
		driver.navigate().to("https://www.pantaloons.com/");
		Thread.sleep(1000);
		Thread.sleep(2000);
		driver.quit();
		
	}
}
