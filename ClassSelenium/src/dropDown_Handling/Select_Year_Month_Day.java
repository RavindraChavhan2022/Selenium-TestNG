package dropDown_Handling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.Base_Class;

public class Select_Year_Month_Day extends Base_Class {

	public static void main(String[] args) {
		setUp();

		driver.get("https://demo.automationtesting.in/Register.html");

		WebElement country = driver.findElement(By.id("country"));
		Select cy = new Select(country);
		// Selecting Country
		cy.selectByValue("India");

		// identify drop down list
		WebElement year = driver.findElement(By.id("yearbox"));
		Select yr = new Select(year);
		// Selecting Year
		yr.selectByValue("1989");

		WebElement month = driver.findElement(By.cssSelector("select[ng-model='monthbox']"));
		// OR
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// WebElement month =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-md-3>select.ng-touched>option:nth-of-type(7)")));

		Select mt = new Select(month);
		// Selecting Month
		mt.selectByVisibleText("June");

		WebElement day = driver.findElement(By.id("daybox"));
		Select d = new Select(day);
		// Selecting Day
		d.selectByValue("18");

		tearDown();
	}

}
