package com.hy.ly.util;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerDemo {
	
	public static void main(String[] args) {
		BigInteger bi=new BigInteger("1000000");
		BigDecimal bd=new BigDecimal("132123.78678");
		BigDecimal bd2=new BigDecimal("13");
		System.out.println(bi);
		//System.out.println(bd.divide(bd2));
		System.out.println(bd.divide(bd2,BigDecimal.ROUND_HALF_UP));
		System.out.println(bd.divide(bd2,15,BigDecimal.ROUND_HALF_UP));
		
		
		}

}
