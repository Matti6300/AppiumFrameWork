package DriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ToastHandle {
	@Test
	public void toastMesg() throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("UDID", "611e80f");
		dc.setCapability("deviceName", "onePlus");
		dc.setCapability("noReset", "true");
		dc.setCapability("autoGrantPermission", "true");
		dc.setCapability("ignoreHiddenApiPolicyError", "true");

		String packagename = "com.androidsample.generalstore";

		URL url = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.activateApp(packagename);
		WebElement Ele=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		Ele.click();
		String mesg = driver.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getText();
		System.out.println(mesg);
	}
}
