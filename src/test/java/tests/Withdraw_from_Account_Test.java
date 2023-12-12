package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SignInPage;
import pages.TestBase;
import pages.Withdraw_from_Account_Page;

public class Withdraw_from_Account_Test extends TestBase {

	Withdraw_from_Account_Page wd;
	SignInPage sip;
	
	@BeforeMethod
	public void setup()
	{
		sip=new SignInPage();
		wd=new Withdraw_from_Account_Page();
		sip.enterSignInDetails();
	}
	
	
	@Test()
	public void testwithdraw() throws InterruptedException
	{
		wd.clickonWithDraw();
		String expectedUrl=driver.getCurrentUrl();
		wd.enterWithdrawDetails("Individual Checking (Standard Checking)", "20");
		
		Thread.sleep(3000);
		
		wd.clickonReset();
		
		
		Thread.sleep(3000);
		
		wd.clickonSubmit();
		Thread.sleep(3000);
		/*Alert alert = driver.switchTo().alert();
		String actual_alert_txt=alert.getText();
		System.out.println(actual_alert_txt);
		String expected_alert_txt = "Please select an item in the list";
		Assert.assertEquals(actual_alert_txt, expected_alert_txt);
		*/
		
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Assert failed- Reading empty fields");
		wd.enterWithdrawDetails("Individual Checking (Standard Checking)", "0");
		wd.clickonSubmit();
		System.out.println(wd.captureError());
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Assert failed- Accepting amount as 0");
		
		wd.enterWithdrawDetails("Individual Checking (Standard Checking)", "20");
		wd.clickonSubmit();
		
		Assert.assertNotEquals(driver.getCurrentUrl(), expectedUrl, "Assert failed- Unsuccessful Transaction");
	}
	
	@AfterMethod
	public void logout()
	{
		sip.logout();
	}
	
}
