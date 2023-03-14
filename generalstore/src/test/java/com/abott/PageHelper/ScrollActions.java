package com.abott.PageHelper;

import static io.appium.java_client.touch.offset.PointOption.point;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollActions {
	AppiumDriver<MobileElement> driver;
	TouchAction touchActions;
	
	public ScrollActions(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		touchActions = new TouchAction(driver);
	}
	
	public void SwipeUp( ) {
		
		touchActions.longPress(PointOption.point(450, 2139)).moveTo(PointOption.point(450, 1320)).release()
		.perform();
		
	}
	
	public void scrollTillElementIsVisible(MobileElement element , int scrollThreshold) {
		for (int cnt = 0; cnt < scrollThreshold; cnt++) {
			if (element.isDisplayed()) {
				break;
			}
			
			SwipeUp();
		}
	}

}
