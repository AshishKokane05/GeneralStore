package com.abott.Pages;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.interactions.touch.TouchActions;

import com.abott.Autohelper.SoftAsserts;
import com.abott.Autohelper.WaitHelper;
import com.abott.PageHelper.ClickActions;
import com.abott.PageHelper.ScrollActions;
import com.abott.PageHelper.TextboxActions;
import com.abott.PageObjects.AddToCartPageObjects;
import com.abott.PageObjects.ProductsPageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AddToCartPage {

	AppiumDriver driver;
	ClickActions clickActions;
	WaitHelper waitHelper;
	AddToCartPageObjects addToCartPageObjects;
	ScrollActions scrollAction;
	TextboxActions textboxActions;
	TouchActions touchActions;
	SoftAsserts softAssert;

	public AddToCartPage(AppiumDriver<MobileElement> driverDevice) {
		this.driver = driverDevice;
		clickActions = new ClickActions(driverDevice);
		waitHelper = new WaitHelper();
		addToCartPageObjects = new AddToCartPageObjects(driverDevice);
		scrollAction = new ScrollActions(driverDevice);
		textboxActions = new TextboxActions(driverDevice);
		softAssert = new SoftAsserts();
	}

	/**
	 * @author ashish.kokane
	 * @Desc Verification of products
	 */
	public void VerifyProducts(ArrayList<String> products) {
		waitHelper.pause(3);
		ArrayList<String> actProd = new ArrayList<String>();
		for (MobileElement element : addToCartPageObjects.getProductsOnPage()) {
			actProd.add(textboxActions.getText(element));
		}
		softAssert.performSoftAssert(products, actProd);
	}

	/**
	 * @author ashish.kokane
	 * @Desc Extracting Float From String
	 * @return
	 */
	public float ExtractingFloatFromString(String value) {
		float flt = 0;
		// Creating a pattern to identify floats
		Pattern pat = Pattern.compile("[-]?[0-9]*\\.?[0-9]+");
		// matching the string with the pattern
		Matcher m = pat.matcher(value);
		// extracting and storing the float values
		while (m.find()) {
			flt = Float.parseFloat(m.group());
		}
		return flt;
	}

	/**
	 * @author ashish.kokane
	 * @Desc Verification of products
	 */
	public void verifyTotalAmount() {
		float total = 0;
		for (MobileElement element : addToCartPageObjects.getProductPrice()) {
			String value = textboxActions.getText(element);
			float flt = ExtractingFloatFromString(value);
			total = total + flt;
		}
		float ExpVal=ExtractingFloatFromString(textboxActions.getText(addToCartPageObjects.getTotalAmount()));
		softAssert.performSoftAssert(total, ExpVal);
	}
	
	/**
	 * @author ashish.kokane
	 * @Desc select send email checkbox
	 */
	public void selectSendEmailCheckbox() {
		clickActions.clickElement(addToCartPageObjects.getSendEmailCheckbox());
	}
	
	/**
	 * @author ashish.kokane
	 * @Desc click visit TO website button 
	 */
	public void clickVisitToWebsiteButton() {
		clickActions.clickElement(addToCartPageObjects.getVisitToWebsiteBtn());
	}
	
	/**
	 * @author: ashish.kokane
	 * @Desc: Press back button
	 */
	public void pressBackBtn() {
		driver.navigate().back();
	}
	
	
}
