package keyboard_Operations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import locators.Base_Class;

public class Copy_Paste extends Base_Class{

	public static void main(String[] args) throws InterruptedException {
		setUp();
		driver.get("https://online.actitime.com/tcs/login.do");
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("admin01", Keys.chord(Keys.CONTROL, "a") , Keys.chord(Keys.CONTROL, "c"));
		Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys(Keys.chord(Keys.CONTROL + "v", Keys.ENTER));
		
		//tearDown();
	}

}
