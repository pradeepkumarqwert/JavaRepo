package com.scripts.resource;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
import org.testng.asserts.SoftAssert;

import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.CreateCloudTemplate;
import com.scripts.repository.SigninAndFindProjectElement;
import com.scripts.repository.Testdev;


public class Web_2_TestDevScript {
	WebDriver driver;

	@BeforeMethod
	public void initilizeBrowser() throws MalformedURLException {
		String seleniumHubUrl = "https://fireflinkclouddev.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=4f6f3903-4b38-43e3-9c29-38f5b66d8cb8&licenseId=LIC4630&projectId=PJT1003/";
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("132");
		this.driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
		driver.manage().window().setSize(new Dimension(1024, 768));


	}

	@Test
	public void Mainscript() throws InterruptedException {

		BaseMethodsCloud baseMethod = new BaseMethodsCloud(driver);
		BaseObjectsCloud objectCreate = new BaseObjectsCloud(driver);

		Testdev testDevRepo = objectCreate.getTestDevRepo();

		Web_2b_Create_WebScript cSClass = objectCreate.getcSClass();

		SigninAndFindProjectElement SaPE = objectCreate.getSaPE();
		

		Actions act = objectCreate.getAct();

		driver.get("https://www.google.com/");
		driver.navigate().to("https://app.v3.fireflink.com/");
		baseMethod.MaximizeBrowser(driver,"Browser is maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		String Actual = baseMethod.GetText(SaPE.getVerifySigninPage(),"Text is fetched from the sign-in page to validate");
	
		baseMethod.assertVerifyByActualAndExpectedValue(Actual, "SIMPLIFY TESTING. AMPLIFY", "Text is fetched from the sign-in page matched with expected text");

		baseMethod.Click(SaPE.getEmailTextField());
		baseMethod.TypeText(SaPE.getEmailTextField(), "pavan.n@yopmail.com");

		baseMethod.Click(SaPE.getPasswordTextField());
		baseMethod.TypeText(SaPE.getPasswordTextField(), "Password@123");

		baseMethod.Click(SaPE.getSignInButton());

		baseMethod.PrintValue("Successfully sign in");

		baseMethod.MouseHoverOnElement(SaPE.getProjectName(),"Mouse hovered on already created project name");
		baseMethod.Click(SaPE.getProjectName());

		String attributeClass = testDevRepo.getTopNavBarScriptTab().getAttribute("class");

		if (attributeClass.contains("ff-app-header-nav-bar-submenu-item--selected")) {
			baseMethod.PrintValue("Script tab is selected by default");
		}
		
		
		//Started to createModule
		baseMethod.Click(testDevRepo.getCreateModuleButton());

		Boolean CreateButtonCheck = driver.findElement(By.cssSelector(".ff-button.ff-button--small.ff-button--primary"))
				.isEnabled();
		if (CreateButtonCheck) {
			baseMethod.PrintValue("Button Is not enable");
		} else {

			baseMethod.TypeText(testDevRepo.getCreateModuleName(), "FireCloud1_Testing");
			Thread.sleep(3000);

			baseMethod.Click(testDevRepo.getCmRootModuleRadioBtn());

			if (testDevRepo.getConfirmCreateModule().isEnabled()) {
				baseMethod.Click(testDevRepo.getConfirmCreateModule());

			} else {
				baseMethod.PrintValue("Button is not enable");

			}
		}
		Thread.sleep(5000);

		cSClass.createWebScript(driver, testDevRepo, act, baseMethod, objectCreate);

		
		

		baseMethod.PrintValue("Control Return to main Script");

		baseMethod.MouseHoverOnElement(testDevRepo.getCreatedNewModule(), "Mouse hovered on created module name in test dev section");

		baseMethod.PrintValue("Mouse Hovered");

		baseMethod.WaitUntilVisibilityOfElement(testDevRepo.getQuickAccessIcon(),"Wai until the visibility on more action icon in the created module");

		baseMethod.MouseHoverOnElementAndClick(testDevRepo.getQuickAccessIcon(),"Mouse hover on more action icon in the created module");

		baseMethod.Click(testDevRepo.getCmMoreDelete());

		baseMethod.Click(testDevRepo.getCmConfirmDelete());
		Thread.sleep(5000);
		
		
		
		

	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}

}
