package testNG;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Loan_Dept {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void setUp() {
		System.out.println("I will execute first");

	}

	@Test(priority = 2, groups = { "Smoke" })
	public void take_MobileLoan() {
		System.out.println("Smoke test for MobileLoan : rate of Interest is 7.5% ");
	}

	@Test
	public void take_Car_Loan() {
		System.out.println("rate of Interest is 9.5% ");
	}

	@Test
	public void take_HomeLoan() {
		System.out.println("rate of Interest is 6.5% ");
	}

	@Test
	public void take_FarmLoan() {
		System.out.println("rate of Interest is 3.5% ");
	}

}
