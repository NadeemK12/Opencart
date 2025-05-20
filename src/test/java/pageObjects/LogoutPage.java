package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		
	super(driver);	
	}
	
	
	@FindBy(xpath="//*[text()=\"Continue\"]") WebElement continuebtn;
	@FindBy (xpath ="//*[@id=\"content\"]//p[1]") WebElement logoutconfmsg;
	
	
	public void clkOnContinue() {
		
		continuebtn.click();	
	}
	
	public boolean checklogoutmsg() {
		
		try {
		return (logoutconfmsg.isDisplayed());
		}
		
		catch (Exception e){
			
			return(false);
			
		}
		 
	}
	
	
}
