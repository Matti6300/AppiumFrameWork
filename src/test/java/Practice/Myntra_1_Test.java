package Practice;

import java.io.File;
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
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Myntra_1_Test {
	@Test
	public void first_Test() throws MalformedURLException {

		File f = new File("C:\\Users\\bhara\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1")
				.usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("deviceName", "onePlus 9RT");
		dc.setCapability("udid", "611e80f");
		dc.setCapability("noReset", "false");
		dc.setCapability("autoGrantPermission", "true");
		dc.setCapability("ignoreHiddenApiPolicyError", "true");
		dc.setCapability("networkLogs", "true");

		URL url = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(url, dc);
		driver.activateApp("com.myntra.android");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(
				AppiumBy.xpath("//android.widget.TextView[@text=\"New\"]"))
				.click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"19:0bb1793a-058d-4f9a-8e21-8e5459b6c62a\")")).click();
				
		WebElement ele = driver
				.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"touchable_wishlist\"])[1]"));
		ele.click();
		if (ele.isSelected()) {
			System.out.println("selected");
		}
		else {
			System.out.println("not selected");
		}
		
		}

}
