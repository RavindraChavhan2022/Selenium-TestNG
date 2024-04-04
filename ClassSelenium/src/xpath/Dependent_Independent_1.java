package xpath;

import org.openqa.selenium.By;

import locators.Base_Class;

public class Dependent_Independent_1 extends Base_Class {

	public static void main(String[] args) {
		setUp();
		driver.get("https://www.demoblaze.com/");
		
		//Get a price for Sony xperia z5
		System.out.println("Price of Sony xperia z5 = " + driver.findElement(By.xpath("//div[h4[a[text()='Sony xperia z5']]]/h5")).getText());
		
		/*xpath using text() --> //div[@class='card-block']/h5[text()='$360']
		 * Css selector --> #tbodyid >div:nth-child(6) >div >div > h5
		 */

		tearDown();
	}
}

/*
Dependent & independent
Question: get price for Sony xperia z5 from https://www.demoblaze.com/
Step1: Identify independent and dependent elements
Independent: Sony xperia z5
dependent: Price

Step2: Right click on Independent element and inspect the element, then slowly drag you mouse pointer in the upwards direction till both dependent and independent elements are covered or highlighted together
Step3: note down the HTML tree structure
Step4: write down xpath for independent element
Step5: with the help of independent element expression drive xpath for common parent
Step6: with the help of comman parent expression drive expression for dependent element

*/