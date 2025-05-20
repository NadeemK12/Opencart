package testCases;

//import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
//import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
//import utilities.ExcelUtilities;

public class VerifyLoginDataDDTTest extends BaseClass {
	
	
@Test (dataProvider = "LoginData", dataProviderClass = DataProviders.class)	

	public void verify_Login(String emailID, String password, String Response) {
		
		
		logger.info("*********** Testin DDT Started *************");
		
		try {
		
		HomePage hp = new HomePage(driver);
		
		//Thread.sleep(5000);
		hp.clkOnAccount();
		hp.clkOnLogin();
		LoginPage lp = new LoginPage(driver);
		lp.enteremailadd(emailID);
		lp.enterpassword(password);
		lp.clkOnLogin();
		
		
		MyAccountPage map = new MyAccountPage(driver);
		/*Assert.assertTrue(map.loginConfirmation());
		map.logout();
	LogoutPage lgp = new LogoutPage(driver);
	Assert.assertTrue(lgp.checklogoutmsg());	
		
	lgp.clkOnContinue();
		*/
		
	boolean targetpage = 	map.loginConfirmation();
		if(Response.equalsIgnoreCase("Valid")) {
			
			if (targetpage == true) {
				
				hp.clkOnAccount();
				map.logout();
				Assert.assertTrue(true);
			}
			
			else 
			{
				Assert.assertTrue(false);
			}
			
		}
		
		
		if(Response.equalsIgnoreCase("Invalid")) {
			
if (targetpage == true) {
				
				map.logout();
				Assert.assertTrue(false);
			}
			
else {
	
	Assert.assertTrue(true);
}
		}
	} catch(Exception e) {
		
		Assert.fail("An Exception occured..." + e.getMessage());
	}
		
	logger.info("***** Veification Completed *******");
} 
	
	
}