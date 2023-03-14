package com.abott.utilities.Merchant.Enums;

public enum MerchantIDs {
	MerchantId("MerchantId"),

	autoID_1("1"), autoID_2("2");
	
	private String enumValue;

	MerchantIDs(String value) {
		this.enumValue = value;
	} 

	public String getText() {
		return this.toString().replace("mid", "");
	}

	public String getDataGroup() {
		return this.enumValue;
	}
}
