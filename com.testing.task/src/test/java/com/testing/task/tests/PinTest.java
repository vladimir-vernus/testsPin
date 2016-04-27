package com.testing.task.tests;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.task.atm.AtmMashine;

public class PinTest {
	
	AtmMashine atmMashine;
	
	@BeforeMethod
	protected void setUp(){
		atmMashine = new AtmMashine();
		atmMashine.setInsertedCard(false);
		atmMashine.setCorrectPin(1234);
		atmMashine.setAccessToAccount(false);
		atmMashine.setEatCard(false);
		atmMashine.setEnterPinCounter(0);
	}

	@Test(dataProviderClass = PinData.class, dataProvider = "firstTryPinData")
	public void firstTryPinTest(Integer pin, Boolean expectedResultAccessToaccount
			, Boolean expectedResultEatcard) {
		atmMashine.insertCard();
		atmMashine.enterPIN(pin);
		Assert.assertTrue(atmMashine.getAccessToAccount()
				== expectedResultAccessToaccount);
		Assert.assertTrue(atmMashine.getEatCard()
				== expectedResultEatcard);
	}
	
	@Test(dataProviderClass = PinData.class, dataProvider = "secondTryPinData")
	public void secondTryPinTest(Integer firstPin, Integer secondPin
			, Boolean expectedResultAccessToaccount, Boolean expectedResultEatcard) {
		atmMashine.insertCard();
		atmMashine.enterPIN(firstPin);
		atmMashine.enterPIN(secondPin);
		Assert.assertTrue(atmMashine.getAccessToAccount()== expectedResultAccessToaccount);
		Assert.assertTrue( atmMashine.getEatCard() == expectedResultEatcard);
	}
	
	@Test(dataProviderClass = PinData.class, dataProvider = "thirdTryPinData")
	public void thirdTryPinTest(Integer firstPin, Integer secondPin
			, Integer thirdPin, Boolean expectedResultAccessToaccount, Boolean expectedResultEatcard) {
		atmMashine.insertCard();
		atmMashine.enterPIN(firstPin);
		atmMashine.enterPIN(secondPin);
		atmMashine.enterPIN(thirdPin);
		Assert.assertTrue(atmMashine.getAccessToAccount()== expectedResultAccessToaccount);
		Assert.assertTrue(atmMashine.getEatCard() == expectedResultEatcard);
	}
	
}


