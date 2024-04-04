package javaScript_Executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Selenium_Util;

public class Example2 extends Selenium_Util {

	public static void main(String[] args) {
		Example2 e1 = new Example2();
		e1.testCase1();
	}

	public void testCase1() {
		WebDriver driver = setUp("chrome", "https://online.actitime.com/tcs/login.do");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// identifying elements from the UI using JavaScript and typing required value in it
		js.executeScript("document.getElementById('username').value='admin01'");

		// identifying elements from the UI using JavaScript and typing required value in it
		js.executeScript("document.getElementsByName('pwd')[0].value='admin01'");

		// identifying elements from the UI using JavaScript and click on it
		js.executeScript("document.getElementById('loginButton').click();");
		
		// OR
		 WebElement element=driver.findElement(By.id("loginButton"));
		 js.executeScript("arguments[0].click();", element);
		 
		// OR
		 WebElement element1=driver.findElement(By.id("loginButton"));
		 element1.click();
		
		
	}

}
