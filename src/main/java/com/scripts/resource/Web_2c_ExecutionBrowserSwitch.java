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

public class Web_2c_ExecutionBrowserSwitch 
{
	
                   	          
	public void SwitchToNewTab( WebDriver driver, Testdev testdevRepo, Actions act, AutomationRunSettings aRS, NLPs nLP,CreateAutoamtion_Script_Slider aSSlider) throws InterruptedException
	{		

		
		
		Thread.sleep(30000);
		
	    //SwitchtoSctiptTab in top nav bar
	    testdevRepo.getTopNavBarScriptTab().click();
	   
	    String attributeClass = testdevRepo.getTopNavBarScriptTab().getAttribute("class");
	    if(attributeClass.contains("ff-app-header-nav-bar-submenu-item--selected"))
	    {
	    	System.out.println("Script tab is selected after execution");
	    }
	    
		
		
	    Web_2d_deleteCreatedAutomationScript deleteclassAS = new Web_2d_deleteCreatedAutomationScript();
	    
	    deleteclassAS.DeleteAS(driver, act, testdevRepo, aRS, nLP, aSSlider);
	    System.out.println("Created Automation Sccript is deleted");
	    
	  
	    
	}

	
	

}
