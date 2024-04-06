package interviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import locators.Base_Class;

public class Finding_XPath_of_Google_Using_Following_sibling extends Base_Class{

	public static void main(String[] args) {
		setUp();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//div[@id='gb']/div/div/following-sibling::div//a[@class='gb_d']")).click();
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='ngVsM u4RcUd']/li/a/div/following-sibling::span"));

		System.out.println("Total options in Google apps: " + options.size());

		for (int i = 0; i < options.size(); i++) {
			System.out.println("Options names : " + options.get(i).getText());
		}
		/* OR
		for (WebElement option : options) {
		    System.out.println("Options names : " + option.getText());
		}
		*/
		//driver.findElement(By.xpath("//ul[@class='ngVsM u4RcUd']/li/a/div/following-sibling::span[text()='Account']")).getTagName();
	}

}
