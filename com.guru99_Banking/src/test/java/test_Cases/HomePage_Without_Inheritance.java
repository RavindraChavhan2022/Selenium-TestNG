package test_Cases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage_Without_Inheritance {

	public WebDriver driver;

	@BeforeClass
	public void openBrowser_And_Url() {
		String browser = "firefox";
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("safari")) {
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	@BeforeMethod
	public void setUp() {
		driver.get("https://www.demo.guru99.com/V4/");
	}

	@AfterClass
	public void tearDown1() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyUrl() {
		String expectedUrl = "https://www.demo.guru99.com/V4/";
		String actualUrl = driver.getCurrentUrl();
		System.out.println("HomePage Url is : " + actualUrl);
		// Verifying both Url are same
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(priority = 2)
	public void verifyTitle() {
		String expected_Title = "Guru99 Bank Home Page";
		String actual_Title = driver.getTitle();
		System.out.println("HomePage title is : " + actual_Title);
		Assert.assertEquals(actual_Title, expected_Title);
	}

}
