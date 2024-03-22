package com.mystore.utility;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting  implements  ITestListener{
	
	
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	

public void onStart(ITestContext testContext) {
	
	String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String repName="Test_report_"+timestamp+".html";
	
	htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
	
	reports=new ExtentReports();
	reports.attachReporter(htmlReporter);
	
	//add report info/environment info on reports
    reports.setSystemInfo("Machine", "PC1");
    reports.setSystemInfo("user", "Sachin");
    reports.setSystemInfo("Environment", "QA");

    
    //configuration to change look and feel
    htmlReporter.config().setDocumentTitle("Extent report demo");
    htmlReporter.config().setReportName("Data driven test cases");
    htmlReporter.config().setTheme(Theme.DARK);
	System.out.println("onstart");

	
}
	public void onTestSuccess(ITestResult tr) {
	
		test=reports.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	

	}
	public void onTestFailure(ITestResult tr) {
		
		test=reports.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		test.fail(tr.getThrowable());

		
		String Screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f=new File(Screenshotpath);
		 if(f.exists()) 
		 {test.fail("ScreenShot is Below:"+test.addScreenCaptureFromPath(Screenshotpath));
		
		}

	}
	public void onTestSkipped(ITestResult tr) {
		test=reports.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		

}
	
	public void onFinish(ITestContext testContex) {
		
		reports.flush();

		
	}



}
