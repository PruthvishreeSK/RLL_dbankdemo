package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_TRN_ViewChecking_Page extends TestBase{

	@FindBy(id="checking-menu")
	static WebElement Btn_checkingmenu;
	
	@FindBy(id="view-checking-menu-item")
	static WebElement Btn_viewcheckingmenuitem;
	
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	static WebElement searchbox_transactionTablefilter;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	static WebElement no_match_txt;
	
	
	
	public Search_TRN_ViewChecking_Page() { 
		 PageFactory.initElements(driver,this); 
		 }
	
	public void clickonCheckingPage() { 
		 	
		Btn_checkingmenu.click();
		Btn_viewcheckingmenuitem.click(); 
		
		}

	public void searchtrn(String trn)
	{
		searchbox_transactionTablefilter.clear();
		searchbox_transactionTablefilter.sendKeys(trn);
	}
	
	public String capturetext()
	{
		String captured_txt=no_match_txt.getText();
		return captured_txt;
		
	}
	
}