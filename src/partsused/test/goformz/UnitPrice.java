package partsused.test.goformz;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import common.goformz.Check;
import common.goformz.Enter;
import common.goformz.Text;

public class UnitPrice extends Description {
	
	public String calculateUnitPriceXpath(int row){
		String unitPriceXpath="//*[contains(@id,'table3')]/tr[".concat(String.valueOf(row)).concat("]/td[5]/input");
		return unitPriceXpath;
	}
	public void enterUnitPrice(String text, int row, WebDriver driver){
		String unitPriceXpath=calculateUnitPriceXpath(row);
		clearUnitPrice(row,driver);
		Enter.text(text, unitPriceXpath, driver);
		Enter.enterKey(unitPriceXpath, driver);
		Boolean result=Check.isEntered(unitPriceXpath, text , driver);
		Assert.assertEquals("Unit Price has not been entered correctly" + text, true,result);
	}
	public void clearUnitPrice(int row, WebDriver driver){
		String unitPriceXpath=calculateUnitPriceXpath(row);
		Enter.clear(unitPriceXpath, driver);
		Enter.enterKey(unitPriceXpath, driver);
		Boolean result=Check.isEmpty(unitPriceXpath, driver);
		Assert.assertEquals("Unit Price has not been cleared successfully", true, result);
	}
	public void autoFillUnitPrice(int row, WebDriver driver){
		String unitPriceXpath=calculateUnitPriceXpath(row);
		String manufacturer="Aruba";
		String partNumber="ARB-AIR-ANT2455V-N=";
		enterMfg(manufacturer, row, driver);
		enterPartNumber(partNumber, row, driver);
		Boolean result=Check.isEmpty(unitPriceXpath, driver);
		Assert.assertEquals("Unit Price has not be update correctly in row" + row, false, result);
	}
	public void editAutoFillUnitPrice(String text,int row, WebDriver driver){
		String unitPriceXpath=calculateUnitPriceXpath(row);
		autoFillUnitPrice(row,driver); 
		String existingUnitPrice=Text.getJS(unitPriceXpath, driver);
		String newUnitPrice=existingUnitPrice.concat(text);
		Enter.text(text, unitPriceXpath, driver);
		Enter.enterKey(unitPriceXpath, driver);
		Boolean result=Check.isEntered(unitPriceXpath, newUnitPrice, driver);
		Assert.assertEquals("Can edit quantity for auto fill"+row, false, result);
	}
	public void deleteAutoFillUnitPrice(int row, WebDriver driver){
		String unitPriceXpath=calculateUnitPriceXpath(row);
		autoFillUnitPrice(row,driver);
		String existingUnitPrice=Text.getJS(unitPriceXpath, driver);
		Enter.clear(unitPriceXpath, driver);
		Enter.enterKey(unitPriceXpath, driver);
		Boolean result=Check.isEntered(unitPriceXpath, existingUnitPrice, driver);
		Assert.assertEquals("Can delete quantity for auto fill"+row, true, result);
	}
}
