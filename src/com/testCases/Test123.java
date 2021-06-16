package com.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.library.Library;

import xls.ShineXlsReader;

public class Test123 extends Library {
	@Test(dataProvider="getdata")
	public void tetscase123(String Fn, String ln,String p,String email,String email1, String pwd) throws Throwable {
		
		clickonregister();
		contactinfo(Fn, ln, p, email);
		userinfo(email1, pwd, pwd);
		Submit();
		verifysuccemssage(Fn);
		assertall();
			
		
	}
	@DataProvider
	public Object[][] getdata(){
		ShineXlsReader xls = new ShineXlsReader("./src/com/excelFiles/Datapool.xlsx");
		int rcount=xls.getRowCount("Register");
		int ccount=xls.getColumnCount("Register");
		Object obj[][]=new Object[rcount-1][ccount];
		
		for(int i=2;i<=rcount;i++) {
			for(int j=0;j<ccount;j++) {
				obj[i-2][j]=xls.getCellData("Register", j, i);
			}
		}
		return obj;
		
		
	}
	

}
