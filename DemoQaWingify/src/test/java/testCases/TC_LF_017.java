package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_017 extends BaseClass {
	
	@Test
	public void verify_twitter_login() {
		LoginPage lp = new LoginPage(driver);
		
		lp.clickTwitterLogo();
		
		String linkedinLoginURL = driver.getCurrentUrl();
		
		Assert.assertTrue(linkedinLoginURL.contains("linkedin"), 
	            "Linkedin login does not open linkedin login URL");
	}
}
