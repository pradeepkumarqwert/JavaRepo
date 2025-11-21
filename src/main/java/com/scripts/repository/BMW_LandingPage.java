package com.scripts.repository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;

@Data
public class BMW_LandingPage {
	
	WebDriver driver;
	
	public BMW_LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public WebElement gettopNavBarElement(String topNavBarOptions) {
	    return driver.findElement(By.xpath("//div[@id='navbarCollapse']//span[text()='" + topNavBarOptions + "']"));
	}
	
	//done
	public WebElement getNewCarsListElement(String car) {
	    return driver.findElement(By.xpath("//li[contains(@class,'navcatlevel1')]//span[text()='" + car + "']"));
	}
	//li[contains(@class,'navcatlevel1')]//following-sibling::ul[contains(@class,'shop-categ1')]//span[text()='The BMW M340i']
	public WebElement getNewCarsSubListElement() {
	    return driver.findElement(By.xpath("//li[contains(@class,'navcatlevel1')]//ul[contains(@class,\"shop-categ1\")]//span"));
	}
	
	
}
