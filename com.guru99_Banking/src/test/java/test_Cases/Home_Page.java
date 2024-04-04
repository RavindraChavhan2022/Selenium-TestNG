package test_Cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Home_Page extends Base_Test {

	@BeforeMethod
	public void setUp() {
		openBrowser_And_Url();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=1)
	public void verifyUrl() {
		String expectedUrl = "https://www.demo.guru99.com/V4/";
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		//Verifying both Url are same
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	@Test(priority=2)
	public void verifyTitle() {
		String expected_Title = "Guru99 Bank Home Page";
		String actual_Title = driver.getTitle();
		System.out.println("HomePage title is : " + actual_Title);
		Assert.assertEquals(actual_Title, expected_Title);
	}
	

}
