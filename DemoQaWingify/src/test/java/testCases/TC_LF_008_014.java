package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_008_014 extends BaseClass {
    
    @Test(dataProvider = "LoginData")
    public void verify_login_with_remember_me(String username, String password, String expectedResult) {
        LoginPage lp = new LoginPage(driver);
        
        lp.clickRememberMe();
        
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clickLogin();
        
        String actualURL = driver.getCurrentUrl();
        
        if (expectedResult.equalsIgnoreCase("valid")) {
            Assert.assertTrue(actualURL.contains("home"), 
                "Login failed for valid credentials with Remember Me");
        } else {
            Assert.assertFalse(actualURL.contains("home"), 
                "Login passed for invalid credentials with Remember Me");
        }
    }
}