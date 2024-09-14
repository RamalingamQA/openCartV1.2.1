package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReport implements ITestListener{
	public ExtentSparkReporter sp;
	public ExtentReports extent;
	public ExtentTest test;
	public String repName;
	public void onStart(ITestContext context) {
	    //create timeStamp for reportfilename
		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String timestamp=df.format(dt);
		String repName="TestReport"+timestamp+".html";// report file name
		
		//Create Report using SparkReport and write how it shoud look
		
		sp=new ExtentSparkReporter(".\\Reports\\"+ repName);
		sp.config().setDocumentTitle("TestReport");
		sp.config().setReportName("ExtentReport");
		sp.config().setTheme(Theme.DARK);
		
		//general attributes like QA name,app name,browser name,groups name if included
		extent=new ExtentReports();
		extent.attachReporter(sp);
		extent.setSystemInfo("applicationName", "Opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub-Module", "Customer");
		extent.setSystemInfo("TesterName", System.getProperty("user.dir"));
		String os=context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("OS", os);
		extent.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
		List<String> includeGroups=context.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroups.isEmpty()) {
			extent.setSystemInfo("groups", includeGroups.toString());
		}
	}
		
		public void onTestSuccess(ITestResult result) {
			//create testinstance on report with test case(java file) name
		    test=extent.createTest(result.getTestClass().getName());
		    //create a category with group name on the report
		    test.assignCategory(result.getMethod().getGroups());
		    test.log(Status.PASS, result.getName()+"is passed");		    		
		}
		
		public void onTestFailure(ITestResult result) {
		    test=extent.createTest(result.getTestClass().getName());
		    test.assignCategory(result.getMethod().getGroups());
		    test.log(Status.FAIL, result.getName()+" is failed");
		    test.info(result.getThrowable().getMessage());
		    try {
		    	String impPath=new BaseClass().capturescreenshot(result.getName());//send testmethod name to base class to make the screenshot stored with test method name
		    	test.addScreenCaptureFromPath(impPath);
		    	}
		    catch(Exception e) {
		    	e.printStackTrace();
		    }
		}
		    
		public void onTestSkipped(ITestResult result) {
			test=extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP,result.getName()+"is skipped");
		      }
		
		public void onFinish(ITestContext context) {
			extent.flush();	
			
		}  
		   
}
