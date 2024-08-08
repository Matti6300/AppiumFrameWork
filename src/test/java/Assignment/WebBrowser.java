package Assignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class WebBrowser {
	
	@Test
	public void TC01() throws MalformedURLException {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("latest");
		HashMap<String, Object> Options= new HashMap<String, Object>();
		Options.put("build", "nothing_0.1");
		Options.put("name", "facebook");
		browserOptions.setCapability("sauce:options", Options);
		RemoteWebDriver driver= new RemoteWebDriver(new URL("https://bharathmatti_073W5P:xi2zo3UNHjD82ZS5HWjt@hub-cloud.browserstack.com/wd/hub"),browserOptions);
		driver.get("https://facebook.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	
	
	}

}
