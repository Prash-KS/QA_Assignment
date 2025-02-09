package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//th[@id='amount']")
	WebElement headerAmount;
	
	@FindBy(xpath="//table[@id='transactionsTable']//td[5]")
	public List<WebElement> amountElements;
	
	@FindBy(xpath="//table[@id='transactionsTable']//tbody/tr")
	public List<WebElement> allRows;

	public void clickAmount() {
		headerAmount.click();
	}
}
