package Css_Selector;

import org.openqa.selenium.By;

import locators.Base_Class;

public class Any_attribute extends Base_Class {

	public static void main(String[] args) {
		setUp();
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.cssSelector("input[data-testid='royal_email']")).sendKeys("9595795842");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Vision@2020");
		driver.findElement(By.cssSelector("button[name='login']")).click();
		
		tearDown();
	}

}
