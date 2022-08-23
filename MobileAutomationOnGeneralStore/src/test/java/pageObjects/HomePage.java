package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	public HomePage(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	@AndroidFindBy(xpath = "//*[@text='Female']")
	public WebElement femaleButton;
	
	
	@AndroidFindBy(id="android:id/text1")
	public WebElement dropDownClick;
	
	@AndroidFindBy(xpath ="//*[@text='Bangladesh']")
	public WebElement chooseCountryBangladesh;

	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letsShop;
	
}
