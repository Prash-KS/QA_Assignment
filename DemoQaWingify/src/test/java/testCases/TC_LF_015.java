package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_015 extends BaseClass {
	
	@Test
	public void verify_twitter_login() {
		LoginPage lp = new LoginPage(driver);
		
		lp.clickTwitterLogo();
		
		String twitterLoginURL = driver.getCurrentUrl();
		
		Assert.assertTrue(twitterLoginURL.contains("twitter"), 
	            "Twitter login does not open twitter login URL");
	}
}
