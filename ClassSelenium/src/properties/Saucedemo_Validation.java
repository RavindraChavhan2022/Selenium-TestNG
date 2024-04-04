package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

import locators.Base_Class;

public class Saucedemo_Validation extends Base_Class {

	public static void main(String[] args) throws IOException {
		setUp();
		FileInputStream fis = new FileInputStream(".\\Property-File\\Test_Data.properties");
		Properties prop = new Properties();
		prop.load(fis);

		driver.get(prop.getProperty("URL"));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// Adding items to the shopping Cart
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.cssSelector(".shopping_cart_link")).click();
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();

		// Filling Our Information
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(prop.getProperty("FirstName"));
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(prop.getProperty("LastName"));
		driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys(prop.getProperty("Zip/PostalCode"));
		driver.findElement(By.xpath("//input[@data-test='continue']")).click();

		// Final submission
		driver.findElement(By.xpath("//button[@data-test='finish']")).click();

		// Validation of order Confirmation message
		String confirmationMessage = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).getText();
		String expectedconfirmationMessage = "Thank you for your order!";

		if (confirmationMessage.equals(expectedconfirmationMessage)) {
			System.out.println("Your order has been placed and dispatched.");
		} else {
			System.out.println("Order has not been placed. If amount deducted it will be refunded");
		}

		tearDown();
	}
}
