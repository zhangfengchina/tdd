package com.jiker.keju;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public  class CalPrintTest {
	
	private CalPrint calPrint = new CalPrint();
	
	
	@Test
	public void testgetCalString() throws Exception{
		Assert.assertEquals("收费6元\r\n收费8元\r\n收费23元", calPrint.getCalString("src/main/resources/testData.txt"));
	}
	
	@Test
	public void testfileStringList() throws Exception{
		List ls = new ArrayList();
		ls.add("2公里,等待1分钟\r\n");
		ls.add("4公里,等待0分钟\r\n");
		ls.add("15公里,等待6分钟\r\n");
		Assert.assertEquals(ls, calPrint.fileStringList(new File("src/main/resources/testData.txt")));
	}
	
	@Test
	public void testgetNumberfromString() throws Exception{
		List<Integer> ls = new ArrayList();
		ls.add(2);
		ls.add(1);
		Assert.assertEquals(ls, calPrint.getNumberfromString("2公里,等待1分钟"));
	}
	
}
