package dropDown_Handling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import locators.Base_Class;

public class WikiPedia_Dropdown extends Base_Class {

	public static void main(String[] args) {
		
		setUp();
		
		driver.get("https://www.wikipedia.org/");

		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		
		Select select = new Select(dropdown);

		// select.selectByVisibleText("Eesti");
		select.selectByVisibleText("हिन्दी");
				
		List<WebElement> values = dropdown.findElements(By.tagName("option"));

		// 0 - size-1(61-1=60)
		System.out.println("Total values are : " + values.size());

		System.out.println(values.get(7).getText());

		for (int i = 0; i < values.size(); i++) {

			System.out.println(values.get(i).getAttribute("lang"));
		}
		
		tearDown();
	}
}
