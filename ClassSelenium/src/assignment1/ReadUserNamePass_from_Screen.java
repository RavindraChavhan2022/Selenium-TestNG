package assignment1;

import org.openqa.selenium.By;

import locators.Base_Class;

public class ReadUserNamePass_from_Screen extends Base_Class {

	public static void main(String[] args) {
		setUp();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Reading username from the screen
		String username = driver.findElement(By.xpath("//div[@class='orangehrm-login-form']/div/div/p[1]")).getText();
		System.out.println("Username is : " + username);
		String Username = username.substring(11);

		// Entering valid Username from screen
		driver.findElement(By.xpath("//div[@class='oxd-form-row']/div/div[2]/input[@name='username']"))
				.sendKeys(Username);

		// Reading password from the screen
		String pass = driver.findElement(By.xpath("//div[@class='orangehrm-login-form']/div/div/p[2]")).getText();
		System.out.println("Username is : " + pass);
		String Password = pass.substring(11);

		// Entering valid Password from screen
		driver.findElement(By.xpath("//div[@class='oxd-form-row']/div/div[2]/input[@name='password']")).sendKeys(Password);
		
		//Login with valid credentials
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Validation of Login 
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Login has been successful.");
		}else {
			System.out.println("Login has been not successful.");
		}
		
		tearDown();
	}

}
