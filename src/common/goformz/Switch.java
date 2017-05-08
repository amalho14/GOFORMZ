package common.goformz;

import org.openqa.selenium.WebDriver;

public class Switch {
	private static String windHadleBefore;
	public static void tabs(WebDriver driver){
		windHadleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	}
	public static void previousTabs(WebDriver driver){
		driver.close(); //Close the existing tab
		driver.switchTo().window(windHadleBefore);
	}
}
