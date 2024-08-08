package Gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SwipegesturesTest {
	@Test
	public void swippingGesture_test() throws MalformedURLException {
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

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)"))
				.click();
		/*
		 * driver.findElement(AppiumBy.xpath(
		 * "//android.view.ViewGroup[@content-desc=\"pdp_image_0\"]/android.view.ViewGroup/android.widget.ImageView[2]"
		 * )) .click();
		 */
		/*
		 * WebElement element = driver.findElement(AppiumBy.xpath(
		 * "//androidx.viewpager.widget.ViewPager[@resource-id=\"com.myntra.android:id/pager2\"]/android.widget.RelativeLayout/android.widget.ImageView"
		 * ));
		 */

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("left", 30, "top", 1300,
				"width", 1060, "height", 1300, "direction", "right", "percent", 1));

	}

}
