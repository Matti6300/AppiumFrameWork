package Assignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class frist_AssignmentTest {
	@Test
	public void swipingWithElementId_Test() throws MalformedURLException {
		
		/*
		 * DesiredCapabilities dc= new DesiredCapabilities();
		 * dc.setCapability("platformName", "android");
		 * dc.setCapability("automationName", "uiAutomator2");
		 * dc.setCapability("deviceName", "oneplus"); dc.setCapability("udid",
		 * "611e80f"); dc.setCapability("noReset", "true");
		 * dc.setCapability("autoGrantPermission", "true");
		 * dc.setCapability("ingnoreHiddenApiPolicyError", "true");
		 * dc.setCapability("appPackage", "io.appium.android.apis");
		 * dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		 * 
		 * 
		 * URL url= new URL("http://localhost:4723");
		 * 
		 * AndroidDriver driver= new AndroidDriver(url, dc);
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 */

		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("uidi", "611e80f");
		dc.setCapability("deviceName", "onePlus");
		dc.setCapability("noReset", "true");
		dc.setCapability("autoGrantPermission", "true");
		dc.setCapability("ignoreHiddenApiPolicyError", "true");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		URL url= new URL("http://localhost:4723");
		AndroidDriver driver= new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		WebElement element= driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));
		
		
	//((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"direction","right"));
		
		((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "direction", "right",
			    "speed", 500));
			
		
	}

}
