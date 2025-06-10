package app.vercel.devProfileEight.pageObjects;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver,this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	//Web Elements
	
	//Page Main Heading
	@FindBy(xpath="//header//h1") WebElement pageTitle;
	
	//Sub Heading
	@FindBy(xpath="//header//h2") WebElement subtitle;
	
	//Fullname
	@FindBy(id="fullName") WebElement fullNameInp;
	
	//Email
	@FindBy(id="email") WebElement emailInp;
	
	//Experience
	@FindBy(id="yearsExperience") WebElement experienceInp;
	
	//Job Title
	@FindBy(id="jobTitle") WebElement jobTitleInp;
	
	//Websites Developed
	@FindBy(id="websitesDeveloped") WebElement webDevInp;
	
	//Apps Made
	@FindBy(id="appsMade") WebElement appsMadeInp;
	
	//Skills
	@FindBy(id="skills") WebElement skillsInp;
	
	//Measure Button
	@FindBy(id="measureBtn") WebElement measureBtn;
	
	//Profile Status
	@FindBy(id="profileStatus") WebElement profileStatus;
	
	//Profile Highlights
	@FindBy(xpath="//div[@id=\"profileHighlight\"]//p[2]") WebElement totalNoOfWebsites;
	
	//Experience Level
	@FindBy(xpath="//div[@id=\"profileHighlight\"]//p//span") WebElement expLevel;
	
	//Create Portfolio Button
	@FindBy(xpath="//button[@type='submit']") WebElement createPortfolioButton;
	
	
	
	//Utility functions
	public String enterData(WebElement element, String data) {
		try {
			element.sendKeys(data);
			//System.out.println(data+"##"+element.getDomProperty("value"));
			return element.getDomProperty("value");
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public boolean selectData(WebElement element,String option) {
		try {
			Select sel=new Select(element);
			sel.getOptions().stream().forEach(ele->{
				if(ele.getText().contains(option)) {
					ele.click();
				}
			});
			//sel.selectByVisibleText(option);
			if(sel.getFirstSelectedOption().getText().contains(option)) {
				return true;
			}
			return false;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean clickButton(WebElement button) {
		try {
			button.click();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	//Actions
	
	
	
	public String getWebTitle() {
		return driver.getTitle();
	}
	
	public boolean pageTitleIsDisplayed() {
		return (pageTitle.isDisplayed());
	}
	
	public String getPageHeading() {
		return pageTitle.getText();
	}
	
	public boolean subTitleIsDisplayed() {
		return subtitle.isDisplayed();
	}
	
	public String getSubHeading() {
		return subtitle.getText();
	}
	
	public boolean fullNameInpIsEnabled() {
		return fullNameInp.isEnabled();
	}
	
	public String setFullName(String fname) {
		return enterData(fullNameInp,fname);
	}
	
	
	public boolean emailInpIsEnabled() {
		return emailInp.isEnabled();
	}
	
	public String setEmail(String email) {
		return enterData(emailInp,email);
	}
	
	
	public boolean experienceSelectIsEnabled() {
		return experienceInp.isEnabled();
	}
	public boolean selectExperience(String exp) {
		return selectData(experienceInp,exp.split(" ")[0]);
	}
	
	public boolean jobTitleInpIsEnabled() {
		return jobTitleInp.isEnabled();
	}
	
	public String setJobTitle(String jTitle) {
		return enterData(jobTitleInp,jTitle);
	}
	
	public boolean websitesDevelopedInpIsEnabled() {
		return webDevInp.isEnabled();
	}
	
	public String setWebsitesDeveloped(String noOfWebsites) {
		return enterData(webDevInp,noOfWebsites);
	}
	
	public boolean appsMadeInpIsEnabled() {
		return appsMadeInp.isEnabled();
	}
	
	public String setAppsMade(String noOfApps) {
		return enterData(appsMadeInp,noOfApps);
	}
	
	public boolean skillsInpIsEnabled() {
		return skillsInp.isEnabled();
	}
	public String setSkills(String skills) {
		return enterData(skillsInp,skills);
	}
	
	
	
	public boolean isAlertDisplayed() {
		try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            return true;
        } catch (TimeoutException timeOutException) {
            return false;
        }
	}
	
	public boolean measureBtnIsEnabled() {
		return measureBtn.isEnabled();
	}
	
	public boolean clickMeasureBtn() {
		return clickButton(measureBtn);
	}
	
	public boolean profileStatusIsDisplayed() {
		return profileStatus.isDisplayed();
	}
	
	public boolean isTotalProjectsMatched(String websites,String apps) {
		try {
			String totalwebsite_txt=totalNoOfWebsites.getText();
			int web_count=Integer.parseInt(websites);
			int apps_count=Integer.parseInt(apps);
			int total=web_count+apps_count;
			String result="You've completed "+total+" projects ("+web_count+" websites and "+apps_count+" apps).";
			return totalwebsite_txt.equals(result);
		}
		catch(NumberFormatException e) {
			//e.printStackTrace();
			return false;
		}
		
	}
	
	
	public boolean isExperienceLevelMatched(String yearsOfExperience) {

		int years = Integer.parseInt(yearsOfExperience.split(" ")[0]);
		String result="";
		switch (years) {
			case 0:
			case 1:
				result="Beginner";
				break;
			case 2:
			case 3:
			case 4:
				result="Intermediate";
				break;
			case 5:
			case 6:
			case 7:
				result="Advanced";
				break;
			case 8:
			case 9:
			case 10:
			result="Expert";
		}
		return(result.equalsIgnoreCase(expLevel.getText()));
	
	}

	
	public boolean portfolioBtnIsEnabled() {
		return createPortfolioButton.isEnabled();
	}
	
	public boolean clickCreatePortfolioBtn() {
		return clickButton(createPortfolioButton);
	}
	
}
