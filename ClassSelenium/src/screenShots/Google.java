package screenShots;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import utility.Selenium_Util;

public class Google {

	public static void main(String[] args) throws IOException {
		Selenium_Util util = new Selenium_Util();

		WebDriver driver = util.setUp("chrome", "https://www.google.com");
		// type cast WebDriver instance into TakeScreenshot interface
		TakesScreenshot ts = (TakesScreenshot) driver;
		// take screenshot in the form of File object
		File screenShot = ts.getScreenshotAs(OutputType.FILE);
		// store screenshot into required location
		FileUtils.copyFile(screenShot, new File(".\\screenshots\\google.png"));

		System.out.println("Screenshot is taken");

		driver.close();
	}
}
