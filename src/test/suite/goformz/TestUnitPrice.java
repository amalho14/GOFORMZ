package test.suite.goformz;

import org.testng.annotations.Test;

import partsused.test.goformz.UnitPrice;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class TestUnitPrice extends UnitPrice {
	public WebDriver driver;
  @Test(priority=20)
  public void testASCIIUnitPrice() {
	  int row=4;
	  String unitPrice=RandomStringUtils.randomAlphanumeric(1, 3);//Validate alphanumeric 
	  enterUnitPrice(unitPrice, row, driver);
  }
  @Test(priority=21)
  public void testDoubleUnitPrice(){
	  double price=11.99;
	  String unitPrice=String.valueOf(price);
	  int row=4;
	  enterUnitPrice(unitPrice,row,driver);
  }
  @Test(priority=22)
  public void testAmmedUnitPrice(){
	  String unitPriceOld="10";
	  String unitPriceNew="20";
	  int row=4;
	  enterUnitPrice(unitPriceOld,row,driver);
	  enterUnitPrice(unitPriceNew,row,driver);
  }
  @Test(priority=23)
  public void testAutoFillUnitPrice(){
	  int row=1;
	  autoFillUnitPrice(row, driver);
  }
  @Test(priority=24)
  public void testEditAutoFillUnitPrice(){
	  int row=1;
	  String unitPrice="111";
	  editAutoFillUnitPrice(unitPrice, row, driver);
  }
  @Test(priority=25)
  public void testDeleteAutoFillUnitPrice(){
	  int row=1;
	  deleteAutoFillUnitPrice(row, driver);
  }
  @BeforeClass
  public void beforeClass() {
	  driver=TestSetUp.getter();	 
  }

}
