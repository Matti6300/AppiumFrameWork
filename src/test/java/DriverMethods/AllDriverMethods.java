package DriverMethods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class AllDriverMethods {
	
	
	@Test
	public void driverMethods() throws MalformedURLException, InterruptedException {
		
		
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("uidi", "611e80f");
		dc.setCapability("deviceName", "onePlus");
		dc.setCapability("noReset", "true");
		dc.setCapability("autoGrantPermission", "true");
		dc.setCapability("ignoreHiddenApiPolicyError", "true");
		String packagename = "io.appium.android.apis";
		
		URL url = new URL("http://localhost:4723");
		
		AndroidDriver driver= new AndroidDriver(url, dc);
		/*
		 * driver.activateApp(packagename); ScreenOrientation screnn=
		 * driver.getOrientation(); driver.rotate(screnn.LANDSCAPE); Thread.sleep(5000);
		 * 
		 * driver.rotate(screnn.PORTRAIT);
		 */
	 
	
	 driver.toggleData();
	 driver.toggleWifi();
	 //driver.toggleLocationServices();
	 driver.toggleAirplaneMode();
		
	}

}
