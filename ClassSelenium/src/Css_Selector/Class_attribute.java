package Css_Selector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import locators.Base_Class;

public class Class_attribute extends Base_Class {

	public static void main(String[] args) {
		setUp();
		
		driver.get("http://demowebshop.tricentis.com/");
		driver.findElement(By.cssSelector("a.ico-register")).click();
		
		//using tag[attribute = 'value'] CSS selector
		WebElement radio = driver.findElement(By.cssSelector("input[type='radio']"));
		System.out.println("Is radio button for Gender Selection visible ? " + radio.isDisplayed());
		System.out.println("Is radio button for Gender Selection functional/clickable ? " + radio.isEnabled());
		System.out.println("Is radio button for Gender Selection by default selected ? " + radio.isSelected());
		radio.click();
		System.out.println("Is radio button for Gender Selection selected after clicking? " + radio.isSelected());
		
		driver.close();
	}

}


/*
 *Using class value attribute: http://demowebshop.tricentis.com/
 Syntax: .classvalue or htmltag.classvalue
 exp: .textField  or input.textField

HTML Code:
<input type="text" class="text Field" placeholder="Username">
	exp: .text.Field  or input.text.Field
		 .text		  or input.text
		 .Field		  or input.Field
HTML Code:
<input type="text" class="text Field user" placeholder="Username">
	exp: .text
		 .Field
		 .user
		 .text.Field.user
		 .text.Field
		 .Field.user
		 .text.user
 */
