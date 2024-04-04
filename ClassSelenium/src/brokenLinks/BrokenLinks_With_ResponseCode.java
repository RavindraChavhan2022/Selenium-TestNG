package brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinks_With_ResponseCode {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		for(WebElement link : links) {
			String url =link.getAttribute("href");
			HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
	        connection.setRequestMethod("HEAD");
	        connection.connect();
	        int responseCode = connection.getResponseCode();
	        System.out.println("Response of the link is : " + responseCode);
	       
	        if(responseCode>400) {
	        	System.out.println("The link for " + link.getText() + " is broken with code " + responseCode);
	        	
	        }
	     
		}
			
	}

}
