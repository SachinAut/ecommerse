package com.mystore.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;


import com.mystore.pageobject.BaseClass;
import com.mystore.pageobject.RegistrationPage;

public class TC_Register_001 extends BaseClass {

	
	@Test
	public void registercust() throws InterruptedException {
		
		RegistrationPage rp=new RegistrationPage(driver);
		logger.info("Url is open");
		rp.ClickSignIn();
		logger.info("registration page  is open");
		rp.Email("sbichakule5236@gmail.com");
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
		rp.Pass("Sachin@1lonj23");
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
			System.out.println("Testcase passed");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("Testcase failed");
		}
	}
	
	
	
	
	
}
