package xpath;

import org.openqa.selenium.By;
import locators.Base_Class;

public class Dependent_Independent_Flipkart extends Base_Class {

	public static void main(String[] args) {
		setUp();
		driver.get("https://www.flipkart.com/televisions/pr?sid=ckf%2Cczl&p%5B%5D=facets.availability%255B%255D%3DExclude%2BOut%2Bof%2BStock&otracker=categorytree&p%5B%5D=facets.serviceability%5B%5D%3Dtrue&p%5B%5D=facets.brand%255B%255D%3DSamsung&otracker=nmenu_sub_TVs%20%26%20Appliances_0_Samsung");
	
		//Finding the Price Samsung TV 
		System.out.println("Price of Samsung Tv = " + driver.findElement(By.xpath("//a[div[div[div[text()='LG UR7500 108 cm (43 inch) Ultra HD (4K) LED Smart WebOS TV 2023 Edition with a5 AI Processor 4K Gen6 ...']]]]/div[2]/div[2]/div/div/div[1]")).getText());
        // If item/Tv name changes, we just put new text other xpath will be same.
		tearDown();
	}
}
