package actions_Class;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locators.Base_Class;

public class Mouse_hover extends Base_Class {

	public static void main(String[] args) throws InterruptedException {
		setUp();
		driver.get("https://demo.automationtesting.in/Register.html");

		Actions action = new Actions(driver);
		// menu list
		List<WebElement> menuList = driver.findElements(By.cssSelector(".navbar-nav>li>a"));

		// hover on particular element like webtable
		// action.moveToElement(menuList.get(2)).perform();

		// to hover on all menu items one by one
		for (int i = 0; i < menuList.size(); i++) {
			Thread.sleep(1000);
			action.moveToElement(menuList.get(i)).perform();
		}

		tearDown();
	}

}
