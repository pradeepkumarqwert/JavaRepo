package com.scripts.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;

@Data
public class GeneralStore_Repository 
{
	WebDriver driver;
	public GeneralStore_Repository(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	
	@FindBy(xpath = "//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']")
	private WebElement GeneralStoreSelectionOfCountryDropDownElement;
	
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']")
	private WebElement GeneralStoreYourNameTextFiledElement;
	
	public WebElement CountryOptionInDropDown(String CountryName)
	{
		return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='"+ CountryName +"']"));
	}
	
	
	public WebElement GenderRadioButton(String Gender)
	{
		return driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radio"+ Gender +"']"));
	}
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")
	private WebElement letsShopButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Air Jordan 4 Retro']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")
	private WebElement product1AddToCartButton;
	
	public WebElement CheckNumberOfProductAddedToCart(String number)
	{
		return driver.findElement(By.xpath("//android.widget.TextView[@text='"+number+"']"));
	}
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/counterText']")
	private WebElement FetchNumberOfProductAddedToCart;
	
	@FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']")
	private WebElement CartButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Cart']/ancestor::android.widget.LinearLayout/following-sibling::android.widget.RelativeLayout//android.widget.LinearLayout//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")
	private WebElement VerifyAddedProductInCartPage;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Cart']")
	private WebElement VerifyCartPage;
	

}
