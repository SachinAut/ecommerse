package com.mystore.pageobject;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public static WebDriver driver;
	
	public static Logger logger;
	

	
	@BeforeClass
	public void setup() {
		
		
		logger=Logger.getLogger("e-Commerse project");
		PropertyConfigurator.configure("log4j.properties");
		
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("http://www.automationpractice.pl/index.php");
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	

}
