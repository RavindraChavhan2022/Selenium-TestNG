package validation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ColorPosition {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.automationtesting.in/Register.html");

		// Refresh button
	/*	WebElement Refresh = driver.findElement(By.id("Button1"));//
		Point RefreshLoc = Refresh.getLocation();
		int Refresh_X = RefreshLoc.getX();
		int Refresh_Y = RefreshLoc.getY();
		System.out.println("Refresh button x-cord: " + Refresh_X);
		System.out.println("Refresh button y-cord: " + Refresh_Y);
		*/
		// OR
		Point Refresh = driver.findElement(By.id("Button1")).getLocation();
		System.out.println("Refresh button X-cord: " + Refresh.x);
		System.out.println("Refresh button Y-cord: " + Refresh.y);

		// Submit button
		Point Submit = driver.findElement(By.id("submitbtn")).getLocation();
		System.out.println("Submit button X-cord: " + Submit.x);
		System.out.println("Submit button Y-cord: " + Submit.y);

		
		//Validate Submit button is on the left hand side of Refresh button
		System.out.println(("Is Submit button on the left hand side of Refresh button ? " +  (Submit.x < Refresh.x)));

	}

}
