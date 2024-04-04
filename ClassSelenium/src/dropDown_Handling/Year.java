package dropDown_Handling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import locators.Base_Class;

public class Year extends Base_Class {

	public static void main(String[] args) {
		setUp();
		driver.get("https://demo.automationtesting.in/Register.html");

		// identify drop down list
		WebElement yearDropdown = driver.findElement(By.id("yearbox"));

		Select yearsSelect = new Select(yearDropdown);
		int count = yearsSelect.getOptions().size();
		System.out.println("Years option count: " + count);

		// creating a List to store Years
		List yrslist = new ArrayList();

		for (int i = 1; i < count; i++) {
			yearsSelect.getOptions().get(i).getText();
		
			//Adding all years into original empty list
			yrslist.add(yearsSelect.getOptions().get(i).getText());
		}
		System.out.println("Original list is : " + yrslist);
		
		List newlist = yrslist;
		System.out.println("New List before sorting : " + newlist);
		
		Collections.sort(newlist);
		System.out.println("List after sorting : " + newlist);
		
		//Now compare the content/value of both the lists using .equals() method
		System.out.println("Are year dropdown options sorted ?" + yrslist.equals(newlist));
		
		tearDown();
	}
}
