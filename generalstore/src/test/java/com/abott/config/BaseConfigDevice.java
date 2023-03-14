package com.abott.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abott.Autohelper.AppiumServer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseConfigDevice {

	protected AppiumDriver<MobileElement> driverDevice;
	protected AppiumServer appiumServerBuilder;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		
		//Appium Server initialization
		appiumServerBuilder = new AppiumServer();
		appiumServerBuilder.configureServer("http", "127.0.0.1",
				"4723", new DesiredCapabilities());
		appiumServerBuilder.startTheServer();
		  
		//Starting the session
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "496b1174");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\Workspace\\generalstore\\src\\test\\resources\\TestData\\apks\\General-Store.apk");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
	    desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
	    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driverDevice = new AndroidDriver(remoteUrl, desiredCapabilities);
	    driverDevice.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	   
		
	  }
	 
	@AfterClass
	public void close() {
		driverDevice.quit();
	}

}
