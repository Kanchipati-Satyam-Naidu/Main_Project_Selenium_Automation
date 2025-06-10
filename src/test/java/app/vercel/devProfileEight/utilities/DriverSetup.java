package app.vercel.devProfileEight.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class DriverSetup {

	private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	private static ThreadLocal<String> browserName=new ThreadLocal<>();
	
	public static WebDriver getDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			browserName.set(browser.toUpperCase());
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			browserName.set(browser.toUpperCase());
		}
		else {
			throw new IllegalArgumentException("Unsupported Browser : "+browser);
		}
		return driver.get();
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void quitdriver() {
		if(driver.get()!=null) {
			driver.get().quit();
			driver.remove();
			browserName.remove();
		}
	}
	
	public static String getBrowserName() {
		return browserName.get();
	}
}
