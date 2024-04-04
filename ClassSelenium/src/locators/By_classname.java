package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class By_classname {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com/hotels/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement hotels = driver.findElement(By.className("menu_Hotels"));
		System.out.println("Is Hotels name visible ? " + hotels.isDisplayed());
		System.out.println("Is Hotels menu functional/clickable ? " + hotels.isEnabled());
		System.out.println("Hotels menu text is : " + hotels.getText());
		
		System.out.println("\n**************************************************");
		
		//validation of radio button
		WebElement radio = driver.findElement(By.className("grpBkngOpt__item--text"));
		System.out.println("is radio button visible? " + radio.isDisplayed());
		System.out.println("is radio button functional/clickable? " + radio.isEnabled());
		System.out.println("Is radio button selected by default ? " + radio.isSelected());

	}

}

/*
 * Guru99 web site 
 * User ID : mngr559492 
 * Password : syjebet
 */