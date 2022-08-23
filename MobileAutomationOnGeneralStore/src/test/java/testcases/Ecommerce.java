package testcases;

import java.awt.Checkbox;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.Products;
import utilitties.Utilitties;

public class Ecommerce extends Base {

	@Test
	public void mySecondTest() throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities();
		Thread.sleep(2000);

		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		
		
		HomePage hpage=new HomePage(driver);
		hpage.nameField.sendKeys("Hello");
		Thread.sleep(2000);
		
		hpage.femaleButton.click();
		
		hpage.dropDownClick.click();
		
		Utilitties util = new Utilitties(driver);
		util.scrollToText("Bangladesh");
		
		Thread.sleep(2000);
		hpage.chooseCountryBangladesh.click();
		
		hpage.letsShop.click();
		
		Products prod = new Products(driver);
		prod.addToCart.get(1).click();
		Thread.sleep(2000);
		prod.addToCart.get(0).click();
		Thread.sleep(2000);
		prod.cart.click();
		
		CheckoutPage cPage= new CheckoutPage(driver);
		
		double sum = 0;
		int count = cPage.productList.size();

		for (int i = 0; i < count; i++) {
			String amountWithDollarSign = cPage.productList.get(i).getText();
			double onlyDoubleAmount = getAmount(amountWithDollarSign);
			sum = sum + onlyDoubleAmount;
		}
		System.out.println("SumOfProducts individually: " + sum);

		String total = cPage.total.getText();
		double totalValue = getAmount(total);
		System.out.println("TotalValue from the application: " + totalValue);

		Assert.assertEquals(sum, totalValue);
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		driver.quit();
		

	}
	
	

	public static double getAmount(String amountWithDollarSign) {
		String amountWithOutDollarSign = amountWithDollarSign.substring(1);
		double amountOnlyDouble = Double.parseDouble(amountWithOutDollarSign);
		return amountOnlyDouble;
	}
}
