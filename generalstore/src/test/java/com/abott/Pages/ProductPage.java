package com.abott.Pages;

import org.openqa.selenium.interactions.touch.TouchActions;

import com.abott.Autohelper.WaitHelper;
import com.abott.PageHelper.ClickActions;
import com.abott.PageHelper.ScrollActions;
import com.abott.PageHelper.TextboxActions;
import com.abott.PageObjects.ProductsPageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ProductPage {

	AppiumDriver driver;
	ClickActions clickActions;
	WaitHelper waitHelper;
	ProductsPageObjects productsPageObjects;
	ScrollActions scrollAction;
	TextboxActions textboxActions;
	TouchActions touchActions;

	public ProductPage(AppiumDriver<MobileElement> driverDevice) {
		this.driver = driverDevice;
		clickActions = new ClickActions(driverDevice);
		waitHelper = new WaitHelper();
		productsPageObjects = new ProductsPageObjects(driverDevice);
		scrollAction = new ScrollActions(driverDevice);
		textboxActions = new TextboxActions(driverDevice);
	}

	/**
	 * @author: ashish.kokane
	 * @Desc: Adding Products To cart
	 */
	public void AddToCart(String ProductName) {
		boolean found = false;
		int length=0;
		int addToCartLength = 0;
		
		while (true) {
			length=productsPageObjects.getProductsOnPage().size();
			addToCartLength = productsPageObjects.getAddToCartBtn().size();
			
			for (int i=0;i<length;i++) {
				 
				if (textboxActions.getText(productsPageObjects.getProductsOnPage().get(i)).equals(ProductName)){
					System.out.println(textboxActions.getText(productsPageObjects.getProductsOnPage().get(i)));
					;
					//touchActions.singleTap(productsPageObjects.getAddToCartBtn().get(count+1));
					waitHelper.pause(2);
					if (length != addToCartLength) {
						System.out.println("Condition passed");
						i=i+1;
						System.out.println("i = "+i);
					}
					
					clickActions.clickElement(productsPageObjects.getAddToCartBtn().get(i));
					 found=true;
					 
					 waitHelper.pause(3);
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
	 * @Desc: Clicking top Add to Cart Button
	 */
	public void ClickAddToCartButton() {
		clickActions.clickElement(productsPageObjects.getAddToCartTopBtn());
		
	}
	
	
}
