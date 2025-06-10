package app.vercel.devProfileEight.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import app.vercel.devProfileEight.utilities.DataProviders;
import app.vercel.devProfileEight.utilities.ExtentReportManager;

public class TS01_HomePageValidation extends BaseTestClass {

	//public final Logger logger=LogManager.getLogger(TS01_HomePageValidation.class);
	
	@Test(groups= {"Sanity","Master"})
	public void checkWebTitle() {
		logger.info("Verifying the Webpage title");
		driver.navigate().refresh();
		String homePageTitle=props.getProperty("homePageTitle");
		Assert.assertEquals(homePage.getWebTitle(), homePageTitle);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Web Title is correct", ExtentColor.BLUE));

	}
	
	@Test(groups= {"Sanity","Master"})
	public void headerCheck() {
		logger.info("Verifying the Header is present and Correct");
		driver.navigate().refresh();
		Assert.assertTrue(homePage.pageTitleIsDisplayed(),"Page Heading is not displayed" );
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Page Heading is Displayed", ExtentColor.BLUE));
		String header=homePage.getPageHeading();
		Assert.assertEquals(header,"DevProfile","Page heading is not correct ");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Page Sub Heading is Displayed", ExtentColor.BLUE));
	}
	
	@Test(groups= {"Sanity","Master"})
	public void subTitleCheck() {
		driver.navigate().refresh();
		logger.info("Verifying the Subheading is present and Correct");
		Assert.assertTrue(homePage.subTitleIsDisplayed(), "Page subheading is not displayed");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Page Sub Heading is Displayed", ExtentColor.BLUE));
		String subHeading=homePage.getSubHeading();
		Assert.assertEquals(subHeading,"Showcase your development journey with style","Sub heading is not correct");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Page Sub Heading is Correct", ExtentColor.BLUE));
	}
	
	
	@Test(dataProviderClass=DataProviders.class,groups= {"Sanity","Master"})
	public void nameFieldEnableCheck() {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.fullNameInpIsEnabled(),"Full Name Input Box is not Enabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Full name input field is enabled", ExtentColor.BLUE));
		String fullName="Sudhan";
		String fName=homePage.setFullName(fullName);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered 'Sudhan' in full name field", ExtentColor.BLUE));
		Assert.assertEquals(fName,fullName,"Entered and retrieved Fullnames are not same");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved Fullnames are same", ExtentColor.BLUE));
	}
	
	
	@Test(dataProviderClass=DataProviders.class,groups= {"Sanity","Master"})
	public void emailFieldEnableCheck() {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.emailInpIsEnabled(),"Email Input Box is not Enabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Email input field is enabled", ExtentColor.BLUE));
		String email="manoj@gmail.com";
		String enteredEmail=homePage.setEmail(email);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered 'sudhan@gmail.com' in gmail input box", ExtentColor.BLUE));
		Assert.assertEquals(email,enteredEmail,"Entered and retrieved emails are not same");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved emails are same", ExtentColor.BLUE));
	}
	
	
	@Test( dataProviderClass=DataProviders.class,groups= {"Sanity","Master"})
	public void experienceFieldEnableCheck() {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.experienceSelectIsEnabled(),"Experience input Field is disabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Experience input field is enabled", ExtentColor.BLUE));
		String exp="4 years";
		boolean res=homePage.selectExperience(exp);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Selected '4 years' in experience field", ExtentColor.BLUE));
		Assert.assertTrue(res,"Given and selected experiences are not same");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved years are same", ExtentColor.BLUE));
	}
	
	
	@Test(dataProviderClass=DataProviders.class,groups= {"Sanity","Master"})
	public void jobTitleFieldEnableCheck() {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.jobTitleInpIsEnabled(),"Job Title input Field is disabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Job Title input field is enabled", ExtentColor.BLUE));
		String jobTitle="Manager";
		String enteredJobTitle=homePage.setJobTitle(jobTitle);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered 'Manager' in Job Title Field", ExtentColor.BLUE));
		Assert.assertEquals(jobTitle,enteredJobTitle,"Given and entered data into Job Title input Field are not same");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved Job Titles are same", ExtentColor.BLUE));
	}
	
	@Test(dataProviderClass=DataProviders.class,groups= {"Sanity","Master"})
	public void websitesDevelopedEnableCheck() {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.websitesDevelopedInpIsEnabled(),"Websites Developed Field is disabled");
		ExtentReportManager.getTest().pass(MarkupHelper.createLabel("Number of Websites developed input field is enabled", ExtentColor.GREEN));
		String noOfWebsites="5";
		String noOfWebDev=homePage.setWebsitesDeveloped(noOfWebsites);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '5' in websites developed Field", ExtentColor.BLUE));
		Assert.assertEquals(noOfWebsites,noOfWebDev,"Given and retrieved data are not same");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved number of websites are same", ExtentColor.BLUE));
		
	}
	
	@Test(dataProviderClass=DataProviders.class,groups= {"Sanity","Master"})
	public void appsMadeEnableCheck() {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.appsMadeInpIsEnabled(),"Apps Made Input Field is disabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Number of apps made input field is enabled", ExtentColor.BLUE));
		String apps="4";
		String appsMade=homePage.setAppsMade(apps);
		
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '4' in apps made input Field", ExtentColor.BLUE));
		Assert.assertEquals(apps,appsMade,"Given and retrieved data are not same");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved number of apps made are same", ExtentColor.BLUE));
	}
	
	
	@Test(dataProviderClass=DataProviders.class,groups= {"Sanity","Master"})
	public void skillsFieldEnableCheck() {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.skillsInpIsEnabled(),"Skills Input field is disabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Skills input field is enabled", ExtentColor.BLUE));
		String skills="Python,Java";
		String enteredSkills=homePage.setSkills(skills);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered 'Python,Java' in skills input field", ExtentColor.BLUE));
		Assert.assertEquals(enteredSkills,skills,"Given and entered skills are not matching");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved skills are same", ExtentColor.BLUE));
	}
	
	
	@Test(groups= {"Sanity","Master"})
	public void measureBtnClickCheck() {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.measureBtnIsEnabled(),"Measure Button is not enabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Measure Button is enabled", ExtentColor.BLUE));
		Assert.assertTrue(homePage.clickMeasureBtn(),"Unable to click measure Button");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Clicked Measured button without filling the data", ExtentColor.BLUE));
		Assert.assertTrue(homePage.isAlertDisplayed(),"Pop up is not raised even if all the fields are empty");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Alert is raised", ExtentColor.BLUE));
	}
	
	
	@Test(groups= {"Sanity","Master"})
	public void createPortfolioBtnClickCheck() {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.portfolioBtnIsEnabled(),"Create Portfolio Button is not enabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Create Portfolio Button is enabled", ExtentColor.BLUE));
		Assert.assertTrue(homePage.clickCreatePortfolioBtn(),"Unable to click createportfolio button");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Clicked create portfolio button without filling the data", ExtentColor.BLUE));
		String curTitle=homePage.getWebTitle();
		Assert.assertEquals(curTitle, props.getProperty("homePageTitle"),"CreatePortfolio Button is navigating to next page even if all the fields are empty");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("It is not navigated to portfolio page", ExtentColor.BLUE));
	}
	
	
	
}
