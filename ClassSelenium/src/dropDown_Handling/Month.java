package dropDown_Handling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import locators.Base_Class;

public class Month extends Base_Class {

	public static void main(String[] args) {
		setUp();
		driver.get("https://demo.automationtesting.in/Register.html");

		// identify drop down list
		WebElement monthDropdown = driver.findElement(By.cssSelector("select[placeholder='Month']"));

		Select monthSelect = new Select(monthDropdown);
		int count = monthSelect.getOptions().size() - 1;
		System.out.println("Months option count: " + count);
		System.out.println("Is month dropdown allow multiple selection? " + monthSelect.isMultiple());

		List expectedMonths = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");
		System.out.println("Expected Months sequence is : " + expectedMonths);

		List monthsList = new ArrayList();
		for (int i = 1; i <= count; i++) {
			String months = monthSelect.getOptions().get(i).getText();
			monthsList.add(months);
		}
		System.out.println("List after adding months from options is : " + monthsList);
/*
		// Assigning List to new/Actual months list which we have got from drop-down option
		List actualMonths = monthsList;
		System.out.println("Actual Months sequence is : " + actualMonths);
*/
		// Now compare the content/value of both the lists using .equals() method
		System.out.println("Are months in a required sequence ? " + expectedMonths.equals(monthsList));

		tearDown();
	}
}
