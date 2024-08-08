package com.android.ecom.gestureUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Gestureutilities {
	
	

	public void lonbgClickOnElement(AndroidDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	public void doubleClickOnElement(AndroidDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	public void clickingOnElemenet(AndroidDriver driver, WebElement element) {
		driver.executeScript("mobile: clickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	public void dragAndDropUsingElement(AndroidDriver driver, WebElement element, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", x, "endY", y));
	}

	public void zoomIn(AndroidDriver driver, WebElement element, double percentage) {
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", percentage));
	}

	public void zoomOut(AndroidDriver driver, WebElement element, double percentage) {
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", percentage));
	}

	public void swiping(AndroidDriver driver, int left, int top, int width, int height, String direction, double percentage) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("left", left, "top", top,
				"width", width, "height", height, "direction", "direction", "percent", percentage));
	}

	public void scrollByusingTheCoordunates(AndroidDriver driver, int left, int top, int width, int height, String direction,
			double percentage) {
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", left, "top", top,
				"width", width, "height", height, "direction", "direction", "percent", percentage));
	}

	public WebElement scrollToElementUsingText(AndroidDriver driver, String text) {
		WebElement ele = driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
		return ele;
	}

	public WebElement scrollToElementUsingXpath(AndroidDriver driver, String xpath) {
		WebElement ele = driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(xpath(\""+xpath+"\"));"));

		return ele;
	}

	public void swipingByElementId(AndroidDriver driver, WebElement element, String direction, double percentage) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", direction, "percent", percentage));
	}
}
