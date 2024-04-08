package assignment1;

import org.openqa.selenium.By;

import locators.Base_Class;

public class Saucedemo2 extends Base_Class {

	public static void main(String[] args) {
		setUp();

		driver.get("https://www.saucedemo.com/");
		// Reading username from the screen
		String user = driver.findElement(By.xpath("//div[@id='login_credentials']")).getText();

		// Splitting the text and store into a String Array
		String[] lines = user.split("\\n");
		
		// Looping through the lines to find the desired username
		for (int i=0; i<lines.length; i++) {
			System.out.println(i);
			}
		}
	/*
		System.out.println("username to be enter : " + User_name);
		// Entering Username
		driver.findElement(By.id("user-name")).sendKeys(User_name);

		// Reading password from the screen
		String pass = driver.findElement(By.xpath("//div[@class='login_password']")).getText();
		// Splitting the text and store into a String Array
		String[] lines2 = pass.split("\\n");
		String Password = null;
		for (String st : lines2) {
			// Remove white spaces if any using trim() method
			if (st.trim().equals("secret_sauce")) {
				Password = st.trim();
				break;
			}
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

		tearDown();*/
	}

