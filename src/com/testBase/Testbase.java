package com.testBase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class Testbase {
	
	public static FileInputStream fip;
	public static Properties prop;
	public static String Browser;
	public static WebDriver driver;
	public static  SoftAssert st;
	public static int tc=0;
	@BeforeSuite
	
	
	
	public static void OpenBrowser() throws Throwable {
		st=new SoftAssert();
		fip=new FileInputStream("./src/com/config/Or.Properties");
		
		prop=new Properties();
		prop.load(fip);
		Browser=prop.getProperty("Browser");
		if(Browser.equalsIgnoreCase("chrome")) {
            System.setProperty("ChromeDriver", "chromedriver.exe");
       driver = new ChromeDriver();
       }else if(Browser.equalsIgnoreCase("ie")) {
            System.setProperty("InternetExplorerDriver", "IEDriverServer.exe");
       driver = new InternetExplorerDriver();
       }else if(Browser.equalsIgnoreCase("mozilla")) {
            System.setProperty("FirefoxDriver","geckodriver.exe");
        driver = new FirefoxDriver();
       }
       driver.get("http://newtours.demoaut.com");//open url
       driver.manage().window().maximize();//maximize browser
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterSuite
	   public static void CloseBrowser() {
		   driver.quit();
		
	}
	
	   public static void assertall() {
		   st.assertAll();
	   }
	

}
