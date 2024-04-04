package testNG;  
import org.testng.annotations.Test;

import utilities.Selenium_Util;

public class Priority extends Selenium_Util {
	@Test(priority = 2)
	public void openOrangeHRM() {
		driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Page title: " + driver.getTitle());
	}

	@Test(priority = 4)
	public void openGoogle() {
		driver = setUp("chrome", "https://www.google.com");
		System.out.println("Page title: " + driver.getTitle());
	}

	@Test(priority = 1)
	public void openSwagLabs() {
		driver = setUp("chrome", "https://www.saucedemo.com/");
		System.out.println("Page title: " + driver.getTitle());
	}

	@Test(priority = 3)
	public void openActitime() {
		driver= setUp("chrome", "https://online.actitime.com/tcs/login.do");
		System.out.println("Page title: " + driver.getTitle());
	}
}



/* - priority: will help to decide execution order of @Test
 * 				default priority is 0
 * 				lowest priority will get 1st preference
 * 				if more than one @Test method has same priority than alphabetical order

*/