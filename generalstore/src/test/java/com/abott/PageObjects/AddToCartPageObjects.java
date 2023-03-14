package com.abott.PageObjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddToCartPageObjects {
	
	public AddToCartPageObjects(AppiumDriver<MobileElement> driverDevice) {
		PageFactory.initElements(new AppiumFieldDecorator(driverDevice), this);

	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	private List<MobileElement> productsOnPage;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private MobileElement sendEmailCheckbox;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private MobileElement visitToWebsiteBtn;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<MobileElement> productPrice;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private MobileElement totalAmount;
	
	

	public List<MobileElement> getProductsOnPage() {
		return productsOnPage;
	}

	public MobileElement getSendEmailCheckbox() {
		return sendEmailCheckbox;
	}

	public MobileElement getVisitToWebsiteBtn() {
		return visitToWebsiteBtn;
	}

	public List<MobileElement> getProductPrice() {
		return productPrice;
	}

	public MobileElement getTotalAmount() {
		return totalAmount;
	}
	

}
