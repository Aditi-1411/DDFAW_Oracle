package com.library;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.testBase.Testbase;

//library where we have wrote user defined  functions, created for clicking on register, contactinfo, userinfo, submit button

public class Library extends Testbase {
	
	public static void clickonregister() {
		driver.findElement(By.xpath(prop.getProperty("Register"))).click();
		
	}
	
	public static void contactinfo(String Fn,String ln,String p,String email) {
		driver.findElement(By.xpath(prop.getProperty("Fname"))).sendKeys(Fn);
		driver.findElement(By.xpath(prop.getProperty("Lname"))).sendKeys(ln);
		driver.findElement(By.xpath(prop.getProperty("phone"))).sendKeys(p);
		driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(email);
	}
	
	public static void userinfo(String email1,String pwd, String cpwd) {
		
		driver.findElement(By.xpath(prop.getProperty("uname"))).sendKeys(email1);
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(pwd);
		driver.findElement(By.xpath(prop.getProperty("cpassword"))).sendKeys(cpwd);
	}
	
	     public static void Submit() {
		driver.findElement(By.xpath(prop.getProperty("submit"))).click();
	}
	     
	     public static void verifysuccemssage(String name) throws Throwable {
	    	 
	    	 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileHandler.copy(srcFile,new File(".\\src\\com\\screenshots\\Test"+(tc=tc+1)+".png"));
	    	 
	    	 
	    	String text= driver.findElement(By.xpath(prop.getProperty("sucessmsg"))).getText();
	    	st.assertEquals(text.contains(name), true);
	    	
	    	 
	     }
	
	
	
	
	
	
	

}
