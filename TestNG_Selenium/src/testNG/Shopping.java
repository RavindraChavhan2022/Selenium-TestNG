package testNG;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Shopping {

	@BeforeSuite
	public void BSuite() {
		System.out.println("Before Suite Annotation");
	}

	@Test
	public void Create_Account() {
		System.out.println("Amazon account has been created");
	}

	@Test(priority = 3 , groups= {"Smoke"})
	public void Login() {
		System.out.println("Smoke test for Login : User is able to login ");
	}

	@Test
	public void Search_Product() {
		System.out.println("User is able to search products ");
	}

	@Test
	public void Add_To_Cart() {
		System.out.println("User is able to add items to cart ");
	}

	@Test
	public void Make_Payment() {
		System.out.println("User is able to pay using GooglePay ");
	}

}
