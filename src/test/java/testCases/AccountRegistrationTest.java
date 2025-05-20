package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass {
	
	
	
   // WebDriver driver;
	
/*	@BeforeClass
	
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		*/
	
	
	@Test
	public void verify_account_registration() {
		
		try {
		logger.info("***** Starting Test *******");
		
		HomePage  hp = new HomePage(driver);
		hp.clkOnAccount();
		
		logger.info("clicked on Account");
		hp.clkOnRegister();
		
		logger.info("clicked on Registration");
		String password = randomString();
		AccountRegistrationPage ac= new AccountRegistrationPage(driver);
		logger.info("Entering the inputs");
		ac.enterFN(randomString());
		ac.enterLN(randomString());
		ac.enterEmail(alphaNumeric()+"@xyz.com");
		ac.enterTel(randomNumber());
		ac.enterPwd(password);
		ac.enterCPwd(password);
		ac.clkonSub();
		ac.clkonChkBox();
		ac.clkonsubmit();
	String msg = ac.getConfirmation();
	
	logger.info("validating the message");
		Assert.assertEquals(msg, "Congratulations! Your new account has been successfully created!");
		
		
		}
		
		catch(Exception e){
			//logger.debug("failed messages");
			logger.error("Error Messages");
			
			Assert.fail();
		}
	
		logger.info("*********  Testing Finished  ********");
		
	}
/*	
	@AfterClass
	
	public void tearDown() {
		
		driver.quit();
	}
	

	public String randomString() {
		
		String generatedsString = RandomStringUtils.randomAlphabetic(5);
		
		return generatedsString;
	}
	
	public String randomNumber()
	{
		
String generatedNo = RandomStringUtils.randomNumeric(9);
		
		return generatedNo ;
		
	}
	
	
	public String alphaNumeric() {
String st = RandomStringUtils.randomAlphabetic(4);
String no = RandomStringUtils.randomNumeric(3);		
		return (st+"@"+no) ;
		
	}*/
}
