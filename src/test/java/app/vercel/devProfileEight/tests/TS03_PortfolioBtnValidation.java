package app.vercel.devProfileEight.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import app.vercel.devProfileEight.utilities.DataProviders;
import app.vercel.devProfileEight.utilities.ExtentReportManager;

public class TS03_PortfolioBtnValidation extends BaseTestClass{

	@Test(dataProvider="userProfileData",dataProviderClass=DataProviders.class)
	public void detailsEntryTestAndCreateProfile(String fullName,String email,String years,String jobTitle,String noOfWebsites,String apps,String skills, String expectedRes) {
		driver.navigate().refresh();
		homePage.setFullName(fullName);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+fullName+"' into full name Input field",ExtentColor.BLUE));
		homePage.setEmail(email);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+email+"' into email Input field",ExtentColor.BLUE));
		if(years.length()>0)
		homePage.selectExperience(years);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Selected '"+years+" years' in experience field",ExtentColor.BLUE));
		homePage.setJobTitle(jobTitle);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+jobTitle+"' into Job Title Input field",ExtentColor.BLUE));
		homePage.setWebsitesDeveloped(noOfWebsites);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+noOfWebsites+"' into websites developed Input field",ExtentColor.BLUE));
		homePage.setAppsMade(apps);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+apps+"' into apps made Input field",ExtentColor.BLUE));
		homePage.setSkills(skills);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+skills+"' into skills Input field",ExtentColor.BLUE));
		homePage.clickCreatePortfolioBtn();
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Clicked Create portfolio Button",ExtentColor.BLUE));
		String portfolioPageTitle=props.getProperty("portfolioPageTitle");
		boolean result=driver.getTitle().equals(portfolioPageTitle);
		if(result){
			driver.navigate().back();
			Assert.assertTrue(expectedRes.equalsIgnoreCase("true"),"Invalid details entered still creating portifolio and navigating to portifolio page");
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Portfolio is created",ExtentColor.BLUE));
		}
		else {
			Assert.assertTrue(expectedRes.equalsIgnoreCase("false"),"Valid details entered still not creating portifolio");
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Some details are invalid portfolio is not created",ExtentColor.BLUE));
		}
	}
	
	
	
}
