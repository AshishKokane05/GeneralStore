package com.abott.Tests;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import com.abott.Pages.AddToCartPage;
import com.abott.Pages.ProductPage;
import com.abott.Pages.RegistrationPage;
import com.abott.config.BaseConfigDevice;
import com.abott.utilities.Merchant.Enums.MerchantIDs;

public class GeneralStoreTest extends BaseConfigDevice {

	@Test(enabled = true , priority = 1)
	public void TC1() {
		RegistrationPage registrationPage = new RegistrationPage(driverDevice);
		ProductPage productPage = new ProductPage(driverDevice);
		AddToCartPage addToCartPage=new AddToCartPage(driverDevice);
		
		//Registration process
		//registrationPage.selectCountry("Argentina");
		//registrationPage.enterName("Ashish Kokane");
		//registrationPage.selectGender("Male");
		registrationPage.EnterMerchantDetails(MerchantIDs.autoID_1.toString());
		registrationPage.LetsShopBtnClick();
		
		//Adding Products to Cart
		productPage.AddToCart("PG 3");
		productPage.AddToCart("Nike SFB Jungle");
		productPage.ClickAddToCartButton();
		
		//Cart verification and Visit Website for complete payment
		addToCartPage.VerifyProducts(new ArrayList<String>(Arrays.asList("PG 3","Nike SFB Jungle")));
		addToCartPage.verifyTotalAmount();
		addToCartPage.selectSendEmailCheckbox();
		addToCartPage.clickVisitToWebsiteButton();
		
		//Verifying General Store Home Page
		registrationPage.pressBackBtn();
		registrationPage.VerifyTitle();
		
	}
}
