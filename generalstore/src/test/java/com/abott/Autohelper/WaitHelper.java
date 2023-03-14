package com.abott.Autohelper;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WaitHelper {

	AppiumDriver<MobileElement> driver;

	public WaitHelper(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public WaitHelper() {
	}

	public MobileElement waitForElementToBeDisplayed(MobileElement elementVal, int secTime) {
		try {
			new WebDriverWait(driver, secTime).until(ExpectedConditions.visibilityOf(elementVal));

		} catch (Exception e) {
		}
		return elementVal;
	}
	
	public void pause(int secTime) {
		try {
			Thread.sleep(secTime * 1000);
		} catch (Exception e) {

		}
	}
}
