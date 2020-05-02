package com.jiker.keju;

import java.math.BigDecimal;

public  class TaxCalculation {

    private  Integer minDistance = 2;

    private  Integer midDistance = 8;


    private  BigDecimal price = new BigDecimal(0.8);

    private  BigDecimal addItionalPrice = new BigDecimal(0.5);

    private  BigDecimal waitPrice = new BigDecimal(0.25);
    
    public static void main(String[] args) {
    	System.out.println(new TaxCalculation().valuationOne(10));
    	System.out.println(new TaxCalculation().valuationTwo(10));
    	System.out.println(new TaxCalculation().valuationThree(10));
    	System.out.println(new TaxCalculation().valuationFour(0));
	}
    
    public  Integer calAll(Integer distance, Integer minute) {
    	return valuation(valuationOne(distance).add(valuationTwo(distance)).add(valuationThree(distance)).add(valuationFour(minute)));
    }

    
    
    //最后计价的时候司机会四舍五入只收到元。
    public Integer valuation(BigDecimal price)
    {
    	return price.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }
    
    //不大于2公里时只收起步价6元。
    public BigDecimal valuationOne(Integer distance)
    {
    	if(distance <= minDistance)
    	{
    		return new BigDecimal("6");
    	}else
    	{
    		return new BigDecimal("0");
    	}
    }
    
    
    //超过2公里的部分每公里收取0.8元。
    public BigDecimal valuationTwo(Integer distance)
    {
    	if(distance > minDistance && distance <= midDistance)
    	{
    		BigDecimal minPrice = new BigDecimal("6");
    		BigDecimal midPrice = new BigDecimal(distance - minDistance).multiply(price);
    		return minPrice.add(midPrice);
    	}else 
    	{
    		return new BigDecimal("0");
    	}
    }
    
    //超过8公里的部分，每公里加收50%长途费。
    public BigDecimal valuationThree(Integer distance)
    {
    	if(distance > midDistance)
    	{
    		BigDecimal minPrice = new BigDecimal("6");
    		BigDecimal midPrice = new BigDecimal(midDistance - minDistance).multiply(price);
    		BigDecimal coefficient = new BigDecimal(1).add(addItionalPrice);
    		BigDecimal maxPrice = new BigDecimal(distance - midDistance).multiply(coefficient);
    		return minPrice.add(midPrice).add(maxPrice);
    	}else
    	{
    		return new BigDecimal("0");
    	}
    }
    
    //停车等待时加收每分钟0.25元。
    public BigDecimal valuationFour(Integer minute)
    {
    	return new BigDecimal(minute).multiply(waitPrice);
    }
    
    
    
}
