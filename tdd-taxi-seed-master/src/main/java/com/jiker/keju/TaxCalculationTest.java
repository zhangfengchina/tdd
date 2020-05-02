package com.jiker.keju;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public  class TaxCalculationTest {
	
	TaxCalculation taxCalculation = new TaxCalculation();
	
	@Test
	public void testvaluation(){
		Assert.assertEquals("10", taxCalculation.valuation(new BigDecimal("10.4")).intValue()+"");
		Assert.assertEquals("11", taxCalculation.valuation(new BigDecimal("10.5")).intValue()+"");
	}
	
	@Test
	public void testvaluationOne(){
		Assert.assertEquals("6.0", taxCalculation.valuationOne(2).doubleValue()+"");
		Assert.assertEquals("0.0", taxCalculation.valuationOne(3).doubleValue()+"");
	}
	
	@Test
	public void testvaluationTwo(){
		Assert.assertEquals("0.0", taxCalculation.valuationTwo(2).doubleValue()+"");
		Assert.assertEquals("6.8", taxCalculation.valuationTwo(3).doubleValue()+"");
		Assert.assertEquals("0.0", taxCalculation.valuationTwo(9).doubleValue()+"");
	}
	
	@Test
	public void testvaluationThree(){
		Assert.assertEquals("0.0", taxCalculation.valuationThree(2).doubleValue()+"");
		Assert.assertEquals("0.0", taxCalculation.valuationThree(3).doubleValue()+"");
		Assert.assertEquals("13.8", taxCalculation.valuationThree(10).doubleValue()+"");
	}
	
	@Test
	public void testvaluationFour(){
		Assert.assertEquals("0.25", taxCalculation.valuationFour(1).doubleValue()+"");
		Assert.assertEquals("0.5", taxCalculation.valuationFour(2).doubleValue()+"");
	}
	
	@Test
	public void testcalAll(){
		Assert.assertEquals("6", taxCalculation.calAll(2,0)+"");
		Assert.assertEquals("6", taxCalculation.calAll(2,1)+"");
		Assert.assertEquals("7", taxCalculation.calAll(2,2)+"");
		
		Assert.assertEquals("8", taxCalculation.calAll(5,0)+"");
		Assert.assertEquals("9", taxCalculation.calAll(5,1)+"");
		
		Assert.assertEquals("14", taxCalculation.calAll(10,0)+"");
		Assert.assertEquals("14", taxCalculation.calAll(10,1)+"");
		Assert.assertEquals("14", taxCalculation.calAll(10,2)+"");
		Assert.assertEquals("15", taxCalculation.calAll(10,3)+"");
	}
	
	
}
