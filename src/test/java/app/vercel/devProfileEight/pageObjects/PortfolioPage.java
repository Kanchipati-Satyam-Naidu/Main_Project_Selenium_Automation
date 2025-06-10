package app.vercel.devProfileEight.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortfolioPage {

	private WebDriver driver;
	WebDriverWait wait;

	public PortfolioPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Elements
	@FindBy(xpath = "//div[@class='profile-avatar']") WebElement avatar;
	
	@FindBy(xpath = "//h2[@class='profile-name']") WebElement profileName;
	
	@FindBy(xpath = "//div[@class='profile-title']") WebElement profileTitle;
	
	@FindBy(xpath = "//div[@class='profile-email']") WebElement profileEmail;
	
	@FindBy(xpath = "//div[text()='Years Experience']/preceding::div[1]") WebElement yearsOfExp;
	
	@FindBy(xpath = "//div[text()='Websites Developed']/preceding::div[1]") WebElement websitesDevCount;

	@FindBy(xpath = "//div[text()='Apps Created']/preceding::div[1]")
	WebElement appsCount;

	@FindBy(xpath = "//*[@class='skills-container']/div")
	List<WebElement> skills;
	
	@FindBy(xpath = "//div[@class='profile-highlight']")
	WebElement profileDescription;
	
	@FindBy(xpath = "//a[@class='btn btn-back']")
	WebElement backButton;
	
	@FindBy(xpath = "//div[@class='profile-avatar']")
	WebElement logo;
	//Actions
	
	public String getWebTitle() {
		return driver.getTitle();
	}
	public boolean checkAvatar() {
		return avatar.isDisplayed();
	}
	
	public String getProfileName() {
		return profileName.getText();
	}
	
	public String getProfileTitle() {
		return profileTitle.getText();
	}
	
	public String getProfileEmail() {
		return profileEmail.getText();
	}
	
	public String getYears() {
		return yearsOfExp.getText();
	}
	
	public String getWebDevCount() {
		return websitesDevCount.getText();
	}
	
	public String getAppsCount() {
		return appsCount.getText();
	}
	
	public List<String> getSkills() {
		List<String> displayedSkills = skills.stream()
			.map(ele->ele.getText().trim())
			.collect(Collectors.toList());

		return displayedSkills;
	}
	
	public boolean getProfileDescription() {
		return profileDescription.isDisplayed();
	}
	
	public String getBackButton() {
		backButton.click();
		return (driver.getTitle());
	}
	
	public boolean getAvatarInitials(String name) {
		String[] nameParts=name.split(" ");
		String initials="";
		for(String part :nameParts) {
			initials +=part.substring(0,1).toUpperCase();
		}
		return initials.equals(logo.getText());		
	}
}
