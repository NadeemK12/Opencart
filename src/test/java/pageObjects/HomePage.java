package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		
    super(driver);	
	}

	
	@FindBy(xpath="//span [text()= 'My Account']") WebElement myaccount;
	@FindBy(xpath="//*[text()='Register']") WebElement register;
	@FindBy(xpath="//*[text()='Login']")	WebElement login;
	
	public void clkOnAccount() {
		
		myaccount.click();
		
		System.out.println("able to click on myaccount");
		
	}
	
public void clkOnRegister() {
		
		register.click();
		System.out.println("able to click on Register");
	}
	

public void clkOnLogin() {
	
	login.click();
	System.out.println("able to click on login");
}


	
	
	
}
