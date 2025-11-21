
package com.scripts.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;

@Data
public class AutomationRunSettings
{
	public AutomationRunSettings(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"_steps_landing__icons_block_1pk30_19\"]//div[contains(@class,\"ff-light-theme\")]//span[contains(@class,\"_all_run_setting_icons_hover_color_1pk30_63\")]")
    private WebElement AutomationRunSettings;
    
    @FindBy(xpath = "//div[@class=\"_machine_option_select_dropdown_1b76w_87\"]//input[@id=\"select-input-element\"]")
    private WebElement ARSSelectMachine;
	
    @FindBy(xpath = "//div[text()='FFE-Pradeep-Kum...']")
    private WebElement PradeepMachineCard;
    
    @FindBy(xpath = "//span[text()='Run']")
    private WebElement ARSRunScript;
	
	
}
