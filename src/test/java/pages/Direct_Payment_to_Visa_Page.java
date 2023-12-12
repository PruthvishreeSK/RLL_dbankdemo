package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Direct_Payment_to_Visa_Page extends TestBase {

	@FindBy(xpath="//a[@id='visa-transfer-menu-item']")
	static WebElement Link_VisaTransfer;
	
	@FindBy(xpath="//select[@id='extAccount']")
	static WebElement DrpDwn_SelectAcnt;
	
	@FindBy(xpath = "//input[@id='extAmount']")
	static WebElement TxtBox_Amt;
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	static WebElement Btn_SubmittoVisa;
	
	@FindBy(xpath = "//span[@class='badge badge-pill badge-danger']")
	static WebElement service_error;
	
		 public Direct_Payment_to_Visa_Page() {
				
			    PageFactory.initElements(driver, this);
		 }
		 
		public void clickonVisaTransfer()
		{
			Link_VisaTransfer.click();
		}
		
		public void enterTransferDetails(int ddindex, String amt)
		{
			Select dd = new Select(DrpDwn_SelectAcnt);
			dd.selectByIndex(ddindex);
			TxtBox_Amt.sendKeys(amt);
		}
		
		public void clickonSubmit()
		{
			Btn_SubmittoVisa.click();
		}
		
		public String ServiceError()
		{
			String errortxt = service_error.getText();
			return errortxt;
		}
}
