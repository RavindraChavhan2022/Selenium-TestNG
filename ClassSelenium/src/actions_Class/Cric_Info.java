package actions_Class;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.Selenium_Util;

public class Cric_Info {

	public static void main(String[] args) throws InterruptedException {
		Selenium_Util util=new Selenium_Util();
		WebDriver driver=util.setUp("chrome", "https://www.espncricinfo.com/");
		Actions action = new Actions(driver);
		List<WebElement> menuList = driver.findElements(By.xpath("//div[@class='ds-flex ds-flex-row']/div"));
		System.out.println("Total count of main options is : " + menuList.size());
		
		//Printing menu list
		System.out.println("Name List of options is : ");
		for (int i = 0; i < menuList.size(); i++)
			System.out.println(menuList.get(i).getText());

		//Hovering the mouse on Menu List
		for (int i = 0; i < menuList.size(); i++) {
			Thread.sleep(1000);
			action.moveToElement(menuList.get(i)).perform();
		}
		driver.close();
	}

}
