package locators;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_Class {

	public static WebDriver driver;

	// Create am method for setting up common requirements like opening, maximizing window etc
	public static void setUp() {
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	// Create am method for closing the browser
	public static void tearDown() {
		driver.quit();

	}
}
