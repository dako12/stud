package fpt.com.pcHardwareShop.util;

import fpt.com.pcHardwareShop.MyException.IDOverflowException;

public class IDGenerator{
	
	private static long id = 1;
	
	
	public static long generateID() throws IDOverflowException{
		
		if (id+1>=999999){
			throw new IDOverflowException("Number of products exceeded");
		}
		
			return id++;
	
	}
	
}
