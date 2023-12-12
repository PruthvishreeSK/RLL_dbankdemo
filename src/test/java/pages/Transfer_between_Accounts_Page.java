package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Transfer_between_Accounts_Page extends TestBase{

	@FindBy(xpath="//a[@id='transfer-menu-item']")
	static WebElement Link_TransferBetweenAccounts;

	@FindBy(xpath="//select[@id='fromAccount']")
	static WebElement DrpDwn_fromAcnt;

	@FindBy(xpath="//select[@id='toAccount']")
	static WebElement DrpDwn_toAcnt;

	@FindBy(xpath="//input[@id='amount']")
	static WebElement TxtBox_Amt;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-sm']")
	static WebElement Btn_Reset;

	@FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
	static WebElement Btn_Submit;
	
	@FindBy(xpath="//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']/child::span[2]")
	static WebElement Error_0_Amt; 
	
	public Transfer_between_Accounts_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonTransferBetweenAcnts()
	{
		Link_TransferBetweenAccounts.click();
	}
	
	public void enterAcntsDetails(int dd1_index, int dd2_index, String amt)
	{
		Select dd1 = new Select(DrpDwn_fromAcnt);
		dd1.selectByIndex(dd1_index);
		Select dd2 = new Select(DrpDwn_toAcnt);
		dd2.selectByIndex(dd2_index);
		TxtBox_Amt.clear();
		TxtBox_Amt.sendKeys(amt);
	}
	
	public void clickonReset()
	{
		Btn_Reset.click();
	}
	
	public void clickonSubmit()
	{
		Btn_Submit.click();
	}
	
	public String captureError()
	{
		String errortxt=Error_0_Amt.getText();
		return errortxt;
	}

}
