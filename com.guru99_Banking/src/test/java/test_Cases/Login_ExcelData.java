package test_Cases;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_ExcelData extends Base_Test {
	@BeforeMethod
	public void setUp() {
		openBrowser_And_Url();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "Login")
	public void enterInvalidCredentials(String User, String Password) {
		driver.findElement(By.cssSelector("tbody>tr>td>input[name='uid']")).sendKeys(User);
		driver.findElement(By.cssSelector("tbody>tr>td>input[name='password']")).sendKeys(Password);
		driver.findElement(By.cssSelector("td>[type='submit']")).click();
		try {
			// handling pop up or alert after clicking on Login button
			Alert alert = driver.switchTo().alert();
			String pop_up = alert.getText();
			System.out.println("Pop up appears after entering invalid credentials : " + pop_up);
			alert.accept();
		} catch (NoAlertPresentException Ex) {
			// Verifying LoginPage
			String expected_Url = "https://www.demo.guru99.com/V4/manager/Managerhomepage.php"; 
			String actual_Url = driver.getCurrentUrl();
			System.out.println("Actual URL after login : " + actual_Url);
			Assert.assertEquals(actual_Url, expected_Url);
			
			// Verifying Login title
			String expectedTitle = "Guru99 Bank Manager HomePage";
			String actualTitle = driver.getTitle();
			System.out.println("Actual HomePage title after login :" + actualTitle);
			//Assert.assertEquals(actualTitle, expectedTitle);
			Assert.assertEquals(actualTitle, expectedTitle, "Login is not successfull");
			
		}
	}

	@DataProvider(name = "Login")
	public String[][] getTestData() throws IOException {
		File excelFile = new File(System.getProperty("user.dir") + ".\\src\\main\\java\\test_Data\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("LoginDetails");
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[rowCount][columnCount]; // 2 parameters: User and Password
		for (int i = 1; i <= rowCount; i++) { // Start from i = 1 to skip header row
	        Row row = sheet.getRow(i);
	        if (row != null) {
	            for (int j = 0; j < columnCount; j++) {
	                Cell cell = row.getCell(j);
	                if (cell != null) {
	                    data[i - 1][j] = cell.getStringCellValue();
	                } else {
	                    data[i - 1][j] = ""; // Set empty string for null cells
	                }
	            }
	        }
	    }
        workbook.close();
        fis.close();
        return data;
	}

	@Test(priority = 2)
	public void verifyLogin() {
		driver.get("https://www.demo.guru99.com/V4/manager/Managerhomepage.php");
		String expected_message = "Welcome To Manager's Page of Guru99 Bank";
		String actual_message = driver.findElement(By.xpath("//tr/td/marquee")).getText();
		Assert.assertEquals(actual_message, expected_message);
	}

}

/*
 * guru99 Login Details UserId --> mngr559492 Password --> syjebet
 * 
 */