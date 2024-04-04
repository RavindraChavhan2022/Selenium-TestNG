package xpath;

import org.openqa.selenium.By;

import locators.Base_Class;

public class Dependent_Independent extends Base_Class {

	public static void main(String[] args) {
		setUp();
		driver.get("https://www.demoblaze.com/");
		//Finding the details of Samsung galaxy s6 mobile along with price
		System.out.println(driver.findElement(By.xpath("//div[h4[a[text()='Samsung galaxy s6']]]")).getText());
		
		//Finding only the Price
		System.out.println("Price of Samsung galaxy s6 = " + driver.findElement(By.xpath("//div[h4[a[text()='Samsung galaxy s6']]]/h5")).getText());
        //CSS Selector for this --> #tbodyid > div:nth-child(1) >div > div >h5
		tearDown();
	}
}

/*
Dependent & independent
Question: get price for Samsung galaxy s6 from https://www.demoblaze.com/
Step1:Identify independent and dependent elements
Independent:Samsung galaxy s6
dependent: Price

Step2:
Right click on Independent element and inspect the element, dn slowly drag you mouse pointer in the upwards direction till both dependent and independent elements are covered or highlighted together

Step3: 
note down the HTML tree structore

Step4:
write down xpath for independent element

Step5:
with the help of independent element expression drive xpath for common parent

Step6:
with the help of comman parent expression drive expression for dependent element

*/