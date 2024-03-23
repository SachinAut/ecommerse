/**
 * 
 */
package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.BaseClass;
import com.mystore.pageobject.LoginPage;
import com.mystore.utility.XLUtils;

/**
 * 
 */
public class TC_LoginCust_002 extends BaseClass {
	WebDriver driver;
	@Test(dataProvider="LoginData")
	public void LoginCust(String email,String pass) throws InterruptedException {
		logger.info("Homepage open");
		LoginPage lp=new LoginPage(driver);
		
		lp.ClickSignIn();
		Thread.sleep(3000);
		logger.info("Click on Sign_in");
		lp.EmailId(email);
		logger.info("Entered Mail_Id");
		lp.Upass(pass);
		logger.info("Entered Passward");
		lp.ClickLogin();
		Thread.sleep(3000);
		
		Boolean result=driver.getPageSource().contains("");
		
		
	}

	@DataProvider(name="loginData")
	String [][]getData()throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/mystore/testcases/Sachin.xlsx";
		int rowCount=XLUtils.getRowCount(path, "Sheet1");
		int cellCount=XLUtils.getCellCount(path,"Sheet1", 1);
		String loginData [][]=new String [rowCount][cellCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++) {
				
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		
		return loginData;
		
	}
	
	
	
	
	
	
	
	
}
