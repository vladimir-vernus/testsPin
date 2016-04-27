package com.testing.task.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class PinData {
	
	@DataProvider()
	public static Iterator<Object[]> firstTryPinData(){
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[]{1234, true, false});
		list.add(new Object[]{4321, false, false});
		return list.iterator();	
	}
	
	@DataProvider()
	public static Iterator<Object[]> secondTryPinData(){
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[]{4321, 1234, true, false});
		list.add(new Object[]{4321, 4321, false, false});
		return list.iterator();	
	}
	
	@DataProvider()
	public static Iterator<Object[]> thirdTryPinData(){
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[]{4321, 4321, 1234, true, false});
		list.add(new Object[]{4321, 4321, 4321, false, true});
		return list.iterator();	
	}

}
