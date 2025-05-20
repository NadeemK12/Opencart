package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
		
	
	public LoginPage (WebDriver driver) {
		
		super(driver);
		
	}

	
	@FindBy(xpath="//*[@name=\"email\"]") WebElement emailAddress;
	@FindBy(xpath="//*[@name=\"password\"]") WebElement validpassword;
	@FindBy(xpath="//*[@value=\"Login\"]") WebElement login;



public void enteremailadd (String emailID ) {
	
	emailAddress.sendKeys(emailID);
	
}

public void enterpassword (String password ) {
	
	validpassword.sendKeys(password);
	
}

public void clkOnLogin () {
	
	login.click();
	
}


}

