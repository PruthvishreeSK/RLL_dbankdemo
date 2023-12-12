package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_TRN_ViewSaving_Page extends TestBase {

	
		@FindBy(xpath="//*[@id='savings-menu']/i")
		static WebElement Btn_savingsmenu;
		
		@FindBy(xpath="//a[@id='view-savings-menu-item']")
		static WebElement Btn_viewsavingsmenuitem;
		
		@FindBy(xpath="//*[@type='search']")
		static WebElement searchbox_transactionTablefilter;
		
		@FindBy(xpath="//tr[@class='odd']/child::td[3]")
		static WebElement Assert_tabledata;
		
		@FindBy(xpath="//td[@class='dataTables_empty']")
		static WebElement no_match_txt;
		
		public Search_TRN_ViewSaving_Page() { 
			 PageFactory.initElements(driver,this); 
			 }
		
		public void clickSavingPage() { 
			 	
			Btn_savingsmenu.click();
			Btn_viewsavingsmenuitem.click(); 
			
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
