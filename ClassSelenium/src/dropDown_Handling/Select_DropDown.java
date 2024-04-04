package dropDown_Handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import locators.Base_Class;

public class Select_DropDown extends Base_Class {

	public static void main(String[] args) {
		setUp();

		driver.get("https://demo.automationtesting.in/Register.html");

		// identify drop down list
		WebElement skillDropdown = driver.findElement(By.id("Skills"));

		// create an instance of Select class and pass above drop down object to its
		// constructor
		Select skillSelect = new Select(skillDropdown);

		System.out.println("Is skill dropdown allow multiple selected? " + skillSelect.isMultiple());
		System.out.println("Default value from dropdown: " + skillSelect.getFirstSelectedOption().getText());

		skillSelect.selectByIndex(1);
		System.out.println("New selected-index value from dropdown: " + skillSelect.getFirstSelectedOption().getText());

		skillSelect.selectByValue("Analytics");
		System.out.println("New selected-value value from dropdown: " + skillSelect.getFirstSelectedOption().getText());

		skillSelect.selectByVisibleText("Backup Management");
		System.out.println("New selected-text value from dropdown: " + skillSelect.getFirstSelectedOption().getText());

		int count = skillSelect.getOptions().size();
		System.out.println("Option count: " + count);

		for (int i = 0; i < count; i++) {
			System.out.println(skillSelect.getOptions().get(i).getText());
		}

		tearDown();

	}

}
