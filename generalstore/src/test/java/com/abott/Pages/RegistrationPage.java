package com.abott.Pages;

import com.abott.Autohelper.JsonFileHelper;
import com.abott.Autohelper.SoftAsserts;
import com.abott.Autohelper.WaitHelper;
import com.abott.PageHelper.ClickActions;
import com.abott.PageHelper.ScrollActions;
import com.abott.PageHelper.TextboxActions;
import com.abott.PageObjects.RegistrationPageObjects;
import com.abott.utilities.Merchant.Enums.MerchantIDs;
import com.abott.utilities.UserClasses.MerchantClass;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class RegistrationPage {
	AppiumDriver driver;
	ClickActions clickActions;
	WaitHelper waitHelper;
	RegistrationPageObjects registrationPageObjects;
	ScrollActions scrollAction;
	TextboxActions textboxActions;

	public RegistrationPage(AppiumDriver<MobileElement> driverDevice) {
		this.driver = driverDevice;
		clickActions = new ClickActions(driverDevice);
		waitHelper = new WaitHelper();
		registrationPageObjects = new RegistrationPageObjects(driverDevice);
		scrollAction = new ScrollActions(driverDevice);
		textboxActions = new TextboxActions(driverDevice);
	}

	/**
	 * @author: ashish.kokane
	 * @Desc: Selecting Country
	 */
	public void selectCountry(String CountryName) {
		clickActions.clickElement(registrationPageObjects.getCountryDropdown());
		boolean found = false;
		while (true) {
			for (MobileElement ele : registrationPageObjects.getDropDronValue()) {
				if (ele.getAttribute("text").equals(CountryName)) {
					System.out.println(ele.getAttribute("text"));
					clickActions.clickElement(ele);
					found = true;
					break;
				}
			}
			if (found == true) {
				break;
			}
			scrollAction.SwipeUp();
		}

	}

	/**
	 * @author: ashish.kokane
	 * @Desc: Enter Name
	 */
	public void enterName(String name) {
		textboxActions.enterText(registrationPageObjects.getNameTextbox(), name);
		pressBackBtn();
	}

	/**
	 * @author: ashish.kokane
	 * @Desc: Press back button
	 */
	public void pressBackBtn() {
		driver.navigate().back();
	}

	/**
	 * @author: ashish.kokane
	 * @Desc: Gender Selection
	 */
	public void selectGender(String gender) {
		if (gender == "Male") {
			clickActions.clickElement(registrationPageObjects.getRadioBtnMale());

		} else if (gender == "Female") {
			clickActions.clickElement(registrationPageObjects.getRadioBtnFemale());
		}
	}

	/**
	 * @author: ashish.kokane
	 * @Desc: Lets Shop Button Click
	 */
	public void LetsShopBtnClick() {
		clickActions.clickElement(registrationPageObjects.getLetsShopBtn());
	}

	/**
	 * @author: ashish.kokane
	 * @Desc: Title Verification
	 */
	public void VerifyTitle() {
		new SoftAsserts().performSoftAssert("General Store",
				textboxActions.getText(registrationPageObjects.getGeneralStoreTitle()));
		;
	}

	/**
	 * @author: ashish.kokane
	 */
	public void EnterMerchantDetails(String merchantAutoID) {
		// MerchantClass MerchantDetails = (MerchantClass) new
		// JsonFileHelper().convertJSONFileToJsonArray(merchantAutoID);
		MerchantClass MerchantDetails = (MerchantClass) new JsonFileHelper().convertJsonFileToUserDefinedObject(
				new MerchantClass(), MerchantIDs.MerchantId.getText(), merchantAutoID,
				"D:/Workspace/generalstore/src/test/resources/TestData/MerchantDetails/MerchantRegistrationDetails.json");
		selectCountry(MerchantDetails.getCountry());
		enterName(MerchantDetails.getMerchantName());
		selectGender(MerchantDetails.getGender());
		

	}

}
