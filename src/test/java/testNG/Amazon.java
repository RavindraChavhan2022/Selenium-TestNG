package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Amazon extends Base_Class{
	
	@BeforeMethod
	public void openBrowser() {
		setUp();
	}
	
	@AfterMethod
	public void close() {
		tearDown();
	}
	
	@Test
	public void openUrl() {
		driver.get("https://www.amazon.in/");
	}

}
