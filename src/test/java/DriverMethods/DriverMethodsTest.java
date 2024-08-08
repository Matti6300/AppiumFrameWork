package DriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class DriverMethodsTest {

	@Test

	public void installAndUnInstall_Test() throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("deviceName", "Oneplus");
		dc.setCapability("uidi", "611e80f");
		dc.setCapability("noReset", "true");
		dc.setCapability("autoGrantPermission", "true");
		dc.setCapability("ignoreHiddenApiPolicyError", "true");

		URL url = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.installApp("C:\\Users\\bhara\\Downloads\\General-Store.apk");
		System.out.println(driver.isAppInstalled("com.androidsample.generalstore"));
		// driver.removeApp("com.androidsample.generalstore");
		System.out.println(driver.isAppInstalled("com.androidsample.generalstore"));

	}

}
