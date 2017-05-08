package test.suite.goformz;

import org.testng.annotations.Test;

import partsused.test.goformz.Description;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class TestDescription extends Description {
	private static WebDriver driver;
	
	@Test(priority=1)
	public void testEnterDesc(){
		String input=RandomStringUtils.randomAscii(10,50);
		enterDesc(input,1,driver); //Verify if String is entered or not in description
	}
	@Test(priority=2)
	public void testClearField(){
		clearDesc(1,driver);
	}
	@Test(priority=3)
	public void testAutoFill(){
		autoFillDesc(1,driver);
	}
	@Test(priority=4)
	public void testAutoFillEdit(){
		String enterText=RandomStringUtils.randomAscii(2, 10);
		autoFillEdit(enterText, 2,driver);//Verify if auto fill cannot be edited
	}
	
	@BeforeClass
	public void beforeTest() {
	  driver=TestSetUp.getter();	
	}
}
