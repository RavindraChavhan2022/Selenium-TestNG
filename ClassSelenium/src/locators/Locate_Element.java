package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locate_Element {

	public static void main(String[] args) {
		// Create an instance of ChromeDriver class and upcast it to WebDriver interface
		WebDriver driver = new ChromeDriver();

		// enter application URL
		driver.get("https://www.saucedemo.com/");

		// identify user name input field
		WebElement usernameInputField = driver.findElement(By.id("user-name"));
		
		// type username as standard_user
		usernameInputField.sendKeys("standard_user");

		// indetify password input field
		WebElement passwordInputfield = driver.findElement(By.name("password"));
		// type password as secret_sauce
		passwordInputfield.sendKeys("secret_sauce");

		// identify login button
		WebElement loginBtn = driver.findElement(By.className("submit-button"));
		// click on login button
		loginBtn.click();

	}

}

/*
 * Locator: is a concept to identify the object from application opened in browser
 * 
 * To identify the object from application we use findElement(By)
 * 
 * findElement(By):- is a method with parameter as By class, where By is a predefined class which has several static methods. 
 * findElement(By)- help use to identify the element using "By." class predefined methods which are also known as locators and return the WebElement.
 * 
 * WebElement element =driver.findElementBy.id(String) By.name(String)
 * By.linkText(String) 
 * By.partialLinkText(String) 
 * By.tagName(String)
 * By.className(String) 
 * By.cssSelector(String) 
 * By.xpath(String) - 
 * this method return WebElement
 * 
 * Step2: once you identify the WebElement you can perform required operation it
 * a. type text ----> sendkeys(""); 
 * b. delete existing text ----> clear(); 
 * c. click on element ----> click();
 * 
 * element.sendkeys("amdin"); 
 * element.clear(); 
 * element.click();
 */
