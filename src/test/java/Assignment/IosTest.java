package Assignment;

import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class IosTest {
	@Test
	public static void ioT_Test() {
	DesiredCapabilities dc = new DesiredCapabilities();
	HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
	browserstackOptions.put("projectName", "general Strore");
	browserstackOptions.put("buildName", "1.0");
	browserstackOptions.put("debug", "true");
	browserstackOptions.put("networkLogs", "true");
	dc.setCapability("bstack:options", browserstackOptions);
	dc.setCapability("platformName", "ios");
	dc.setCapability("platformVersion", "16");
	dc.setCapability("deviceName", "iPhone 14 Pro Max");
	dc.setCapability("app", "bs://1a8b30f598d8be61a1ca96ed63a4a0159b7d7546");


}
}
