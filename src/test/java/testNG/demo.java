package testNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo extends Base_Class {

	@BeforeTest
	public void openBrowser() {
		setUp();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
	}

	@BeforeMethod
	public void login() {

		driver.findElement(By.xpath("//div/div/div/form/div/div/div[2]/input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
	}

	@Test
	public void test_OrangeHRM_PIM_Update() {
		System.out.println("Write a code to update PIM");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")).click(); // a[contains(text(),'Employee
																												// List')]

		driver.findElement(By.xpath("//*[@id=\"app\"] //div[2]/div/div[9]/div/button[2]/i")).click();
		driver.findElement(By.xpath(
				"//div[@class='orangehrm-edit-employee-content']/div/form/div[2]/div[2]/div[1]/div/div[2]/input"))
				.sendKeys("abc@124");

		driver.findElement(By.xpath("//*[@id=\"app\"]//form/div[2]/div[2]/div[2]/div/div[2]/div/div/i")).sendKeys("2027-10-07");

		WebElement nationality = driver
				.findElement(By.xpath("//*[@id=\"app\"]//form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[2]/i"));
		selectDropDown(nationality, "Indian");

		WebElement marital = driver
				.findElement(By.xpath("//*[@id=\"app\"]//form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[2]/i"));
		selectDropDown(marital, "Single");

		driver.findElement(By.xpath("//*[@id=\"app\"]//form/div[3]/div[2]/div[1]/div/div[2]/div/div/i"))
				.sendKeys("1989-18-06");
		driver.findElement(By.xpath("//label/input[@value='1']/following-sibling::span")).click();
	}

	public static void selectDropDown(WebElement el, String value) {
		Select drp = new Select(el);
		List<WebElement> alloptions = drp.getOptions();
		String option = "value";
		for (WebElement opt : alloptions) {
			if (opt.getText().contains(option)) {
				opt.click();
				break;
			}
		}
	}
}
