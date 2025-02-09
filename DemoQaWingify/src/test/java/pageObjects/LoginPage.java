package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='username']")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkRememberMe;
	
	@FindBy(xpath="//button[@id='log-in']")
	WebElement btnLogin;
	
	@FindBy(xpath="//img[@src='img/twitter.png']")
	WebElement imgTwitter;

	@FindBy(xpath="//img[@src='img/facebook.png']")
	WebElement imgFacebook;
	
	@FindBy(xpath="//img[@src='img/linkedin.png']")
	WebElement imgLinkedin;
	
	
	public void setUserName(String username) {
		txtUsername.sendKeys(username);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickRememberMe() {
		checkRememberMe.click();
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickTwitterLogo() {
		imgTwitter.click();
	}
	
	public void clickFacebookLogo() {
		imgFacebook.click();
	}
	
	public void clickLinkedinLogo() {
		imgLinkedin.click();
	}
	
}
