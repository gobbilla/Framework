package com.learnautomationutilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	// Screenshots, alerts, frames, windows, sync issue, javascript executor 
	public static String captureScreenshot(WebDriver driver) throws IOException
	{
		File srcc= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir")+"/Screenshots/ActiTime"+Helper.getCurrentDateTime()+".png";

		try
		{
	   FileHandler.copy(srcc, new File(screenshotpath));	
		}
		catch(IOException e)
		{
			System.out.println("Unable to print screenshot" + e.getMessage());
		}
		return screenshotpath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customerFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		Date currentDate = new Date();
		return customerFormat.format(currentDate);
	}
}





