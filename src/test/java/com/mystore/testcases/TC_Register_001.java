package com.mystore.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.mystore.pageobject.BaseClass;
import com.mystore.pageobject.RegistrationPage;
import com.mystore.utility.XLUtils;

public class TC_Register_001 extends BaseClass {

	
	@Test(dataProvider="loginData")
	public void registercust(String email,String pass) throws InterruptedException {
		
		RegistrationPage rp=new RegistrationPage(driver);
		logger.info("Url is open");
		rp.ClickSignIn();
		logger.info("registration page  is open");
		rp.Email(email);
		logger.info("entered mail id");
		rp.submitcreate();
		logger.info("click on submit");
		Thread.sleep(3000);
		
		rp.gender();
		logger.info("Gender selected");
		Thread.sleep(3000);
		rp.Fname("Slkolpij");
		logger.info("fname entered");
		Thread.sleep(3000);
		rp.Lname("Bjuhiuee");
		logger.info("Lname entered");
		Thread.sleep(3000);
		rp.Pass(pass);
		logger.info("passward entered");
		Thread.sleep(3000);
		rp.Day("25");
		logger.info("birth day select");
		Thread.sleep(3000);
		rp.month("3");
		logger.info("birth month select");
		Thread.sleep(3000);
		rp.year("2022");
		logger.info("Birth year select");
		Thread.sleep(3000);
		rp.SubmitBtn();
		logger.info("click on submit");
		Thread.sleep(3000);
		
		logger.info("my account page open");
		Boolean result=driver.getPageSource().contains("Your account has been created.");
		if(result==true) {
			Assert.assertTrue(true);
			
			System.out.println(email+pass +"is valid and account created");
			
			rp.SignOut();
			logger.info("sign out ");
			Thread.sleep(3000);
		}
		else {
			Assert.assertTrue(false);
			System.out.println(email+pass +"is valid and account created");
			rp.SignOut();
			logger.info("sign out ");
		}
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
