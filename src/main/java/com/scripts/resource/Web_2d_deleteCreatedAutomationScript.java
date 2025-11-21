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

import com.scripts.repository.AutomationRunSettings;
import com.scripts.repository.CreateAutoamtion_Script_Slider;
import com.scripts.repository.NLPs;
import com.scripts.repository.Testdev;

public class Web_2d_deleteCreatedAutomationScript 
{
	public void DeleteAS(WebDriver driver, Actions act,Testdev testdevRepo, AutomationRunSettings ARS,NLPs NLP,CreateAutoamtion_Script_Slider ASSlider)
	{
		act.moveToElement(testdevRepo.getCreateAScriptName()).perform();
		System.out.println("Mouse hoverd on created automation script");
		testdevRepo.getMoreIconInCreateAutomationScript().click();
		testdevRepo.getDeleteBtnInMoreIconInCreatedAutomationScript().click();
		testdevRepo.getConfirmDeleteAutomationScript().click();
		

	}

}
