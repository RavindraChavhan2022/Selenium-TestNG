package screenShots;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import locators.Base_Class;

public class SS_of_specific_portion extends Base_Class {

	public static void main(String[] args) throws IOException {
		
		setUp();
		
		driver.get("https://www.flipkart.com/");
		
		WebElement web = driver.findElement(By.xpath("//div[@class= '_3sdu8W emupdz']"));
		File src = web.getScreenshotAs(OutputType.FILE);
		File trg = new File("E:\\screenshots\\products.png");
		
		FileUtils.copyFile(src, trg);
		
		tearDown();

	}

}
