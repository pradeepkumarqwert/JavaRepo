package com.scripts.resource;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Parallel_Check2 
{
	WebDriver driver;
	@BeforeMethod
	public void initialized() throws MalformedURLException
	{
		String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=736d95c1-64e3-46ba-8f86-cf4086a93045&licenseId=LIC3943&projectName=Sanity/";
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("125");
		driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
		driver.manage().window().setSize(new Dimension(1024, 768));

	}
	
	@Test
	public void steps1()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
		driver.navigate().to("https://www.jiomart.com");
	
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

}
