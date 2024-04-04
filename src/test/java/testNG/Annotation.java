package testNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Selenium_Util;

public class Annotation extends Selenium_Util{
	
	@BeforeTest
	public void preCondition() {
		setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@Test(priority = 1)
	public void testOrangeHRM_LoginPage() {
		
		String expected="login";
		System.out.println(expected);
		String actual=driver.getCurrentUrl();
		System.out.println(actual);
		Assert.assertTrue(actual.contains(expected));
	}
	
	@Test(priority = 2)
	public void testOrangeHRM_LoginFlow() {
		typeInput(driver.findElement(By.name("username")),"Admin");
		typeInput(driver.findElement(By.name("password")),"admin123");		
		clickOnElement(driver.findElement(By.cssSelector(".orangehrm-login-button")));		
		String expected="dashboard";
		String actual=driver.getCurrentUrl();
		Assert.assertTrue(actual.contains(expected));
	}
	
	@AfterTest
	public void postCondition() {
		driver.close();
	}

}
