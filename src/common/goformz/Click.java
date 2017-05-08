package common.goformz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Click {
	public static void clickableClick(String xPath, WebDriver driver){
		Wait.clickable(xPath, driver);
		WebElement element=driver.findElement(By.xpath(xPath));
		element.click();
	}
	public static void visibleClick(String xPath, WebDriver driver){
		Wait.presence(xPath, driver);
		WebElement element=driver.findElement(By.xpath(xPath));
		element.click();
	}
	public static void actionClick(String xPath, WebDriver driver){
		Wait.clickable(xPath, driver);
		WebElement actionElement=driver.findElement(By.xpath(xPath));
		Actions actions=new Actions(driver);
		actions.moveToElement(actionElement).click().build().perform();
	}
	public static void actionOffSet(String xPath, int xOffSet, int yOffSet, WebDriver driver){
		Wait.presence(xPath, driver);
		WebElement element=driver.findElement(By.xpath(xPath));
		Actions actions=new Actions(driver);
		actions.moveToElement(element, xOffSet, yOffSet).click().build().perform();
	}
}
