package test.suite.goformz;

import org.testng.annotations.Test;

import common.goformz.Environment;
import common.goformz.StartBrowser;
import common.goformz.Templates;
import partsused.test.goformz.Quantity;
import partsused.test.goformz.TotalPrice;
import partsused.test.goformz.UnitPrice;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class E2ETest extends UnitPrice {
	private WebDriver driver;
	private Quantity quantityObj=new Quantity();
	private TotalPrice price=new TotalPrice();
  @Test(priority=29)
  public void enterE2E() {
	  int row=1;
	  String mfg="Test Manufacturer";
	  enterMfg(mfg, row, driver);
	  String partNumber="Test PartNumber";
	  enterPartNumber(partNumber, row, driver);
	  String description="Test Description";
	  enterDesc(description, row, driver);
	  String quantity="5";
	  quantityObj.enterValidQuantity(quantity, row, driver);
	  String unitPrice="10.99";
	  enterUnitPrice(unitPrice, row, driver);
	  price.verifyTotalPrice(row, driver); 
  }
  @Test(priority=30)
  public void autoFillE2E(){
	  int row=2;
	  String quantity="10";
	  autoFillUnitPrice(row, driver);
	  quantityObj.enterValidQuantity(quantity, row, driver);
	  price.verifyTotalPrice(row, driver);
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
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
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
