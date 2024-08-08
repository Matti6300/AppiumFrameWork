package DriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class BackUGround_Test {
	String Packagename = "com.androidsample.generalstore";

	@Test
	public void background_Test() throws MalformedURLException {

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
		driver.activateApp(Packagename);
		System.out.println(driver.currentActivity());
		driver.runAppInBackground(Duration.ofSeconds(5));
		driver.activateApp("io.appium.android.apis");
		System.out.println(driver.queryAppState(Packagename));

		System.out.println(driver.queryAppState("io.appium.android.apis"));
		driver.terminateApp(Packagename);
		System.out.println(driver.queryAppState(Packagename));
		driver.terminateApp("io.appium.android.apis");

	}

}
