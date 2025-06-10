package app.vercel.devProfileEight.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import app.vercel.devProfileEight.utilities.DataProviders;
import app.vercel.devProfileEight.utilities.ExtentReportManager;

public class TS04_PortfolioPageValidation extends BaseTestClass {

	//public final Logger logger=LogManager.getLogger(TS04_PortfolioPageValidation.class);
	
	
	@Test(dataProvider = "profilePageData",dataProviderClass = DataProviders.class,groups= {"Sanity","Master"})
	void avatarValidation(String fullName,String email,String years,String jobTitle,String websites,String apps,String skills) {
		logger.info("Verifying avatar display on the portfolio page");
		if(homePage.getWebTitle() .equalsIgnoreCase( "DevProfile | Portfolio")) {
			driver.navigate().back();
		}
		driver.navigate().refresh();
		homePage.setFullName(fullName);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+fullName+"' into full name Input field",ExtentColor.BLUE));
		homePage.setEmail(email);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+email+"' into email Input field",ExtentColor.BLUE));
		homePage.selectExperience(years);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Selected '"+years+" years' in experience field",ExtentColor.BLUE));
		homePage.setJobTitle(jobTitle);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+jobTitle+"' into Job Title Input field",ExtentColor.BLUE));
		homePage.setWebsitesDeveloped(websites);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+websites+"' into websites developed Input field",ExtentColor.BLUE));
		homePage.setAppsMade(apps);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+apps+"' into apps made Input field",ExtentColor.BLUE));
		homePage.setSkills(skills);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Entered '"+skills+"' into skills Input field",ExtentColor.BLUE));
		homePage.clickCreatePortfolioBtn();
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Clicked Create portfolio Button",ExtentColor.BLUE));
		Assert.assertEquals(portfolioPage.getWebTitle(),props.getProperty("portfolioPageTitle"),"Didn't navigated to Portfolio Page");
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Portfolio is created",ExtentColor.BLUE));
		boolean avatarDisplay = portfolioPage.checkAvatar();
		
		if(avatarDisplay) {
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Avatar is displayed",ExtentColor.BLUE));
		}
		else {
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Avatar is not displayed",ExtentColor.RED));
		}
		if(portfolioPage.getAvatarInitials(fullName)) {
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Avatar value is correct",ExtentColor.BLUE));
		}
		else {
			ExtentReportManager.getTest().info(MarkupHelper.createLabel("Avatar value is not correct",ExtentColor.RED));
		}
		String nameValidation = portfolioPage.getProfileName();
		
		Assert.assertEquals(nameValidation, fullName);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Full name is fetched and displayed correctly",ExtentColor.BLUE));
		String resJobTitle = portfolioPage.getProfileTitle();
		Assert.assertEquals(resJobTitle, jobTitle);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Job Title is fetched and displayed correctly",ExtentColor.BLUE));
		String resEmail = portfolioPage.getProfileEmail();
		Assert.assertEquals(resEmail, email);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Email is fetched and displayed correctly",ExtentColor.BLUE));
		String resYears =portfolioPage.getYears();
		Assert.assertEquals(resYears, years.split(" ")[0]);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Years of Experience is fetched and displayed correctly",ExtentColor.BLUE));
		String web = portfolioPage.getWebDevCount();
		Assert.assertEquals(web, websites);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Number of websites developed is fetched and displayed correctly",ExtentColor.BLUE));
		
		String app =portfolioPage.getAppsCount();
		Assert.assertEquals(app, apps);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Number of apps made is fetched and displayed correctly",ExtentColor.BLUE));
		
		List<String> inputSkillsList = Arrays.asList(skills.split(","));
		inputSkillsList=inputSkillsList.stream().map(ele->ele.trim()).toList();
		List<String> result =portfolioPage.getSkills();
		Assert.assertEquals(inputSkillsList, result);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Skills are fetched and displayed correctly",ExtentColor.BLUE));
		logger.info("Validating the presence of the profile description on the portfolio page");
		Assert.assertTrue(portfolioPage.getProfileDescription());
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Profile description is displayed correctly",ExtentColor.BLUE));
		//driver.navigate().back();
	}
	
	
	@Test(dataProvider="profilePageData",dataProviderClass = DataProviders.class,groups= {"Functional","Master"})
	void backBtnValidation(String fullName,String email,String years,String jobTitle,String websites,String apps,String skills){
		if(!homePage.getWebTitle().equalsIgnoreCase( props.getProperty("homePageTitle"))) {
			driver.navigate().back();
			driver.navigate().back();
		}
		driver.navigate().refresh();
		homePage.setFullName(fullName);
		homePage.setEmail(email);
		homePage.selectExperience(years);
		homePage.setJobTitle(jobTitle);
		homePage.setWebsitesDeveloped(websites);
		homePage.setAppsMade(apps);
		homePage.setSkills(skills);
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("All the details are entered",ExtentColor.BLUE));
		homePage.clickCreatePortfolioBtn();
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Clicked create portfolio button",ExtentColor.BLUE));
		logger.info("Verifying the 'Back' button functionality on the portfolio page");
		String text=portfolioPage.getBackButton();
		ExtentReportManager.getTest().info(MarkupHelper.createLabel("Clicked back button in portfolio page",ExtentColor.BLUE));
		Assert.assertEquals(text,"DevProfile | Statistics");

	}
}
