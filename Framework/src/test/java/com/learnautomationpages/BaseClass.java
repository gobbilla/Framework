package com.learnautomationpages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomationutilities.BrowserFactory;
import com.learnautomationutilities.ConfigDataProvider;
import com.learnautomationutilities.ExcelDataProvider;
import com.learnautomationutilities.Helper;

public class BaseClass {
	
	public static WebDriver driver;
	public static ExcelDataProvider excel;
	public static ConfigDataProvider config;
	public ExtentReports report; 
	public ExtentTest logger; 
	
	@BeforeSuite
	public void setUpSuite() throws IOException
	{  
		Reporter.log("Before Suite - Setting up reports and Test is getting ready", true );
		
		excel = new ExcelDataProvider();
		config =new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ActiTime"+Helper.getCurrentDateTime()+".html"));
		
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Before Suite - Setting done test can be started", true );
	}
	
	@BeforeClass
	public void setUp() throws InterruptedException
	{      
		    Reporter.log("Before Class - trying to start browser and getting application ready", true );
			driver=BrowserFactory.startApplication(driver, config.getBrowser(),config.getStagingURL());
			Thread.sleep(5000);	
		    Reporter.log("Before Class - Browser and application is up and running", true );
	}
	

	@AfterClass
	public void tearDown()
	{
		System.out.println("=====Running After calss ==========");
		BrowserFactory.quitBrowser(driver);  
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
	    Reporter.log("AfterMethod - Test is about to end", true );


		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("fail", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
	    Reporter.log("AfterMethod - Test Completed >> Reports Generated", true );

	}

}




