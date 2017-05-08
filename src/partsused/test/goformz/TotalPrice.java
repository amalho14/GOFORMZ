package partsused.test.goformz;

import java.text.DecimalFormat;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import common.goformz.Check;
import common.goformz.Text;

public class TotalPrice extends UnitPrice{
	private Quantity quantityObj=new Quantity();
	
	public String calculateTotalPriceXpath(int row){
		String totalPriceXpath="//*[contains(@id,'table3')]/tr[".concat(String.valueOf(row)).concat("]/td[6]/input");
		return totalPriceXpath;
	}
	public void verifyTotalPrice(int row, WebDriver driver){
		Boolean result=false;
		String totalPriceXpath=calculateTotalPriceXpath(row);
		String unitPriceXpath=calculateUnitPriceXpath(row);
		String unitPrice=Text.getJS(unitPriceXpath, driver);
		String quantity=quantityObj.returnQuantity(row, driver);
		int quantityValue=Integer.valueOf(quantity);
		double  unitPriceValue=Double.valueOf(unitPrice);
		double expectedTotalPrice=quantityValue*unitPriceValue;
		DecimalFormat df = new DecimalFormat("#.##");
		expectedTotalPrice=Double.valueOf(df.format(expectedTotalPrice));
		String actualTotalPriceValue=Text.getJS(totalPriceXpath, driver);
		actualTotalPriceValue=actualTotalPriceValue.replaceAll(",", "");
		char dollarValue=actualTotalPriceValue.charAt(0);
		Double actualTotalPrice=Double.parseDouble(actualTotalPriceValue.substring(1));
		Boolean dollarExist=Check.isCharEqual(dollarValue, '$');
		Assert.assertEquals("Dollar Sign is missing in total price", true,dollarExist);
		if(expectedTotalPrice==actualTotalPrice){
			result=true;
		}
		Assert.assertEquals("Total Price calculated incorrectly" , true, result);
	}
	public void quantityTotalPrice(String quantity, int row, WebDriver driver){
		autoFillUnitPrice(row, driver);
		quantityObj.enterValidQuantity(quantity, row, driver);
		autoFillUnitPrice(row, driver);
		verifyTotalPrice(row,driver);
	}
	public void totalPrice(String quantity, String unitPrice, int row, WebDriver driver){
		quantityObj.enterValidQuantity(quantity, row, driver);
		enterUnitPrice(unitPrice, row, driver);
		verifyTotalPrice(row,driver);
	}
	public void nullTotalPrice(String unitPrice,int row, WebDriver driver){
		String totalPriceXpath=calculateTotalPriceXpath(row);
		enterUnitPrice(unitPrice, row, driver);
		quantityObj.clearQuantity(row, driver);
		Boolean result=Check.isEmpty(totalPriceXpath, driver);
		Assert.assertEquals("For invalid quantity total price exists", true, result);
	}
}
