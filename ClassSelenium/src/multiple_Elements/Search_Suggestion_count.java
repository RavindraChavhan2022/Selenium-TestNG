package multiple_Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import locators.Base_Class;

public class Search_Suggestion_count extends Base_Class {

	public static void main(String[] args) {
		setUp();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");

		// identify all suggestions present in the page
		List<WebElement> suggestionList = driver
				.findElements(By.cssSelector("ul.G43f7e>li>div>div:nth-of-type(2)>*:first-child>*:first-child>span"));

		System.out.println("Total suggestions in the page: " + suggestionList.size());

		for (int i = 0; i < suggestionList.size(); i++) {

			// to avoid StaleElementReferenceException, re-identify suggestionList
			suggestionList = driver.findElements(
					By.cssSelector("ul.G43f7e>li>div>div:nth-of-type(2)>*:first-child>*:first-child>span"));
			System.out.println("Suggestion: " + suggestionList.get(i).getText());

		}

	}

}
