package common.goformz;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class StartBrowser {
	
	public WebDriver chrome(URL goformzURL){
		ChromeDriverManager.getInstance().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(goformzURL);
		return driver;
	}
	public void login(String email, String password, String username, WebDriver driver){
		String loginXpath="//*[contains(@class,'container-fluid')]/div/ul[2]/li/a[contains(text(),'Login')]";
		Click.clickableClick(loginXpath, driver);
		String emailXpath="//*[contains(@name,'form')]/fieldset/div/input[contains(@type,'email')]";
		Enter.text(email, emailXpath, driver);
		String passwordXpath="//*[contains(@name,'form')]/fieldset/div/input[contains(@type,'password')]";
		Enter.text(password, passwordXpath, driver);
		String submitXpath="//*[contains(@name,'form')]/fieldset/div/button[contains(text(),'Login to GoFormz')]";
		Click.clickableClick(submitXpath, driver);
		String menuBarXpath="//*[contains(@id,'menuACCOUNT')]/a[contains(text(),'".concat(username).concat("')]");
		Wait.presence(menuBarXpath, driver);
	}
}
