package app.vercel.devProfileEight.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
	
	public static ExtentReports getInstance() {
		if(extent==null) {
			String path=System.getProperty("user.dir")+"//Reports//report.html";
			ExtentSparkReporter reporter=new ExtentSparkReporter(path);
			reporter.config().setDocumentTitle("Selenium Automation Report");
	        reporter.config().setReportName("Functional Test Automation Report"); // Name of the report
	        //reporter.config().setTheme(Theme.DARK);
			extent=new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}
	
	public static void createTest(String testName) {
		String browserName=DriverSetup.getBrowserName();
		ExtentTest testCase=getInstance().createTest(browserName+"_"+testName);
		testCase.assignCategory(browserName);
		test.set(testCase);
	}
	
	public static ExtentTest getTest() {
		
		return test.get();
	}
	
	public static void flushReports() {
		getInstance().flush();
	}
}
