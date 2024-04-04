package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Validation_of_components extends Base_Class {

	public static void main(String[] args) {
		// As method setUp() is static, we can call it directly
		setUp();
		
		//opening of Url- web site
		driver.get("https://online.actitime.com/tcs/login.do");
		
		/*
		 Validation of - User name input
		 * 	- visible or not   ----> isDisplay()
		 *  - functional or not----> isEnabled()
		 *  - default value ------> getAttribute()
		 */
		System.out.println("Is user name input field visible? " + driver.findElement(By.name("username")).isDisplayed());
		
		System.out.println("Is user name input field functional/editable? " + driver.findElement(By.name("username")).isEnabled());
		
		System.out.println("Is user name input field default visible text is : " + driver.findElement(By.name("username")).getAttribute("placeholder")); 
		// OR
		//System.out.println("Is user name input field default visible text is : " + ((WebElement) driver).getAttribute("placeholder")); 
		
		System.out.println("\n***************************************************************");
		
		// Validation of- check box 
		System.out.println("Is checkbox visible? "+ driver.findElement(By.id("keepLoggedInCheckBox")).isDisplayed());
		System.out.println("Is checkbox functional/clickable ? "+ driver.findElement(By.id("keepLoggedInCheckBox")).isEnabled());
		System.out.println("Is checkbox by default selected ? "+ driver.findElement(By.id("keepLoggedInCheckBox")).isSelected());
		
		// Select the check box by clicking on it
		driver.findElement(By.id("keepLoggedInCheckBox")).click();
		
		//Check whether check box is selected or not after clicking
		System.out.println("After click, is checkbox selected? "+ driver.findElement(By.id("keepLoggedInCheckBox")).isSelected());
		
		// OR
		/*
		WebElement checkbox=driver.findElement(By.id("keepLoggedInCheckBox"));
		System.out.println("is checkbox visible? "+checkbox.isDisplayed());
		System.out.println("is checkbox functional/clickable? "+checkbox.isEnabled());
		System.out.println("is checkbox by default selected? "+checkbox.isSelected());
		checkbox.click();
		System.out.println("after click, is checkbox selected? "+checkbox.isSelected());
		*/
		
		System.out.println("\n***************************************************************");
		
		// Validate Login button
		WebElement loginButton=driver.findElement(By.className("initial"));
		System.out.println("Is loginButton visible? "+loginButton.isDisplayed());
		System.out.println("Is loginButton functional/clickable? "+loginButton.isEnabled());
		System.out.println("loginButton text- "+loginButton.getText());
		
		// As method tearDown() is static, we can call it directly
		tearDown();
	}

}
