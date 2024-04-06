package interviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import locators.Base_Class;

public class Result_Count_After_Entering_Text extends Base_Class {

	public static void main(String[] args) {
		setUp();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Movies", Keys.ENTER);
		System.out.println("Result count is : " + driver.findElement(By.id("result-stats")).getText());
	
	}

}
