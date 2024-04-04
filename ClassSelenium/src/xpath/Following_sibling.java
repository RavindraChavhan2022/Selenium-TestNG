package xpath;

import org.openqa.selenium.By;

import locators.Base_Class;

public class Following_sibling extends Base_Class {

	public static void main(String[] args) {
		setUp();

		driver.get("https://www.amazon.in/gift-card-store/b/?ie=UTF8&node=3704982031&ref_=nav_cs_gc\r\n");

		driver.findElement(By.xpath("//a[span[text()='Birthday']]/div/label/i")).click();

		tearDown();

	}

}
