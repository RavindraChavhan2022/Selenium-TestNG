package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Helper_Attributes {
	public static WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void openAmazon() {
		driver.get("https://www.amazon.in/");
	}

	@Test(dependsOnMethods = { "openAmazon" })
	public void searchproduct() {
		driver.get("https://www.amazon.in/");
		WebElement input = driver.findElement(By.name("field-keywords"));
		input.sendKeys("Laptop");
		input.sendKeys(Keys.ENTER);
	}

	@Test(enabled = true, description = "this is Swag Lab application under testing")
	public void openSwagLabs() {

		driver.get("https://www.saucedemo.com/");
		System.out.println("Page title: " + driver.getTitle());
	}

	@Test(enabled = true, timeOut = 20000)
	public void openActitime() {
		driver.get("https://online.actitime.com/tcs/login.do");
		System.out.println("Page title: " + driver.getTitle());
	}

	@Test(enabled = true, expectedExceptions = ArithmeticException.class)
	public void testCase() {
		System.out.println("Test case started");
		int i = 10 / 0;
		System.out.println("Test case ends");
	}

}
/*
 * Helper Attributes are: 1) enabled : will allow that method to include/exclude
 * from execution true(by default)- included from execution false - excluded
 * from execution 2) priority: will help to decide execution order of @Test
 * default priority is 0 lowest priority will get 1st preference if more than
 * one @Test method has same priority than alphabetical order 3)
 * dependsOnMethods :
 * 
 * 4) timeout : wait
 * 
 * 5) description :
 * 
 */
