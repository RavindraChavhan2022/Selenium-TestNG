package javaScript_Executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Selenium_Util;

public class Example1 extends Selenium_Util{

	public static void main(String[] args) {
		Example1 e1=new Example1();
		e1.testCase1();
		e1.testCase2();
	}
	
	public void testCase1() {
		WebDriver driver=setUp("firefox", "https://demo.vtiger.com/vtigercrm/index.php");	
		//Identify Login button using Selenium
		WebElement element=driver.findElement(By.cssSelector(".buttonBlue"));
		
		//convert WebDriver instance into javascriptexecutor
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//Write a code to perform click operation
		js.executeScript("arguments[0].click();", element);	
		driver.close();
	}
	public void testCase2() {
		WebDriver driver=setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");		
		//convert WebDriver instance into javascriptexecutor
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//write a code to identify and perform click operation
		js.executeScript("document.getElementsByClassName('button buttonBlue')[0].click();");
		
		driver.close();
		
	}


}

/*js.executeScript("arguments[0].click();", element);: This line executes a JavaScript code using the JavascriptExecutor interface in Selenium. 
 *The JavaScript code passed as a string is "arguments[0].click();", and element is passed as an argument.
Inside the JavaScript code, arguments[0] represents the first argument passed to the executeScript method, which is the element in this case. 
The .click() method is then called on this element, which simulates a click operation in the browser.
 * 
 * */
