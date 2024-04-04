package automation_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Create_Facebook_Account {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Ajay\\Softewares or Apps\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Opening Facebook Login page
		driver.get("https://www.facebook.com/");
		// Maximize the web page
		driver.manage().window().maximize();
		driver.quit();
	
	}

}
