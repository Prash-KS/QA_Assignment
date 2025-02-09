package testCases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_HP_003 extends BaseClass {

	@Test
	public void verifyRowsRemainIntactAfterSorting() {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(p.getProperty("validUsername"));
		lp.setPassword(p.getProperty("validPassword"));
		lp.clickLogin();
		
		HomePage hp = new HomePage(driver);

	    List<List<String>> tableDataBefore = new ArrayList<>();

	    for (WebElement row : hp.allRows) {
	        List<WebElement> cells = row.findElements(By.tagName("td"));
	        List<String> rowData = new ArrayList<>();
	        for (WebElement cell : cells) {
	            rowData.add(cell.getText().trim());  
	        }
	        tableDataBefore.add(rowData);
	    }

	    hp.clickAmount();

	    List<List<String>> tableDataAfter = new ArrayList<>();

	    for (WebElement row : hp.allRows) {
	        List<WebElement> cells = row.findElements(By.tagName("td"));
	        List<String> rowData = new ArrayList<>();
	        for (WebElement cell : cells) {
	            rowData.add(cell.getText().trim()); 
	        }
	        tableDataAfter.add(rowData);
	    }

	    List<List<String>> sortedTableDataBefore = new ArrayList<>(tableDataBefore);
	    sortedTableDataBefore.sort(Comparator.comparing(row -> Double.parseDouble(row.get(4).replace(",", "").replace("USD", "").replace(" ", ""))));

	    Assert.assertEquals(tableDataAfter, sortedTableDataBefore, "Rows got jumbled after sorting");
	}
}
