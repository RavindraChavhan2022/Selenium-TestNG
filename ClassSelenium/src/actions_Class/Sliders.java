package actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locators.Base_Class;

public class Sliders extends Base_Class {

	public static void main(String[] args) {
		setUp();

		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		
		WebElement mainslider = driver.findElement(By.id("slider"));
		int width = mainslider.getSize().width/2;
		
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']"));
		new Actions(driver).dragAndDropBy(slider, width, 0).perform();
	}

}
