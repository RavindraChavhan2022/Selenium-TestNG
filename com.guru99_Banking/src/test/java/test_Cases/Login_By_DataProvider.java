package test_Cases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_By_DataProvider extends Base_Test {
	@BeforeMethod
	public void setUp() {
		openBrowser_And_Url();
		driver.get(BASE_URL + "/V4/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "GuruTest")
	public void loginTest(String username, String password) throws Exception {
		String actualTitle;
		String actualBoxMsg;
		// Enter valid UserId
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(username);
		// Enter valid Password
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		// Click Login
		driver.findElement(By.name("btnLogin")).click();

		try {
			Alert alt = driver.switchTo().alert();
			actualBoxMsg = alt.getText(); // get content of the Alter Message
			alt.accept();
			// Compare Error Text with Expected Error Value
			assertEquals(actualBoxMsg, Base_Test.EXPECT_ERROR);
		} catch (NoAlertPresentException Ex) {
			// Get text displays on login page
			String pageText = driver.findElement(By.xpath("//tbody/tr[3]/td")).getText();
			System.out.println(pageText);
			String expectedText = "Manger Id : mngr559492";
			Assert.assertEquals(expectedText, pageText);
			
			// type cast WebDriver instance into TakeScreenshot interface and taking
			// screenshot
			File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Copy and store screenshot into required location
			FileUtils.copyFile(screenShot, new File(".\\Screenshots\\Login.png"));

			System.out.println("Screenshot is taken");

			// Extract the dynamic text mngrXXXX on page
			String[] parts = pageText.split(Base_Test.PATTERN);
			String dynamicText = parts[1];

			// Check that the dynamic text is of pattern mngrXXXX
			// First 4 characters must be "mngr"
			Assert.assertTrue(dynamicText.substring(1, 5).equals(Base_Test.FIRST_PATTERN));
			// remain stores the "XXXX" in pattern mngrXXXX
			String remain = dynamicText.substring(dynamicText.length() - 4);
			// Check remain string must be numbers;
			Assert.assertTrue(remain.matches(Base_Test.SECOND_PATTERN));
		}

	}

	@DataProvider(name = "GuruTest")
	public Object[][] testData() {

		Object[][] data = new Object[4][2];

		// 1st row
		data[0][0] = Base_Test.USER_NAME;
		data[0][1] = Base_Test.PASSWD;
		// 2nd row
		data[1][0] = "mngr559498";
		data[1][1] = Base_Test.PASSWD;
		;
		// 3rd row
		data[2][0] = Base_Test.USER_NAME;
		data[2][1] = "syjebeti";
		// 4th row
		data[3][0] = "mngr559498";
		data[3][1] = "syjebeti";
		return data;
	}

}
