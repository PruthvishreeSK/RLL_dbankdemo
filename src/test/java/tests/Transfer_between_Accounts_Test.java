package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SignInPage;
import pages.TestBase;
import pages.Transfer_between_Accounts_Page;

public class Transfer_between_Accounts_Test extends TestBase{

	SignInPage sip;
	Transfer_between_Accounts_Page tba;
	
	@BeforeMethod
	public void setup()
	{
		sip = new SignInPage();
		tba = new Transfer_between_Accounts_Page();
		sip.enterSignInDetails();
	}
	
	@Test
	public void testTransfer()
	{
		tba.clickonTransferBetweenAcnts();
		String expectedUrl=driver.getCurrentUrl();
		tba.clickonSubmit();
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Assert failed- Reading empty fields");
		
		tba.enterAcntsDetails(1, 2, "10");
		tba.clickonReset();
		
		tba.enterAcntsDetails(1, 2, "0");
		tba.clickonSubmit();
		System.out.println(tba.captureError());
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Assert failed- Accepting amount as 0");
		
		tba.enterAcntsDetails(2, 1, "20");
		tba.clickonSubmit();
		Assert.assertNotEquals(driver.getCurrentUrl(), expectedUrl, "Assert failed- Unsuccessful Transaction");
		
	}
	
	@AfterMethod
	public void logout()
	{
		sip.logout();
	}
}
