/**
 * 
 */
package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 */
public class RegistrationPage {
	WebDriver ldriver;
	
	String Mr,Mrs;
	
	public RegistrationPage(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(linkText="Sign in")
	WebElement SignInbtn;
	
	
	@FindBy(id="email_create")
	WebElement Email;
	
	@FindBy(id="SubmitCreate")
	WebElement subcreate;
	@FindBy(id="id_gender1")
	WebElement RadioMr;
	
	@FindBy(id="id_gender2")
	WebElement RadioMrs;
	
	@FindBy(id="customer_firstname")
	WebElement fname;
	
	@FindBy(id="customer_lastname")
	WebElement lname;
	
	
	@FindBy(id="passwd")
	WebElement pass;
	
	
	@FindBy(id="submitAccount")
	WebElement subbtn;
	
	@FindBy(id="days")
	WebElement day;
	@FindBy(id="months")
	WebElement month;
	@FindBy(id="years")
	WebElement year;
	
	//a[@class="logout"]
	@FindBy(xpath="//a[@class=\"logout\"]")
	WebElement signout;
	public void ClickSignIn() {
		SignInbtn.click();
	}
	
	public void Email(String el) {
		Email.sendKeys(el);
	}	
		public void submitcreate() {
			subcreate.click();
		}
		
	
	public void gender() {
			RadioMr.click();
	}
	
	public void Fname(String name) {
		fname.sendKeys(name);
	}
	
	public void Lname(String nameL) {
		lname.sendKeys(nameL);
	}
	public void Pass(String Pass) {
		pass.sendKeys(Pass);
	}
	
	public void Day(String dd) {
		Select sel=new Select(day);
		sel.selectByValue(dd);
	}
	public void month(String mm) {
		Select sel=new Select(month);
		sel.selectByValue(mm);
	}
	public void year(String yy) {
		Select sel=new Select(year);
		sel.selectByValue(yy);
	}
	
	public void SubmitBtn() {
		subbtn.click();
	}
	
	public void SignOut() {
		signout.click();
	}
	
	
}
