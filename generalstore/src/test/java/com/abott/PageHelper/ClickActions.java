package com.abott.PageHelper;

import org.openqa.selenium.WebElement;

import com.abott.Autohelper.WaitHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ClickActions {

	AppiumDriver<MobileElement> driver;
	WaitHelper waitHelper;

	public ClickActions(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
	}

	/**
	 * @author ashish.kokane
	 * @Desc:This method will clcik on mobile element
	 * @param element
	 */
	public void clickElement(MobileElement element) {
		waitHelper.waitForElementToBeDisplayed(element, 5);
		element.click();
	}

}
