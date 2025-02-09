package testCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_HP_002 extends BaseClass {

	@Test
	public void verifyDescendingSort() {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(p.getProperty("validUsername"));
		lp.setPassword(p.getProperty("validPassword"));
		lp.clickLogin();
		
		HomePage hp = new HomePage(driver);
		hp.clickAmount();
		hp.clickAmount();
		
		List<Double> amountList = new ArrayList<>();
		
        for (WebElement amountElement : hp.amountElements) {
        	
            String amountText = amountElement.getText().replace(" USD", "").replace(",", "").replace(" ", "");
            double amountDouble = Double.parseDouble(amountText);

            amountList.add(amountDouble);
        }
        
        for (int i = 1; i < amountList.size(); i++) {
            Assert.assertTrue(amountList.get(i) <= amountList.get(i - 1), "Table is not sorted in descending order");
        }

	}

}
