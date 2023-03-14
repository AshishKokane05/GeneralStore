package com.abott.Autohelper;

import java.util.List;

import org.testng.asserts.SoftAssert;

public class SoftAsserts {

	SoftAssert softAssert;

	/**
	 * @author ashish.kokane
	 */
	public void performSoftAssert(List<String> actVal, List<String> expVal) {

		softAssert = new SoftAssert();
		for (int cntVal = 0; cntVal < actVal.size(); cntVal++) {
			softAssert.assertEquals(actVal.get(cntVal), expVal.get(cntVal));
		}
		softAssert.assertAll();
	}

	/**
	 * @author ashish.kokane
	 */
	public void performSoftAssert(float total, float expVal) {
		softAssert = new SoftAssert();
		softAssert.assertEquals(total, expVal);
		softAssert.assertAll();
		
	}

	/**
	 * @author ashish.kokane
	 */
	public void performSoftAssert(String string, String text) {
		softAssert = new SoftAssert();
		softAssert.assertEquals(string, text);
		softAssert.assertAll();
		
	}
}
