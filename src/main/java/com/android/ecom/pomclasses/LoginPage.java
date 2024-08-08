package com.android.ecom.pomclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.android.ecom.generalutility.BaseClass;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BaseClass {
	
	//AndroidDriver driver;
	public LoginPage(AndroidDriver driver) {
     this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement CountyDropDown;

	@FindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameTextField;

	@FindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement maleRadioButton;

	@FindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleRadioButton;

	@FindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopButton;

	@FindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	private WebElement pageVerifier;

	public WebElement getPageVerifier() {
		return pageVerifier;
	}

	public WebElement getCountyDropDown() {
		return CountyDropDown;
	}

	public WebElement getNameTextField() {
		return nameTextField;
	}

	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}

	public WebElement getLetsShopButton() {
		return letsShopButton;
	}
	public void login(AndroidDriver driver, String name, String text) {		
		CountyDropDown.click();
		gu.scrollToElementUsingText(driver, text).click();
		nameTextField.sendKeys("bharath");
		letsShopButton.click();	
	}
   public void skipLogin() {
	   letsShopButton.click();
	   du.toggleMessage(driver);
   }
}
