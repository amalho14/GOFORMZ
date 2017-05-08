package test.suite.goformz;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import common.goformz.Environment;
import common.goformz.StartBrowser;
import common.goformz.Templates;

public class TestSetUp {
	private static WebDriver driver;
	
	public static WebDriver getter(){
		return driver;
	}
  
  @BeforeSuite
  public void beforeSuite() {
	  Environment environment=new Environment();
	  environment.setTestEnvironmentURL();
	  environment.setTestCredentials();
	  StartBrowser start=new StartBrowser();
	  driver=start.chrome(environment.getTestURL());
	  start.login(environment.getUserName(), environment.getTestPassword(), environment.getUser(), driver);
	  Templates t1=new Templates();
	  t1.open(driver);
	  t1.newForm(driver);
  }
  @AfterSuite
  public void afterSuite(){
	  driver.quit();
  }
}
