package pages;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Constants;

public class BookFlightPage {

	WebDriver driver;
	//String departFlightText;
	//String returnFlightText;

	@FindBy(xpath=Constants.outBoundFlight)
	WebElement outBoundFlight;

	@FindBy(xpath=Constants.inBoundFlight)
	WebElement inBoundFlight;
	
	@FindBy(xpath=Constants.firstName)
	WebElement firstName;
	
	@FindBy(xpath=Constants.lastName)
	WebElement lastName;
	
	@FindBy(xpath=Constants.number)
	WebElement number;
	
	@FindBy(xpath=Constants.securePurchase)
	WebElement securePurchase;
	
	@FindBy(xpath=Constants.itenaryBooked)
	WebElement itenaryBooked;	
	
	public FilghtItenaryPage bookFlight(String fName,String lName,int no){
		Assert.assertTrue("Incorrect Book Flights Page", outBoundFlight.isDisplayed());
		Assert.assertTrue("Incorrect Book Flights Page", inBoundFlight.isDisplayed());
		//System.out.println("deaprt flight name is " + SelectFlightPage.departFlightText + " and -- " + outBoundFlight.getText());
		Assert.assertEquals("Incorrect Flight Name displayed", SelectFlightPage.departFlightText, outBoundFlight.getText());
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		number.sendKeys(String.valueOf(no));
		securePurchase.click();	
		try{
			if(itenaryBooked.isDisplayed()){
				FilghtItenaryPage fliternaryPage = PageFactory.initElements(driver, FilghtItenaryPage.class);
				return fliternaryPage;
			}
		}catch(Exception e){}
		return null;
	}
	
}
