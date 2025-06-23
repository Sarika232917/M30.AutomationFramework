package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provide implementation to ITestListener interface of testNG
 * @author sarik
 */

//how to get this method automatically
//step -Right click on class name select source override/implementation method and check ITestListener
public class ListenersImplementationUtility implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	
	public void onTestStart(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+" -Test Execution Started");
		
		//Create test for extent report
		test=report.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+" -Test is Pass");
		
		//log the status of test to extent report
		test.log(Status.PASS,methodname+"-Test is pass");
	}


	public void onTestFailure(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+" -Test is Fail");
		
		
		//log the status of test to extent report
		test.log(Status.FAIL,methodname+"-Test is fail");
		
		//capture the exception
		System.out.println(result.getThrowable());
				
		//log the exception in extent report
		test.log(Status.WARNING,result.getThrowable());
				
		
		//capture screenshot
		SeleniumUtility s=new  SeleniumUtility();
		JavaUtility j=new JavaUtility();
		
		//configure screenshot name
		String screenshotname=methodname+"-"+j.getSystemDate();
		
		try {
			String path=s.captureScreenshot(BaseClass.sdriver,screenshotname);
			
			//attach screenshot to extent report
			test.addScreenCaptureFromPath(path, methodname);
		}
		catch(IOException e)
		{
			//Todo auto generated catch block
			e.printStackTrace();
		}
	}

	
	public void onTestSkipped(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+" -Test is skip");
		
		//capture the exception
		System.out.println(result.getThrowable());
		
		//log the status of test to extent report
		test.log(Status.SKIP,methodname+"-Test is skip");
		
		//capture the exception
		System.out.println(result.getThrowable());
		
		//log the exception in extent report
		test.log(Status.WARNING,result.getThrowable());
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) {
		System.out.println("Suite execution started");
		
		//Basic configuration of Extent Report
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Swag labs Automation execution report");
		esr.config().setReportName("Sawg labs execution report");
		esr.config().setTheme(Theme.DARK);
		
		//Configure extent report
	    report=new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base browser", "Microsoft edge");
		report.setSystemInfo("Base platform", "Windows");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Base URL", "Test URL");
		report.setSystemInfo("Reporter name", "Sarika");
	}

	
	public void onFinish(ITestContext context) {
		System.out.println("Suite execution Finished");
		
		//Generate extents report
		report.flush();
	}

}
