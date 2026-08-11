package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObject.HomePage;
import PageObject.LoginPage;
import utilities.DataProviders;

public class LoginTest extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"Regression", "Master"} )
	public void verify_login (String username, String pass, String exp) {
		
		logger.info("******* Starting LoginTest *******");
		try {
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(username);
	    lp.enterPassword(pass);
	    lp.clickLogin();
	    
	    HomePage hp = new HomePage(driver);
	    boolean targetPage = hp.isHomePageExists();
	    
	    if(exp.equalsIgnoreCase("Valid"))
	    {
	    	if(targetPage == true) {
	    		hp.clickSidebar();
	    		hp.clickLogout();
	    		Assert.assertTrue(true);
	    	}
	    	else {
	    		Assert.assertTrue(false);
	    	}
	    }
	    
	    if(exp.equalsIgnoreCase("Invalid"))
	    {
	    	if(targetPage == true) {
	    		hp.clickSidebar();
	    		hp.clickLogout();
	    		Assert.assertTrue(false);
	    	}
	    	else {
	    		Assert.assertTrue(true);
	    	}
	    }
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("******* Finishing LoginTest *******");
			
	}
}
