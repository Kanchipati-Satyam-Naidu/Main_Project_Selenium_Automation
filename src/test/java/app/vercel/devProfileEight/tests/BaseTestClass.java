package app.vercel.devProfileEight.tests;

import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import app.vercel.devProfileEight.pageObjects.HomePage;
import app.vercel.devProfileEight.pageObjects.PortfolioPage;
import app.vercel.devProfileEight.utilities.DriverSetup;
import app.vercel.devProfileEight.utilities.ExtentReportManager;
import app.vercel.devProfileEight.utilities.Loadproperties;

public class BaseTestClass {
	public WebDriver driver;
	public HomePage homePage;
	public Properties props;
	public PortfolioPage portfolioPage;
	public Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(@Optional("edge") String browser) {
		logger=LogManager.getLogger(this.getClass());
		logger.info("Starting the Web Driver");
		driver=DriverSetup.getDriver(browser);
		props=Loadproperties.loadProps();
		String baseUrl=props.getProperty("baseUrl");
		driver.get(baseUrl);
		logger.info("Navigated to the url: "+baseUrl);
		homePage=new HomePage(driver);
		portfolioPage=new PortfolioPage(driver);
	}
	
	@BeforeMethod
	public void methodSetup(Method method) {
		ExtentReportManager.createTest(method.getName());
	}
	
	@AfterMethod
	public void methodTearDown() {
		ExtentReportManager.flushReports();
	}
	
	@AfterClass
	public void tearDown() {
		
		DriverSetup.quitdriver();
	}
}
