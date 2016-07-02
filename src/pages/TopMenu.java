package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.TestBaseClass;
import util.Constants;

public class TopMenu {

	@FindBy(xpath=Constants.logoutLink)
	WebElement logoutLink;	

	WebDriver driver;

	public TopMenu(WebDriver dr){
		driver=dr;
	}
	
	public void Logout(){		
		try{
			if(logoutLink.isDisplayed())
				logoutLink.click();
			TestBaseClass.isLoggedIn = false;
		}catch(Exception e){}
	}

}
