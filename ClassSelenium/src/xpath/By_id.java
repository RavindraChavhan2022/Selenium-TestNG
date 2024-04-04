package xpath;

import org.openqa.selenium.By;

import locators.Base_Class;

public class By_id extends Base_Class{

	public static void main(String[] args) {
		// Inheriting method from Base_Class
		setUp();
		
		driver.get("https://online.actitime.com/tcs/login.do");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Ajay2024");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("Ravindra");
		
		System.out.println("Is checkbox functional ? " + driver.findElement(By.xpath("//input[@value='on']")).isEnabled());
		driver.findElement(By.xpath("//input[@value='on']")).click();
		
		System.out.println("Is checkbox selected ? " + driver.findElement(By.xpath("//input[@value='on']")).isSelected());
		//relative XPath using normalize-space() for Login button
		driver.findElement(By.xpath("//div[normalize-space(text()) = 'Login']")).click();
		
		tearDown();

	}

}


//relative XPath syntax --> //tagname[@attribute='value']