package gener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListimplClass  implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;
	JavaUtils jLib=new JavaUtils();
	
	@Override 
	public void onTestStart(ITestResult result) {
		 
		//test script execution starts from here
		String methodName=result.getMethod().getMethodName();
		test =report.createTest(methodName);
		Reporter.log(methodName+"---------Execution started---------");
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"passed");
		
	} 

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		
		try {
			String path = WebDriverUtils.getScreenshot(BaseClass.sdriver,methodName);
			test.addScreenCaptureFromPath(path);
			
			test.log(Status.FAIL, methodName+"failed");
			test.log(Status.FAIL, result.getThrowable());
			
			Reporter.log(methodName+"------> Failed");		
			
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
			}

	@Override
	public void onStart(ITestContext context) {
		JavaUtils jLib=new JavaUtils();
		//configure report
				ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\extentReport\\report"+jLib.getSystemDateFormat()+".html");
				htmlreport.config().setDocumentTitle("SDET 53");
				htmlreport.config().setTheme(Theme.STANDARD);
				htmlreport.config().setReportName("BANKO Oversight");
				
			    report=new ExtentReports();
				report.attachReporter(htmlreport);
				report.setSystemInfo("Base Platform", "OS");
				report.setSystemInfo("Base Browser", "chrome");
				report.setSystemInfo("Base URL", "http://rmgtestingserver/domain/Online_Banking_System/");
				report.setSystemInfo("Reporter Name", "Akshata");
			}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
	}
}


//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']//span[@class='a-price-whole']


//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']

//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole']

//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::div[@class='puisg-row']//span[@class='a-price']

//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price']
