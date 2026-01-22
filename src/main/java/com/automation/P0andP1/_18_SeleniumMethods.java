package com.automation.P0andP1;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class _18_SeleniumMethods
{
	WebDriver driver;
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;
	WebDriverWait wait ;
	String products;

	@BeforeClass
	public void driverinitiation() throws InterruptedException, MalformedURLException
	{

		
		driver = new ChromeDriver();


		// Fetch system info
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getBrowserVersion();
		String platform = caps.getPlatformName().toString();

		System.out.println("Browser: " + browserName);
		System.out.println("Version: " + browserVersion);
		System.out.println("Platform: " + platform);

		this.baseMethod = new BaseMethodsCloud(driver);
		this.baseObject = new BaseObjectsCloud(driver);
		this.baseData = new BaseDataCloud();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.products = "Shirts";

		pantaloonsLandingPage = new PantaloonsLandingPage(driver);
		baseMethod.ImplicitWait(driver, 30,"Implicit wait is applied");
		baseMethod.HardWait(2000,"Hard wait applied");
	}

	
	//-----------------Browser Related Methods----------------
		@Test(priority = 1)
		public void browserRelatedMethods()
		{
			
			System.out.println("browserRelatedMethods Started !!---");
			// get(URL)
			baseMethod.getString(baseData.getBrowserURL(),"Landed on Google website");
			takeScreenshot(driver, "04_After_Search_Result_Click");

			// navigate().to(URL)
			baseMethod.Navigateinto(baseData.getPantaloonspageURL(),"Navigate to pantaloons landing page");
			takeScreenshot(driver, "04_After_Search_Result_Click");

			// wait until browser page loads
			waitUntilPageLoadComplete();

			// navigate().back() 
			driver.navigate().back();

			// navigate().forward() 
			driver.navigate().forward();

			// navigate().refresh() 
			driver.navigate().refresh();

			waitUntilPageLoadComplete();

			// get title
			String title = driver.getTitle();
			System.out.println("Title: " + title);

			// Get currentURL
			String currentURL = driver.getCurrentUrl();
			System.out.println("CurrentURL: " + currentURL);

			// Get Page Source
			String pageSource = driver.getPageSource();
			System.out.println("PageSource length: " + pageSource.length());
			System.out.println("browserRelatedMethods completed --!!");
			
		}
		
		// ----------------- Page Load Wait -----------------
		@Test(priority = 2)
		public void waitUntilPageLoadComplete()
		{
			
			System.out.println("waitUntilPageLoadComplete Started !!---");
			
			wait.until((ExpectedCondition<Boolean>) wd ->
				((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
			);
            System.out.println("waitUntilPageLoadComplete completed --!!");

		}

		// ----------------- Timeouts -----------------
		@Test(priority = 3)
		@SuppressWarnings("deprecation")
		public void timeOutMethods()
		{
            System.out.println("timeOutMethods completed --!!");


			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(40));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeAsyncScript(
			    "var callback = arguments[arguments.length - 1];" +
			    "window.setTimeout(callback, 5000);"
			);
			System.out.println("Async script executed successfully");
			System.out.println("timeOutMethods completed !!");
		}
	
		// ----------------- Window Management -----------------
		@Test(priority = 4)
		public void windowsManagementMethods()
		{
			System.out.println("windowsManagementMethods Started !!---");
			
			driver.manage().window().fullscreen();
			baseMethod.MaximizeBrowser(driver, "Page maximized");
			driver.manage().window().minimize();
			baseMethod.MaximizeBrowser(driver, "Maximixed");

			Dimension size = driver.manage().window().getSize();
			System.out.println("Window size: " + size);

			driver.manage().window().setSize(new Dimension(1024, 768));

			Point position = driver.manage().window().getPosition();
			System.out.println("Window position: " + position);
			driver.manage().window().setPosition(position);
			
			driver.manage().window().maximize();
			System.out.println("windowsManagementMethods completed !!");
		}
	
		
		@Test(priority = 5)
		public void alertMethods()
		{
			System.out.println("alertMethods Started !!---");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Trigger and dismiss alert
			js.executeScript("alert('Hello from Selenium! This is a test alert.');");
			Alert alert1 = driver.switchTo().alert();
			System.out.println("Alert text: " + alert1.getText());
			alert1.dismiss();

			// Trigger and accept alert
			js.executeScript("alert('Hello from Selenium! This is a test alert.');");
			Alert alert2 = driver.switchTo().alert();
			alert2.accept();
			System.out.println("alertMethods completed !!");
		}

		// ----------------- Windows / Tabs -----------------
		@Test(priority = 6)
		public void WindowsOrTabMethods() throws InterruptedException
		{
			System.out.println("WindowsOrTabMethods Started !!---");
			
			String parentHandle = driver.getWindowHandle();

			//Scroll until bottom of the page
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			// Mouse hover & click on element
			new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[text()='womenswear collection']")));
			driver.findElement(By.xpath("//a[text()='womenswear collection']")).click();

			// Switch to child window
			Set<String> listOfWindows = driver.getWindowHandles();
			for(String list: listOfWindows)
			{
				if(!list.equals(parentHandle))
				{
					driver.switchTo().window(list);
					System.out.println("Switched to child window");
				}
			}

			waitUntilPageLoadComplete();

			// Switch back to parent window
			driver.switchTo().window(parentHandle);	
			
			System.out.println("WindowsOrTabMethods completed !!");
		}

		// ----------------- Cookies -----------------
		@Test(priority = 7)
		public void cookiesMethods()
		{
			System.out.println("cookiesMethods Started !!---");
			
			Cookie testcookie = new Cookie("Testingcookie1", "12345");
			driver.manage().addCookie(testcookie);

			Set<Cookie> allCookies = driver.manage().getCookies();
			for(Cookie cookies: allCookies)
			{
				System.out.println("List of cookies: "+ cookies);
			}

			Cookie specifiedCookie = driver.manage().getCookieNamed("Testingcookie1");
			System.out.println("Specific cookie: " + specifiedCookie);
	
//			driver.manage().deleteCookie(testcookie);
//			System.out.println("Cookies deleted");
			Cookie testcookie2 = new Cookie("Testingcookie2", "12345");
			driver.manage().addCookie(testcookie2);
			System.out.println("Cookies added on second time");
//			driver.manage().deleteCookieNamed("TestingCookie2");
//			System.out.println("Cookies deleted based on name");
			Set<Cookie> newCookieList = driver.manage().getCookies();
			System.out.println("New Cookies list taken");
			for(Cookie cookies: newCookieList)
			{
				System.out.println("List of cookies: " + cookies);
			}

//			System.out.println("cookiesMethods completed !!");
		}

		// ----------------- Actions Class -----------------
		@Test(priority = 8)
		public void actionClassMethos() throws InterruptedException
		{
			System.out.println("actionClassMethos Started !!---");
			
			Actions act = new Actions(driver);
			WebElement searchBox = pantaloonsLandingPage.getPantaloonsMainSearchBarElement();

			act.click(searchBox)
			   .doubleClick(searchBox)
			   .contextClick(searchBox)
			   .clickAndHold(searchBox)
			   .release(searchBox)
			   .keyDown(searchBox, Keys.LEFT_SHIFT)
			   .sendKeys(searchBox, products)
			   .keyUp(searchBox, Keys.LEFT_SHIFT)
			   .moveToElement(searchBox, 0, 0)
			   .build()
			   .perform();

			act.dragAndDrop(driver.findElement(By.xpath("//span[text()='BRANDS']")), searchBox)
			   .dragAndDropBy(driver.findElement(By.xpath("//span[text()='BRANDS']")), 44, 78)
			   .perform();
			
			System.out.println("actionClassMethos completed !!");
		}
		
		
		// ----------------- Element Interactions -----------------
		@Test(priority = 9)
		public void elementInteractionMethos()
		{
			System.out.println("elementInteractionMethos Started !!---");
			
			WebElement searchBox = pantaloonsLandingPage.getPantaloonsMainSearchBarElement();

			searchBox.click();
			searchBox.sendKeys(products);
			searchBox.clear();
			searchBox.sendKeys(products);
			searchBox.submit();

			System.out.println("Text: " + searchBox.getText());
			System.out.println("Tag: " + searchBox.getTagName());
			System.out.println("Displayed: " + searchBox.isDisplayed());
			System.out.println("Enabled: " + searchBox.isEnabled());
			System.out.println("Selected: " + searchBox.isSelected());
			System.out.println("Size: " + searchBox.getSize());
			System.out.println("Location: " + searchBox.getLocation());
			System.out.println("Rect: " + searchBox.getRect());
			System.out.println("Attribute type: " + searchBox.getAttribute("type"));
			System.out.println("CSS font-size: " + searchBox.getCssValue("font-size"));
			System.out.println("elementInteractionMethos completed !!");
		}

		// ----------------- Dropdown -----------------
		@Test(priority = 10)
		public void dropdownMethods()
		{
			System.out.println("dropdownMethods Started !!---");
			
			driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");

	        driver.switchTo().frame("iframeResult");

	        WebElement carsDropdown = driver.findElement(By.name("cars"));
	        Select select = new Select(carsDropdown);

	        System.out.println("Is dropdown multiple? " + select.isMultiple());

	        select.selectByVisibleText("Volvo");
	        select.selectByVisibleText("Saab");
	        select.selectByValue("opel");
	        select.selectByIndex(3); // Audi

	        List<WebElement> allSelected = select.getAllSelectedOptions();
	        System.out.println("Selected options:");
	        for (WebElement option : allSelected) {
	            System.out.println(option.getText());
	        }

	        System.out.println("First selected: " + select.getFirstSelectedOption().getText());

	        select.deselectByVisibleText("Saab");
	        select.deselectByValue("opel");
	        select.deselectByIndex(3); // Audi
	        select.deselectAll();

	        driver.switchTo().defaultContent();
	        System.out.println("All options deselected successfully.");
	        
	        System.out.println("dropdownMethods completed !!");
		}

		
		//-----------------Java Script Executor---------------------
		@Test(priority = 11)
		public void javeScriptExecutor() throws InterruptedException
		{
			System.out.println("javeScriptExecutor Started !!---");
			
	        driver.manage().window().maximize();
	        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Get Page Title
	        String title = (String) js.executeScript("return document.title;");
	        System.out.println("Page Title: " + title);

	        // Get Current URL
	        String url = (String) js.executeScript("return document.URL;");
	        System.out.println("Page URL: " + url);

	        // Scroll down
	        js.executeScript("window.scrollBy(0, 500)");
	        Thread.sleep(1000);

	        // Scroll to bottom of the page
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        Thread.sleep(1000);

	        // Scroll back to top
	        js.executeScript("window.scrollTo(0, 0);");

	        // Switch to iframe and trigger alert
	        driver.switchTo().frame("iframeResult");
	        js.executeScript("myFunction()"); // executes JS function defined on page
	        Alert alert = driver.switchTo().alert();
	        System.out.println("Alert text: " + alert.getText());
	        alert.accept();
	        driver.switchTo().defaultContent();

	        // Click an element using JS (works even if normal click fails)
	        driver.navigate().to("https://www.w3schools.com/html/html_forms.asp");
	        WebElement tryItButton = driver.findElement(By.xpath("//a[@class='w3-btn w3-margin-bottom']"));
	        js.executeScript("arguments[0].click();", tryItButton);

	        // Send keys into input field using JS
	        driver.navigate().to("https://www.w3schools.com/html/html_forms.asp");
	        WebElement fnameInput = driver.findElement(By.id("fname"));
	        js.executeScript("arguments[0].value='Pradeep';", fnameInput);
	        System.out.println("Entered Name via JS");

	        // Highlight an element
	        js.executeScript("arguments[0].style.border='3px solid red';", fnameInput);
	        Thread.sleep(2000);

	        // Get inner text of body
	        String bodyText = (String) js.executeScript("return document.body.innerText;");
	        System.out.println("Body Text Length: " + bodyText.length());

	        // Get total links on page
	        Long linksCount = (Long) js.executeScript("return document.getElementsByTagName('a').length;");
	        System.out.println("Total links: " + linksCount);

	        // Navigate using JS
	        js.executeScript("window.location='https://www.google.com';");
	        Thread.sleep(3000);

	        // Refresh page using JS
	        js.executeScript("history.go(0);");

	        // Get Page Load State
	        String readyState = (String) js.executeScript("return document.readyState;");
	        System.out.println("Page Ready State: " + readyState);

	        // Zoom Page
	        js.executeScript("document.body.style.zoom='80%';");

	        Thread.sleep(3000);
	        
	        
	        System.out.println("javeScriptExecutor completed --!!");
		}
		
		
		
		
		//-----------------executeAsyncScript(String script, Object... args)---------------
		@Test(priority = 12)
		public void executeAsyncScript()
		{
			System.out.println("executeAsyncScript Started !!---");
			
	        driver.get("https://www.w3schools.com");

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        System.out.println("Starting async JavaScript execution...");

	        // Simple async callback after 3 seconds
	        Long result1 = (Long) js.executeAsyncScript(
	                "var callback = arguments[arguments.length - 1];" +
	                "window.setTimeout(function(){callback(123);}, 3000);"
	        );
	        System.out.println("Async Script 1 completed with result: " + result1);

	        // Simulate waiting for AJAX response
	        Long result2 = (Long) js.executeAsyncScript(
	                "var callback = arguments[arguments.length - 1];" +
	                "var xhr = new XMLHttpRequest();" +
	                "xhr.open('GET', 'https://jsonplaceholder.typicode.com/posts/1', true);" +
	                "xhr.onreadystatechange = function() {" +
	                "  if (xhr.readyState == 4) {" +
	                "    console.log('AJAX completed');" +
	                "    callback(xhr.status);" +
	                "  }" +
	                "};" +
	                "xhr.send();"
	        );
	        System.out.println("AJAX call status code: " + result2);

	        // Delay execution and scroll asynchronously
	        js.executeAsyncScript(
	                "var callback = arguments[arguments.length - 1];" +
	                "window.scrollBy(0, 500);" +
	                "window.setTimeout(callback, 2000);"
	        );
	        System.out.println("Scrolled down asynchronously");

	        // Asynchronous DOM check
	        String state = (String) js.executeAsyncScript(
	                "var callback = arguments[arguments.length - 1];" +
	                "window.setTimeout(function() {" +
	                "  callback(document.readyState);" +
	                "}, 2000);"
	        );
	        System.out.println("Async Document Ready State: " + state);

	        // Measure async time taken
	        Long duration = (Long) js.executeAsyncScript(
	                "var callback = arguments[arguments.length - 1];" +
	                "var start = Date.now();" +
	                "setTimeout(function(){" +
	                "  var end = Date.now();" +
	                "  callback(end - start);" +
	                "}, 2500);"
	        );
	        System.out.println("Async operation duration: " + duration + " ms");
	        
	        System.out.println("executeAsyncScript completed --!!");
		}

		

	// ----------------- Screenshot Helper -----------------
	public static void takeScreenshot(WebDriver driver, String fileName) 
	{
		
        if (driver == null) return;
        try {
            File src = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
            File dest = new File("C:\\Selenium Grid\\Screenshots\\" + fileName + ".png");
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }

	@AfterClass
	public void QuitBrowser()
	{
		driver.quit();
	}
}
