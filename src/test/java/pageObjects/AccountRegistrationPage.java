package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	
	@FindBy(xpath="//*[@name=\"firstname\"]") WebElement firstName;
	@FindBy(xpath="//*[@name=\"lastname\"]") WebElement lastName;
	@FindBy(xpath="//*[@name=\"email\"]") WebElement email;
	@FindBy(xpath="//*[@name=\"telephone\"]") WebElement telephone;
	@FindBy(xpath="//*[@name=\"password\"]") WebElement password;
	@FindBy(xpath="//*[@name=\"confirm\"]") WebElement confirmPassword;
	@FindBy(xpath="//*[@name=\"newsletter\"]") WebElement subscribeBtn;
	@FindBy(xpath="//*[@type=\"checkbox\"]") WebElement checkBox;
	@FindBy(xpath="//*[@type=\"submit\"]") WebElement submit;
	@FindBy(xpath="//*[@id=\"content\"]/p[1]") WebElement confirmationMsg;
	
	
	public void enterFN(String fname) {
		
		firstName.sendKeys(fname);
	}
	
public void enterLN(String lname) {
		
		lastName.sendKeys(lname);
	}
	
public void enterEmail(String emailId) {
	
	email.sendKeys(emailId);
}


public void enterTel(String telno) {
	
	telephone.sendKeys(telno);
}


public void enterPwd(String pwd) {
	
	password.sendKeys(pwd);
}


public void enterCPwd(String cpwd) {
	
	confirmPassword.sendKeys(cpwd);
}

public void clkonSub() {
	
	subscribeBtn.click();
}
public void clkonChkBox() {
	
	checkBox.click();
}


public void clkonsubmit() {
	
	submit.click();
}

public String getConfirmation() {
	
	try {
		
		return(confirmationMsg.getText());
	}
	catch (Exception e) {
		
		return (e.getMessage());
	}
}

}

