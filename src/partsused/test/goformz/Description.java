package partsused.test.goformz;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import common.goformz.Check;
import common.goformz.Enter;
import common.goformz.Text;

public class Description extends PartNumber {
	public String calculateDescXpath(int row){
		String descXpath="//*[contains(@id,'table3')]/tr[".concat(String.valueOf(row)).concat("]/td[3]/input");
		return descXpath;
	}
	public void enterDesc(String text, int row, WebDriver driver){
		String descXpath=calculateDescXpath(row);
		Enter.text(text, descXpath, driver);
		Boolean result=Check.isEntered(descXpath, text, driver);
		Assert.assertEquals("Description not Entered", true, result);
	}
	public void clearDesc(int row, WebDriver driver){
		String descXpath=calculateDescXpath(row);
		Enter.clear(descXpath, driver);
		Boolean result=Check.isEmpty(descXpath, driver);
		Assert.assertEquals("Description not cleared", true, result);
	}
	public void autoFillDesc(int row, WebDriver driver){
		String descXpath=calculateDescXpath(row);
		autoFillPartNumber(row, driver);
		Boolean result=Check.isEmpty(descXpath, driver);
		Assert.assertEquals("Description not Auto Filled", false, result);
	}
	public void autoFillEdit(String text, int row, WebDriver driver){
		autoFillDesc(row, driver);
		String descXpath=calculateDescXpath(row);
		String currentText=Text.getJS(descXpath,driver);
		Enter.text(text, descXpath, driver);
		Enter.enterKey(descXpath, driver);
		String concatString=currentText.concat(text);
		Boolean result=Check.isEntered(descXpath, concatString,driver);
		Assert.assertEquals("Can edit auto filled description for MFG and Par Number",false, result);
	}
}
