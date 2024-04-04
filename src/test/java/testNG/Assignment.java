package testNG;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Selenium_Util;

public class Assignment extends Selenium_Util {

	@BeforeTest
	public void openBrowser() {
		System.out.println("************Open browser and enter OrangeHRM URL***********************");
		setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@BeforeMethod
	public void login() {
		System.out.println("************Login with valid data***********************");
		    WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/div/form/div/div/div[2]/input[@name='username']")));
		    waitForElement(usernameInput);
		    // Enter username and password
		   // typeInput(usernameInput, "Admin");
		typeInput(driver.findElement(By.xpath("//div/div/div/form/div/div/div[2]/input[@name='username']")),"Admin");
		typeInput(driver.findElement(By.xpath("//input[@type='password']")),"admin123");
		clickOnElement(driver.findElement(By.cssSelector(".orangehrm-login-button")));
	}

	@AfterMethod
	public void logout() {
		System.out.println("************Logout from the application***********************");
		WebElement log = driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"));
	    log.click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	
	@AfterTest
	public void closingBrowser() {
		tearDown();
	}

	@Test(priority=1)
	public void test_OrangeHRM_PIM_Creation() throws InterruptedException {
		System.out.println("Write a code to create PIM");
		driver.findElement(By.xpath("//ul/li[2]/a")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Add Employee')]")).click();
		driver.findElement(By.name("firstName")).sendKeys("Ajay");
		driver.findElement(By.name("lastName")).sendKeys("Singh Rathore");
		driver.findElement(By.xpath("//div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input[@class='oxd-input oxd-input--active']")).sendKeys("036456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test(priority=2)
	public void test_OrangeHRM_PIM_Update() {
		System.out.println("Write a code to update PIM");
		
		//click on PIM tab
		driver.findElement(By.xpath("//ul/li[2]/a")).click();
		
		//Click on employee List tab
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")).click();         //a[contains(text(),'Employee List')]
		
		//*[@id="app"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[9]/div/button[2]/i
		//*[@id="app"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[9]/div/button[2]
		 driver.findElement(By.xpath("//*[@id=\"app\"]//div[1]/div/div[9]/div/button[2]")).click();
		 WebElement number = driver.findElement(By.xpath("//div[@class='orangehrm-edit-employee-content']/div/form/div[2]/div[2]/div[1]/div/div[2]/input"));
		 number.clear();
		 number.sendKeys("abc@124");
		
		 WebElement license = driver.findElement(By.xpath("//*[@id='app']//form/div[2]/div[2]/div[2]/div/div[2]/div/div/i"));
		 license.clear();
		 license.sendKeys("2027-10-07");
		
		WebElement nationality = driver.findElement(By.xpath("//*[@id='app']//form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[2]/i"));
		nationality.clear();
		selectDropDown(nationality, "Indian");
		
		WebElement marital = driver.findElement(By.xpath("//*[@id='app']//form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[2]/i"));
		marital.clear();
		selectDropDown(marital, "Single");
		
		WebElement dob = driver.findElement(By.xpath("//*[@id='app']//form/div[3]/div[2]/div[1]/div/div[2]/div/div/i"));
		dob.clear();
		dob.sendKeys("1989-18-06");
		driver.findElement(By.xpath("//label/input[@value='1']/following-sibling::span")).click();
	}
	
	public static void selectDropDown(WebElement el, String value) {
		Select drp = new Select(el);
		List<WebElement> options = drp.getOptions();
		for(WebElement opt:options) {
			if(opt.getText().equals(value)) {
				opt.click();
				break;
			}
		}
	}

	@Test(priority=3)
	public void test_OrangeHRM_PIM_Delete() {
		System.out.println("Write a code to delete PIM");
		driver.findElement(By.xpath("//ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='app']//div[3]/div/div[2]/div[2]/div/div[9]/div/button[1]/i")).click();
		driver.findElement(By.xpath("//div[@class='orangehrm-modal-footer']/button[2]")).click();	
	}

}
