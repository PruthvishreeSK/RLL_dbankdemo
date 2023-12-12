package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Deposit_into_Account_Page;
import pages.SignInPage;
import pages.TestBase;


public class Deposit_into_Account_Test extends TestBase {
	
	Deposit_into_Account_Page ds;
	SignInPage sip;
	
	@BeforeMethod
	public void setup()
	{
		sip=new SignInPage();
		ds=new Deposit_into_Account_Page();
		sip.enterSignInDetails();
	}
	
	Logger logger = LogManager.getLogger(this);
	@Test()
	public void testwithdraw() throws InterruptedException
	{
		logger.info("Checking Reset button");
		ds.clickonDeposit();
		String expectedUrl=driver.getCurrentUrl();
		ds.enterDepositDetails("Individual Checking (Standard Checking)", "30");
		Thread.sleep(3000);
		
		ds.clickonReset();
		logger.info("Checking Submit button ");
		ds.clickonSubmit();
		Thread.sleep(3000);
		/*Alert alert = driver.switchTo().alert();
		String actual_alert_txt=alert.getText();
		System.out.println(actual_alert_txt);
		String expected_alert_txt = "Please select an item in the list";
		Assert.assertEquals(actual_alert_txt, expected_alert_txt);
		*/
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Assert failed- Reading empty fields");
		ds.enterDepositDetails("Individual Checking (Standard Checking)", "0");
		ds.clickonSubmit();
		System.out.println(ds.captureError());
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Assert failed- Accepting amount as 0");
		
		ds.enterDepositDetails("Individual Checking (Standard Checking)", "9");
		ds.clickonSubmit();
		Assert.assertNotEquals(driver.getCurrentUrl(), expectedUrl, "Assert failed- Unsuccessful Transaction");
	}
	
	@AfterMethod
	public void logout()
	{
		sip.logout();
	}
}
