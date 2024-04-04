package screenShots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Flipkart {

	public static void main(String[] args) throws IOException{
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 
		// type cast WebDriver instance into TakeScreenshot interface and  taking screenshot
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);;
		 
		// Copy and store screenshot into required location
		FileUtils.copyFile(screenShot, new File(".\\screenshots\\flipkart.png"));

		System.out.println("Screenshot is taken");

		//driver.close();
	}
}
