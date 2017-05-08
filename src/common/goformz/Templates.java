package common.goformz;

import org.openqa.selenium.WebDriver;

public class Templates {
	public void open(WebDriver driver){
		String templatesXpath="//*[contains(@id,'menuFORMS')]/a[contains(text(),'Templates')]";
		Click.clickableClick(templatesXpath, driver);
		//Open Sample Work Order Template
		String sampleWorderXpath="//*[contains(@class,'viewgrid')]/div/table/tbody/tr/td/a[contains(text(),'Sample Work Order')]";
		Click.clickableClick(sampleWorderXpath, driver);
	}
	public void newForm(WebDriver driver){
		//System.out.println("Wait");
		//Wait.presence("//*[@class='x-mask-loading'][contains(text(),'Loading')]",driver);
		//Wait.invisible("//*[@class='x-mask-loading'][contains(text(),'Loading')]", driver);
		//Explicit wait for 3 seconds
		Wait.sleep();
		String tempXpath="//*[contains(@class,'x-panel formpagepanel x-panel-default')]/div/img";
		//Wait.presence(tempXpath, driver);
		Wait.clickable(tempXpath, driver);
		String moreButtonXpath="//*[contains(@class,'x-box-inner')]/div/em/button/span[contains(text(),'More')]";
		Click.actionClick(moreButtonXpath, driver);
		String newFormXpath="//*[contains(@class,'x-box-inner')]/div/a/span[contains(text(),'New Form')]";
		Click.actionClick(newFormXpath, driver);
		Wait.sleep();
		Switch.tabs(driver);
	}

}
