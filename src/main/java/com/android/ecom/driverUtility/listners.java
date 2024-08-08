package com.android.ecom.driverUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.android.ecom.generalutility.BaseClass;

public class listners implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String time = 	new Date().toString().replace(" ", "_").replace(":", "_");
		String name= result.getMethod().getMethodName();
		TakesScreenshot sh= (TakesScreenshot)BaseClass.sdriver;
		File src = sh.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Files/"+name+time+".png");
		try {
			FileUtils.copyDirectory(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
			
		
	

}

