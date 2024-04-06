package interviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import locators.Base_Class;

public class Count_SearchSuggestion extends Base_Class {

	public static void main(String[] args) {
		setUp();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");

		// identify all suggestions present in the page
		List<WebElement> suggestionList = driver.findElements(By.xpath("//ul/li"));

		System.out.println("Total suggestions in the page: " + suggestionList.size());

		for (int i = 0; i < suggestionList.size(); i++) {

			System.out.println("Suggestion: " + suggestionList.get(i).getText());
		}
		
		tearDown();
	}
}
