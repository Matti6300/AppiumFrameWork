package DriverMethods;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HidingKeyBoard {

	@Test
	public void hiddingKeyBoard() throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("uidi", "611e80f");
		dc.setCapability("deviceName", "onePlus");
		dc.setCapability("noReset", "true");
		dc.setCapability("autoGrantPermission", "true");
		dc.setCapability("ignoreHiddenApiPolicyError", "true");
		String packagename = "com.androidsample.generalstore";

		URL url = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.activateApp(packagename);
		
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"))
				.click();
		WebElement ele = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
		ele.click();
		Thread.sleep(2000);
		driver.hideKeyboard();
		ele.sendKeys("bharath");
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		//Thread.sleep(5000);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.terminateApp(packagename);

	}

}
