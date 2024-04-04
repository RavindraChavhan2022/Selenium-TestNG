package multiple_Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import locators.Base_Class;

public class gsmarena extends Base_Class {

	public static void main(String[] args) {
		setUp();

		driver.get("https://www.gsmarena.com/");

		List<WebElement> phones = driver.findElements(By.cssSelector(".light>ul>li>a"));
		System.out.println("Total count of phones is : " + phones.size());
		System.out.println("Name of phones is : ");
		for (int i = 0; i < phones.size(); i++)
			System.out.println(phones.get(i).getText());

		tearDown();

	}

}
