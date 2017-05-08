package common.goformz;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Text {
	
	public static String get(String xPath, WebDriver driver){
		Wait.presence(xPath, driver);
		WebElement element=driver.findElement(By.xpath(xPath));
		String value=element.getText();
		return value;
	}
	public static String getJS(String xPath, WebDriver driver){
		Wait.presence(xPath, driver);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element=driver.findElement(By.xpath(xPath));
		Object value= ((JavascriptExecutor) driver).executeScript("return arguments[0].value",element);
		String text=String.valueOf(value);
		return text;
	}

}
