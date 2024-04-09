package testNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Saucedemo extends Base_Class {

	@BeforeTest
	public void openBrowser_Url() {
		setUp();
	}

	@Test
	public void login() {
		driver.get("https://www.saucedemo.com/");

		// Reading username from the screen
		String user = driver.findElement(By.xpath("//div[@id='login_credentials']")).getText();

		// Splitting the text and store into a String Array
		String[] lines = user.split("\\n");
		/*
		 * Get the number of lines created by splitting a Full String
		 * System.out.println("Total number of lines are : " + lines.length);
		 * System.out.println(lines + " ");
		 */
		String User_name = null;
		// Remove white spaces if any using trim() method
		if (lines.length > 1) {
			User_name = lines[1].trim();
		}
		System.out.println("username to be enter : " + User_name);
		// Entering Username
		driver.findElement(By.id("user-name")).sendKeys(User_name);

		// Reading password from the screen
		String pass = driver.findElement(By.xpath("//div[@class='login_password']")).getText();
		// Splitting the text and store into a String Array
		String[] lines2 = pass.split("\\n");
		String Password = null;
		if (lines2.length > 1) {
			Password = lines2[1].trim();
		}
		System.out.println("Password to be enter : " + Password);
		// Entering Password
		driver.findElement(By.id("password")).sendKeys(Password);

		// Click on Login button
		driver.findElement(By.id("login-button")).click();
	}

	@Test
	public void validateLogin() {
		// Validation og Login
		String actualTitle = driver.getTitle();
		System.out.println("Actual Title is : " + actualTitle);
		String expectedTitle = "Swag Labs";

		// Validating title using aeertEquals() instead of if else
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@AfterTest
	public void closebrowser() {
		tearDown();

	}

}
