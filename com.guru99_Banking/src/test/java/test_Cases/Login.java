package test_Cases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends Base_Test {
	@BeforeMethod
	public void setUp() {
		openBrowser_And_Url();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public static void handleErrorMessage() {
		// handling pop up or alert after clicking on Login button
		Alert alert = driver.switchTo().alert();
		String pop_up = alert.getText();
		System.out.println("Pop up is : " + pop_up);
		alert.accept();
	}

	@Test(priority = 1)
	public void enterValidCredentials() throws IOException {
		driver.findElement(By.cssSelector("tbody>tr>td>input[name='uid']")).sendKeys("mngr559492");
		driver.findElement(By.cssSelector("tbody>tr>td>input[name='password']")).sendKeys("syjebet");
		driver.findElement(By.cssSelector("td>[type='submit']")).click();

		// Verifying LoginPage
		String expected_Url = "https://www.demo.guru99.com/V4/manager/Managerhomepage.php";
		String actual_Url = driver.getCurrentUrl();
		Assert.assertEquals(actual_Url, expected_Url);
		// Verifying Login title
		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);

		// type cast WebDriver instance into TakeScreenshot interface and taking
		// screenshot
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Copy and store screenshot into required location
		FileUtils.copyFile(screenShot, new File(".\\Screenshots\\Manager_AccountPage.png"));

		System.out.println("Screenshot is taken");
	}

	@Test(priority = 2)
	public void verifyLogin() {
		driver.get("https://www.demo.guru99.com/V4/manager/Managerhomepage.php");
		String expected_message = "Welcome To Manager's Page of Guru99 Bank";
		String actual_message = driver.findElement(By.xpath("//tr/td/marquee")).getText();
		Assert.assertEquals(actual_message, expected_message);
	}

	@Test(priority = 3)
	public void verifyLoginWith_Invalid_UserID() {
		driver.findElement(By.cssSelector("tbody>tr>td>input[name='uid']")).sendKeys("mngr559497");
		driver.findElement(By.cssSelector("tbody>tr>td>input[name='password']")).sendKeys("syjebet");
		driver.findElement(By.cssSelector("td>[type='submit']")).click();

		Login.handleErrorMessage();
	}

	@Test(priority = 4)
	public void verifyLoginWith_Invalid_Password() {
		driver.findElement(By.cssSelector("tbody>tr>td>input[name='uid']")).sendKeys("mngr559492");
		driver.findElement(By.cssSelector("tbody>tr>td>input[name='password']")).sendKeys("syjebeti");
		driver.findElement(By.cssSelector("td>[type='submit']")).click();

		Login.handleErrorMessage();

	}

	@Test(priority = 5)
	public void verifyLoginWith_Invalid_UserID_And_Password() {
		driver.findElement(By.cssSelector("tbody>tr>td>input[name='uid']")).sendKeys("mngr559497");
		driver.findElement(By.cssSelector("tbody>tr>td>input[name='password']")).sendKeys("syjebeti");
		driver.findElement(By.cssSelector("td>[type='submit']")).click();

		Login.handleErrorMessage();
	}

}

/*
 * guru99 Login Details UserId --> mngr559492 Password --> syjebet
 * 
 */