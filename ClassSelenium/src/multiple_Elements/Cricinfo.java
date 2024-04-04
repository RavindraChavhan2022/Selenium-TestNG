package multiple_Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import locators.Base_Class;

public class Cricinfo extends Base_Class {

	public static void main(String[] args) {
		setUp();

		driver.get("https://www.espncricinfo.com/");

		List<WebElement> items = driver.findElements(By.cssSelector(".ds-popper-wrapper>a"));
		System.out.println("Total count of main options is : " + items.size());

		System.out.print("Name List of options is : ");
		for (int i = 0; i < items.size(); i++)
			System.out.print(items.get(i).getText() + " , " );

		tearDown();

	}

}
