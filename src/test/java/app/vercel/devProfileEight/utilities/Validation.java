package app.vercel.devProfileEight.utilities;

//import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class Validation {
	static String pattern = "^[a-zA-Z]+(?: [a-zA-Z]+)*$";
	static String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	static String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";
	
	public static boolean isValidName(String fName) {
		return fName.matches(pattern);
	}
	
	public static boolean isValidEmail(String email) {
		return email.matches(EMAIL_REGEX);
	}
	
	public static boolean isValidPositiveInteger(String data) {
		return data.matches(POSITIVE_INTEGER_REGEX);
	}
	
	public static boolean stringValidation(String name,String email,String job,String website,String apps){
        
        boolean isNameValid = Pattern.matches(pattern, name);
        boolean isEmailValid = Pattern.matches(EMAIL_REGEX, email);
        boolean isJobTitleValid = Pattern.matches(pattern, job);
        boolean isWebsiteValid = Pattern.matches(POSITIVE_INTEGER_REGEX, website);
        boolean isAppsMadeValid = Pattern.matches(POSITIVE_INTEGER_REGEX, apps);

        return isNameValid && isEmailValid && isJobTitleValid && isWebsiteValid && isAppsMadeValid;
	}
}
