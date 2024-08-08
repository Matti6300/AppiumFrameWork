package com.android.ecom.driverUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class DriverUtilities {


	public void installingApplication(AndroidDriver driver, String path) {
		driver.installApp(path);
	}

	public void uninstallingApplication(AndroidDriver driver, String packageName) {
		driver.removeApp(packageName);
	}

	public void checkForInstallation(AndroidDriver driver, String packageName) {
		driver.isAppInstalled(packageName);
	}

	public void runApp(AndroidDriver driver, String packageName) {
		driver.activateApp(packageName);
	}

	public void runAppInBackgroud(AndroidDriver driver, int time) {
		driver.runAppInBackground(Duration.ofSeconds(time));
	}

	public void statusOfApp(AndroidDriver driver, String packageName) {
		System.out.println(driver.queryAppState(packageName));
	}

	public void getCurrentActivityOfApp(AndroidDriver driver) {
		System.out.println(driver.currentActivity());
	}

	public void keyBoardHide(AndroidDriver driver) {
		driver.hideKeyboard();
	}

	public void landscapeOrientation(AndroidDriver driver) {
		ScreenOrientation screen = driver.getOrientation();
		driver.rotate(screen.LANDSCAPE);
	}

	public void portraiteOrientation(AndroidDriver driver) {
		ScreenOrientation screen = driver.getOrientation();
		driver.rotate(screen.PORTRAIT);
	}

	public void data(AndroidDriver driver) {
		driver.toggleData();
	}

	public void airoplaneMode(AndroidDriver driver) {
		driver.toggleAirplaneMode();
	}

	public void wifi(AndroidDriver driver) {
		driver.toggleWifi();
	}

	public void location(AndroidDriver driver) {
		driver.toggleLocationServices();
	}

	public void setCLipBoard(AndroidDriver driver, String text) {
		driver.setClipboardText(text);
	}

	public void getCLipBoard(AndroidDriver driver) {
		driver.getClipboardText();
	}

	public void closingTheApplication(AndroidDriver driver, String packageName) {
		driver.terminateApp(packageName);
	}

	public void switchingContextByContext(AndroidDriver driver) {
		Set<String> contexts = driver.getContextHandles();
		for (String i : contexts) {

			if (i.contains("WEB_VIEW")) {
				driver.context(i);
				break;
			}
		}
	}

	public void switchContext(AndroidDriver driver, String contextid) {
		driver.context(contextid);
	}
	
	public void toggleMessage(AndroidDriver driver)
	{
		String mesg = driver.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getText();
		System.out.println(mesg);
	}
}
