package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
    public Properties p;
	@SuppressWarnings("deprecation")
	@BeforeClass
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException {
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		logger = LogManager.getLogger(this.getClass());
		
	//	driver = new ChromeDriver();
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else if (os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name.."); return;
	
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		

		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		switch(br.toLowerCase())
		
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver();break;
		default: System.out.println("invalid Brwser name");
		return;
		}
		}
		//Loading properties file
		FileReader fr = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(fr);
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(p.getProperty("appUrl"));
		
		
		System.out.println("able to lunch url");
		
		
	
	
	}
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
		return (st+"."+no) ;
		
	}
	
	
	
	public String CaptureScreen(String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
		TakesScreenshot takesSceenshot = (TakesScreenshot) driver;
		File sourceFile = takesSceenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots" + tname + "_" + timeStamp+ ".png";
		File targetFile = new File (targetFilePath);
		sourceFile.renameTo(targetFile);
		
		
		return targetFilePath;
		
		
		
	}
	
}
