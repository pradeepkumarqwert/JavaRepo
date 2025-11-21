package com.scripts.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;
@Data
public class TestDevelopmentScriptTabPage 
{
	WebDriver driver;
	public TestDevelopmentScriptTabPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//ProjectMenu-Project name
	//------------------------------------------------------------------------------------------
	public WebElement getProjectName(String ProjectName)
	{
		return driver.findElement(By.xpath("//tr[@class=\"ff-table-data-row\"]//div[contains(@class,'_column_data_')]//span[text()='"+ ProjectName +"']/ancestor::div[contains(@class,'_value_')]"));
	}
	
	
	
	//TestDev Verifivation Elements
	//TopNav bar
	//TestDev Script tab Header
	//TestDev Body element
		//TestDev Tree Structure elements
		//TestDev Action icon elements
	//TestDev Toaster message element
	//TestDev Tooltip elements
	
	
}

