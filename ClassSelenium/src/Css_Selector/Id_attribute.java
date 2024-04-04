package Css_Selector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Id_attribute {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://online.actitime.com/tcs/login.do");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#username")).sendKeys("Ajay2024");
		System.out.println("Size of username field is " + driver.findElement(By.cssSelector("input#username")).getSize());
		
		driver.navigate().to("https://www.gmail.com");
		driver.findElement(By.cssSelector("#identifierId")).sendKeys("9595795842");
		
   	    driver.close();
	}

}

/*CSS Selector: its not an attribute, it is an expression.

HTML Code of actiTime web site-> https://online.actitime.com/tcs/login.do
User name field HTML code
<input type="text" name="username" value="" id="username" class="textField" placeholder="Username">

Email field HTML code for https://www.gmail.com
<input type="email" class="whsOnd zHQkBf" jsname="YPqjbf" autocomplete="username" spellcheck="false" tabindex="0" aria-label="Email or phone" 
name="identifier" value="" aria-disabled="false" autocapitalize="none" id="identifierId" dir="ltr" data-initial-dir="ltr" data-initial-value="">

WebElement element=driver.findElement(By.cssSelector("cssexpression"));

Using id attribute: 
			   Syntax: #idvalue or htmltag#idvalue
				  exp: #username  or input#username
WebElement element=driver.findElement(By.cssSelector("#username"));  //or
WebElement element=driver.findElement(By.cssSelector("input#username"));
*/