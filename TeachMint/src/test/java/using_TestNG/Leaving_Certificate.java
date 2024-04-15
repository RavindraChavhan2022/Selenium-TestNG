package using_TestNG;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Leaving_Certificate extends BaseClass_for_Login {

	@BeforeTest
	public void setUp() throws IOException {
		openBrowser_And_Url();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void validateLogin() {
		String actual_DashboardTitle = driver.getTitle();
		System.out.println("Dashboard Title after Login : " + actual_DashboardTitle);
		String expected_DashboardTitle = "Teachmint: Smart Learning Management System (LMS) & Integrated ERP";
		Assert.assertEquals(actual_DashboardTitle, expected_DashboardTitle);
	}

	@Test(priority = 2)
	public void navigate_And_select_Certificate_Type() throws IOException {
		// Mouse Hover to Administration Section to select Certificate Type
		Actions action = new Actions(driver);

		WebElement menu = driver.findElement(By.xpath("//span[@data-qa='icon-administrator']"));
		action.moveToElement(menu).click().perform();

		// Click on Certificates
		WebElement administration = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Certificates']")));
		action.moveToElement(administration).click().perform();

		// Click on School leaving certificate template
		WebElement schoolLeavingCertificate = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='School leaving certificate']")));
		schoolLeavingCertificate.click();
		// Capturing Screenshot of school Leaving Certificate preview prior to Generate
		File screenShot = driver.findElement(By.className("react-pdf__Page__canvas")).getScreenshotAs(OutputType.FILE);
		// Copy and store screenshot into required location
		FileUtils.copyFile(screenShot, new File(".\\Screenshot\\Preview.png"));
		System.out.println("Screenshot of School leaving certificate preview has been taken.");
	}

	@Test(priority = 3)
	public void update_Remarks_And_Generate_Leaving_Certificate() throws IOException, InterruptedException {
		// navigate_And_select_Certificate_Type();
		driver.findElement(By.xpath("//div[text()='Generate']")).click();
		driver.findElement(By.xpath("//tbody/tr/td[1]/label/div/input")).click();

		driver.findElement(By.xpath("//div[text()='Generate']")).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
		try {
			// action.moveToElement(driver.findElement(By.xpath("//div/input[@placeholder='Remarks']"))).click().sendKeys("Leaving
			// Certificate issued").perform();

			driver.findElement(By.xpath("//div/input[@placeholder='Remarks']")).sendKeys("Leaving Certificate issued");
			// Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='Show changes in preview']")).click();

		} catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted: " + e.getMessage());
		}
		// Generate Certificate
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
		driver.findElement(By.xpath("//div[text()='Generate']")).click();
	}

	@Test(priority = 4)
	public void download_Certificate() throws IOException, InterruptedException {

		// Validate Certificate generated for the download
		String actual_message = driver.findElement(By.xpath("//h4[text()='Document generated successfully']"))
				.getText();
		System.out.println(actual_message);
		String expected_message = "Document generated successfully";
		Assert.assertEquals(actual_message, expected_message);
		// Download the Certificate
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
		driver.findElement(By.xpath("//div[text()='Download']")).click();

		// Get current window handle
		String parentWindowHandle = driver.getWindowHandle();

		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Switch to the new window
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		// Validation of Certificate download
		try {
			String actualUrl = driver.getCurrentUrl();
			System.out.println("URL of Certificate Download window: " + actualUrl);

			// Switch to parent link - Dashboard
			Actions action = new Actions(driver);
			driver.switchTo().window(parentWindowHandle);
			WebElement admin = driver.findElement(By.xpath("//span[@data-qa='icon-administrator']"));
			action.moveToElement(admin).click().perform();

			// Click on Certificates
			WebElement cert = driver.findElement(By.xpath("//a[text()='Certificates']"));
			action.moveToElement(cert).click().perform();

			String Certificates = driver
					.findElement(By.xpath("//h6[text()='Recently generated certificates and documents']")).getText();
			System.out.println("Heading :" + Certificates);

			// click on View All
			driver.findElement(By.xpath(
					"//h6[text()='Recently generated certificates and documents']/following-sibling::span[text()='View All']"))
					.click();

			// Total Certificates issued
			List<WebElement> List = driver.findElements(By.xpath("//tbody/tr"));
			System.out.println("Total certificates generated : " + List.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
