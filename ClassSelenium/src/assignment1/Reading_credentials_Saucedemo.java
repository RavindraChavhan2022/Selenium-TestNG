package assignment1;

import org.openqa.selenium.By;

import locators.Base_Class;

public class Reading_credentials_Saucedemo extends Base_Class {

	public static void main(String[] args) {
		setUp();

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

		// Validation og Login
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Swag Labs";
		
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Login has been successful.");
		} else {
			System.out.println("Login has been not successful.");
		}

		tearDown();

	}

}
