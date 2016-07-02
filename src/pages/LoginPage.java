package pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.TestBaseClass;
import util.Constants;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver dr){
		driver = dr;		
	}
	
	@FindBy(xpath=Constants.username)
	WebElement usernmae;
	
	@FindBy(xpath=Constants.password)
	WebElement password;	
	
	@FindBy(xpath=Constants.loginBtn)
	WebElement loginBtn;
	
	@FindBy(xpath=Constants.homepageText)
	WebElement homepageText;
	
	public LandingPage doLogin(String uNmae,String passwd){
		//System.out.println(TestBaseClass.CONFIG.getProperty("loginURL"));
		driver.navigate().to(TestBaseClass.CONFIG.getProperty("loginURL"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		usernmae.sendKeys(uNmae);
		password.sendKeys(passwd);
		loginBtn.click();
		try{
			if(homepageText.isDisplayed()){
				LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
				return lp ;
			}
		}catch(Exception e){}
		return null;	
	}
	

}
