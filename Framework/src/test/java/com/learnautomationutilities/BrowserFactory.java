package com.learnautomationutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		// TODO Auto-generated method stub
		
		if(browserName.equals("chrome"))
		{
			System.out.println("======Entered chrome browser loop========");
		//	System.setProperty("WebDriver.Chrome.driver", "/Users/sureshbabu/Downloads/chromedriver_mac64/chromedriver.exe");
            System.setProperty("WebDriver.Chrome.driver", "./Drivers/chromedriver.exe");

			driver= new ChromeDriver();
		}
		else if(browserName.equals("Firefox")) 
		{
		//	System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browserName.equals("IE")) 
		{
		//	System.setProperty("webdriver.ie.driver", "./IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We don not support this browser");
		}
		
	//	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		System.out.println("Title = " + driver.getTitle()); 
	//	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		return driver; 
 	}
	
 
	public static void quitBrowser(WebDriver driver)
	{
		driver.close();
	}

}


