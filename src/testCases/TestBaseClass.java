package testCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBaseClass {
	
	public static Properties CONFIG;
	public  WebDriver driver;
	static FileInputStream fp ;
	public static boolean isLoggedIn = false;
	
	public static void initalize(){
		if(CONFIG == null){
			try{
				CONFIG = new Properties();
				fp = new FileInputStream(System.getProperty("user.dir")+"//src//config//config.properties");
				CONFIG.load(fp);
				//System.out.println("Properties loaded");
			}catch(Exception e){}
		}
	}	
	public void openBrowser(String browserType){
		if(browserType.equalsIgnoreCase("Mozila"))
		{
			//FirefoxBinary fbinary = new FirefoxBinary("");
			driver = new FirefoxDriver();
		}else if(browserType.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}		
	}
	
	public void closeBrowser(){
		if(driver != null){
			driver.quit();
			isLoggedIn = false;
			driver = null;
		}
	}
}
