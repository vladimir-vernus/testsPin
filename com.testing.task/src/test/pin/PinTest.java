package test.pin;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PinTest {
	
	AtmMashine atmMashine = new AtmMashine();
	
	@DataProvider()
	public static Iterator<Object[]> pinData(){
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[]{1234});
		list.add(new Object[]{4321});
		list.add(new Object[]{1234});
		list.add(new Object[]{4321});
		list.add(new Object[]{1234});
		list.add(new Object[]{4321});
		return list.iterator();	
	}
	
	@BeforeMethod
	protected void setUp(){
		atmMashine.setCorrectPin(1234);
		atmMashine.setAccessToAccount(false);
	}

	@Test(dataProvider = "pinData")
	public void test(Integer pin) {
		atmMashine.insertCard();
		atmMashine.enterPIN(pin);
		if(atmMashine.getCorrectPin() == pin && atmMashine.getEnterPinCounter()<3){
			Assert.assertTrue(atmMashine.getAccessToAccount()== true);
			Assert.assertTrue(atmMashine.getEatCard()== false);
		}else if(!(atmMashine.getCorrectPin() == pin) && atmMashine.getEnterPinCounter()<3){
			Assert.assertTrue(atmMashine.getAccessToAccount()== false);
			Assert.assertTrue(atmMashine.getEatCard()== false);
		}else{
			Assert.assertTrue(atmMashine.getAccessToAccount()== false);
			Assert.assertTrue(atmMashine.getEatCard()== true);
		}
		
	}

}
