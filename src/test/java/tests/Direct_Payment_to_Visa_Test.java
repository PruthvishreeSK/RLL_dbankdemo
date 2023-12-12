package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Direct_Payment_to_Visa_Page;
import pages.SignInPage;
import pages.TestBase;

public class Direct_Payment_to_Visa_Test extends TestBase {

	Direct_Payment_to_Visa_Page vp;
	SignInPage sip;
	SoftAssert soft = new SoftAssert();
	
	@BeforeMethod
	public void setup()
	{
		vp = new Direct_Payment_to_Visa_Page();
		sip = new SignInPage();
		sip.enterSignInDetails();
	}
	
	Logger logger = LogManager.getLogger(this);
	@Test
	public void testVisaPayment() throws InterruptedException
	{
		
		vp.clickonVisaTransfer();
		String expectedPageUrl = driver.getCurrentUrl();
		vp.clickonSubmit();
		soft.assertEquals(driver.getCurrentUrl(), expectedPageUrl, "Assert failed- Reading empty fields");//pass
		
		
		//driver.navigate().back();
		vp.enterTransferDetails(0, "80");
		vp.clickonSubmit();
		soft.assertEquals(driver.getCurrentUrl(), expectedPageUrl, "Assert failed- Reading data without selecting Account");//fail
		
		vp.clickonVisaTransfer();
		vp.enterTransferDetails(1, "0");
		vp.clickonSubmit();
		soft.assertEquals(driver.getCurrentUrl(), expectedPageUrl, "Assert failed - Accepting 0 amount");//fail
		
		vp.clickonVisaTransfer();
		vp.enterTransferDetails(1, "0.001");
		vp.clickonSubmit();
		soft.assertEquals(driver.getCurrentUrl(), expectedPageUrl, "Assert failed - Accepting 0.001 Amount");//fail
		
		vp.clickonVisaTransfer();
		vp.enterTransferDetails(1, "20");
		vp.clickonSubmit();
		soft.assertNotEquals(driver.getCurrentUrl(), expectedPageUrl, "Assert failed- Not accepting correct values");//pass
		
		soft.fail(vp.ServiceError());
		logger.error(vp.ServiceError());
		soft.assertAll();
		
	}
	
	@AfterMethod
	public void logout()
	{
		sip.logout();
	}
}
