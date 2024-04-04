package Css_Selector;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.Base_Class;

public class Class_attribute2 extends Base_Class {

	public static void main(String[] args) {
		setUp();
		driver.get("https://www.flipkart.com");

		List<WebElement> deviceList = driver.findElements(By.cssSelector(".emupdz ._1XjE3T"));

		System.out.println("Total device in the page: " + deviceList.size());

		for (int i = 0; i < deviceList.size(); i++) {

			deviceList = driver.findElements(By.cssSelector(".emupdz ._1XjE3T"));

			System.out.println("Device name: " + deviceList.get(i).getText());
			// OR
			/*
			 * WebElement device=deviceList.get(i); String name = device.getText;
			 * System.out.println("Device name: "+name);
			 */
		}

		tearDown();

	}

}
