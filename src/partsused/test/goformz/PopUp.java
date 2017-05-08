package partsused.test.goformz;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import common.goformz.Check;
import common.goformz.Click;
import common.goformz.Enter;
import common.goformz.Text;
import common.goformz.Wait;

public class PopUp {
	public static void openAndEnterPopUp(String text, String xPath, WebDriver driver){
		try{
			Click.clickableClick(xPath, driver);
			String searchXpath="//*[contains(@class,'x-window-default x-closable')]/div/div/div/input";
			Enter.clear(searchXpath, driver);
			Enter.text(text, searchXpath, driver);
		}catch(WebDriverException e){
			System.out.println("PopUp not opened" + e);
		}
	}
	public static List<String> getList(String xPath, WebDriver driver){
		try{
			Click.clickableClick(xPath, driver);
			String searchXpath="//*[contains(@class,'x-window-default x-closable')]/div/div/div/input";
			Enter.clear(searchXpath, driver);
			Buttons.done(driver);
			Click.clickableClick(xPath, driver);
			String listXpath="//*[contains(@class,'x-grid-row')]";
			Wait.clickable(listXpath, driver);
			int size=driver.findElements(By.xpath(listXpath)).size();
			List<String> values=new ArrayList<String>();
			for(int i=1;i<=size;i++){
				String getXpath=listXpath.concat("[").concat(String.valueOf(i)).concat("]/td/div");
				values.add(Text.get(getXpath, driver));
			}
			Buttons.done(driver);
			return values;
		}catch(WebDriverException e){
			System.out.println("PopUp not opened" + e);
			return null;
		}
	}
	public static String openAndSelect(String xPath, WebDriver driver){ //Check if the list is non-empty we can select
		try{
			Click.clickableClick(xPath, driver);
			String searchXpath="//*[contains(@class,'x-window-default x-closable')]/div/div/div/input";
			Enter.clear(searchXpath, driver);
			String optionXpath="//*[contains(@class,'x-grid-row')][1]/td/div";
			Wait.presence(optionXpath, driver);
			if(Check.exist(optionXpath, driver)==false){
				System.out.println("List is empty");
				return null;
			}
			else{
				String text=Text.get(optionXpath, driver);
				Click.actionClick(optionXpath, driver);
				return text;
			}
		}catch(WebDriverException e){
			System.out.println("PopUp not opened" + e);
			return null;
		}
	}
	public static void openAndSelect(String mfg, String xPath, WebDriver driver){ //Check is entered  is not available is accepted
		Click.clickableClick(xPath, driver);
		String searchXpath="//*[contains(@class,'x-window-default x-closable')]/div/div/div/input";
		Enter.clear(searchXpath, driver);
		Buttons.done(driver);
		Click.clickableClick(xPath, driver);
		Enter.text(mfg, searchXpath, driver);
		String optionXpath="//*[contains(@class,'x-grid-row')][1]/td/div[contains(text(),'".concat(mfg).concat("')]");
		if(Check.exist(optionXpath, driver)==true){
			Click.clickableClick(optionXpath, driver);
		}
	}
}
