package com.scripts.resource;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TimeOutTest 
{
	@Test
	public void rootMethod() throws MalformedURLException
	{
		String seleniumHubUrl = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=a31168ce-bf67-4a7a-bfa1-997fca75f65a&licenseId=LIC1026534&projectName=infra/";
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("129");
		WebDriver driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
		driver.manage().window().setSize(new Dimension(1024, 768));

		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text' and @placeholder = 'Search']")).click();
		driver.quit();
		
	}
}
