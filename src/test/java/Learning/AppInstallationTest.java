package Learning;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class AppInstallationTest {
	
	
	
	@Test
	public void instrallation_Test() throws MalformedURLException
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("uidi", "611e80f");
		dc.setCapability("deviceName", "onePlus");
		dc.setCapability("noReset", "true");
		dc.setCapability("autoGrantPermission", "true");
		dc.setCapability("ignoreHiddenApiPolicyError", "true");
		
		dc.setCapability("app", "C:\\Users\\bhara\\Downloads\\com.davemorrissey.labs.subscaleview.sample.apk");
		URL url= new  URL("http://localhost:4723");
		
		AndroidDriver driver= new AndroidDriver(url,dc);

		
		
		
		
	}

}
