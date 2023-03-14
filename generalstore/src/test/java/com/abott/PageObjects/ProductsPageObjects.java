package com.abott.PageObjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPageObjects {

	public ProductsPageObjects(AppiumDriver<MobileElement> driverDevice) {
		PageFactory.initElements(new AppiumFieldDecorator(driverDevice), this);

	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	private List<MobileElement> productsOnPage;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	private List<MobileElement> addToCartBtn;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private MobileElement addToCartTopBtn;
	
	public MobileElement getAddToCartTopBtn() {
		return addToCartTopBtn;
	}

	public List<MobileElement> getProductsOnPage() {
		return productsOnPage;
	}

	public List<MobileElement> getAddToCartBtn() {
		return addToCartBtn;
	}
}
