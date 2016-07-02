package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Constants;

public class SelectFlightPage {

	WebDriver driver;
	static String departFlightText;
	static String returnFlightText;

	@FindBy(xpath=Constants.departRegion)
	WebElement departRegion;

	@FindBy(xpath=Constants.departText)
	WebElement departText;

	@FindBy(xpath=Constants.returnRegion)
	WebElement returnRegion;

	@FindBy(xpath=Constants.returnText)
	WebElement returnText;

	@FindBy(xpath=Constants.continueBtn)
	WebElement continueBtn;

	@FindBy(xpath=Constants.departFlightNameRadio)
	WebElement departFlightNameRadio;

	@FindBy(xpath=Constants.returnFlightNameRadio)
	WebElement returnFlightNameRadio;
	
	@FindBy(xpath=Constants.departFlightName)
	WebElement departFlightName;

	@FindBy(xpath=Constants.returnFlightName)
	WebElement returnFlightName;

	@FindBy(xpath=Constants.bookFlightPageText)
	WebElement bookFlightPageText;

	public SelectFlightPage(WebDriver driver){
		this.driver=driver;
	}

	public BookFlightPage selectFlights(String fromPlace,String toPlace){		
		Assert.assertTrue("Incorrct Flight Selection Page", departRegion.isDisplayed());
		Assert.assertTrue("Incorrct Flight Selection Page", departText.isDisplayed());
		Assert.assertTrue("Incorrct Flight Selection Page", returnRegion.isDisplayed());
		Assert.assertTrue("Incorrct Flight Selection Page", returnText.isDisplayed());

		String departDetails=departText.getText();
		String[] temp = departDetails.split(" to ");
		Assert.assertEquals("Incorrect Data in From place",fromPlace,temp[0]);
		Assert.assertEquals("Incorrect Data in To place",toPlace,temp[1]);
		
		departFlightText = getFLightName(departFlightName);
		returnFlightText=getFLightName(returnFlightName);

		departFlightNameRadio.click();
		returnFlightNameRadio.click();
		
		try{
			Thread.sleep(5000);
		}catch(Exception e){}

		continueBtn.click();
		try{
			if(bookFlightPageText.isDisplayed()){
				BookFlightPage bookFlighPage = PageFactory.initElements(driver, BookFlightPage.class);
				return bookFlighPage;
				
			}
		}catch(Exception e){}
		return null;
	}
	
	public String getFLightName(WebElement xpathKey){
		return xpathKey.getText();
	}
}
