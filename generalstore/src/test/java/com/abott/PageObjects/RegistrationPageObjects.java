package com.abott.PageObjects;


import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;

public class RegistrationPageObjects {

	public RegistrationPageObjects(AppiumDriver<MobileElement> driverDevice){
		PageFactory.initElements(new AppiumFieldDecorator(driverDevice), this);

	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private MobileElement countryDropdown;
	
	@AndroidFindBy(id = "android:id/text1")
	private List<MobileElement> dropDronValue;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private MobileElement nameTextbox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private MobileElement radioBtnMale;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private MobileElement RadioBtnFemale;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private MobileElement letsShopBtn;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	private MobileElement GeneralStoreTitle;

	public MobileElement getGeneralStoreTitle() {
		return GeneralStoreTitle;
	}
	
	public MobileElement getRadioBtnMale() {
		return radioBtnMale;
	}

	public MobileElement getRadioBtnFemale() {
		return RadioBtnFemale;
	}

	public MobileElement getLetsShopBtn() {
		return letsShopBtn;
	}

	public MobileElement getNameTextbox() {
		return nameTextbox;
	}

	public List<MobileElement> getDropDronValue() {
		return dropDronValue;
	}

	public MobileElement getCountryDropdown() {
		return countryDropdown;
	}
}
