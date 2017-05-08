package partsused.test.goformz;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import common.goformz.Check;
import common.goformz.Enter;
import common.goformz.Text;

public class Quantity {
	
	public String calculateQuantityXpath(int row){
		String quantityXpath="//*[contains(@id,'table3')]/tr[".concat(String.valueOf(row)).concat("]/td[4]/input");
		return quantityXpath;
	}
	public void enterValidQuantity(String text, int row, WebDriver driver){
		String quantityXpath=calculateQuantityXpath(row);
		clearQuantity(row,driver);
		Enter.text(text, quantityXpath, driver);
		Enter.enterKey(quantityXpath, driver);
		Boolean result=Check.isEntered(quantityXpath, text, driver);
		Assert.assertEquals("Quantity hasn't been entered successfully: " + text, true, result);
	}
	public void clearQuantity(int row, WebDriver driver){
		String quantityXpath=calculateQuantityXpath(row);
		Enter.clear(quantityXpath, driver);
		Enter.enterKey(quantityXpath, driver);
		Boolean result=Check.isEmpty(quantityXpath, driver);
		Assert.assertEquals("Quantity has not been cleared successfully", true, result);
	}
	public void enterInvalidQuantity(String text, int row, WebDriver driver){
		String quantityXpath=calculateQuantityXpath(row);
		clearQuantity(row,driver);
		Enter.text(text, quantityXpath, driver);
		Boolean result=Check.isEntered(quantityXpath, text, driver);
		Assert.assertEquals("Invalid Quantity type has been entered: " + text, false,result);
	}
	public String returnQuantity(int row, WebDriver driver){
		String quantityXpath=calculateQuantityXpath(row);
		return Text.getJS(quantityXpath, driver);
		
	}
}
