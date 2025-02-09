package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_016 extends BaseClass {
	
	@Test
	public void verify_twitter_login() {
		LoginPage lp = new LoginPage(driver);
		
		lp.clickTwitterLogo();
		
		String facebookLoginURL = driver.getCurrentUrl();
		
		Assert.assertTrue(facebookLoginURL.contains("facebook"), 
	            "Facebook login does not open facebook login URL");
	}
}
