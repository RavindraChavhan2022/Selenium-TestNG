package assertions;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testNG.Base_Class;

public class Soft_Assertion extends Base_Class {
	SoftAssert softAssert;
	@BeforeMethod
	public void openUrl() {
		setUp();
		driver.get("https://www.amazon.in/");
	    softAssert = new SoftAssert();
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

	@Test()
	public void validateAmazon() {
		
		//Validating Title
		String expected_title = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"; // excel
		String actual_title = driver.getTitle();
		softAssert.assertEquals(actual_title, expected_title, "Title doesn't match");
		
		//Validating Url
		String expectedUrl = "https://www.amazon.com/";
        String actualUrl = driver.getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "URL doesn't match");
        
        softAssert.assertAll();

	}

}
