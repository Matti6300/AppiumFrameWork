package DriverMethods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class CommdingServerThroughScript {
	
	@Parameters({"deviceName","UDID","port"})
	@Test
	public void CSTScript(String deviceName, String UDID, int port ) throws MalformedURLException{
		
		File f= new File("C:\\Users\\bhara\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service= new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(port).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		UiAutomator2Options ap = new UiAutomator2Options();
		ap.setPlatformName("Android");
		ap.setAutomationName("uiAutomator2");
		ap.setDeviceName(deviceName);
		ap.setUdid(UDID);
		ap.setNoReset(true);
		ap.setIgnoreHiddenApiPolicyError(true);
		ap.setAutoGrantPermissions(true);
		
		URL url = new URL("http://localhost:"+port+"");
		AndroidDriver driver = new AndroidDriver(url, ap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.activateApp("io.appium.android.apis");
		
		
	} 

}
