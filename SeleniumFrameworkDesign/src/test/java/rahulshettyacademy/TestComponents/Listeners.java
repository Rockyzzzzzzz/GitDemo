package rahulshettyacademy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.resources.ExportReporterNg;

public class Listeners extends BaseTest implements ITestListener
{
	ExtentTest test;
	ExtentReports extent= ExportReporterNg.getReportObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>(); //thread safe   to avoid overidding of test object for all the testcases entry
	@Override
	public void onTestStart(ITestResult result) 
	{
		
		test= extent.createTest(result.getMethod().getMethodName());   //result.getMethod().getMethodName() -----> gives testcase name
		extentTest.set(test);//unique thread id of each tests
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
		//test.log(Status.PASS, "Test Passed");
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		
		//test.log(Status.FAIL, "Test Failed");
		//test.fail(result.getThrowable());   //result.getThrowable()-----> gives test failed message
		extentTest.get().fail(result.getThrowable());
		
		//Give life for driver
		try 
		{
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			
		} catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		//screenshot
		String filePath = null;
		try 
		{
			filePath = getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		   extent.flush();
		
	}

}
