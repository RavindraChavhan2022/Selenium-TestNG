package javaScript_Executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Selenium_Util;

public class Example3 extends Selenium_Util {

	public static void main(String[] args) throws InterruptedException {
		Example3 e1 = new Example3();
		e1.testCase1();
	}

	public void testCase1() throws InterruptedException {
		WebDriver driver=setUp("chrome", "https://www.amazon.in/ref=nav_logo");

		JavascriptExecutor js=(JavascriptExecutor)driver;
		
//		//vertical scrolling downward
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,2500)");
		
		//vertical scrolling upward
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-2500)");
		
		//scroll till bottom of the page
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

		
		//Horizontal scrolling
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(500,0)");
		
	}

}
