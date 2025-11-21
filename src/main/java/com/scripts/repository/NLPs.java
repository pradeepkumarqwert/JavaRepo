package com.scripts.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;
@Data
public class NLPs 
{
	public NLPs(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[text()='Open Browser']")
	private WebElement NLPOpenBrowser;
	
	@FindBy(xpath = "//div[@id=\"ff-nlp-option-0\"]//div[text()='Wait : Wait for seconds']")
	private WebElement WebHardWait;
	
	@FindBy(xpath = "//input[@id=\"add_variable\"]")
	private WebElement HardWaitInputTextField;
	
	@FindBy(xpath = "//div[text()='Close Browser']")
	private WebElement NLPCloseBrowser;
}
