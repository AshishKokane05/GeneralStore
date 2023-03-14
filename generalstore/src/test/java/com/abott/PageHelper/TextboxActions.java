package com.abott.PageHelper;

import org.openqa.selenium.WebElement;

import com.abott.Autohelper.WaitHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TextboxActions {
	AppiumDriver<MobileElement> driver;
	WaitHelper waitHelper;

	public TextboxActions(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
	}

	public void enterText(MobileElement element, String elementValue) {

		waitHelper.waitForElementToBeDisplayed(element, 5);
		element.click();
		element.sendKeys(elementValue);
	}
	
	public String getText(MobileElement element) {
		return element.getText();
		
	}
}