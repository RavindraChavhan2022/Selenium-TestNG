package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\Property-File\\Test_Data.properties");
		Properties prop = new Properties();
		prop.load(fis);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("appUrl"));

		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));

		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));

		driver.findElement(By.cssSelector(".orangehrm-login-button")).click();

		System.out.println(driver.getCurrentUrl().contains(prop.getProperty("expectedUrl")));
		
		System.out.println(driver.getCurrentUrl().equals(prop.getProperty("expected_URL")));

	}

}
