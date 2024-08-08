package Assignment;

import static org.testng.Assert.assertEquals;

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
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class HMAsignment {

	@Test
	public void hm_Test() throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("uidi", "611e80f");
		dc.setCapability("deviceName", "onePlus");
		dc.setCapability("noReset", "true");
		dc.setCapability("autoGrantPermission", "true");
		dc.setCapability("ignoreHiddenApiPolicyError", "true");
		String packagename = "com.hm.goe";

		URL url = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.activateApp(packagename);

		driver.findElement(AppiumBy.id("com.hm.goe:id/action_search_button")).click();

		driver.hideKeyboard();

		WebElement element2 = driver
				.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")"));
		// element.click();
		driver.hideKeyboard();
		element2.sendKeys("tshirt");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		WebElement tshirt = driver
				.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Cotton T-shirt\")"));
		String SelectedItemName = tshirt.getText();
		tshirt.click();
		driver.findElement(AppiumBy.accessibilityId("Product Image")).click();
		WebElement element = driver.findElement(AppiumBy.id("com.hm.goe:id/carouselPhotoView"));
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", 0.75));

		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", 0.75));
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "left", 50, "top", 1346, "width",
						1052, "height", 1346, "direction", "left", "percent", 1));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.findElement(AppiumBy.accessibilityId("pdp_add_to_bag_new")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"S\")")).click();
		driver.findElement(AppiumBy.className("android.widget.Button")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.id("com.hm.goe:id/hm_shoppingbag_count")).click();
		Thread.sleep(5000);
		String itemNameInTheBag = driver
				.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Cotton T-shirt\")")).getText();
		assertEquals(itemNameInTheBag, SelectedItemName);
		System.out.println(itemNameInTheBag);
		System.out.println(SelectedItemName);
		driver.findElement(AppiumBy.accessibilityId("Remove")).click();
		driver.terminateApp(packagename);

	}

}
