package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {

	@Test
	public void verify_login() {
		
	try {	
		logger.info("******* Verify Loogin Test **************");
		
		HomePage hp = new HomePage(driver);
		hp.clkOnAccount();
		hp.clkOnLogin();
		
		
		LoginPage lp = new LoginPage(driver);
		
		lp.enteremailadd(p.getProperty("email"));
		lp.enterpassword(p.getProperty("password"));
		lp.clkOnLogin();
		
				
		MyAccountPage map = new MyAccountPage(driver);
		Assert.assertTrue(map.loginConfirmation());
		hp.clkOnAccount();
		map.logout();
		
	
		
	}
	
	catch(Exception e) {
		
	Assert.fail();	
	}
		
	
	logger.info(" ****** Login Test Completed *******");
	
	}
}
