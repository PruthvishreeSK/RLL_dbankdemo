package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SignUpPage;
import pages.TestBase;


public class SignUpTest extends TestBase
{
	
	SoftAssert soft = new SoftAssert();
	SignUpPage sup;
	
	@BeforeMethod
	public void setup()
	{
		sup=new SignUpPage();
	}
	
	Logger logger = LogManager.getLogger(this);
	@Test
	public void testSignUp() throws InterruptedException
	{
		logger.info("Testing Sign Up page");
		sup.clickonSignUpHere();
		Thread.sleep(3000);
		String expectedUrl = driver.getCurrentUrl();
		
		sup.clickonNext();
		
		soft.assertEquals(driver.getCurrentUrl(), expectedUrl, "Assert failed- Reading empty fields");
		
		sup.enterSignUpDetailsPage1("Ms.","Veena", "Shankar", "10/10/1978", "123-45-1234", "pruthvishreesk58@gmail.com", "Veena@123", "Veena@123");
		sup.clickonNext();
		/*Alert alert = driver.switchTo().alert();
		String actual_alert_txt=alert.getText();
		System.out.println(actual_alert_txt);
		/*String expected_alert_txt = "Please select an item in the list";
		soft.assertEquals(actual_alert_txt, expected_alert_txt);*/
		soft.assertEquals(driver.getCurrentUrl(), expectedUrl, "Assert failed- Reading already registered data");
		
		sup.enterSignUpDetailsPage1("Ms.","Veena", "Shankar", "10/10/1978", "123-92-4345", "pruthvi5432@gmail.com", "Veena@123", "Veena@123");
		sup.clickonNext();
		expectedUrl = driver.getCurrentUrl();
		sup.clickonRegisterBtn();
		soft.assertEquals(driver.getCurrentUrl(), expectedUrl, "Assert failed- Reading empty fields");
		
		sup.enterSignUpDetailsPage2("SwimmingPool Extension", "Malleshwearam", "Bengaluru", "511101", "India", "6666666666", "9999999999", "7777777777");
		sup.clickonRegisterBtn();
		
		soft.assertAll();
	}
	
}
