package partsused.test.goformz;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import common.goformz.Check;


public class PartNumber extends Manufacturing {
	public String calculatePartNumberXpath(int row){
		String parthNumberXpath="//*[contains(@id,'table3')]/tr[".concat(String.valueOf(row)).concat("]/td[2]");
		return parthNumberXpath;
	}
	public void enterPartNumber(String text, int row, WebDriver driver){
		String partNumberXpath=calculatePartNumberXpath(row);
		PopUp.openAndEnterPopUp(text,partNumberXpath,driver);
		Buttons.done(driver);
		String inputmfgXpath=partNumberXpath.concat("/input");
		Boolean result=Check.isEntered(inputmfgXpath, text, driver);
		Assert.assertEquals("Part Number is not entered correctly" , true, result);
	}
	public void autoFillPartNumber(int row, WebDriver driver){
		autoFillMfg(row, driver);
		String partNumberXpath=calculatePartNumberXpath(row);
		String textResult=PopUp.openAndSelect(partNumberXpath,driver);
		Buttons.done(driver);
		String inputPartNumberXpath=partNumberXpath.concat("/input");
		Boolean result=Check.isEntered(inputPartNumberXpath, textResult, driver);
		Assert.assertEquals("Existing Part Number is not entered" , true, result);
	}
	public void clearPartNumber(int row, WebDriver driver){
		String partNumberXpath=calculateMfgXpath(row);
		PopUp.openAndEnterPopUp("", partNumberXpath, driver);
		Buttons.done(driver);
		String inputPartNumberXpath=partNumberXpath.concat("/input");
		Boolean result=Check.isEmpty(inputPartNumberXpath, driver);
		Assert.assertEquals("Part Number not cleared", true, result);
	}
	public void searchFillPartNumber(String partNumber, int row, WebDriver driver){
		autoFillMfg(row, driver);
		String partNumberXpath=calculatePartNumberXpath(row);
		PopUp.openAndSelect(partNumber,partNumberXpath,driver);
		Buttons.done(driver);
		String inputPartNumberXpath=partNumberXpath.concat("/input");
		Boolean result=Check.isEntered(inputPartNumberXpath, partNumber, driver);
		Assert.assertEquals("Search Part Number is not Entered" , true, result);
	}
	public void cancelPartNumber(int row, WebDriver driver){
		String partNumberXpath=calculateMfgXpath(row);
		String randomPartNumber=RandomStringUtils.randomAscii(6,10);
		PopUp.openAndEnterPopUp(randomPartNumber, partNumberXpath, driver);
		Buttons.close(driver);
		Boolean result=Check.isEntered(partNumberXpath, randomPartNumber, driver);
		Assert.assertEquals("After Cancel part number has still be entered" , false, result);
	}
}
