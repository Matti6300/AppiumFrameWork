package Assignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BSMobileBrowser {
	public static final String url = "https://bharathmatti_073W5P:xi2zo3UNHjD82ZS5HWjt@hub-cloud.browserstack.com/wd/hub";
	@Test
	public void TC01() throws MalformedURLException
	{
		MutableCapabilities mc= new MutableCapabilities();
		HashMap<String, Object>browserstackOptions =new HashMap<String, Object>();
		browserstackOptions.put("browserName", "chrome");
		browserstackOptions.put("deviceName", "Samsung Galaxy S22 Ultra");
		browserstackOptions.put("osVersion", "12.0");
		browserstackOptions.put("projectName", "general Strore");
		browserstackOptions.put("buildName", "1.0");
		browserstackOptions.put("debug", "true");
		browserstackOptions.put("networkLogs", "true");
		//browserstackOptions.put("browserName", "chrome");
		mc.setCapability("bstack:options", browserstackOptions);
		WebDriver driver= new RemoteWebDriver(new URL(url),mc);
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
