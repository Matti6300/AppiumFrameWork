package DriverMethods;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class EmulatorThroughScript {
	public static void main(String[] args) throws IOException {
		
		
		String command="emulator -avd emulator-5554 -netdelay none -netspeed full";
		ProcessBuilder process=new ProcessBuilder(command);
		process.redirectErrorStream(true);
		Process pro=process.start();
		
	
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		//dc.setCapability("uidi", "611e80f");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("noReset", "true");
		dc.setCapability("autoGrantPermission", "true");
		dc.setCapability("ignoreHiddenApiPolicyError", "true");
		
		AndroidDriver driver= new AndroidDriver(new URL("http://localhost:4723"),dc);
		
		
	}

}
