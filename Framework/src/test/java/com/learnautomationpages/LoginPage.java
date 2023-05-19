package com.learnautomationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver; 

	public LoginPage(WebDriver driver)
	{
		 this.driver=driver;
	}
	
    public void loginActitime(String username, String userpwd) throws InterruptedException
    {
    	WebElement uname= driver.findElement(By.xpath("//input[@name='username']"));
    	WebElement pass =driver.findElement(By.xpath("//input[@name='pwd']"));
    	WebElement login= driver.findElement(By.xpath("//a[@id='loginButton']"));
    	
    	uname.sendKeys(username);
    	Thread.sleep(5000);
    	pass.sendKeys(userpwd);
    	Thread.sleep(5000);
       	login.click();
       	System.out.println("=======Everything is successfull======");
    }
}
