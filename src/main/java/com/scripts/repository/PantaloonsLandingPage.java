package com.scripts.repository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;

@Data
public class PantaloonsLandingPage {
	
	WebDriver driver;
	
	public PantaloonsLandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath = "//div[@class='nav-header-container']//img[@class='svgIconImg' and @alt='logoIcon']")
	private WebElement PantaloonsLogoElement;
	
	@FindBy(xpath = "//div[@class='nav-links']//input[@placeholder='Search']")
	private WebElement PantaloonsMainSearchBarElement;
	
	@FindBy(xpath = "//div[@class=older=\"Search\"]")
	private WebElement FalseElement;
	
	@FindBy(xpath = "//div[text()='Yellow Checked Formal Full Sleeves Shirt Collar Boys Regular Fit Shirts ']//ancestor::div[@role='button']")
	private WebElement PantaloonsProductShirt1;
	public WebElement PantaloonsSearchFilterOptionsElement(String FilterOptions)
	{
		return driver.findElement(By.xpath("//div[contains(@class,'MuiGrid-grid-lg-3 PlpWeb_filter-grid__AbSIK')]//div[contains(@class,'PlpWeb_filter-container__gkVa2')]//p[text()='"+ FilterOptions +"']"));
		
	}
	public String PantaloonsSearchedSubFilterOptionsElement(String SubFilterOptions)
	{
		return "//p[text()='"+  SubFilterOptions +"']//ancestor::div[contains(@class,'PlpWeb_filter-values')]//input";	
	}
	public String PantaloonsFilterClearAllandSelectAllElement(int Number)
	{
		return "//button[@id=':r"+ Number +":']";	
//		1 -S Brand
//		2 -C
//		3 -S Category
//		4 -C
//		5 -S Gender
//		6 -C
//		7 -S Size
//		8 -C
//		9 -S Discount
//		10 -C
//		11 -S Occasion
//		12 -C
//		13 -S Colour
//		14 -C
//		15 - Select only one category
//		16 -C
	}
	
	
}