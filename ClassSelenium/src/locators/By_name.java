package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class By_name {

	public static void main(String[] args) {
		// Create an instance of ChromeDriver class and upcast it to WebDriver interface
		WebDriver driver = new ChromeDriver();

		// enter application URL
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user-name")).sendKeys("problem_user");
		
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.name("login-button")).submit();
		
		driver.close();
	}

}
