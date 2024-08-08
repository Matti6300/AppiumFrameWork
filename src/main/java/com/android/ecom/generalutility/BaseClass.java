package com.android.ecom.generalutility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.android.ecom.driverUtility.DriverUtilities;
import com.android.ecom.fileutility.PropertyUtility;
import com.android.ecom.gestureUtility.Gestureutilities;
import com.android.ecom.pomclasses.CartPage;
import com.android.ecom.pomclasses.LoginPage;
import com.android.ecom.pomclasses.ProductPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public PropertyUtility pu = new PropertyUtility();
	public DriverUtilities du = new DriverUtilities();
	public Gestureutilities gu=new Gestureutilities();

	public LoginPage lp;
	public ProductPage pp;
	public CartPage cp;

	public AndroidDriver driver;
	AppiumDriverLocalService service;

	public static AndroidDriver sdriver;

	@BeforeSuite
	public void StartingTheServer() {
		File f = new File("C:\\Users\\bhara\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		service = new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723)
				.withTimeout(Duration.ofSeconds(300)).build();
		service.start();
	}

	@BeforeClass
	public void SettingCapabilities() throws IOException {

		System.out.println("hi");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", pu.getTheDataFromPropertyFile("platformName"));
		dc.setCapability("automationName", pu.getTheDataFromPropertyFile("automtionName"));
		dc.setCapability("uidi", pu.getTheDataFromPropertyFile("uidi"));
		dc.setCapability("deviceName", pu.getTheDataFromPropertyFile("deviceName"));
		dc.setCapability("noReset", true);
		dc.setCapability("autoGrantPermission", true);
		dc.setCapability("ignoreHiddenApiPolicyError", true);

		

		URL url = new URL("http://localhost:4723");

		driver = new AndroidDriver(url, dc);
		sdriver = driver;
       
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);
		cp = new CartPage(driver);

		
		
		
	}
	@BeforeMethod
	public void lauchingTheApp() throws IOException {
		String packagename = pu.getTheDataFromPropertyFile("appPackage");
		System.out.println(packagename);
		du.runApp(driver, packagename);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@AfterMethod
	public void closingTheApp() throws IOException{
		du.closingTheApplication(driver, pu.getTheDataFromPropertyFile("appPackage"));
	}

	@AfterClass
	public void closingTheApplication() throws IOException {
		System.out.println("nothing is here");
		
		//du.closingTheApplication(driver, pu.getTheDataFromPropertyFile("appPackage"));

	}

	@AfterClass
	public void closingTheServer() {
		service.close();
	}

}
