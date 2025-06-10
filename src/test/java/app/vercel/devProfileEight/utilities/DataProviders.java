package app.vercel.devProfileEight.utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="userData")
	public String[][] getData(){
		try {
			return Readingdata.readExcelData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DataProvider(name="fullNameData")
	public String[][] getFullNames(){
		try {
			return Readingdata.readData(26,0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DataProvider(name="emailData")
	public String[][] getEmails(){
		try {
			return Readingdata.readData(26,1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DataProvider(name="experienceData")
	public String[][] getExperience(){
		try {
			return Readingdata.readData(31,2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@DataProvider(name="jobTitleData")
	public String[][] getJobTitles(){
		try {
			return Readingdata.readData(24,3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@DataProvider(name="websitesAndAppsData")
	public String[][] getWebSitesDev(){
		
		try {
			return Readingdata.readData(28,4);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@DataProvider(name="skillsData")
	public String[][] getSkillsData(){
		try {
			return Readingdata.readData(24,6);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@DataProvider(name="userProfileData")
	public String[][] getProfileData(){
		try {
			return Readingdata.readExcel();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DataProvider(name="profilePageData")
	public String[][] getProfilePageData(){
		String[][] data= {
				{"Rithika","rithika@gmail.com","5","Senior Manager","40","20","Java, python, javascript"},
				{"Subhasri","subhasri@gmail.com","4","Senior Associate","20","15","C, C++, Java"},
				{"Aravind","aravind@gmail.com","3","Senior Asscoiate","22","13","Mongo DB, MySQL,Spring, react.js"}
				
		};
		return data;
	}
	
}
