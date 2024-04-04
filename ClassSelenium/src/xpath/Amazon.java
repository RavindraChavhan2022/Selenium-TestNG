package xpath;

import org.openqa.selenium.By;

import locators.Base_Class;

public class Amazon extends Base_Class {

	public static void main(String[] args) {
		setUp();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Men Kurta");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).submit();
		
	}

}
