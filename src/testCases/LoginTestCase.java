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


import pages.LandingPage;
import pages.LoginPage;

@RunWith(Parameterized.class)
public class LoginTestCase extends TestBaseClass{

	String username;
	String password;
	String runmode;
	String browserType;
	String datatype;
	int iter = 0;	

	public LoginTestCase(String username,String password,String browserType,String runmode,String datatype){
		this.username = username;
		this.password = password;
		this.runmode = runmode;
		this.browserType = browserType;
		this.datatype = datatype;		
	}

	@BeforeClass
	public static void initializeTest(){
		initalize();
	}

	@Before
	public void setUp(){
		if(runmode.equalsIgnoreCase("N")){
			Assume.assumeTrue("Runmode is set to No",false);
		}
		openBrowser(browserType);
	}

	@After
	public void tearDown(){
		closeBrowser();
	}

	@Test
	public void loginTest(){
		//System.out.println("Iteration is " + iter + " " + username + " " + password + " " +browserType + " "+  runmode + " " +datatype );
		if(isLoggedIn == true){
			
		}
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		LandingPage landingPage = loginPage.doLogin(username, password);
		if(landingPage != null){
			Assert.assertFalse("Login Successfull", landingPage == null);
			isLoggedIn = true;
		}else if(landingPage == null){
			isLoggedIn = false;
			Assert.assertTrue("Login Failed", landingPage != null);
		}
	}

	@Parameters
	public static Collection<Object[]> getData(){
		
		Object[][] data = new Object[2][5];
		data[0][0]="mercury";
		data[0][1]="mercury";
		data[0][2]="Chrome";
		data[0][3]="Y";	
		data[0][4]="P";	

		data[1][0]="mercury";
		data[1][1]="00";
		data[1][2]="Chrome";
		data[1][3]="Y";	
		data[1][4]="N";	
		return Arrays.asList(data);
	}
}
