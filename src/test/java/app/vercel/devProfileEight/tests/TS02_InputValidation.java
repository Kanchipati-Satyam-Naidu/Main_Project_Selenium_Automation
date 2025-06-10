package app.vercel.devProfileEight.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import app.vercel.devProfileEight.utilities.DataProviders;
import app.vercel.devProfileEight.utilities.ExtentReportManager;
import app.vercel.devProfileEight.utilities.Validation;

public class TS02_InputValidation extends BaseTestClass {
	
	//public final Logger logger=LogManager.getLogger(TS02_InputValidation.class);
	
	@Test(dataProvider="fullNameData", dataProviderClass=DataProviders.class,groups= {"Master"} )
	public void nameFieldValidationTest(String fullName) {
		driver.navigate().refresh();
		logger.info("Entering full name for user data");
		Assert.assertTrue(homePage.fullNameInpIsEnabled(),"Full Name Field is disabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Full name input field is enabled", ExtentColor.BLUE));
		String fName=homePage.setFullName(fullName);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+fullName+"' in full name field", ExtentColor.BLUE));
		Assert.assertEquals(fName,fullName,"Entered and retrieved Fullnames are not same");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved Fullnames are same", ExtentColor.BLUE));
	}
	
	@Test(dataProvider="emailData",dataProviderClass=DataProviders.class,groups= {"Master"})
	public void emailFieldValidationTest(String email) {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.emailInpIsEnabled(),"Email Input Box is not Enabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Email input field is enabled", ExtentColor.BLUE));
		String enteredEmail=homePage.setEmail(email);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+email+"' in gmail input box", ExtentColor.BLUE));
		Assert.assertEquals(email,enteredEmail,"Entered and retrieved emails are not same");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved emails are same", ExtentColor.BLUE));
	}
	
	@Test(dataProvider="experienceData", dataProviderClass=DataProviders.class,groups= {"Master"})
	public void experienceFieldValidationTest(String exp) {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.experienceSelectIsEnabled(),"Experience Field is disabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Experience input field is enabled", ExtentColor.BLUE));
		boolean res=homePage.selectExperience(exp);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Selected '"+exp+" years' in experience field", ExtentColor.BLUE));
		Assert.assertTrue(res,"Given and selected experiences are not same");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved years are same", ExtentColor.BLUE));
	}
	
	@Test(dataProvider="jobTitleData",dataProviderClass=DataProviders.class,groups= {"Master"})
	public void jobTitleFieldValidationTest(String jobTitle) {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.jobTitleInpIsEnabled(),"Job Title Field is disabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Job Title input field is enabled", ExtentColor.BLUE));
		String enteredJobTitle=homePage.setJobTitle(jobTitle);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+jobTitle+"' in Job Title Field", ExtentColor.BLUE));
		Assert.assertEquals(jobTitle,enteredJobTitle,"Given and entered data into Job Title Field are not same");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved Job Titles are same", ExtentColor.BLUE));
	}
	
	@Test(dataProvider="websitesAndAppsData",dataProviderClass=DataProviders.class,groups= {"Master"})
	public void websitesDevelopedFieldValidationTest(String noOfWebsites) {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.websitesDevelopedInpIsEnabled(),"Websites Developed Field is disabled");
		ExtentReportManager.getTest().pass(MarkupHelper.createLabel("Number of Websites developed input field is enabled", ExtentColor.GREEN));
		String noOfWebDev=homePage.setWebsitesDeveloped(noOfWebsites);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+noOfWebsites+"' in websites developed Field", ExtentColor.BLUE));
		boolean res=Validation.isValidPositiveInteger(noOfWebsites);
		
		if(res) {
			Assert.assertEquals(noOfWebsites,noOfWebDev,"Given and retrieved data are not same");
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved number of websites are same", ExtentColor.BLUE));
		}
		else {
			Assert.assertNotEquals(noOfWebsites,noOfWebDev,"Websites Developed Input field is allowing Invalid input");
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved number of websites are not same", ExtentColor.BLUE));
		}
	}
	
	@Test(dataProvider="websitesAndAppsData",dataProviderClass=DataProviders.class,groups= {"Master"})
	public void appsMadeFieldValidationTest(String apps) {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.appsMadeInpIsEnabled(),"Apps Made Field is disabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Number of apps made input field is enabled", ExtentColor.BLUE));
		String appsMade=homePage.setAppsMade(apps);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+apps+"' in apps made input Field", ExtentColor.BLUE));
		boolean res=Validation.isValidPositiveInteger(apps);
		if(res) {
			Assert.assertEquals(apps,appsMade,"Given and retrieved data are not same");
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved number of apps made are same", ExtentColor.BLUE));
		}
		else {
			Assert.assertNotEquals(apps,appsMade,"Apps Made Input field is allowing Invalid input");
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved number of apps made are not same", ExtentColor.BLUE));
		}
	}
	
	@Test(dataProvider="skillsData",dataProviderClass=DataProviders.class,groups= {"Master"})
	public void skillsFieldValidationTest(String skills) {
		driver.navigate().refresh();
		Assert.assertTrue(homePage.skillsInpIsEnabled(),"Skills Input field is disabled");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Skills input field is enabled", ExtentColor.BLUE));
		String enteredSkills=homePage.setSkills(skills);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+skills+"' in skills input field", ExtentColor.BLUE));
		Assert.assertEquals(enteredSkills,skills,"Given and entered skills are not matching");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered and retrieved skills are same", ExtentColor.BLUE));
	}
	
	
	@Test(dataProvider="userProfileData",dataProviderClass=DataProviders.class)
	public void measureProfileTest(String fullName,String email,String years,String jobTitle,String noOfWebsites,String apps,String skills,String expectedRes) {
		driver.navigate().refresh();
		String nameRes=homePage.setFullName(fullName);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+fullName+"' into full name Input field",ExtentColor.BLUE));
		String emailRes=homePage.setEmail(email);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+email+"' into email Input field",ExtentColor.BLUE));
		boolean expRes=false;
		
		if(years.length()>0) {
			expRes=homePage.selectExperience(years);
			
		}
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Selected '"+years+" years' in experience field",ExtentColor.BLUE));
		
		String jobRes=homePage.setJobTitle(jobTitle);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+jobTitle+"' into Job Title Input field",ExtentColor.BLUE));
		String webRes=homePage.setWebsitesDeveloped(noOfWebsites);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+noOfWebsites+"' into websites developed Input field",ExtentColor.BLUE));
		String appRes=homePage.setAppsMade(apps);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+apps+"' into apps made Input field",ExtentColor.BLUE));
		homePage.setSkills(skills);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+skills+"' into skills Input field",ExtentColor.BLUE));
		homePage.clickMeasureBtn();
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Clicked Measure profile Button",ExtentColor.BLUE));
		if(expectedRes.equalsIgnoreCase("false")) {
			Assert.assertTrue( homePage.isAlertDisplayed(),"Alert is not raised even if the details are not valid");
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Some details are invalid so alert is raised",ExtentColor.BLUE));
		}
		else {
			Assert.assertTrue(homePage.profileStatusIsDisplayed(),"Profile is not displayed even if all the details are valid");
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Profile is displayed",ExtentColor.BLUE));
			Assert.assertTrue(homePage.isTotalProjectsMatched(noOfWebsites, apps),"Displayed total projects does not match with actual total projects");
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Displayed total projects are matched with actual total projects",ExtentColor.BLUE));
			Assert.assertTrue(homePage.isExperienceLevelMatched(years),"Displayed experience and expected are not same");
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Displayed experience level matched with actual experienced level",ExtentColor.BLUE));
		}
		
		
		
		//		if(!(expRes && validationRes)) {
		//			try {
		//				Alert alert=driver.switchTo().alert();
		//				alert.accept();
		//				Assert.assertTrue(true);
		//			}catch(Exception e) {
		//				Assert.fail("Pop up is not raised even for Invalid Details");
		//			}
		//		}
		//		else {
		//			Assert.assertTrue(btnRes,"Error while entering details and clicking measure Btn");
		//		}
	}
	
	
}
