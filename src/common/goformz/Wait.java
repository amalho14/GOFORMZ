package common.goformz;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait { 
	
	public static void clickable(String xPath, WebDriver driver){
		try{
			WebDriverWait wait=new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
		}catch(TimeoutException e){
			System.out.println("Element either not clickable or not found" +xPath + e);
		}
		
	}
	public static void presence(String xPath, WebDriver driver){
		try{
			WebDriverWait wait=new WebDriverWait(driver,40);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
		}catch(ElementNotVisibleException e){
			System.out.println("Element no visibile or Time Out" + xPath +e);
		}
	}
	public static void invisible(String xPath, WebDriver driver){
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPath)));
	}
	public static void sleep(){
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}