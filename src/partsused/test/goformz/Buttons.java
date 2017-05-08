package partsused.test.goformz;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import common.goformz.Check;
import common.goformz.Click;
import common.goformz.Wait;

public class Buttons {
	public static void done(WebDriver driver){
		try{
			String doneXpath="//*[contains(@class,'x-btn-inner')][contains(text(),'Done')]";
			Wait.presence(doneXpath, driver);
			Assert.assertEquals("Done button not enabled", true, Check.isEnabled(doneXpath, driver));
			Click.clickableClick(doneXpath, driver);
		}catch(WebDriverException e){
			System.out.println("Either PopUp not opened or done button not available" + e);
		}
		
	}
	public static void close(WebDriver driver){
		try{
			String closeXpath="//*[contains(@class,'x-tool-close')]";
			Click.clickableClick(closeXpath, driver);
		}catch(WebDriverException e){
			System.out.println("Either PopUp not opened or close button not available" + e);
		}
	}
}
