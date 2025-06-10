package app.vercel.devProfileEight.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestNGListeners implements ITestListener{

//	@Override
//	public void onTestStart(ITestResult result) {
//		ExtentReportManager.createTest(result.getMethod().getMethodName());
//		
//	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReportManager.getTest().pass(MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test Case PASSED", ExtentColor.GREEN));
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReportManager.getTest().fail(MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test Case FAILED", ExtentColor.RED));
		ExtentReportManager.getTest().log(Status.INFO, result.getThrowable());
		if (DriverSetup.getDriver() != null) {
            String screenshotPath = captureScreenshot(DriverSetup.getDriver(), result.getMethod().getMethodName());
            ExtentReportManager.getTest().addScreenCaptureFromPath(screenshotPath);
        } else {
        	ExtentReportManager.getTest().log(Status.WARNING, "WebDriver instance is not set. Cannot capture screenshot.");
        }
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReportManager.getTest().skip(MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test Case SKIPPED", ExtentColor.ORANGE));
	}
	
//	@Override
//	public void onFinish(ITestContext context) {
//		ExtentReportManager.flushReports();
//		System.out.println("On finish method executed");
//	}
	
	
	public String captureScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";
        String destination = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName;
 
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
            return destination;
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
            return e.getMessage();
        }
    }
	
}
