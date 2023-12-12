package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SignUpPage extends TestBase{
	//html/body/div[1]/div/div/div[2]/form/div[4]/p/a
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/form/div[4]/p/a")
	static WebElement SignUpHere_Link;
	
	@FindBy(xpath="//select[@id='title']")
	static WebElement DrpDwn_title;
	
	@FindBy(xpath= "//input[@id='firstName']")
	static WebElement firstName;
	
	@FindBy(xpath= "//input[@id='lastName']")
	static WebElement lastName;
	
	@FindBy(xpath="//input[@id='gender' and @value='M']")
	static WebElement gender;
	
	@FindBy(xpath="//input[@id='dob']")
	static WebElement dob;
	
	@FindBy(xpath="//input[@id='ssn']")
	static WebElement ssn;
	
	@FindBy(xpath="//input[@id='emailAddress']")
	static WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='password']")
	static WebElement password;
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	static WebElement confirmPassword;
	
	@FindBy(xpath="//button[text()='Next']")
	static WebElement Next_Link;
	
	@FindBy(xpath="//input[@id='address']")
	static WebElement address;
	
	@FindBy(xpath="//input[@id='locality']")
	static WebElement locality;
	
	@FindBy(xpath="//input[@id='region']")
	static WebElement region;
	
	@FindBy(xpath="//input[@id='postalCode']")
	static WebElement postalCode;
	
	@FindBy(xpath="//input[@id='country']")
	static WebElement country;
	
	@FindBy(xpath="//input[@id='homePhone']")
	static WebElement homePhone;
	
	@FindBy(xpath="//input[@id='mobilePhone']")
	static WebElement mobilePhone;
	
	@FindBy(xpath="//input[@id='workPhone']")
	static WebElement workPhone;
	
	@FindBy(xpath="//input[@id='agree-terms']")
	static WebElement agreeterms;
	
	@FindBy(xpath="//button[text()='Register']")
	static WebElement Register_Btn;
	
	@FindBy (xpath="//form[@action='/bank/signup']")
	static WebElement form_SignUp_Page1;
	
	//WebElement w = driver.get
	
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonSignUpHere()
	{
		SignUpHere_Link.click();
	}
	
	public void enterSignUpDetailsPage1(String ddtxt, String fname,String lname, String date, String secsn, String email, String pwd, String cpwd)
	{	
		Select dd = new Select(DrpDwn_title);
		dd.selectByVisibleText(ddtxt);
		
		firstName.clear();
		firstName.sendKeys(fname);
	
		lastName.clear();
		lastName.sendKeys(lname);
		
		gender.click();
		
		dob.clear();
		dob.sendKeys(date);
		
		ssn.clear();
		ssn.sendKeys(secsn);
		
		emailAddress.clear();
		emailAddress.sendKeys(email);

		password.clear();
		password.sendKeys(pwd);
		
		confirmPassword.clear();
		confirmPassword.sendKeys(cpwd);
	}
	
	public void clickonNext()
	{
		Next_Link.click();
	}
	
	public void clearform()
	{
		((JavascriptExecutor)driver).executeScript("document.getElementsBytagName('form').reset()");
	}
	
	public void enterSignUpDetailsPage2(String addr,String loc,String reg, String pcode, String ctry, String hphone, String mphone, String wphone)
	{
	
		address.sendKeys(addr);

		locality.sendKeys(loc);
		
		region.sendKeys(reg);
		
		postalCode.sendKeys(pcode);
		
		country.sendKeys(ctry);
		
		homePhone.sendKeys(hphone);
		
		mobilePhone.sendKeys(mphone);
		
		workPhone.sendKeys(wphone);
		
		agreeterms.click();
		
	}
		
	public void clickonRegisterBtn()
	{
		Register_Btn.click();
	}	
}
