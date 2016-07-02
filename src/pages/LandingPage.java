package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import util.Constants;

public class LandingPage {
	
	WebDriver driver;
	Select element ;
	public LandingPage(WebDriver dr){
		driver = dr;
	}
	
	@FindBy(xpath=Constants.homepageText)
	WebElement homepageText;
	
	@FindBy(xpath=Constants.roundTrip)
	WebElement roundTrip;
	
	@FindBy(xpath=Constants.oneWay)
	WebElement oneWay;
	
	@FindBy(xpath=Constants.passenger)
	WebElement passenger;
	
	@FindBy(xpath=Constants.from)
	WebElement fromPlace;
	
	@FindBy(xpath=Constants.GoingTo)
	WebElement GoingTo;
	
	@FindBy(xpath=Constants.OutBoundMonth)
	WebElement OutBoundMonth;
	
	@FindBy(xpath=Constants.OutBoundDay)
	WebElement OutBoundDay;
	
	@FindBy(xpath=Constants.InboundMonth)
	WebElement InboundMonth;
	
	@FindBy(xpath=Constants.InboundDay)
	WebElement InboundDay;
	
	@FindBy(xpath=Constants.BusinessClass)
	WebElement BusinessClass;	

	@FindBy(xpath=Constants.continueBooking)
	WebElement continueBooking;	

	@FindBy(xpath=Constants.selectFlightsPageElement)
	WebElement selectFlightsPageElement;
	
	public SelectFlightPage searchFlights(int passengers,String from,String onMonth,int onDate,String arrivingIn,String arrivingMonth,int arrivingDay){			
		Assert.assertTrue("Landing Page is not correct", homepageText.isDisplayed());
		
		//oneWay.click();
		element = new Select(passenger);
		element.selectByIndex(passengers-1); // choosed no of passenagers as 2
		
		element = new Select(fromPlace);
		element.selectByValue(from);
		
		element = new Select(OutBoundMonth);
		//element.selectByValue(onMonth);
		element.selectByVisibleText(onMonth);
		
		element = new Select(OutBoundDay);
		element.selectByIndex(onDate-1);
		
		element = new Select(GoingTo);
		element.selectByValue(arrivingIn);
		
		element = new Select(InboundMonth);
		element.selectByVisibleText(arrivingMonth);
		
		element = new Select(InboundDay);
		element.selectByIndex(arrivingDay-1);
		
		BusinessClass.click();
		
		continueBooking.click();
		
		try{Thread.sleep(3000);}catch(Exception e){}
		
		try{
			if(selectFlightsPageElement.isDisplayed()){
				//System.out.println("A");
				SelectFlightPage searchFlightPage = PageFactory.initElements(driver, SelectFlightPage.class);
				return searchFlightPage;
			}
		}catch(Exception e){}
		return null;
		
	}
}
