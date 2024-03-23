package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(linkText="Sign in")
	WebElement SignInbtn;
	
	@FindBy(id="email")
	WebElement Emailid;

	@FindBy(id="passwd")
	WebElement passward;
	
	@FindBy(id="SubmitLogin")
	WebElement sublogin;
	
	public void ClickSignIn() {
		SignInbtn.click();
	}
	
	public void EmailId(String emailid) {
		Emailid.sendKeys(emailid);
	}
	
	public void Upass(String pass) {
		passward.sendKeys(pass);
	}
	
	public void ClickLogin() {
		sublogin.click();
	}
	
	
}
