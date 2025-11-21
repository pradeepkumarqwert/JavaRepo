package com.scripts.resource;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.CreateCloudTemplate;
import com.scripts.repository.SigninAndFindProjectElement;
import com.scripts.repository.Testdev;


public class Web_3_CreateTemplate 
{
WebDriver driver;
	@BeforeMethod
	public void initilizeBrowser() throws MalformedURLException {
		driver = new ChromeDriver();


	}
	
	
	
	@Test
	public void Mainscript() throws InterruptedException 
	{

		BaseMethodsCloud baseMethod = new BaseMethodsCloud(driver);
		BaseObjectsCloud objectCreate = new BaseObjectsCloud(driver);
		Testdev testDevRepo = objectCreate.getTestDevRepo();
		SigninAndFindProjectElement SaPE = objectCreate.getSaPE();
		CreateCloudTemplate createCloudTemplate = objectCreate.getCreateCloudTemplate();
		
		
		
		driver.get("https://www.google.com/");
		driver.navigate().to("https://app.v3.fireflink.com/");
		baseMethod.MaximizeBrowser(driver,"Browser is maximized");
		Thread.sleep(50000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		String Actual = baseMethod.GetText(SaPE.getVerifySigninPage(),"Text fetched from sign-in page to validate");

		baseMethod.assertVerifyByActualAndExpectedValue(Actual, "SIMPLIFY TESTING. AMPLIFY", "Text is fetched from the sign-in page matched with expected text");

		baseMethod.Click(SaPE.getEmailTextField());
		baseMethod.TypeText(SaPE.getEmailTextField(), "pavan.n@yopmail.com");

		baseMethod.Click(SaPE.getPasswordTextField());
		baseMethod.TypeText(SaPE.getPasswordTextField(), "Password@123");

		baseMethod.Click(SaPE.getSignInButton());

		baseMethod.PrintValue("Successfully sign in");

		baseMethod.MouseHoverOnElement(SaPE.getProjectName(),"Mouse hovered on the already created project name in the project menu");
		baseMethod.Click(SaPE.getProjectName());

		String attributeClass = testDevRepo.getTopNavBarScriptTab().getAttribute("class");

		if (attributeClass.contains("ff-app-header-nav-bar-submenu-item--selected")) {
			baseMethod.PrintValue("Script tab is selected by default");
		}
		
		//Started to create template
		baseMethod.Click(createCloudTemplate.getMoreIconInTopNavBarElement());
		baseMethod.HardWait(2000,"Hard wait applied");
		baseMethod.Click(createCloudTemplate.getConfigurationIndividualLevelButtonInmoreIconInTopNavBarElement());
		baseMethod.HardWait(1000,"Hard wait applied");
		baseMethod.Click(createCloudTemplate.getTemplateActionIconInConfigurationSectionElement());
		baseMethod.HardWait(1000,"Hard wait applied");
		baseMethod.Click(createCloudTemplate.getPlusTemplateButtonInTopRightCornerElement());
		baseMethod.HardWait(1000,"Hard wait applied");
		String randomStringName = UUID.randomUUID().toString().substring(0, 5);
		baseMethod.ElementIsDisplay(createCloudTemplate.getVerifyingCreateTemplateSliderIsDisplayElement());
		baseMethod.Click(createCloudTemplate.getTemplateNameTextFieldInCreateTemplateSlider());
		baseMethod.HardWait(1000,"Hard wait applied");
		baseMethod.TypeText(createCloudTemplate.getTemplateNameTextFieldInCreateTemplateSlider(), randomStringName);
		baseMethod.MouseHoverOnElement(createCloudTemplate.getPlusFieldButtonInCreateteTemplateSliderElement(),"Mouse hovered on the +field button on the create template slider");
		baseMethod.HardWait(2000,"Hard wait applied");
		baseMethod.Click(createCloudTemplate.getPlusFieldButtonInCreateteTemplateSliderElement());
		baseMethod.HardWait(2000,"Hard wait applied");
		baseMethod.ElementIsDisplay(createCloudTemplate.getVerifyingAddFieldSliderIsDisplayElement());
		baseMethod.HardWait(2000,"Hard wait applied");
		baseMethod.Click(createCloudTemplate.getSelectCustomFieldDropdownInAddFieldSlider());
		baseMethod.HardWait(2000,"Hard wait applied");
		baseMethod.Click(createCloudTemplate.getRadioButtonOptionInSelectCustomTextfieldDropdownElement());
		baseMethod.HardWait(2000,"Hard wait applied");
		baseMethod.Click(createCloudTemplate.getTextfield1InRadioButtonOptionFromDropdownElement());
		baseMethod.TypeText(createCloudTemplate.getTextfield1InRadioButtonOptionFromDropdownElement(), "Cloud1");
		baseMethod.HardWait(2000,"Hard wait applied");
		baseMethod.Click(createCloudTemplate.getTextfield2InRadioButtonOptionFromDropdownElement());
		baseMethod.TypeText(createCloudTemplate.getTextfield2InRadioButtonOptionFromDropdownElement(), "Testing");
		baseMethod.HardWait(2000,"Hard wait applied");
		baseMethod.Click(createCloudTemplate.getTextfield3InRadioButtonOptionFromDropdownElement());
		baseMethod.TypeText(createCloudTemplate.getTextfield3InRadioButtonOptionFromDropdownElement(), "By Cloud Team");
		baseMethod.HardWait(5000,"Hard wait applied");
		if(!baseMethod.RadioButtonIsSeleted(createCloudTemplate.getMandatoryOptionAsYESElement()))
		{
			baseMethod.Click(createCloudTemplate.getMandatoryOptionAsYESElement());
			baseMethod.HardWait(1000,"Hard wait applied");
		}
		if(!baseMethod.RadioButtonIsSeleted(createCloudTemplate.getAllowEditInExecutionOptionAsYESElement()))
		{
			baseMethod.Click(createCloudTemplate.getAllowEditInExecutionOptionAsYESElement());
			baseMethod.HardWait(1000,"Hard wait applied");
		}
		baseMethod.Click(createCloudTemplate.getConfirmAddButtonInAddFieldSliderElement());
		baseMethod.HardWait(1000,"Hard wait applied");
		baseMethod.Click(createCloudTemplate.getEditPriorityDropdownButtonInCreateTemplateSliderElement());
		baseMethod.HardWait(1000,"Hard wait applied");
		
		
		
		baseMethod.ElementIsDisplay(createCloudTemplate.getEditPrioritySliderTextFieldOption1Element());
		baseMethod.Click(createCloudTemplate.getEditPrioritySliderTextFieldOption1Element());
		createCloudTemplate.getEditPrioritySliderTextFieldOption1Element().sendKeys(Keys.chord(Keys.SHIFT,"-"));
		baseMethod.HardWait(1000,"Hard wait applied");
		baseMethod.TypeText(createCloudTemplate.getEditPrioritySliderTextFieldOption1Element(), "P0");
		baseMethod.HardWait(1000,"Hard wait applied");
	
		baseMethod.ElementIsDisplay(createCloudTemplate.getEditPrioritySliderTextFieldOption2Element());
		baseMethod.Click(createCloudTemplate.getEditPrioritySliderTextFieldOption2Element());
		createCloudTemplate.getEditPrioritySliderTextFieldOption2Element().sendKeys(Keys.chord(Keys.SHIFT,"-"));
		baseMethod.HardWait(1000,"Hard wait applied");
		baseMethod.TypeText(createCloudTemplate.getEditPrioritySliderTextFieldOption2Element(), "P1");
		baseMethod.HardWait(1000,"Hard wait applied");
		

		baseMethod.ElementIsDisplay(createCloudTemplate.getEditPrioritySliderTextFieldOption3Element());
		baseMethod.Click(createCloudTemplate.getEditPrioritySliderTextFieldOption3Element());
		createCloudTemplate.getEditPrioritySliderTextFieldOption3Element().sendKeys(Keys.chord(Keys.SHIFT,"-"));
		baseMethod.HardWait(1000,"Hard wait applied");
		baseMethod.TypeText(createCloudTemplate.getEditPrioritySliderTextFieldOption3Element(), "P2");
		baseMethod.HardWait(1000,"Hard wait applied");
		
		baseMethod.ElementIsDisplay(createCloudTemplate.getEditPrioritySliderTextFieldOption4Element());
		baseMethod.Click(createCloudTemplate.getEditPrioritySliderTextFieldOption4Element());
		createCloudTemplate.getEditPrioritySliderTextFieldOption4Element().sendKeys(Keys.chord(Keys.SHIFT,"-"));
		baseMethod.HardWait(1000,"Hard wait applied");
		baseMethod.TypeText(createCloudTemplate.getEditPrioritySliderTextFieldOption4Element(), "P3");
		baseMethod.HardWait(1000,"Hard wait applied");
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createCloudTemplate.getEditPrioritySliderTextFieldOption5Element());
		baseMethod.MouseHoverOnElement(createCloudTemplate.getEditPrioritySliderTextFieldOption5Element(),"Mouse hovered on the 5th priority option in the edit priority slider");
		baseMethod.ElementIsDisplay(createCloudTemplate.getEditPrioritySliderTextFieldOption5Element());
		baseMethod.Click(createCloudTemplate.getEditPrioritySliderTextFieldOption5Element());
		createCloudTemplate.getEditPrioritySliderTextFieldOption5Element().sendKeys(Keys.chord(Keys.SHIFT,"-"));
		baseMethod.HardWait(1000,"Hard wait applied");
		baseMethod.TypeText(createCloudTemplate.getEditPrioritySliderTextFieldOption5Element(), "P4");
		

		baseMethod.Click(createCloudTemplate.getConfirmbuttonEditedOptionInPriotityEditSlider());
		baseMethod.HardWait(10000,"Hard wait applied");
		if(createCloudTemplate.getConfrimButtonCreateTemplateSlider().isEnabled())
		{
			baseMethod.Click(createCloudTemplate.getConfrimButtonCreateTemplateSlider());
			baseMethod.HardWait(1000,"Hard wait applied");
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createCloudTemplate.MoreIconInMouseHoveredOnCreatedTemplate(randomStringName));

		baseMethod.MouseHoverOnElement(createCloudTemplate.MouseHoverOnCreatedTemplate(randomStringName),"mouse hovered on the created template card in the template page");
		baseMethod.HardWait(2000,"Hard wait applied");
		baseMethod.Click(createCloudTemplate.MoreIconInMouseHoveredOnCreatedTemplate(randomStringName));
		baseMethod.HardWait(1000,"Hard wait applied");
		baseMethod.Click(createCloudTemplate.getDeleteButtonInCreatedTemplate());
		baseMethod.HardWait(1000,"Hard wait applied");
		baseMethod.Click(createCloudTemplate.getConfirmDeleteButtonInCreatedTemplate());
		baseMethod.HardWait(1000,"Hard wait applied");
		
		
	}
	
	
	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}

}
