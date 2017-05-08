package test.suite.goformz;

import org.testng.annotations.Test;

import partsused.test.goformz.TotalPrice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class TestTotalPrice extends TotalPrice {
	private WebDriver driver;
  @Test(priority=26)
  public void testNullTotalPrice() {
	  String unitPrice="12";
	  int row=4;
	  nullTotalPrice(unitPrice, row, driver);
  }
  @Test(priority=27)
  public void testTotalPriceWhenQuantityEnteredAndPriceExist(){
	  int row=1;
	  String quantity="4";
	  quantityTotalPrice(quantity, row, driver);
  }
  @Test(priority=28)
  public void testTotalPriceQuantityPriceEntered(){
	  int row=4;
	  String quantity="5";
	  String unitPrice="5.55";
	  totalPrice(quantity,unitPrice , row, driver);
  }
  @BeforeClass
  public void beforeClass() {
	  driver=TestSetUp.getter();	
	  
  }

}
