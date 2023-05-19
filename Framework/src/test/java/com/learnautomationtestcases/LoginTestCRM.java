package com.learnautomationtestcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomationpages.BaseClass;
import com.learnautomationpages.LoginPage;

public class LoginTestCRM extends BaseClass {
	
	@Test
	public void loginApp() throws InterruptedException, IOException {
		
		logger=report.createTest("Login to ActiTime");
	
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting application");
  
		login.loginActitime(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));
		logger.pass("Login Success");
	}
	
	@Test
	public void loginApp1() throws InterruptedException, IOException {
		
		logger=report.createTest("Logout");
		logger.fail("logout failed");
	}

}

