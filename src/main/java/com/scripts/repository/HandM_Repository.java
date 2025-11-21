package com.scripts.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;

@Data
public class HandM_Repository 
{
	WebDriver driver;
	public HandM_Repository(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.hm.goe:id/msSuggestedArea']")
	private WebElement SuggestedAreaInChooseLocationOptionHandMElement;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"NO THANKS\"]")
	private WebElement NoThanksButtonInNotificationPopupHandMElement;
	
	@FindBy(xpath = "//android.widget.Button[@text='ACCEPT ALL COOKIES']")
	private WebElement AcceptAllCookiesButtonHandMElement;
	
	
	@FindBy(xpath = "//android.view.View[@resource-id='com.hm.goe:id/menuTabBar']")
	private WebElement SearchProductIconInInterractablePanelHandMElement;
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Search bar, enter term\"]")
	private WebElement SearchProductTextFieldHandMElement;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.hm.goe:id/searchTextField\"]")
	private WebElement SearchProductTextFieldAfterClickOnItHandMElement;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.hm.goe:id/srpSearchTextLabel']")
	private WebElement VerifySearchedProductPageHandMElement;
	
	@FindBy(xpath = "//android.view.View[@resource-id=\"com.hm.goe:id/srpSortButton\"]")
	private WebElement SortTheSearchedproductButton;
	
	public WebElement getSortBy4Options(String SortingName)
	{
		return driver.findElement(By.xpath("//android.widget.TextView[@text='Highest Price']/ancestor::android.view.View[@resource-id='com.hm.goe:id/srpSortOption']/android.view.View"));
	}

}
