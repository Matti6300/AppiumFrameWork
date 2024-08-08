package com.android.ecom.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {

	public String getTheDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./Files/Commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

}
