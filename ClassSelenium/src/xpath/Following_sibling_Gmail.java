package xpath;

import org.openqa.selenium.By;

import locators.Base_Class;

public class Following_sibling_Gmail extends Base_Class {

	public static void main(String[] args) {
		setUp();

		driver.get("https://www.google.com/");

		driver.findElement(By.xpath("//div[@class='o3j99 n1xJcf Ne6nSd']/style/following-sibling::div//a[@data-pid='23']")).click();

		tearDown();

	}

}
