package assertions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testNG.Base_Class;

public class assertEquals extends Base_Class {

	@BeforeMethod
	public void openUrl() {
		setUp();
		driver.get("https://www.amazon.in/");
	}

	@Test(priority=2)
	public void validateHomePageTitle() {
		String actual_Title = driver.getTitle();
		System.out.println("Actual title is : " + actual_Title);

		String expected_Title = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

		// Validating title using aeertEquals() instead of if else
		Assert.assertEquals(actual_Title, expected_Title);
	}

	@Test(priority=1)
	public void validateUrl() {
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Actual URL is : " + actualUrl);

		String expected_Url = "https://www.amazon.com/";
		
		// Validating URL using aeertEquals() instead of if else
	//	Assert.assertEquals(actualUrl, expected_Url);  // Test failed as both Urls are not equal.
	// OR
		Assert.assertTrue(actualUrl.contains(expected_Url), "URLs do not match");	
	}
	
	@Test(priority=3)
	public void validateMakeMyTrip() {
		driver.navigate().to("https://www.makemytrip.com/");
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Actual URL is : " + actualUrl);
		
		String expecteUrl = "https://www.makemytrip.com/";
		Assert.assertTrue(actualUrl.equals(expecteUrl),"URLs do not match");
	
	}
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
