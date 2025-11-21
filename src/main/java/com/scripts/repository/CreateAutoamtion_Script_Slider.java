package com.scripts.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;

@Data
public class CreateAutoamtion_Script_Slider
{
	public CreateAutoamtion_Script_Slider(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//div[text()='Automation']//ancestor::button[@class='ff-plus-icon']")
	private WebElement PlusAutomationBtn;
	
	@FindBy(xpath ="//input[@id=\"name\"]")
	private WebElement nameTextfieldCreateAutomationSlider;
	
	@FindBy(xpath ="//div[@class=\"ff-container-fluid\"]//span[contains(@class,'ff-text--semi-bold')]//span[text()='FireCloud1_Testing']")
	private WebElement createdModuleNameInCreateAutomationScript;
	
	
	@FindBy(xpath ="//span[text()=\"FireCloud1_Testing\"]//ancestor::span[@class=\"tree-table-td-content-text\"]/preceding-sibling::span[@class=\"tree-table-td-content-select\"]//input[@type=\"radio\"]//ancestor::div[@class=\"ff-radio-wrapper\"]")
	private WebElement createdModuleRadioBtnInCreateAutomationScript;
	
	@FindBy(xpath ="//button[@type=\"submit\"]")
	private WebElement ConfirmBtnInCreateAS;
	
	@FindBy(xpath ="//div[contains(@class,'ff-light-theme')]/following-sibling::button[@class='ff-plus-icon']//div[text()='Step']")
	private WebElement addAutomationStepsBtn;
	
	@FindBy(xpath = "//div[@class=\"ff-accordion-table-body\"]//input[@type=\"text\"]")
	private WebElement SearchNLPsearchTextField;
	
    @FindBy(xpath = "//span[text()='Add']")
    private WebElement AddSelectedNLP;
    
    @FindBy(xpath = "//div[@class=\"accordion-header\"]//span[@class=\"ff-checkbox-custom\"]")
    private WebElement SelectAllStepCheckBox;
    
    @FindBy(xpath = "//div[@class=\"_steps_landing__icons_block_1pk30_19\"]//div[contains(@class,\"ff-light-theme\")]//span[contains(@class,\"_all_run_setting_icons_hover_color_1pk30_63\")]")
    private WebElement AutomationRunSettings;
    
    @FindBy(xpath = "//div[@class=\"_machine_option_select_dropdown_1b76w_87\"]//input[@id=\"select-input-element\"]")
    private WebElement ARSSelectMachine;
	
    @FindBy(xpath = "//div[text()='FFE-Pradeep-Kum...']")
    private WebElement PradeepMachineCard;
    
    @FindBy(xpath = "//span[text()='Run']")
    private WebElement ARSRunScript;
	
	
}
