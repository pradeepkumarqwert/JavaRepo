package com.scripts.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;

@Data
public class Testdev
{
	public Testdev(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	
	}
	
	

	@FindBy(xpath = "//div[@class=\"ff-app-header-submenu-container\"]//div[text()='Scripts']")
	private WebElement TopNavBarScriptTab;
	
	@FindBy(xpath = "//button[@class=\"ff-plus-icon\"]//div[text()='Module']")
	private WebElement createModuleButton;
	
	@FindBy(xpath ="//input[@id='name']")
	private WebElement createModuleName;

	@FindBy(xpath = "//span[text()='Cloud P0 and P1']/../..//label[@class='ff-radio ']/input//following-sibling::div")
	private WebElement cmRootModuleRadioBtn;

	@FindBy(css = ".ff-button.ff-button--small.ff-button--primary")
	private WebElement confirmCreateModule;



	@FindBy(xpath = "//span[text()=\"FireCloud1_Testing\"]")
	private WebElement CreatedNewModule;

	@FindBy(xpath = "//span[text()='FireCloud1_Testing']//ancestor::td//div[@class='ff-menu-option-container']")
	private WebElement quickAccessIcon;

	@FindBy(xpath = "//div[@class='ff-options align-left']//label[text()='Delete']")
	private WebElement cmMoreDelete;

	@FindBy(xpath = "//button[@type=\"button\"]//span[text()=\"Delete\"]")
	private WebElement CmConfirmDelete;

	@FindBy(xpath = "//span[text()=\"FireCloud1_Testing\"]//ancestor::td//div[@class=\"table-tree-row-action\"]//div[@id=\"AddModule\"]")
	private WebElement quickAccessPlus;


	@FindBy(xpath = "//div[@id=\"portal-123\"]//button[contains(@class, \"ff-arrow-button--top\")]")
	private WebElement quickAccessRightPlus;

	@FindBy(xpath = "//div[contains(@class,\"align-left\")]//label[text()='Automation Script']")
	private WebElement quickAccessRightPlusAutomationScript;

	@FindBy(xpath="//button[@class='ff-plus-icon']//div[text()='Automation']")
	private WebElement PlusAutomationButton;
	
	@FindBy(xpath = "//span[text()='Script_001-Cloud testing']")
	private WebElement CreateAScriptName;
	
	@FindBy(xpath = "(//span[text()='Script_001-Cloud testing']//ancestor::div[@class=\"tree-title-container\"]//following-sibling::div[@class=\"table-tree-row-action\"]//div[@class=\"ff-menu-option-container\"]//span[@class=\"ff-icon-container\"])[last()]")
	private WebElement MoreIconInCreateAutomationScript;
	
	@FindBy(xpath = "//label[text()='Delete']//ancestor::div[@class=\"ff-options align-left\"]")
	private WebElement DeleteBtnInMoreIconInCreatedAutomationScript;
	
	@FindBy(xpath = "//button//span[text()='Delete']")
	private WebElement ConfirmDeleteAutomationScript;
}
