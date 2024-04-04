package xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.Base_Class;

public class By_contains extends Base_Class {

	public static void main(String[] args) {
		setUp();
		
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.xpath("//input[contains(@data-testid, 'royal_email')]")).sendKeys("9595795842");
		
		driver.findElement(By.xpath("//input[contains(@aria-label, 'Password')]")).sendKeys("Vision2020");
		
		driver.findElement(By.name("login")).click();
		
		
		
	}

}
