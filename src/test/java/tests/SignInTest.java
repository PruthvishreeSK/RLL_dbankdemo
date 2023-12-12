package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.SignInPage;
import pages.TestBase;
import utilities.ExcelRead;

public class SignInTest extends TestBase{

	SignInPage sip;
	
	@BeforeMethod
	public void setup()
	{
		
		sip = new SignInPage();
	}
	
	@Test(dataProvider = "testdata")
	public void testmultipleLogin(String u, String p)
	{
		sip.enterMultipleSignIn(u, p);
		try {
		sip.logout();
		}
		catch(Exception e)
		{
			Assert.fail("Logout is not available - Hence Unsuccessful SignIn");
		}
	}
	
	@DataProvider(name="testdata")
	public Object[][] datasupplier() throws EncryptedDocumentException, IOException
	{
		
		Object input[][] = ExcelRead.getTestData("Sheet1");
		return input;
		
	}
	
}
