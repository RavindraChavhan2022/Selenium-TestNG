package using_TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass_for_Login {
	public WebDriver driver;
	public WebDriverWait wait;

	public void openBrowser_And_Url() throws IOException {
		// Calling of loadProperties() method to load properties file
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications"); // Disables browser notifications
		driver = new ChromeDriver(options);
		driver.get("https://accounts.teachmint.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")))
					.sendKeys(("0000020232"));
			// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));

			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("send-otp-btn-id"))).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));

			// Entering the given OTP
			String ot = "120992";
			String otpFieldLocator = "//input[@data-group-idx='%s']";
			for (int i = 0; i < ot.length(); i++) {
				char digit = ot.charAt(i);
				String otpFieldXPath = String.format(otpFieldLocator, i);
				WebElement otpField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(otpFieldXPath)));
				otpField.sendKeys(Character.toString(digit));
			}
			// Submit the OTP
			driver.findElement(By.id("submit-otp-btn-id")).click();

			// Go to Automation - Owner Account
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[@class='profile-name']/span[text()='Automation']")))
					.click();
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//a[text()='Dashboard']"))).click().perform();

		} catch (TimeoutException e) {
			System.out.println("Timeout occurred while waiting for an element.");
			e.printStackTrace(); // Print stack trace for debugging
			// Perform specific actions or logging for TimeoutException
		}
	}
}
