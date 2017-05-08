package test.suite.goformz;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import partsused.test.goformz.Manufacturing;

public class TestMfg extends Manufacturing{
	private WebDriver driver;
  @Test(priority=5)
  public void testEnterMfg() {
	  String randomMfg=RandomStringUtils.randomAscii(6,10);
	  enterMfg(randomMfg, 1, driver);
  }
  @Test(priority=6)
  public void autoFillMfg(){
	  autoFillMfg(2,driver); //Method to test if there is a list of values available select one
  }
  @Test(priority=7)
  public void cancelMfg(){
	  cancelMfg(3,driver); //Method to test if cancel is clicked the data is not stored.
  }
  @Test(priority=8)
  public void searchFillMfg(){
	  searchFillMfg("Aruba",4,driver);  //Method to test if existing mfg is entered it is entered or not
  }
  @Test(priority=9)
  public void nonExistingMfg(){
	  searchFillMfg("Arubaaaa",4,driver);//Method to test if non existing mfg is not displayed and existed entered Mfg. can be replaced.
  }
  @Test(priority=10)
  public void checkListOfManufacturers(){
	  checkManufacturers(driver);
  }
  @BeforeClass
  public void setup(){
	  driver=TestSetUp.getter();
  }
}
