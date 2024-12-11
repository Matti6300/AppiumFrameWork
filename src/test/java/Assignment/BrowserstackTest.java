package Assignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class BrowserstackTest {

	public static final String url = "https://mattibharath_BGN3gi:TrYwhr3vsYLztmak7StS@hub-cloud.browserstack.com/wd/hub";
	@Parameters({"deviceName","version"})
	@Test
	public void TC01(String deviceName, String version) throws MalformedURLException, InterruptedException {
        
		DesiredCapabilities dc = new DesiredCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("projectName", "general Strore");
		browserstackOptions.put("buildName", "4.0");
		browserstackOptions.put("debug", "true");
		browserstackOptions.put("networkLogs", "true");
		dc.setCapability("bstack:options", browserstackOptions);
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", version);
		dc.setCapability("deviceName", deviceName);
		dc.setCapability("app", "bs://86a39e60644f348314add1892c977cfea883d6eb");

		AndroidDriver driver = new AndroidDriver(new URL(url), dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(AppiumBy.className("android.widget.EditText")).click();
				
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Bharath");
		driver.hideKeyboard();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.terminateApp("com.androidsample.generalstore");
		
	}
}
