package app.vercel.devProfileEight.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import app.vercel.devProfileEight.tests.BaseTestClass;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listeners implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    String reportName;
//    public WebDriver driver;
//
//    public void setWebDriver(WebDriver driver) {
//        this.driver = driver;
//          }
 
    @Override
    public void onStart(ITestContext context) {

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        reportName = "Test-Report-" + timestamp + ".html";
        String reportPath = System.getProperty("user.dir")+"\\Reports\\report.html";
        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Selenium Automation Report");
        sparkReporter.config().setReportName("Functional Test Automation Report"); // Name of the report
        sparkReporter.config().setTheme(Theme.DARK); // Set report theme to DARK
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Host Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Team3");
        extent.setSystemInfo("OS", "Windows");
    }
    
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test Case PASSED", ExtentColor.GREEN));
        test.generateLog(Status.PASS,"Everything passed");
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test Case FAILED", ExtentColor.RED));
        test.log(Status.FAIL, result.getThrowable()); 
        
        if (DriverSetup.getDriver() != null) {
            String screenshotPath = captureScreenshot(DriverSetup.getDriver(), result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenshotPath);
        } else {
            test.log(Status.WARNING, "WebDriver instance is not set. Cannot capture screenshot.");
        }

    }
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
    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test Case SKIPPED", ExtentColor.ORANGE));
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}