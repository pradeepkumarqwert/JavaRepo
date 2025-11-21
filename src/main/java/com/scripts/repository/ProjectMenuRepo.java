package com.scripts.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;

@Data
public class ProjectMenuRepo {
	WebDriver driver;

	public ProjectMenuRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[text()='All Projects']")
	private WebElement VerifyProjectMenuLandingPageElementInProjectMenu;
	
	@FindBy(xpath = "//div[text()='Project']/ancestor::button[@class=\"ff-plus-icon\"]")
	private WebElement plusProjectButtonAtTopRightCornerElementInProjectMenu;
	
	@FindBy(xpath = "//div[text()='Create Project']")
	private WebElement VerifyingCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//input[@id='name' and contains(@class,'ff-input--focused')]")
	private WebElement nameTextFieldWhileItIsFocusedInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameTextFieldWhileItIsNotFocusedInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//input[@id='select-input-element']/ancestor::div[@class='ff-select']")
	private WebElement typeDropdownWhileItIsNotFocusedInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//input[@id='select-input-element']/ancestor::div[@class='ff-select ff-select__focus']")
	private WebElement typeDropdownWhileItIsFocusedInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//input[@id='select-input-element']/ancestor::div[@class='ff-select ff-select__error']")
	private WebElement typeDropdownWhileItIsNotFocusedWithErrorMessageInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//div[text()='Select project type']/preceding-sibling::div[contains(@class,'ff-select__error__focused')]//input")
	private WebElement typeDropdownWhileItIsFocusedWithErrorMessageInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//span[text()='Name is required']")
	private WebElement nameIsRequiredInNameTextFieldInlineValidationInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//textarea[@id='desc' and @placeholder='Type your description here']")
	private WebElement descriptionTextFieldInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//span[text()='Minimum 3 characters required']")
	private WebElement minimum3CharactersRequiredInNameTextFieldInlineValidationInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//span[text()='Maximum 25 characters allowed']")
	private WebElement maximum25CharactersAllowedRequiredInNameTextFieldInlineValidationInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//span[text()='Name should be alphanumeric']")
	private WebElement nameShouldBeAlphanumericRequiredInNameTextFieldInlineValidationInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//div[text()='Select project type']")
	private WebElement selectProjectTypeRequiredInSelectProjectDropdownInlineValidationInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//span[text()='200' and text() = '/']")
	private WebElement verifyMaxOF200CharacterNumberInDescriptionTextAreaInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//div[text()='Web']/ancestor::div[contains(@class,'ff-select-dropdown-option-wrapper')]/ancestor::div[contains(@class,'ff-select-dropdown-option ff-light-theme')]")
	private WebElement webOptionInSelectProjectTypeDropDownInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//span[contains(@class,'ff-select-arrows')]/ancestor::div[@class='ff-select-arrows-wrapper']")
	private WebElement arrowButtonforSelectTypeDropdownInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//div[text()='No Result Found']")
	private WebElement noResultFoundValidationForInValidProjectTypeNameInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//div[@class='ff-close-icon']//span[@class=\"ff-icon-container\"]")
	private WebElement closeButtonInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//div[text()='Close']")
	private WebElement closeToolTipInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//span[text()='Cancel']/ancestor::button")
	private WebElement cancelButtonInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//span[text()='Create']/ancestor::button")
	private WebElement createButtonInCreateProjectSliderElementInProjectMenu;
	
	@FindBy(xpath = "//thead[@class='ff-table-header ff-table-fixed-header']/tr//div[text()='Name']")
	private WebElement nameHeaderInElementInProjectMenu;
	
	@FindBy(xpath = "//thead[@class='ff-table-header ff-table-fixed-header']/tr//div[text()='Type']")
	private WebElement typeHeaderInElementInProjectMenu;
	
	@FindBy(xpath = "//thead[@class='ff-table-header ff-table-fixed-header']/tr//div[text()='Status']")
	private WebElement statusHeaderInElementInProjectMenu;
	
	@FindBy(xpath = "//thead[@class='ff-table-header ff-table-fixed-header']/tr//div[text()='Modified By']")
	private WebElement modifiedByHeaderInElementInProjectMenu;
	
	@FindBy(xpath = "//thead[@class='ff-table-header ff-table-fixed-header']/tr//div[text()='Modified On']")
	private WebElement modifiedOnHeaderInElementInProjectMenu;
//------------------------------------------------------------------------------------------------------------------------------------
	public WebElement getAllProjectNameInTopNavBar(String projectName)
	{
		return driver.findElement(By.xpath("//div[text()='"+ projectName +"']/ancestor::div[@class='ff-all-project-container']"));
	}
	
	@FindBy(xpath = "//div[@class='ff-projects-dropdown']//div[@class=\"option-card\"]//div[text()='All Projects']")
	private WebElement AllProjectOptionInAllProjectNameInTopNavBar;
//-----------------------------------------------------------------------------------------------------------------------------------
//Elements after creation
	
	public WebElement getCreateProjectRowElementInProjectMenu(String projectName)
	{
		return driver.findElement(By.xpath("//span[text()='"+ projectName +"']/ancestor::div[contains(@class,'ff-table-data-container')]"));
	}
	
	
	
	public WebElement getCreatedProjectStatusColumnElementInProjectMenu(String projectName)
	{
		return driver.findElement(By.xpath("(//span[text()='"+ projectName +"']/ancestor::td/following-sibling::td/div/div)[1]"));
	}
	
	public WebElement getCreatedProjectTypeColumnElementInProjectMenu(String projectName)
	{
		return driver.findElement(By.xpath("(//span[text()='"+ projectName +"']/ancestor::td/following-sibling::td/div)[1]"));
	}
	
	public WebElement getCreatedProjectNameColumnElementInProjectMenu(String projectName)
	{
		return driver.findElement(By.xpath("(//span[text()='"+ projectName +"']/ancestor::td)"));
	}
	
	
	
	
	
	public WebElement getCreatedProjectEditActionIconElement(String projectName)
	{
		return driver.findElement(By.xpath("(//span[text()='"+ projectName +"']/ancestor::div[contains(@class,'ff-table-data-container')]//div[@class=\"icon-container\"]/div)[1]"));
	}
	
	public WebElement getCreatedProjectMoreActionIconElement(String projectName)
	{
		return driver.findElement(By.xpath("(//span[text()='"+ projectName +"']/ancestor::div[contains(@class,'ff-table-data-container')]//div[@class=\"icon-container\"]/div)[2]"));
	}
	
	
	@FindBy(xpath = "//div[text()='Edit Project']")
	private WebElement VerifyEditProjectSliderElement;
	
	@FindBy(xpath = "//div[contains(@class,'ff-option-card')]/div/div/label[text()='Delete']/ancestor::div[contains(@class,'ff-disable-option')]")
	private WebElement CreatedProjectDisabledDeleteOptionInMoreActionIconElement;
	
	@FindBy(xpath = "//div[contains(@class,'ff-option-card')]/div/div/label[text()='Details']")
	private WebElement CreatedProjectDetailsOptionInMoreActionIconElement;
	
	@FindBy(xpath = "//div[contains(@class,'ff-option-card')]/div/div/label[text()='Delete']")
	private WebElement CreatedProjectDeleteOptionInMoreActionIconElement;
	
	@FindBy(xpath = "//div[contains(@class,'ff-option-card')]/div/div/label[text()='Archive Project']")
	private WebElement CreatedProjectArchivedProjectOptionInMoreActionIconElement;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement ProjectNameTextFieldInEditProjectSliderElement;
	
	
	@FindBy(xpath = "//input[@id='select-input-element']/ancestor::div[contains(@class,'ff-select__disabled')]")
	private WebElement ProjectTypeDisabledDropdownInEditProjectSliderElement;
	
	@FindBy(xpath = "//div[@class='ff--switch-container']")
	private WebElement ToggleButtonInEditProjectSliderElement;
	
	@FindBy(xpath = "//button[@type='button']")
	private WebElement CancelButtonInEditProjectSliderElement;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement UpdateButtonInEditProjectSliderElement;
	
	@FindBy(xpath = "//span[text()='The project status will change from ' and text()='Open' and text()=' to ' and text()='Closed' and text()='.']")
	private WebElement VerifyTextInChangeStatusOfProjectFromOpenToClose;
	
	@FindBy(xpath = "//div[@class=\"ff-modal-container\"]//div[contains(@class,'warning_actions')]/button/span[text()='Cancel']")
	private WebElement CancelButtonInChangeStatusOfProjectFromOpenToClose;
	
	@FindBy(xpath = "//div[@class=\"ff-modal-container\"]//div[contains(@class,'warning_actions')]/button/span[text()='Continue']")
	private WebElement ContiuneButtonInChangeStatusOfProjectFromOpenToClose;
	
	//Element To Check Weather The Project Is In View Access After Close The Project Element In Individual Proejct Level Of Created Project
	
	public WebElement getElementToCheckWeatherTheProjectIsInViewAccessAfterCloseTheProjectElementInIndividualProejctLevelOfCreatedProject(String projectName)
	{
		return driver.findElement(By.xpath("//div[text()='TESTING']/ancestor::div[contains(@class,'_home_')]//div//following-sibling::div[contains(@class,'_home_body_')]//div//following-sibling::main//div[contains(@class,'_all_run_setting_container')]"));
	}
	
	
	//unarchive option in more icon pop up
	@FindBy(xpath = "//div[@class='ff-option-card ff-light-theme']//label[text()='Unarchive Project']/ancestor::div[contains(@class,'ff-options')]")
	private WebElement unArchiveOptionInMoreActionIconPopUp;
	
	//cureser in disable state for archived project
	public WebElement getDisableCurserForArchivedProjectElement(String projectName)
	{
		return driver.findElement(By.xpath("//span[text()='"+ projectName +"']/ancestor::div[contains(@class,'_isArchiveValue_')]/following-sibling::div[@class='icon-container']//span//span"));
	}
	
	//Delete button in delete project pop up
	@FindBy(xpath = "//span[text()='Your data will be lost. Are your sure you want to delete ']/ancestor::div[contains(@class,'_warning_')]/following-sibling::div//button//span[text()='Delete']")
	private WebElement deleteButtonInDeleteProjectPopUpElement;
	
	//project details slider
	@FindBy(xpath = "//div[text()='Project Details']/ancestor::div[contains(@class,'ff-drawer--open')]")
	private WebElement verifyProjectDetailsSlider;
	
	
	//toaster messages---------------------------------------------
	@FindBy(xpath = "//span[text()='TESTING project has been Archived successfully']/ancestor::div[@class=\"ff-toaster-container ff-toaster--success\"]")
	private WebElement archivedSuccessfullyToasterMessage;
	
	public WebElement getDeleteProjectConformationToasterMessage(String projectName)
	{
		return driver.findElement(By.xpath("//div[contains(@class,'ff-toaster-container')]//span[text()='"+ projectName +" project deleted successfully']"));
	}
	
	
}
