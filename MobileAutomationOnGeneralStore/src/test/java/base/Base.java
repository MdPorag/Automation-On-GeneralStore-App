package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	
	public static AndroidDriver driver;

	
	
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException 
	{
		//Letting which application to run
		File f =new File("src");
		File fs = new File(f,"General-Store.apk");
		
		//Openning Emulator
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_30_x86");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		//Running Server in the mentioned port
		AndroidDriver<AndroidElement> driver= new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		//Adding wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	

}
