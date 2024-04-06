package interviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import locators.Base_Class;

public class Find_NumberOf_Links_On_Page extends Base_Class {

	public static void main(String[] args) {
		setUp();
		driver.get("https://www.wikipedia.org/");
	//	driver.findElement(By.name("q")).sendKeys("Elections", Keys.ENTER);

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total links are: " + links.size());

		for (WebElement link : links) {

			System.out.println(link.getText() + " -- URL IS ---" + link.getAttribute("href"));
		}
		
		tearDown();

	}

}