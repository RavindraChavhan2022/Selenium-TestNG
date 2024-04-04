package test_Cases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base_Test {

	public static WebDriver driver;
	public static final String BASE_URL = "http://www.demo.guru99.com/";

	// Valid account for login
	public static final String USER_NAME = "mngr559492";
	public static final String PASSWD = "syjebet";
	
	// Expected output
    public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
    public static final String EXPECT_ERROR = "User or Password is not valid";

    public static final String PATTERN = "Manger Id :";
    public static final String FIRST_PATTERN = "mngr";
    public static final String SECOND_PATTERN = "[0-9]+";


	public void openBrowser_And_Url() {
		String browser = "firefox";
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("safari")) {
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
}

/*
 * guru99 Login Details UserId --> mngr559492 Password --> syjebet
 */