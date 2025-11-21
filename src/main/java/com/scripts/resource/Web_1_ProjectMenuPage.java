package com.scripts.resource;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.UUID;

import org.apache.http.util.Asserts;
import org.json.simple.JSONObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.DependsOn;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.beust.jcommander.Parameter;
import com.report.listener.ExtentReportManager;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.ProjectMenuRepo;
import com.scripts.repository.SigninAndFindProjectElement;
import com.scripts.repository.Testdev;

import freemarker.core.ReturnInstruction.Return;

public class Web_1_ProjectMenuPage {
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud objectCreate;
	Testdev testDevRepo;
	SigninAndFindProjectElement SaPE;
	ProjectMenuRepo projectMenuRepo;
	String projectName;
	String statusOfCreatedProject;
	Boolean projectCreated = false;
	
	
	@BeforeClass
	public void initilizeBrowser() throws MalformedURLException {
		// 1. Initialize driver first
//		String seleniumHubUrl = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=736d95c1-64e3-46ba-8f86-cf4086a93045&licenseId=LIC3943&projectName=Sanity/";
//		ChromeOptions browserOptions = new ChromeOptions();
//		browserOptions.setPlatformName("Windows 11");
//		browserOptions.setBrowserVersion("129");
//		driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
//		driver.manage().window().setSize(new Dimension(1024, 768));
		driver = new ChromeDriver();

//		driver = new ChromeDriver();


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		// 2. Only then create your base objects
		baseMethod = new BaseMethodsCloud(driver);
		objectCreate = new BaseObjectsCloud(driver);

		testDevRepo = objectCreate.getTestDevRepo();
		SaPE = objectCreate.getSaPE();
		projectMenuRepo = objectCreate.getProjectMenuRepo();

		// 3. Create random project name
		projectName = UUID.randomUUID().toString().substring(0, 8);
		System.out.println("project Name is " + projectName);
		System.out.println("its before class");

	}
	@Test(priority = 1)
	public void CreateProjectMethod() throws InterruptedException {

		System.out.println("inside test 1");
		LaunchBrowser();
		SignInProcess();
		// Verifying Landed in Landing page
		baseMethod.ElementIsDisplay(projectMenuRepo.getVerifyProjectMenuLandingPageElementInProjectMenu());
		baseMethod.ElementIsDisplay(projectMenuRepo.getPlusProjectButtonAtTopRightCornerElementInProjectMenu());
		baseMethod.ElementIsDisplay(projectMenuRepo.getNameHeaderInElementInProjectMenu());
		baseMethod.ElementIsDisplay(projectMenuRepo.getTypeHeaderInElementInProjectMenu());
		baseMethod.ElementIsDisplay(projectMenuRepo.getStatusHeaderInElementInProjectMenu());
		baseMethod.ElementIsDisplay(projectMenuRepo.getModifiedByHeaderInElementInProjectMenu());
		baseMethod.ElementIsDisplay(projectMenuRepo.getModifiedOnHeaderInElementInProjectMenu());

		// Click on +Project Button
		baseMethod.Click(projectMenuRepo.getPlusProjectButtonAtTopRightCornerElementInProjectMenu());
		Thread.sleep(5000);
		baseMethod.ElementIsDisplay(projectMenuRepo.getVerifyingCreateProjectSliderElementInProjectMenu());

		// Validating Name TextField is Focused by default in create project slider
		baseMethod.ElementIsDisplay(
				projectMenuRepo.getNameTextFieldWhileItIsFocusedInCreateProjectSliderElementInProjectMenu());
		// Click on out side to focus out off the name text field
		baseMethod.Click(projectMenuRepo.getVerifyingCreateProjectSliderElementInProjectMenu());
		// validating "Name is required" inline validation is display
		baseMethod.ElementIsDisplay((projectMenuRepo
				.getNameIsRequiredInNameTextFieldInlineValidationInCreateProjectSliderElementInProjectMenu()));
		// validating mimimum of 3 character is required inline validation is displaying
		baseMethod
				.Click(projectMenuRepo.getNameTextFieldWhileItIsNotFocusedInCreateProjectSliderElementInProjectMenu());
		String lessThan3Character = UUID.randomUUID().toString().substring(0, 1);
		baseMethod.TypeText(projectMenuRepo.getNameTextFieldWhileItIsFocusedInCreateProjectSliderElementInProjectMenu(),
				lessThan3Character);
		baseMethod.ElementIsDisplay(projectMenuRepo
				.getMinimum3CharactersRequiredInNameTextFieldInlineValidationInCreateProjectSliderElementInProjectMenu());
		// Clearing Inputs
		projectMenuRepo.getNameTextFieldWhileItIsFocusedInCreateProjectSliderElementInProjectMenu()
				.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		baseMethod.presskeys(
				projectMenuRepo.getNameTextFieldWhileItIsFocusedInCreateProjectSliderElementInProjectMenu(),
				Keys.BACK_SPACE, "Backspace button is pressed to clear entered project name in Create project slider");
		// validating Maximum 25 character is allowed inline validation is displaying
		baseMethod
				.Click(projectMenuRepo.getNameTextFieldWhileItIsNotFocusedInCreateProjectSliderElementInProjectMenu());
		String GreaterThan25Character = UUID.randomUUID().toString().substring(0, 26);
		baseMethod.TypeText(projectMenuRepo.getNameTextFieldWhileItIsFocusedInCreateProjectSliderElementInProjectMenu(),
				GreaterThan25Character);
		baseMethod.ElementIsDisplay(projectMenuRepo
				.getMaximum25CharactersAllowedRequiredInNameTextFieldInlineValidationInCreateProjectSliderElementInProjectMenu());
		// Clearing Inputs
		projectMenuRepo.getNameTextFieldWhileItIsFocusedInCreateProjectSliderElementInProjectMenu()
				.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		baseMethod.presskeys(
				projectMenuRepo.getNameTextFieldWhileItIsFocusedInCreateProjectSliderElementInProjectMenu(),
				Keys.BACK_SPACE, "Backspace button is pressed to clear entered project name in Create project slider");
		// validating Name should be alphanumeric inline validation in displaying
		baseMethod.TypeText(projectMenuRepo.getNameTextFieldWhileItIsFocusedInCreateProjectSliderElementInProjectMenu(),
				"CloudTesting***");
		baseMethod.ElementIsDisplay(projectMenuRepo
				.getNameShouldBeAlphanumericRequiredInNameTextFieldInlineValidationInCreateProjectSliderElementInProjectMenu());
		// Clearing Inputs
		projectMenuRepo.getNameTextFieldWhileItIsFocusedInCreateProjectSliderElementInProjectMenu()
				.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		baseMethod.presskeys(
				projectMenuRepo.getNameTextFieldWhileItIsFocusedInCreateProjectSliderElementInProjectMenu(),
				Keys.BACK_SPACE, "Backspace button is pressed to clear entered project name in Create project slider");
		// Creating Project name and providing it in name textField

		baseMethod.TypeText(projectMenuRepo.getNameTextFieldWhileItIsFocusedInCreateProjectSliderElementInProjectMenu(),
				projectName);

		// validating DropDown TextField
		baseMethod.Click(projectMenuRepo.getTypeDropdownWhileItIsNotFocusedInCreateProjectSliderElementInProjectMenu());
		baseMethod.Click(projectMenuRepo.getVerifyingCreateProjectSliderElementInProjectMenu());
		// Select project type is required inline validation is dispalying
		baseMethod.ElementIsDisplay(projectMenuRepo
				.getSelectProjectTypeRequiredInSelectProjectDropdownInlineValidationInCreateProjectSliderElementInProjectMenu());
		baseMethod.Click(projectMenuRepo
				.getTypeDropdownWhileItIsNotFocusedWithErrorMessageInCreateProjectSliderElementInProjectMenu());
		baseMethod.TypeText(
				projectMenuRepo
						.getTypeDropdownWhileItIsFocusedWithErrorMessageInCreateProjectSliderElementInProjectMenu(),
				projectName);
		// No Result found message displaying in dropdown
		baseMethod.ElementIsDisplay(projectMenuRepo
				.getNoResultFoundValidationForInValidProjectTypeNameInCreateProjectSliderElementInProjectMenu());
		projectMenuRepo.getTypeDropdownWhileItIsFocusedWithErrorMessageInCreateProjectSliderElementInProjectMenu()
				.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		baseMethod.presskeys(
				projectMenuRepo
						.getTypeDropdownWhileItIsFocusedWithErrorMessageInCreateProjectSliderElementInProjectMenu(),
				Keys.BACK_SPACE, "Backspace button is pressed to clear entered project type on Create project slider");

		// Select Web type of project
		baseMethod.MouseHoverOnElement(
				projectMenuRepo.getWebOptionInSelectProjectTypeDropDownInCreateProjectSliderElementInProjectMenu(),
				"Mouse hovered on the 'Web' option in type of project dropdown in create project slider");
		baseMethod.Click(
				projectMenuRepo.getWebOptionInSelectProjectTypeDropDownInCreateProjectSliderElementInProjectMenu());

		// Validating Description Text area
		String moreThan200Character = baseMethod.generateAStringOfSize(205);
		baseMethod.TypeText(projectMenuRepo.getDescriptionTextFieldInCreateProjectSliderElementInProjectMenu(),
				moreThan200Character);
		baseMethod.ElementIsDisplay(projectMenuRepo
				.getVerifyMaxOF200CharacterNumberInDescriptionTextAreaInCreateProjectSliderElementInProjectMenu());

		// Create project
		baseMethod.Click(projectMenuRepo.getCreateButtonInCreateProjectSliderElementInProjectMenu());
		// Validate that after creation of project it should landed in testdev script
		// section by default
		ValidateTestDevSectionOfCreatedProject();
		// navigate to All project menu

		Thread.sleep(15000);
		baseMethod.MouseHoverOnElement(projectMenuRepo.getAllProjectNameInTopNavBar(projectName),
				"Mouse hovered on the project name option in individual project top navigation bar");
		baseMethod.MouseHoverOnElement(projectMenuRepo.getAllProjectOptionInAllProjectNameInTopNavBar(),
				"Mouse hovered on the 'All project' option in Project dropdown in individual project top navigation bar");
		baseMethod.Click(projectMenuRepo.getAllProjectOptionInAllProjectNameInTopNavBar());
		Thread.sleep(5000);

		// ValidateThatCreatedProjectHadAllValidValidations
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				projectMenuRepo.getCreateProjectRowElementInProjectMenu(projectName));

		// This if condition for get the information weather the project is created or
		// not for delete the project after execution of test case
		if (baseMethod.ElementIsDisplay(projectMenuRepo.getCreatedProjectNameColumnElementInProjectMenu(projectName))) {
			projectCreated = true;
		}

		baseMethod.MouseHoverOnElement(projectMenuRepo.getCreateProjectRowElementInProjectMenu(projectName),
				"Mouse hovered on the created project name in project menu");
		statusOfCreatedProject = baseMethod.GetText(
				projectMenuRepo.getCreatedProjectStatusColumnElementInProjectMenu(projectName),
				"Created project status text is fetched");
		if (statusOfCreatedProject.equalsIgnoreCase("Open")) {
			// Status is Open
			baseMethod.PrintValue("Project is in Open Status");
		} else {
			baseMethod.PrintValue("Throws Error 1");
		}
		String typeOfCreatedProject = baseMethod.GetText(
				projectMenuRepo.getCreatedProjectTypeColumnElementInProjectMenu(projectName),
				"Created project type text is fetched");
		if (typeOfCreatedProject.equalsIgnoreCase("Web")) {
			// Status is Open
			baseMethod.PrintValue("Project is Web Type");
		} else {
			baseMethod.PrintValue("Throws Error 2");
		}

		String nameOfCreatedProject = baseMethod.GetText(
				projectMenuRepo.getCreatedProjectNameColumnElementInProjectMenu(projectName),
				"Created project name text is fetched");
		if (nameOfCreatedProject.equalsIgnoreCase(projectName)) {
			// Status is Open
			baseMethod.PrintValue("Project is matched");
		} else {
			baseMethod.PrintValue("Project name mismatched");
			baseMethod.PrintValue(nameOfCreatedProject);
		}
		System.out.println("indisee test 1 completed ");

	}

	@Test(priority = 2, dependsOnMethods = { "CreateProjectMethod" }, retryAnalyzer = com.frameworks.utils.RetryAnalizer.class)
	public void OpenToCloseProjectMethod() throws InterruptedException

	{

		System.out.println("indisee test 2");
		// 1.Mouse hovered on the created project card
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				projectMenuRepo.getCreateProjectRowElementInProjectMenu(projectName));
		baseMethod.MouseHoverOnElement(projectMenuRepo.getCreateProjectRowElementInProjectMenu(projectName),
				"Mouse hovered on the created project name in project menu");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 2.click on more action icon of the created project
		baseMethod.Click(projectMenuRepo.getCreatedProjectMoreActionIconElement(projectName));
		Thread.sleep(5000);
		// 3.Check weather the delete button is in disable state for the open type of
		// project
		if (!projectMenuRepo.getCreatedProjectDisabledDeleteOptionInMoreActionIconElement().isEnabled()) {
			baseMethod.PrintValue("DeleteButtonIsInDisableStateForOpenProject");
		}
		// 4.Mouse hovered and Click on edit icon in created project card
		baseMethod.MouseHoverOnElement(projectMenuRepo.getCreatedProjectEditActionIconElement(projectName),
				"Mouse hovered on the edit action icon of the created project");
		baseMethod.Click(projectMenuRepo.getCreatedProjectEditActionIconElement(projectName));
		Thread.sleep(6000);
		// 5.Validate Edit project slider is dispalyed
		baseMethod.ElementIsDisplay(projectMenuRepo.getVerifyEditProjectSliderElement());
		// 6.Validating name text field inline validation
		projectMenuRepo.getProjectNameTextFieldInEditProjectSliderElement().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		baseMethod.presskeys(projectMenuRepo.getProjectNameTextFieldInEditProjectSliderElement(), Keys.BACK_SPACE,
				"Backspace button is pressed to clear Project name in Edit project slider");
		baseMethod.ElementIsDisplay(projectMenuRepo
				.getNameIsRequiredInNameTextFieldInlineValidationInCreateProjectSliderElementInProjectMenu());
		projectMenuRepo.getProjectNameTextFieldInEditProjectSliderElement().sendKeys(Keys.chord(Keys.CONTROL, "z"));

		// 7.Validate type dropdown is in disable state in edit project slider
		if (!projectMenuRepo.getUpdateButtonInEditProjectSliderElement().isEnabled()) {
			baseMethod.PrintValue("Update button is in disable status initally");
		}
		// 8.Validate that the project type dropdown button is in disable state or not
		// by the xpath
		baseMethod.ElementIsDisplay(projectMenuRepo.getProjectTypeDisabledDropdownInEditProjectSliderElement());
		// 9.Click on status toggle button to change the status of the project from open
		// to close
		baseMethod.Click(projectMenuRepo.getToggleButtonInEditProjectSliderElement());
		// 10.Validate that the waring pop up is displayed with the proper text in it
		baseMethod.ElementIsDisplay(projectMenuRepo.getVerifyTextInChangeStatusOfProjectFromOpenToClose());
		// 11.Click on cancel button in warning popup to check weather its redirect to
		// edit project slider
		baseMethod.Click(projectMenuRepo.getCancelButtonInChangeStatusOfProjectFromOpenToClose());
		// 12.Click on status toggle button to change the status of the project from
		// open to close
		baseMethod.Click(projectMenuRepo.getToggleButtonInEditProjectSliderElement());
		// 13.Validate that the waring pop up is displayed with the proper text in it
		baseMethod.ElementIsDisplay(projectMenuRepo.getVerifyTextInChangeStatusOfProjectFromOpenToClose());
		// 14.Click on continue button in warning popup to Change the status of the
		// project
		baseMethod.Click(projectMenuRepo.getContiuneButtonInChangeStatusOfProjectFromOpenToClose());
		// 15.Check weather the update button is enable after add some changes in the
		// edit project slider
		if (projectMenuRepo.getUpdateButtonInEditProjectSliderElement().isEnabled()) {
			// 16.After Validating, click on update button to confirm tehh changes in edit
			// project slider
			baseMethod.Click(projectMenuRepo.getUpdateButtonInEditProjectSliderElement());
			Thread.sleep(5000);
		}

		// 17a.Now Check weather the applied changes are applied in project menu page by
		// validate that project is closed or not
		statusOfCreatedProject = baseMethod.GetText(
				projectMenuRepo.getCreatedProjectStatusColumnElementInProjectMenu(projectName),
				"Created project status text is fetched");
		// 17b.Ftech the status of the project from status olumn in the created project
		// card and comparing to the expected status of the project
		if (statusOfCreatedProject.equalsIgnoreCase("Closed")) {
			baseMethod.PrintValue("Proejct is in closed state");
		}

		System.out.println("indisee test 2 complted");

		// 18.Navigate inside the created project
		baseMethod.Click(projectMenuRepo.getCreatedProjectNameColumnElementInProjectMenu(projectName));
		Thread.sleep(10000);

		// 19.Check weather that created project is in view access state in side the
		// project
		try {
			validateThatProjectIsInViewAccessAfterCloseTheProejct();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Test(priority = 3, dependsOnMethods = { "OpenToCloseProjectMethod" }, retryAnalyzer = com.frameworks.utils.RetryAnalizer.class)
	public void CloseToArchiveProject() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				projectMenuRepo.getCreateProjectRowElementInProjectMenu(projectName));
		baseMethod.MouseHoverOnElement(projectMenuRepo.getCreatedProjectMoreActionIconElement(projectName),
				"Mouse hovered on the more action icon in created project card in project menu list");
		baseMethod.Click(projectMenuRepo.getCreatedProjectMoreActionIconElement(projectName));
		// 1.Check Weather all the archive, delete, details options are display in more
		// action icon popup
		if (baseMethod.ElementIsDisplay(projectMenuRepo.getCreatedProjectArchivedProjectOptionInMoreActionIconElement())
				&& baseMethod.ElementIsDisplay(projectMenuRepo.getCreatedProjectDeleteOptionInMoreActionIconElement())
				&& baseMethod
						.ElementIsDisplay(projectMenuRepo.getCreatedProjectDetailsOptionInMoreActionIconElement())) {
			if (projectMenuRepo.getCreatedProjectDeleteOptionInMoreActionIconElement().isEnabled()) {
				baseMethod.PrintValue(
						"In more action icon all 3 options are displayed and delete button is in enable state");
			}
		}
		// 2.click on details option in more icon pop up
		baseMethod.Click(projectMenuRepo.getCreatedProjectDetailsOptionInMoreActionIconElement());
		Thread.sleep(5000);
		// 3.Check Project details slider is display
		baseMethod.ElementIsDisplay(projectMenuRepo.getVerifyProjectDetailsSlider());
		// 4.Mouse hover on Close button in project details slider(here the close button
		// in create project slider and edit project slider and project details slider
		// all are same so here create proejct slider close button element is used)
		baseMethod.MouseHoverOnElement(projectMenuRepo.getCloseButtonInCreateProjectSliderElementInProjectMenu(),
				"Mouse hover on Close button in project details slider");
		// 5.Valitate that close tooltip is displaing
		baseMethod.ElementIsDisplay(projectMenuRepo.getCloseToolTipInCreateProjectSliderElementInProjectMenu());
		// 6.Close the project details slider
		baseMethod.Click(projectMenuRepo.getCloseButtonInCreateProjectSliderElementInProjectMenu());
		// 7.Mouse hover on the created project name
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				projectMenuRepo.getCreateProjectRowElementInProjectMenu(projectName));
		// 8.Mouse hover on the more action icon of created project
		baseMethod.MouseHoverOnElement(projectMenuRepo.getCreatedProjectMoreActionIconElement(projectName),
				"Mouse hovered on the more action icon in created project card in project menu list");
		// 9.Click on more action icon
		baseMethod.Click(projectMenuRepo.getCreatedProjectMoreActionIconElement(projectName));
		// 10.Click on archive option in more action icon popup
		baseMethod.Click(projectMenuRepo.getCreatedProjectArchivedProjectOptionInMoreActionIconElement());
		Thread.sleep(5000);
		// 11.Wait until the successful archive toaster message card is display or not
		baseMethod.WaitUntilVisibilityOfElement(projectMenuRepo.getArchivedSuccessfullyToasterMessage(),
				"waited until the visibility of archived successfully toaster message displays");
		// 12.Verify that successful archive toaster message card is display or not
		baseMethod.ElementIsDisplay(projectMenuRepo.getArchivedSuccessfullyToasterMessage());

		// 13.verify that project status is displaing as archived in UI
		if (baseMethod.GetText(projectMenuRepo.getCreatedProjectStatusColumnElementInProjectMenu(projectName),
				"Archived project status is fetched").equalsIgnoreCase("Archive")) {
			baseMethod.PrintValue("Project is in archived status");
		} else {
			baseMethod.PrintValue("Project is not in archived status there is some logical mistake happened");
		}

	}

	@Test(priority = 4, dependsOnMethods = { "CloseToArchiveProject" }, retryAnalyzer = com.frameworks.utils.RetryAnalizer.class)
	public void ArchiveToUnarchivingOrClosedProject() throws InterruptedException {
		// 1.Mouse hover on the created project row
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				projectMenuRepo.getCreateProjectRowElementInProjectMenu(projectName));

		// 2.Check the curser style while mouse hover
		checkDisableCurserForArchivedProject();
		// 3.Mouse hover on the created project more action icon
		baseMethod.MouseHoverOnElement(projectMenuRepo.getCreatedProjectMoreActionIconElement(projectName),
				"Mouse hovered on the more action icon in created project card in project menu list");
		// 4.Click on created project more action icon
		baseMethod.Click(projectMenuRepo.getCreatedProjectMoreActionIconElement(projectName));
		// 5.Check that Unarchive project option is present on the more icon popup
		baseMethod.ElementIsDisplay(projectMenuRepo.getUnArchiveOptionInMoreActionIconPopUp());
		Thread.sleep(5000);
		// 6.Click on unarchive option in more action icon pop up
		baseMethod.Click(projectMenuRepo.getUnArchiveOptionInMoreActionIconPopUp());
		// 7.Validate that project is unarchived/Closed state
		String StatusOfUnarchivedOrClosedProject = baseMethod.GetText(
				projectMenuRepo.getCreatedProjectStatusColumnElementInProjectMenu(projectName),
				"Unarchived/closed project status text is fetched");
		if (StatusOfUnarchivedOrClosedProject.equalsIgnoreCase("Closed")) {
			baseMethod.PrintValue("project is in unarchived/closed status");
		}
	}

	// Launch briwser method---------------------------------------------
	public void LaunchBrowser() throws InterruptedException {
		System.out.println("Started to open URL");
		driver.get("https://www.google.com/");
		 takeScreenshot(driver, "01_After_landed_on_Google");
		// driver.navigate().to("https://app.v3.fireflink.com/");
		driver.navigate().to("https://test3.fireflink.com/");
		takeScreenshot(driver, "02_After_landed_on_fireflink");
		Thread.sleep(10000);
		System.out.println("landed 1");
	}

	// Sign-In to app.ve.fireflink process-------------------------------
	public void SignInProcess() throws InterruptedException {
		System.out.println("Started to sign in");
		takeScreenshot(driver, "03_After_landed_on_fireflink");
		// Started To Sign-in process
		String Actual = baseMethod.GetText(SaPE.getVerifySigninPage(),
				"Text is fetched from the sign-In page to validate");
		 takeScreenshot(driver, "02_After_Click_Search_Icon");
		System.out.println(Actual);
		// Verify Sign in Landing Page
	
		Assert.assertEquals(Actual, "SIMPLIFY TESTING. AMPLIFY QUALITY.");
		 takeScreenshot(driver, "02_After_Click_Search_Icon");
		System.out.println("Validated");

		// Entering Email
		baseMethod.Click(SaPE.getEmailTextField());
		baseMethod.TypeText(SaPE.getEmailTextField(), "nonfunctional3.0@gmail.com");
//		baseMethod.TypeText(SaPE.getEmailTextField(), "shirinenvi123@gmail.com");
		// Entering Password
		baseMethod.Click(SaPE.getPasswordTextField());
		baseMethod.TypeText(SaPE.getPasswordTextField(), "Password@123");
		// Click on sign in button
		baseMethod.Click(SaPE.getSignInButton());
		baseMethod.PrintValue("Successfully sign in");
		Thread.sleep(10000);
	}

	// Check the curser style is in disable state---------------------------
	public void checkDisableCurserForArchivedProject() {
		// Mouse hover on created project
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				projectMenuRepo.getCreateProjectRowElementInProjectMenu(projectName));
		// get the project curser style while mouse hover
		String curserStyle = projectMenuRepo.getDisableCurserForArchivedProjectElement(projectName)
				.getCssValue("cursor");
		if (curserStyle.equalsIgnoreCase("not-allowed")) {
			System.out.println("Block curser is displayed");
		}
		return;
	}

	// Check that project is in view access when it is in closed state
	public void validateThatProjectIsInViewAccessAfterCloseTheProejct() throws InterruptedException {
		Thread.sleep(15000);
		// 1.Check weather the automation run setting and manual run setting and
		// automattion run icons are present or not
		if (!baseMethod.ElementIsDisplay(projectMenuRepo
				.getElementToCheckWeatherTheProjectIsInViewAccessAfterCloseTheProjectElementInIndividualProejctLevelOfCreatedProject(projectName))) {
			baseMethod.PrintValue("Project is in view access");
			return;
		}
		// 2.navigate to project menu
		Thread.sleep(15000);
		// 2b.Mouse hovered on the project name in top navigation bar
		baseMethod.MouseHoverOnElement(projectMenuRepo.getAllProjectNameInTopNavBar(projectName),
				"Mouse hovered on the project name option in individual project top navigation bar");
		// 2b.Mouse hovered on the All project option on project name drop down on top
		// navigation bar
		baseMethod.MouseHoverOnElement(projectMenuRepo.getAllProjectOptionInAllProjectNameInTopNavBar(),
				"Mouse hovered on the 'All project' option in Project dropdown in individual project top navigation bar");
		// 2c.click on all project option in the dropdown
		baseMethod.Click(projectMenuRepo.getAllProjectOptionInAllProjectNameInTopNavBar());
		Thread.sleep(15000);

		// 3.Mouse hovered on the created project card
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				projectMenuRepo.getCreateProjectRowElementInProjectMenu(projectName));
		return;
	}

	// Validate that user is landed on test dev section after create a project
	public void ValidateTestDevSectionOfCreatedProject() {
		String attributeClass = testDevRepo.getTopNavBarScriptTab().getAttribute("class");
		if (attributeClass.contains("ff-app-header-nav-bar-submenu-item--selected")) {
			baseMethod.PrintValue("Script tab is selected by default");
		}
	}

	
	 public static void takeScreenshot(WebDriver driver, String fileName) 
	    {
	        if (driver == null) {
	            return;
	        }
	        try {
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            File dest = new File("C:\\Selenium Grid\\Screenshots\\" + fileName + ".png");
	            dest.getParentFile().mkdirs(); // Ensure folder exists
	            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
	            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
	        } catch (IOException e) {
	            System.out.println("Failed to save screenshot: " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Screenshot capture failed: " + e.getMessage());
	        }
	    }

	
	
	@AfterClass
	public void quitBrowser() throws InterruptedException {
		// delete project if it is created
		if (projectCreated) {
			System.out.println("Started to delete project");
			Thread.sleep(5000);
			// 1a.Mouse hovered on the project name in top navigation bar
			baseMethod.MouseHoverOnElement(projectMenuRepo.getAllProjectNameInTopNavBar(projectName),
					"Mouse hovered on the project name option in individual project top navigation bar");
			// 1b.Mouse hovered on the All project option on project name drop down on top
			// navigation bar
			baseMethod.MouseHoverOnElement(projectMenuRepo.getAllProjectOptionInAllProjectNameInTopNavBar(),
					"Mouse hovered on the 'All project' option in Project dropdown in individual project top navigation bar");
			// 1c.click on all project option in the dropdown
			baseMethod.Click(projectMenuRepo.getAllProjectOptionInAllProjectNameInTopNavBar());
			Thread.sleep(5000);
			// 2.mouse hover on the created project name
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					projectMenuRepo.getCreateProjectRowElementInProjectMenu(projectName));
			baseMethod.MouseHoverOnElement(projectMenuRepo.getCreatedProjectNameColumnElementInProjectMenu(projectName),
					"Mouse hovered on the created project name column");
			// 3.Click on more action icon on the created project card
			baseMethod.Click(projectMenuRepo.getCreatedProjectMoreActionIconElement(projectName));
			// 4.Click on delete option on more action icon popup
			baseMethod.Click(projectMenuRepo.getCreatedProjectDeleteOptionInMoreActionIconElement());
			// 5.Click on Conformation delete button for delete project popup
			baseMethod.Click(projectMenuRepo.getDeleteButtonInDeleteProjectPopUpElement());
			Thread.sleep(3000);
			baseMethod.ElementIsDisplay(projectMenuRepo.getDeleteProjectConformationToasterMessage(projectName));

		}

		System.out.println("its after class");
		driver.quit();
	}
	

}
