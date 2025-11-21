package com.scripts.basefolder;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.report.listener.ExtentReportManager;
import com.scripts.repository.AutomationRunSettings;
import com.scripts.repository.CreateAutoamtion_Script_Slider;
import com.scripts.repository.CreateCloudTemplate;
import com.scripts.repository.NLPs;
import com.scripts.repository.ProjectMenuRepo;
import com.scripts.repository.SigninAndFindProjectElement;
import com.scripts.repository.Testdev;
import com.scripts.resource.Web_2b_Create_WebScript;
import com.scripts.resource.Web_2c_ExecutionBrowserSwitch;
import com.scripts.resource.Web_2d_deleteCreatedAutomationScript;

public class BaseObjectsCloud {

    public WebDriver driver;

    // Repos that need driver
    private Testdev testDevRepo;
    private SigninAndFindProjectElement SaPE;
    private NLPs NLP;
    private CreateAutoamtion_Script_Slider ASSlider;
    private AutomationRunSettings ARS;
    private CreateCloudTemplate createCloudTemplate;
    private ProjectMenuRepo projectMenuRepo;

    // Repos / utils that don’t need driver
    private Web_2b_Create_WebScript cSClass = new Web_2b_Create_WebScript();
    private Web_2d_deleteCreatedAutomationScript deleteclassAS = new Web_2d_deleteCreatedAutomationScript();
    private Web_2c_ExecutionBrowserSwitch newTab = new Web_2c_ExecutionBrowserSwitch();

    // Driver dependent helpers
    private WebDriverWait waitUntilVisibilityOfElement;
    private Actions act;
    private ExtentReportManager extentReport;

    // ✅ Constructor
    public BaseObjectsCloud(WebDriver driver) {
        this.driver = driver;

        // Initialize driver-dependent objects only after driver is set
        this.testDevRepo = new Testdev(driver);
        this.SaPE = new SigninAndFindProjectElement(driver);
        this.NLP = new NLPs(driver);
        this.ASSlider = new CreateAutoamtion_Script_Slider(driver);
        this.ARS = new AutomationRunSettings(driver);
        this.createCloudTemplate = new CreateCloudTemplate(driver);
        this.projectMenuRepo = new ProjectMenuRepo(driver);

        this.act = new Actions(driver);
        this.extentReport = new ExtentReportManager();
        this.waitUntilVisibilityOfElement = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //------------------------------------------------------
    public Testdev getTestDevRepo() {
        return testDevRepo;
    }

    //------------------------------------------------------
    public ExtentReportManager getextentreport() {
        return extentReport;
    }

    //------------------------------------------------------
    public CreateCloudTemplate getCreateCloudTemplate() {
        return createCloudTemplate;
    }

    //------------------------------------------------------
    public ProjectMenuRepo getProjectMenuRepo() {
        return projectMenuRepo;
    }

    //------------------------------------------------------
    public SigninAndFindProjectElement getSaPE() {
        return SaPE;
    }

    //------------------------------------------------------
    public NLPs getNLP() {
        return NLP;
    }

    //------------------------------------------------------
    public CreateAutoamtion_Script_Slider getASSlider() {
        return ASSlider;
    }

    //------------------------------------------------------
    public AutomationRunSettings getARS() {
        return ARS;
    }

    //------------------------------------------------------
    public Web_2b_Create_WebScript getcSClass() {
        return cSClass;
    }

    //------------------------------------------------------
    public Web_2d_deleteCreatedAutomationScript getDeleteclassAS() {
        return deleteclassAS;
    }

    //------------------------------------------------------
    public Web_2c_ExecutionBrowserSwitch getNewTab() {
        return newTab;
    }

    //------------------------------------------------------
    public void setwaitUntilVisibilityOfElements(WebDriverWait wait) {
        this.waitUntilVisibilityOfElement = wait;
    }

    //------------------------------------------------------
    public Actions getAct() {
        return act;
    }

    //------------------------------------------------------
    public WebElement getwaitUntilVisibilityOfElement(WebElement expectedElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(expectedElement));
    }

    //------------------------------------------------------
    public WebElement getwaitUntilPresenceOfElement(String expectedElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(expectedElement)));
    }
}
