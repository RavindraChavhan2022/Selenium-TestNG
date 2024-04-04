package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Password_Validation extends Base_Class {

	public static void main(String[] args) {
		
		//Calling setUp() methods from Base_Class to open browser
		setUp();
		// opening of Url- web site
		driver.get("https://online.actitime.com/tcs/login.do");
		
		//Validation of password input field
        System.out.println("Is password input field visible? " + driver.findElement(By.name("pwd")).isDisplayed());
		
		System.out.println("Is password input field functional/editable? " + driver.findElement(By.name("pwd")).isEnabled());
		
		System.out.println("What is the password input field default visible text ? : " + driver.findElement(By.name("pwd")).getAttribute("placeholder")); 
		
		//Validation of forgot password
		WebElement forgot=driver.findElement(By.id("toPasswordRecoveryPageLink"));
		System.out.println("Is forgotButton visible ? " + forgot.isDisplayed());
		System.out.println("Is forgotButton functional/clickable ? " + forgot.isEnabled());
		System.out.println("forgotButton text is- " + forgot.getText());
		
		// Calling method tearDown() to close the browser
		tearDown();

	}

}
