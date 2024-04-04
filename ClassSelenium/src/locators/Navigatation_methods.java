package locators;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigatation_methods {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// maximize browser window
		driver.manage().window().maximize();
		// minimize browser window
		driver.manage().window().minimize();
		// set window size based on need
		Dimension dimension = new Dimension(400, 500);
		driver.manage().window().setSize(dimension);

		driver.manage().window().maximize();

//		WebElement forgotPasswordLink=driver.findElement(By.className("orangehrm-login-forgot"));
//		forgotPasswordLink.click();
		// or
		driver.findElement(By.className("orangehrm-login-forgot")).click();

		// want to come back to previous page
		driver.navigate().back();

		// want to go to next page again
		driver.navigate().forward();

		// refresh page
		driver.navigate().refresh();

		// want to move to next application
		driver.navigate().to("https://www.google.com");
		
		driver.navigate().back();
		
		driver.close();

	}

}
