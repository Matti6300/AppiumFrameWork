package DriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Context {

	@Test
	public void context_Test() throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("uidi", "611e80f");
		dc.setCapability("deviceName", "onePlus");
		dc.setCapability("noReset", "true");
		dc.setCapability("autoGrantPermission", "true");
		dc.setCapability("ignoreHiddenApiPolicyError", "true");
		//String packagename = "com.androidsample.generalstore";

		URL url = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.activateApp("com.clinicia.activity");
	}
}
		// driver.findElement(AppiumBy.id("android:id/text1")).click();
		/*
		 * driver.findElement( AppiumBy.
		 * androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"
		 * )) .click();
		 
		WebElement ele = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
		ele.click();
		Thread.sleep(2000);
		driver.hideKeyboard();
		ele.sendKeys("bharath");
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		// Thread.sleep(5000);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElement(AppiumBy.xpath(
				"//android.support.v7.widget.RecyclerView[@resource-id=\"com.androidsample.generalstore:id/rvProductList\"]//android.widget.RelativeLayout[1]//android.widget.LinearLayout[2]//android.widget.TextView[@text=\"ADD TO CART\"]"))
				.click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.FrameLayout\").instance(3)"))
				.click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(3000);
		Set<String> Contexthandles = driver.getContextHandles();
		System.out.println(Contexthandles.size());
		Thread.sleep(3000);
		for (String i : Contexthandles) {

			System.out.println(i);

		}
		driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys("facebook");

	}

}*///android.support.v7.widget.RecyclerView//android.widget.RelativeLayout[2]//android.widget.LinearLayout[2]//android.widget.TextView[@text="ADD TO CART"]
