package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATM {
	//Test cases by default executed on the basis of alphabetical order if we don't give priority
	@Test
	public void ATM_Name() {
		System.out.println("Ravindra Chavhan ");
	}
	@Test
	public void ATM_Pin() {
		System.out.println("1234 ");
	}
	@BeforeMethod  // It will execute before every method of that particular Class
	public void setUp() {
		System.out.println("SetUp for opening of Browser, Url etc.");
	}
	
	@Test(priority = 1 , groups= {"Smoke"})
	public void ATM_Number() {
		System.out.println("Smoke test for ATM number : 79823556");
	}
	
	@AfterSuite
	public void ASuite() {
		System.out.println("After Suite Annotaion");
	}
	@Test
	public void ATM_Expiry() {
		System.out.println("24/04/2050");
	}
	
	@AfterMethod  // It will execute after every method of this class.
	public void tearDown() {
		System.out.println("Closing of the Browser");
	}
	
	@Test
	public void ATM_CVC() {
		System.out.println("786");
	}
	@Test
	public void ATM_Type() {
		System.out.println("Rupay Silver ");
	}
	
	@Test
	public void ATM_Password() {
		System.out.println("6475");
	}
	
	@Test
	public void Insert_ATM() {
		System.out.println("ATM inserted");
	}
	
	@Test
	public void Enter_Pin() {
		System.out.println("Entering Pin");
	}
	
	@Test
	public void Withdraw_Cash() {
		System.out.println("Cash withdraw ");
	}



}
