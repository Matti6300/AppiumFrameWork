package Gestures;

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

public class ZoomInZoomOutTest {

	@Test
	public void zoomInZoomOut_Test() throws MalformedURLException {

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

		driver.findElement(AppiumBy
				.xpath("(//android.view.ViewGroup[@content-desc=\"TOPNAV_CAROUSEL_1_1\"])[2]/android.view.ViewGroup"))
				.click();
		driver.findElement(AppiumBy.xpath(
				"(//android.view.ViewGroup[@content-desc=\"image_image_container\"])[1]/android.view.ViewGroup/android.widget.ImageView"))
				.click();

		// ((JavascriptExecutor)driver).executeScript("mobile: clickGesture",
		// ImmutableMap.of("x",500, "y",1000));
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)"))
				.click();
		// driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"pdp_image_0\"]/android.view.ViewGroup/android.widget.ImageView[2]")).click();
		WebElement element = driver.findElement(AppiumBy.xpath(
				"//androidx.viewpager.widget.ViewPager[@resource-id=\"com.myntra.android:id/pager2\"]/android.widget.RelativeLayout/android.widget.ImageView"));
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
		/*
		 * ((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",
		 * ImmutableMap.of( "elementId", ((RemoteWebElement) element).getId(),
		 * "percent", 0.75 ));
		 * 
		 * ((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",
		 * ImmutableMap.of( "elementId", ((RemoteWebElement) element).getId(),
		 * "percent", 0.75 ));
		 */

	}

}
