package Gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ScrollTest {
	@Test
	public void scrollToElement() throws MalformedURLException {
		
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("uidi", "611e80f");
		dc.setCapability("deviceName", "onePlus");
		dc.setCapability("noReset", "true");
		dc.setCapability("autoGrantPermission", "true");
		dc.setCapability("ignoreHiddenApiPolicyError", "true");
		dc.setCapability("appPackage", "com.myntra.android");
		dc.setCapability("appActivity", ".activities.react.ReactActivity");

		URL url = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.findElement(AppiumBy.accessibilityId(null))
		
		/*
		 * driver.findElement(AppiumBy .xpath(
		 * "(//android.view.ViewGroup[@content-desc=\"TOPNAV_CAROUSEL_1_1\"])[2]/android.view.ViewGroup"
		 * )) .click();
		 */
		
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"COTTON\"));")).click();
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(id(\"PRODUCT_GRID_3_1\"));")).click();
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().xpath(\"//android.view.ViewGroup[@content-desc=\"VIDEO_RACK_1_1\"]/android.view.ViewGroup[4]\"));")).click();  
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(xpath(\"//android.view.ViewGroup[@content-desc=\"VIDEO_RACK_1_1\"]/android.view.ViewGroup[4]\"));")).click();	
	}

}
