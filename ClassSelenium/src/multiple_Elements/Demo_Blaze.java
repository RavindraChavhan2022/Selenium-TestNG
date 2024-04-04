package multiple_Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import locators.Base_Class;

public class Demo_Blaze extends Base_Class {

	public static void main(String[] args) {
		setUp();
		driver.get("https://tutorialsninja.com/demo/");

		// identify all images present in the page
		List<WebElement> deviceList = driver.findElements(By.cssSelector("#content>div.row>div h4>a"));

		System.out.println("Total devices on the page: " + deviceList.size());

		for (int i = 0; i < deviceList.size(); i++) {

			System.out.println("Device name: " + deviceList.get(i).getText());

		}

		System.out.println("*******************************");

		List<WebElement> devicePrice = driver.findElements(By.cssSelector("#content>div.row>div div>div p.price"));
		for (int p = 0; p < devicePrice.size(); p++) {

			System.out.println("Device Price: " + devicePrice.get(p).getText());

		}
	}
}
