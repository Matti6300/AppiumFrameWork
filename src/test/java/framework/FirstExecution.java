package framework;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.android.ecom.generalutility.BaseClass;
@Listeners(com.android.ecom.driverUtility.listners.class)
public class FirstExecution extends BaseClass {

	@Test
	public void TC1() throws InterruptedException {

		lp.login(driver, "Bharath", "India");
		
	}

	@Test
	public void TC2() {
		lp.skipLogin();
	}

}
