package test.suite.goformz;

import org.testng.annotations.Test;

import partsused.test.goformz.PartNumber;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class TestPartNumber extends PartNumber {
	private WebDriver driver;
  @Test(priority=11)
  public void testEnterPartNumber() {
	//Check to validate if any alphanumeric part number is entered it is acceped.
	 enterPartNumber(RandomStringUtils.randomAscii(10), 1, driver); 
  }
  @Test(priority=12)
  public void testExistPartNumber(){
	//Check to validate if an existing part number is selected then existing part number can also be selected
	  autoFillPartNumber(2,driver);
  }
  @Test(priority=13)
  public void testSelectExistPartNumber(){
	//Method to test if existing part number is entered it is entered or not
	  searchFillPartNumber("ARB-AIR-ANT2455V-N=",2,driver); 
  }
  @Test(priority=14)
  public void cancelPartNumber(){
	//Cancel while entering a part Number
	  cancelPartNumber(2,driver);
  }
  @Test(priority=15)
  public void testNonExistingPartNumber(){
	//Method to test if non existing part number is entered it is entered or not
	  searchFillPartNumber("ARB-AIR-ANT2455V-N=====",3,driver); 
  }
  @BeforeClass
  public void beforeClass() {
	  driver=TestSetUp.getter();
  }

}
