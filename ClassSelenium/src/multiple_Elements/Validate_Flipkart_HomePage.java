package multiple_Elements;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import locators.Base_Class;

public class Validate_Flipkart_HomePage extends Base_Class {

	public static void main(String[] args) {
		setUp();

		driver.get("https://www.flipkart.com/");
		String expectedTitle = "Online Shopping India Mobile, Cameras, Lifestyle & more Online @ Flipkart.com";
		String actualTitle = driver.getTitle();
		System.out.println("Actual title is : " + actualTitle);
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("HomePage title is correct.");
		} else {
			System.out.println("HomePage title is not correct.");
		}
		List<WebElement> items = driver.findElements(By.cssSelector("._3sdu8W ._1XjE3T>span:nth-of-type(1)"));
		System.out.println("Total count of main options is : " + items.size());
		
		//xpath = //span[@class='_1XjE3T']

		System.out.println("Name List of options is : ");
		for (int i = 0; i < items.size(); i++)
			System.out.println(items.get(i).getText());

		tearDown();
	}

}
