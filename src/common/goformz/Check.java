package common.goformz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Check {
	
	public static void verify(String xPath, String text, WebDriver driver){
		Wait.presence(xPath, driver);
		WebElement element=driver.findElement(By.xpath(xPath));
		String getText=element.getText();
		if(getText.equalsIgnoreCase(text)==false){
			System.out.println("INFO: Text not equal for request String" + '\t' + text + xPath);
		}
	}
	public static Boolean isEnabled(String xPath, WebDriver driver){
		Wait.presence(xPath, driver);
		WebElement element=driver.findElement(By.xpath(xPath));
		Boolean result=element.isEnabled();
		return result;
	}
	public static Boolean exist(String xPath, WebDriver driver){
		if(driver.findElements(By.xpath(xPath)).size()>0){
			return true;
		}
		else return false;
	}
	public static Boolean isEntered(String xPath, String text, WebDriver driver){
		String getText=Text.getJS(xPath, driver);
		Boolean result=getText.equals(text);
		return result;
	}
	public static Boolean isEmpty(String xPath, WebDriver driver){
		String getText=Text.getJS(xPath, driver);
		return getText.isEmpty();
	}
	public static Boolean isCharEqual(char text1, char text2){
		if(text1==text2){
			return true;
		}
		else
			return false;
	}
}
