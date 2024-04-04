package test_Cases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class New_Customer extends Base_Test {
	
	@BeforeMethod
	public void setUp() {
		openBrowser_And_Url();
		driver.get(BASE_URL + "/V4/manager/addcustomerpage.php");
	}

	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	*/
	@Test
	public void Add_New_Customer() throws InterruptedException {
	    
	    driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Ajay");
	    System.out.println(driver.findElement(By.cssSelector("input[value='m']")).isEnabled());
	    System.out.println(driver.findElement(By.cssSelector("input[value='m']")).isDisplayed());
	    driver.findElement(By.cssSelector("input[name='name']")).click();
		
	    WebElement dateInput = driver.findElement(By.xpath("//input[@onkeyup='validatedob();']"));
	    dateInput.sendKeys("18/06/1989");
	
	    
	  //  date.sendKeys("18-June-2001");
	    
	//	driver.findElement(By.name("dob")).sendKeys("06/18/1989");
		driver.findElement(By.name("addr")).sendKeys("Swaraj Residency, Moshi");
		driver.findElement(By.name("city")).sendKeys("Pune");
		driver.findElement(By.name("state")).sendKeys("Maharashtra");
		driver.findElement(By.name("pinno")).sendKeys("412105");
		driver.findElement(By.name("telephoneno")).sendKeys("9607052843");
		driver.findElement(By.name("emailid")).sendKeys("shivmangal451@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Ravi@1234");
		driver.findElement(By.name("sub")).click();
		
		Alert alt = driver.switchTo().alert();
		alt.accept();
		
	}
		
}
