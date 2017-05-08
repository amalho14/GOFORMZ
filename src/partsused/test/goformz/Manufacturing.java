package partsused.test.goformz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import common.goformz.Check;

public class Manufacturing {
	public String calculateMfgXpath(int row){
		String mfgXpath="//*[contains(@id,'table3')]/tr[".concat(String.valueOf(row)).concat("]/td[1]");
		return mfgXpath;
	}
	public void enterMfg(String text, int row, WebDriver driver){
		String mfgXpath=calculateMfgXpath(row);
		String inputmfgXpath=mfgXpath.concat("/input");
		PopUp.openAndEnterPopUp(text,mfgXpath,driver);
		Buttons.done(driver);
		Boolean result=Check.isEntered(inputmfgXpath, text, driver);
		Assert.assertEquals("Manufacturing Name Not Entered" , true, result);
	}
	public void autoFillMfg(int row, WebDriver driver){
		String mfgXpath=calculateMfgXpath(row);
		String textResult=PopUp.openAndSelect(mfgXpath,driver);
		Buttons.done(driver);
		String inputmfgXpath=mfgXpath.concat("/input");
		Boolean result=Check.isEntered(inputmfgXpath, textResult, driver);
		Assert.assertEquals("Selected Manufacturer Not Entered", true, result);
	}
	public void clearMfg(int row, WebDriver driver){
		String mfgXpath=calculateMfgXpath(row);
		PopUp.openAndEnterPopUp("", mfgXpath, driver);
		Buttons.done(driver);
		String inputmfgXpath=mfgXpath.concat("/input");
		Boolean result=Check.isEmpty(inputmfgXpath, driver);
		Assert.assertEquals("Manufacturer not cleared", true, result);
		
	}
	public void searchFillMfg(String mfg, int row, WebDriver driver){
		String mfgXpath=calculateMfgXpath(row);
		PopUp.openAndSelect(mfg,mfgXpath,driver);
		Buttons.done(driver);
		String inputmfgXpath=mfgXpath.concat("/input");
		Boolean result=Check.isEntered(inputmfgXpath, mfg, driver);
		Assert.assertEquals("Search and Select Manufacturer not Entered" , true, result);
	}
	public void cancelMfg(int row, WebDriver driver){
		String mfgXpath=calculateMfgXpath(row);
		String randomMfg=RandomStringUtils.randomAscii(6,10);
		PopUp.openAndEnterPopUp(randomMfg, mfgXpath, driver);
		Buttons.close(driver);
		Boolean result=Check.isEntered(mfgXpath, randomMfg, driver);
		Assert.assertEquals("Cancel when editing Manufacturer not working", false, result);
	}
	public List<String> mfgList(){
		List<String> manufacturers=new ArrayList<String>();
		manufacturers.add("Aruba");
		manufacturers.add("Cisco");
		manufacturers.add("Juniper");
		manufacturers.add("Motorola");
		manufacturers.add("Ruckus");
		return manufacturers;
	}
	public void checkManufacturers(WebDriver driver){
		String mfgXpath=calculateMfgXpath(1);
		List<String> getValues=PopUp.getList(mfgXpath, driver);
		Boolean result=getValues.equals(mfgList());
		Assert.assertEquals("Manufacturers list is not equal", true,result);
	}
}
