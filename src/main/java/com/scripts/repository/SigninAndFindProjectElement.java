package com.scripts.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;
@Data
public class SigninAndFindProjectElement 
{
	public SigninAndFindProjectElement(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//span[text()='Cloud P0 and P1']")
	private WebElement ProjectName;
	
	@FindBy(xpath = "//span[text()='SIMPLIFY TESTING. AMPLIFY QUALITY.']")
	private WebElement verifySigninPage;
	
	@FindBy(xpath = "//input[@id=\"email\"]")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//input[@id=\"password\"]")
	private WebElement passwordTextField;
	
	@FindBy(css = ".ff-button.ff-button--small.ff-button--primary")
	private WebElement signInButton;
}
