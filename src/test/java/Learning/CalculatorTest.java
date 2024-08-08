package Learning;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorTest {
	
	@Test
	public void calculator() throws MalformedURLException {
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("deviceName", "onePlus");
		dc.setCapability("udid", "611e80f");
		dc.setCapability("noReset", "true");
		dc.setCapability("autoGrantPermission", "true");
		dc.setCapability("ignoreHiddenApiPolicyError", "true");
		dc.setCapability("appPackage", "com.oneplus.calculator");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
		
		
		URL u =new URL("http://localhost:4723");
		AndroidDriver adr= new AndroidDriver(u,dc);
		
		adr.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("hi");
		
		
		
		adr.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_7")).click();
		
		adr.findElement(AppiumBy.id("com.oneplus.calculator:id/img_op_mul")).click();
		
		adr.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_2")).click();
		String input= adr.findElement(AppiumBy.id("com.oneplus.calculator:id/formula")).getText();
		String output= adr.findElement(AppiumBy.id("com.oneplus.calculator:id/result")).getText();
		
		System.out.println(input);
		System.out.println(output);
		
		
		adr.findElement(AppiumBy.id("com.oneplus.calculator:id/formula")).clear();
		adr.findElement(AppiumBy.id("com.oneplus.calculator:id/img_eq")).click();
		adr.findElement(AppiumBy.id("com.oneplus.calculator:id/result")).clear();
		adr.quit();
		
	}

}
