package actions_Class;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.Base_Class;

public class RightClick_MouseHover extends Base_Class {

	public static void main(String[] args) {
		setUp();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("delexu-menu.com", Keys.ENTER);
		
		 //OR finding element for Goofle Search 
		//driver.findElement(By.xpath("//div[@jsname='VlcLAe']/center/input[1]")).click();
		
		//Go to link and click
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Popup Menu (Right Click Menu) - Samples']"))).click();
		
		WebElement img = driver.findElement(By.xpath("//img[@src='data-samples/images/popup_pic.gif']"));
		//Creating instance of Actions Class
		Actions action = new Actions(driver);
		action.contextClick(img).perform();
		
		WebElement menu = driver.findElement(By.id("dm2m1i1tdT"));
		action.moveToElement(menu).perform();
		
		WebElement ins = driver.findElement(By.id("dm2m2i1tdT"));
		action.moveToElement(ins).perform();
		
		WebElement set = driver.findElement(By.id("dm2m3i1tdT"));
		action.moveToElement(set).click().perform();
		
		tearDown();
	}

}
