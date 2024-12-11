package com.android.ecom.pomclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage {
	
	public CartPage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	private WebElement PageVerifier;
	
	@FindBy(id = "com.androidsample.generalstore:id/productName")
	private WebElement itemAddedToCart;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Total Purchase Amount:  \"]")
	private WebElement totalAmount;
	
	@FindBy(className = "android.widget.CheckBox")
	private WebElement checkBox;
	
	@FindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement WebsiteButton;

	
	public WebElement getPageVerifier() {
		return PageVerifier;
	}

	public WebElement getItemAddedToCart() {
		return itemAddedToCart;
	}

	public WebElement getTotalAmount() {
		return totalAmount;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getWebsiteButton() {
		return WebsiteButton;
	}
	
}
