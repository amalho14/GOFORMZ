package test.suite.goformz;

import org.testng.annotations.Test;

import partsused.test.goformz.Quantity;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class TestQuantity extends Quantity {
	private WebDriver driver;
  @Test(priority=16)
  public void validQuantity() {
	  int row=1;
	  enterValidQuantity("12", row, driver);
	  enterValidQuantity("!12@",row,driver);
  }
  @Test(priority=17)
  public void clearExistingQuantity(){
	  int row=1;
	  enterValidQuantity("1", row, driver);
	  clearQuantity(row, driver);
  }
  @Test(priority=18)
  public void invalidQuantity(){
	  int row=1;
	  String text="abc";
	  enterInvalidQuantity(text,row,driver);
  }
  @Test(priority=19)
  public void editQuantity(){
	  int row=1;
	  String text1="14";
	  String text2="15";
	  enterValidQuantity(text1, row, driver);
	  enterValidQuantity(text2,row,driver);
  }
  @BeforeClass
  public void beforeClass() {
	  driver=TestSetUp.getter();
  }

}
