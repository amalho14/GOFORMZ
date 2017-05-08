package common.goformz;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Enter {
	public static void text(String text, String xPath, WebDriver driver){
		Wait.clickable(xPath, driver);
		WebElement element=driver.findElement(By.xpath(xPath));
		element.sendKeys(text);
	}
	public static void enterKey(String xPath, WebDriver driver){
		Wait.presence(xPath, driver);
		WebElement element=driver.findElement(By.xpath(xPath));
		element.sendKeys(Keys.ENTER);
	}
	public static void clear(String xPath, WebDriver driver){
		Wait.presence(xPath, driver);
		WebElement element=driver.findElement(By.xpath(xPath));
		element.clear();
	}
	public static void selectClear(String xPath, WebDriver driver){
		Wait.presence(xPath, driver);
		WebElement element=driver.findElement(By.xpath(xPath));
		element.sendKeys(Keys.chord(Keys.CONTROL+"a"));
		element.sendKeys(Keys.BACK_SPACE);
	}
}
