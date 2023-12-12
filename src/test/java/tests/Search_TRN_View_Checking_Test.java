package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Search_TRN_ViewChecking_Page;
import pages.SignInPage;
import pages.TestBase;

public class Search_TRN_View_Checking_Test extends TestBase {

	Search_TRN_ViewChecking_Page strn;
	SignInPage sip;
	
	@BeforeMethod
	public void setup()
	{
		sip=new SignInPage();
		strn = new Search_TRN_ViewChecking_Page();
		sip.enterSignInDetails();
	}
	
	
	@Test
	public void testSearchTRN()
	{
		String expected_txt = "No matching records found";
		strn.clickonCheckingPage();
		strn.searchtrn("845586594");
	
		strn.searchtrn("845586877");
		Assert.assertEquals(strn.capturetext(), expected_txt);
	}
	
	@AfterMethod
	public void logout()
	{
		sip.logout();
	}
}
