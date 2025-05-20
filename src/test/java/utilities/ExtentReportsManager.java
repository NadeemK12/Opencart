package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.BaseClass;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;
/*
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme; */

public class ExtentReportsManager implements ITestListener {

	//public ExtentSparkReporter sparkReporter;
	//public ExtentReports extent;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	public void onStart(ITestContext testContext) {
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-"+ timestamp + ".html";
		sparkReporter  = new ExtentSparkReporter(".\\reports\\"+repName);
		
		sparkReporter.config().setDocumentTitle("opencart Automation Report");
		sparkReporter.config().setReportName("opencart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("User.name"));
		extent.setSystemInfo("Environment", "QA");
				
		
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		

		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroups.isEmpty()) {
			
			extent.setSystemInfo("Groups", includeGroups.toString());
			
		}
		

		
		
	}
	
	public void onTestSuccess(ITestResult results) {
		
		test = extent.createTest(results.getTestClass().getName());
		test.assignCategory(results.getMethod().getGroups());
		test.log(Status.PASS, results.getName()+ "got suce4ssfully executed");
	}
	
	public void onTestFailuer(ITestResult results) {
		test = extent.createTest(results.getTestClass().getName());
		test.assignCategory(results.getMethod().getGroups());
		test.log(Status.FAIL, results.getName()+ "got Failed");
		test.log(Status.INFO, results.getThrowable().getMessage());
		
		try {
			String imgPath = new BaseClass().CaptureScreen(results.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		}
		catch (IOException e1){
			e1.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult results) {
		test = extent.createTest(results.getTestClass().getName());
				
		test.assignCategory(results.getMethod().getGroups());
		test.log(Status.SKIP, results.getName()+ "got skipped");
		test.log(Status.INFO, results.getThrowable().getMessage());
		
	}
	
	public void onFinish(ITestContext testContext) {
	
		
		extent.flush();
		String pathofExtentsReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		
		File extentReport = new File(pathofExtentsReport);
		
		try {
			
			Desktop.getDesktop().browse(extentReport.toURI());
			
		}
		
		
		catch(Exception e2) {
			
			e2.printStackTrace();
		}
		
	}
	
	
	
}
