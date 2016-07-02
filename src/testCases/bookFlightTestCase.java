package testCases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.support.PageFactory;

import pages.BookFlightPage;
import pages.FilghtItenaryPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.SelectFlightPage;

@RunWith(Parameterized.class)
public class bookFlightTestCase extends TestBaseClass{

	String browserType;
	int NoPassengers;
	String DepartingFrom;
	String OnMonth;
	int OnDate;
	String ArrivingIn;
	String returningmonth;
	int returningDay;
	LandingPage landingPage;
	String runModeHere;

	public bookFlightTestCase(String browserType,int NoPassengers,String DepartingFrom,String OnMonth,int OnDate,String ArrivingIn,String returningmonth,int returningDay,String runModeHere){

		this.browserType=browserType;
		this.NoPassengers=NoPassengers;
		this.DepartingFrom=DepartingFrom;
		this.OnMonth=OnMonth;
		this.OnDate=OnDate;
		this.ArrivingIn=ArrivingIn;
		this.returningmonth=returningmonth;
		this.returningDay=returningDay;
		this.runModeHere = runModeHere;
	}

	@BeforeClass
	public static void initializeMethod(){
		initalize();
	}
	@Before
	public void startUp(){
		//System.out.println(runModeHere);
		if(runModeHere.equalsIgnoreCase("N")){
			Assume.assumeTrue("Runmode set to No", false);
		}
		openBrowser(browserType);
	}

	@After
	public void tearDown(){
		closeBrowser();
	}
	@Test
	public void bookFlight(){
		//System.out.println(browserType+NoPassengers+DepartingFrom+OnMonth+OnDate+ArrivingIn+returningmonth+returningDay);
		if(isLoggedIn== false){
			LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
			landingPage = lp.doLogin(TestBaseClass.CONFIG.getProperty("defaultUsername"), TestBaseClass.CONFIG.getProperty("defaultPassword"));
		}
		SelectFlightPage sfp = landingPage.searchFlights(NoPassengers, DepartingFrom, OnMonth, OnDate, ArrivingIn, returningmonth, returningDay);
		Assert.assertFalse("Flight Searching Failed", sfp == null);
		BookFlightPage bookFlighPage= sfp.selectFlights(DepartingFrom, ArrivingIn);
		Assert.assertFalse("Flight Selecting Failed", bookFlighPage == null);
		FilghtItenaryPage flghtItPage = bookFlighPage.bookFlight("Svetlana", "Bolila", 570361035);
		Assert.assertFalse("Itenary Page not displayed", flghtItPage == null);
	}

	@Parameters
	public static Collection<Object[]> getData(){

		Object[][] data = new Object[2][9];

		data[0][0] = "Chrome";
		data[0][1] = 1;
		data[0][2] = "Paris";
		data[0][3] = "August";
		data[0][4] = 10;
		data[0][5] = "London";
		data[0][6] = "December";
		data[0][7] = 2;
		data[0][8] = "Y";

		data[1][0] = "Chrome";
		data[1][1] = 1;
		data[1][2] = "Portland";
		data[1][3] = "August";
		data[1][4] = 10;
		data[1][5] = "Seattle";
		data[1][6] = "December";
		data[1][7] = 2;
		data[1][8] = "y";

		return Arrays.asList(data);		
	}

}
