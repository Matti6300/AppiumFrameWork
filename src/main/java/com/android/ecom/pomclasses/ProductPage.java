package com.android.ecom.pomclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ProductPage {
	public ProductPage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	private WebElement pageVerifier;

	@FindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartButton;
	
		@FindBy(xpath = "//android.support.v7.widget.RecyclerView//android.widget.RelativeLayout[2]//android.widget.LinearLayout[2]//android.widget.TextView[@text=\"ADD TO CART\"]")
		private WebElement addToCArtButton;

		public WebElement getPageVerifier() {
			return pageVerifier;
		}

		public WebElement getCartButton() {
			return cartButton;
		}

		public WebElement getAddToCArtButton() {
			return addToCArtButton;
		}
}
