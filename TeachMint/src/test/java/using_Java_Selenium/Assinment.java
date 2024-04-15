package using_Java_Selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assinment {
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void login(String phoneNumber, String otp) {
		driver.get("https://accounts.teachmint.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")))
					.sendKeys(phoneNumber);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("send-otp-btn-id"))).click();

			// Entering the given OTP
			String otpFieldLocator = "//input[@data-group-idx='%s']";
			for (int i = 0; i < otp.length(); i++) {
				char digit = otp.charAt(i);
				String otpFieldXPath = String.format(otpFieldLocator, i);
				WebElement otpField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(otpFieldXPath)));
				otpField.sendKeys(Character.toString(digit));
			}

			// Submit the OTP
			driver.findElement(By.id("submit-otp-btn-id")).click();
		} catch (TimeoutException e) {
			System.out.println("Timeout occurred while waiting for an element.");
			e.printStackTrace(); // Print stack trace for debugging
		}
	}

	public static void navigateToDashboard() {
		try {
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[@class='profile-name']/span[text()='Automation']")))
					.click();
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//a[text()='Dashboard']"))).click().perform();
		} catch (TimeoutException e) {
			System.out.println("Timeout occurred while navigating to Dashboard.");
			e.printStackTrace();
		}
	}

	public static void validateLogin(String expectedTitle) {
		String actual_DashboardTitle = driver.getTitle();
		System.out.println("Dashboard Title after Login : " + actual_DashboardTitle);

		System.out.println("Is Login successful? " + actual_DashboardTitle.equals(expectedTitle));
	}

	public static void navigate_To_Administration_and_Select_Certificates() throws IOException {
		// Navigating to Administration Section and Select Certificate_Type
		Actions action = new Actions(driver);
		// Mouse Hover to Administration Section to select Certificate Type
		WebElement menu = driver.findElement(By.xpath("//span[@data-qa='icon-administrator']"));
		action.moveToElement(menu).click().perform();

		// Click on Certificates
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Certificates']"))).click();

		// Select School leaving certificate template
		WebElement schoolLeavingCertificate = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='School leaving certificate']")));
		schoolLeavingCertificate.click();

		// Capturing Screenshot of school Leaving Certificate preview prior to Generate
		File screenShot = driver.findElement(By.className("react-pdf__Page__canvas")).getScreenshotAs(OutputType.FILE);

		// Copy and store screenshot into required location
		FileUtils.copyFile(screenShot, new File(".\\Screenshot\\Certificate Preview.png"));
		System.out.println("Screenshot of School leaving certificate preview has been taken.");
	}

	public static void updateRemarks() {
		// Update the Remarks of Leaving_Certificate
		driver.findElement(By.xpath("//div[text()='Generate']")).click();
		driver.findElement(By.xpath("//tbody/tr/td[1]/label/div/input")).click();

		driver.findElement(By.xpath("//div[text()='Generate']")).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
		try {
			driver.findElement(By.xpath("//div/input[@placeholder='Remarks']")).sendKeys("Leaving Certificate issued");
			// Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='Show changes in preview']")).click();

		} catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted: " + e.getMessage());
		}
	}

	public static void downloadCertificate() {
		// Generate Certificate
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
			driver.findElement(By.xpath("//div[text()='Generate']")).click();
			
			//Validate Certificate generated for the download
			String actual_message = driver.findElement(By.xpath("//h4[text()='Document generated successfully']")).getText();
			System.out.println("Message to downoad certificate :  " +actual_message);
			String expected_message = "Document generated successfully";
			if(actual_message.equals(expected_message)) {
				System.out.println("Certificate is generated successfully for download.");
			}else {
				System.out.println("Certificate is not generated successfully for download.");
			}
			
			// Download the Certificate
			driver.findElement(By.xpath("//div[text()='Download']")).click();

			// Get current window handle
			String parentWindowHandle = driver.getWindowHandle();

			// Get all window handles
			Set<String> allWindowHandles = driver.getWindowHandles();

			// Switch to the new window (Pdf download window)
			for (String handle : allWindowHandles) {
				if (!handle.equals(parentWindowHandle)) {
					driver.switchTo().window(handle);
					break;
				}
			}
			// Validation of Certificate download
			String url = driver.getCurrentUrl();
			System.out.println("Certificate Download Page URL is : " + url);
			
			// Switch back to main window - Dashboard
			driver.switchTo().window(parentWindowHandle);
		} catch (TimeoutException e) {
			System.out.println("Timeout occurred while generating or downloading the certificate.");
			e.printStackTrace();
		}
	}

	public static void navigateTo_And_validateCertificates() {
		Actions action = new Actions(driver);
		// Mouse Hover to Administration Section to select Certificate Type
		WebElement Administration = driver.findElement(By.xpath("//span[@data-qa='icon-administrator']"));
		action.moveToElement(Administration).click().perform();
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
		
		// Click on Certificates
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Certificates']"))).click();
		
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
	}

	public static void main(String[] args) throws IOException {
		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications"); // Disables browser notifications
			driver = new ChromeDriver(options);

			// Call login method
			login("0000020232", "120992");

			// Call navigateToDashboard method
			navigateToDashboard();

			// Call validateLogin method
			validateLogin("Teachmint: Smart Learning Management System (LMS) & Integrated ERP");

			// Call a method
			navigate_To_Administration_and_Select_Certificates();

			// Call a method
			updateRemarks();

			// Call downloadCertificate method
			downloadCertificate();

			// Call navigateTo_And_validateCertificates method
			navigateTo_And_validateCertificates();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}
