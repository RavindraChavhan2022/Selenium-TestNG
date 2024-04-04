package automation_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testing_FireFoxBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\Ajay\\Softewares or Apps\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// To open Facebook website
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		// driver.close();

	}

}
