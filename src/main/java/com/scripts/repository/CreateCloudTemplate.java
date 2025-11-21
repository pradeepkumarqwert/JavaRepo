package com.scripts.repository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;

@Data
public class CreateCloudTemplate 
{
	WebDriver driver;
	public CreateCloudTemplate(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath = "//div[@class='more-menu']")
	private WebElement moreIconInTopNavBarElement;
	@FindBy(xpath = "//label[text()='Configuration']//ancestor::div[contains(@class,'ff-option-card--default')]")
	private WebElement ConfigurationIndividualLevelButtonInmoreIconInTopNavBarElement;
	@FindBy(xpath = "//div[text()='Templates']")
	private WebElement TemplateActionIconInConfigurationSectionElement;
	@FindBy(xpath = "//div[@class=\"ff-col-6 _template_config_toolbar_right_lcth0_21\"]//div[text()='Manual Template']")
	private WebElement PlusTemplateButtonInTopRightCornerElement;
	@FindBy(xpath = "//div[contains(@class,'ff-drawer--open')]//span[text()='Create Manual Test Case Template']")
	private WebElement VerifyingCreateTemplateSliderIsDisplayElement;
	@FindBy(xpath = "//input[@id=\"templateName\"]")
	private WebElement TemplateNameTextFieldInCreateTemplateSlider;
	@FindBy(xpath = "//div[text()='Field']//ancestor::button[@class='ff-plus-icon']")
	private WebElement plusFieldButtonInCreateteTemplateSliderElement;
	@FindBy(xpath = "//div[contains(@class,'ff-drawer--open')]//div[text()='Add Field']")
	private WebElement VerifyingAddFieldSliderIsDisplayElement;
	@FindBy(xpath = "//div[contains(@class,'ff-drawer--small')]//div[@class='ff-select-arrows-wrapper']")
	private WebElement SelectCustomFieldDropdownInAddFieldSlider;
	@FindBy(xpath = "//div[text()='Radio Button']/ancestor::div[contains(@class,'ff-select-dropdown-option ')]")
	private WebElement RadioButtonOptionInSelectCustomTextfieldDropdownElement;
	@FindBy(xpath = "//input[@id='customFieldLabel']")
	private WebElement Textfield1InRadioButtonOptionFromDropdownElement;
	@FindBy(xpath = "//input[@id='options.0']")
	private WebElement Textfield2InRadioButtonOptionFromDropdownElement;
	@FindBy(xpath = "//input[@id='options.1']")
	private WebElement Textfield3InRadioButtonOptionFromDropdownElement;
	@FindBy(xpath = "//span[text()='Mandatory']//following-sibling::div//span[text()='Yes']/ancestor::div[@class='ff-radio-wrapper']")
	private WebElement MandatoryOptionAsYESElement;
	@FindBy(xpath = "//span[text()='Allow Edit in Execution']//following-sibling::div//span[text()='Yes']/ancestor::div[@class='ff-radio-wrapper']")
	private WebElement AllowEditInExecutionOptionAsYESElement;
	@FindBy(xpath = "//span[text()='Add']/ancestor::button")
	private WebElement ConfirmAddButtonInAddFieldSliderElement;
	@FindBy(xpath = "//span[text()='Priority']/preceding-sibling::div[@class='ff-select-arrows-wrapper']")
	private WebElement PriorityDropdownButtonInCreateTemplateSliderElement;
	@FindBy(xpath = "//span[text()='Priority']/preceding-sibling::div[@class='ff-select-arrows-wrapper']//ancestor::div[@class='_individual_field_container_ia0cq_22']//div//following-sibling::div/preceding-sibling::div//span[contains(@class,'cursor-pointer')]")
	private WebElement EditPriorityDropdownButtonInCreateTemplateSliderElement;
	@FindBy(xpath = "//input[@id='options.0']")
	private WebElement EditPrioritySliderTextFieldOption1Element;
	@FindBy(xpath = "//input[@id='options.1']")
	private WebElement EditPrioritySliderTextFieldOption2Element;
	@FindBy(xpath = "//input[@id='options.2']")
	private WebElement EditPrioritySliderTextFieldOption3Element;
	@FindBy(xpath = "//input[@id='options.3']")
	private WebElement EditPrioritySliderTextFieldOption4Element;
	@FindBy(xpath = "//input[@id='options.4']")
	private WebElement EditPrioritySliderTextFieldOption5Element;
	@FindBy(xpath = "//span[text()='Update']/ancestor::button")
	private WebElement ConfirmbuttonEditedOptionInPriotityEditSlider;
	@FindBy(xpath = "//span[text()='Create']/ancestor::button")
	private WebElement ConfrimButtonCreateTemplateSlider;
	public WebElement MouseHoverOnCreatedTemplate(String TemplateName) {
	    return driver.findElement(By.xpath("//span[text()='"+  TemplateName +"']//ancestor::td"));
	}
	public WebElement MoreIconInMouseHoveredOnCreatedTemplate(String TemplateName) {
	    return driver.findElement(By.xpath("//span[text()='"+  TemplateName +"']//ancestor::td//div[@class='ff-menu-option-container']"));
	}
	@FindBy(xpath = "//div[contains(@class,'ff-option-card ff-light-theme')]//label[text()='Delete']/ancestor::div[@class='ff-options align-left']")
	private WebElement DeleteButtonInCreatedTemplate;
	@FindBy(xpath = "//span[text()='Delete']/ancestor::button")
	private WebElement ConfirmDeleteButtonInCreatedTemplate;
	
	
}
