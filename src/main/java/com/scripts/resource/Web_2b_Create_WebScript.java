package com.scripts.resource;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.AutomationRunSettings;
import com.scripts.repository.CreateAutoamtion_Script_Slider;
import com.scripts.repository.NLPs;
import com.scripts.repository.Testdev;

public class Web_2b_Create_WebScript {

	public void createWebScript(WebDriver driver, Testdev testdevRepo, Actions act, BaseMethodsCloud baseMethod,
			BaseObjectsCloud objectCreate) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		baseMethod.PrintValue("Creation of Automation script Started");

		CreateAutoamtion_Script_Slider ASSlider = objectCreate.getASSlider();
		NLPs NLP = objectCreate.getNLP();
		AutomationRunSettings ARS = objectCreate.getARS();
		Web_2c_ExecutionBrowserSwitch newTab = objectCreate.getNewTab();

		
		baseMethod.Click(ASSlider.getPlusAutomationBtn());
		baseMethod.PrintValue("+Automation Button Clicked");
		Thread.sleep(2000);
		baseMethod.Click(ASSlider.getNameTextfieldCreateAutomationSlider());
		Thread.sleep(1000);
		baseMethod.TypeText(ASSlider.getNameTextfieldCreateAutomationSlider(), "Script_001-Cloud testing");
		Thread.sleep(1000);
		baseMethod.MouseHoverOnElement(ASSlider.getCreatedModuleNameInCreateAutomationScript(),"Mouse hovered on the created project name after the created project name radio button in create automation script slider");
		Thread.sleep(1000);
		baseMethod.Click(ASSlider.getCreatedModuleRadioBtnInCreateAutomationScript());
		Thread.sleep(1000);

		Boolean checkConfirmBtnEnable = ASSlider.getConfirmBtnInCreateAS().isEnabled();
		if (checkConfirmBtnEnable) {
			baseMethod.Click(ASSlider.getConfirmBtnInCreateAS());

		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'ff-light-theme')]/following-sibling::button[@class='ff-plus-icon']//div[text()='Step']")));
		wait.until(ExpectedConditions.visibilityOf(ASSlider.getAddAutomationStepsBtn()));
		baseMethod.Click(ASSlider.getAddAutomationStepsBtn());
		Thread.sleep(1000);
		baseMethod.Click(ASSlider.getSearchNLPsearchTextField());

		Thread.sleep(1000);
		baseMethod.TypeText(ASSlider.getSearchNLPsearchTextField(), "Open B");

		Thread.sleep(1000);
		//baseMethod.Click(NLP.getNLPOpenBrowser());
		baseMethod.ClickByPresenceString("//div[text()='Open Browser']");

		Thread.sleep(1000);
		baseMethod.Click(ASSlider.getAddSelectedNLP());

		Thread.sleep(1000);
		baseMethod.Click(ASSlider.getAddAutomationStepsBtn());

		Thread.sleep(1000);
		baseMethod.TypeText(ASSlider.getSearchNLPsearchTextField(), "wait");

		Thread.sleep(1000);
		baseMethod.Click(NLP.getWebHardWait());

		Thread.sleep(1000);
		baseMethod.TypeText(NLP.getHardWaitInputTextField(), "10");

		Thread.sleep(1000);
//		ASSlider.getAddSelectedNLP();
//		Thread.sleep(2000);
		baseMethod.Click(ASSlider.getAddSelectedNLP());

		Thread.sleep(2000);
		baseMethod.Click(ASSlider.getAddAutomationStepsBtn());

		Thread.sleep(1000);
		baseMethod.TypeText(ASSlider.getSearchNLPsearchTextField(), "Close B");

		Thread.sleep(1000);
		baseMethod.Click(NLP.getNLPCloseBrowser());

		Thread.sleep(1000);
		baseMethod.Click(ASSlider.getAddSelectedNLP());

		Thread.sleep(1000);
		baseMethod.Click(ASSlider.getSelectAllStepCheckBox());

		Thread.sleep(1000);
		baseMethod.Click(ASSlider.getAutomationRunSettings());

		Thread.sleep(1000);
		baseMethod.Click(ARS.getARSSelectMachine());

		Thread.sleep(1000);
		
		ARS.getARSSelectMachine().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(1000);
		
		baseMethod.presskeys(ARS.getARSSelectMachine(), Keys.BACK_SPACE, "Click on backSpace to clear machine name on Automation run setting");
		
		Thread.sleep(1000);
		baseMethod.TypeText(ARS.getARSSelectMachine(), "Pradeep");

		Thread.sleep(1000);
		baseMethod.Click(ARS.getPradeepMachineCard());

		Thread.sleep(1000);
		baseMethod.Click(ARS.getARSRunScript());

		Thread.sleep(1000);

		newTab.SwitchToNewTab(driver, testdevRepo, act, ARS, NLP, ASSlider);

		baseMethod.PrintValue("Return and now Going to delete Created Module");
		
	}

}
