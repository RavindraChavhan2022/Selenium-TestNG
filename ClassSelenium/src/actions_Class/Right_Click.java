package actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locators.Base_Class;

public class Right_Click  extends Base_Class {

	public static void main(String[] args) {
		setUp();
		
		driver.get("https://deluxe-menu.com/popup-mode-sample.html");
		//Locating element by xpath
	
		WebElement img = driver.findElement(By.xpath("//img[@src='data-samples/images/popup_pic.gif']"));
		//Creating instance of Actions Class
		Actions action = new Actions(driver);
		action.contextClick(img).perform();

	}

}
