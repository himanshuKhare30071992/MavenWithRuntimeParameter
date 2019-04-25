package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamaterTest 
{
	WebDriver driver;
	String filePath = "C:/Users/HK-SONY/Selenium_Eclipse_Workspace/MavenWithRuntimeParameter/src/test/java/config/config.properties";
	String browserName;

	/*@BeforeTest(enabled=false)
	public void readProperties() throws Exception
	{
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		browserName = prop.getProperty("browser");
	}
	*/
	
	//NOTE: This browser parameter will taken from Maven at run time from user
	@Parameters({"browser", "application"})
	@BeforeClass	
	public void setUp(String browserName, String applicationUrl)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.get(applicationUrl);
		driver.quit();
	}
	

	@Test
	public void Test1()
	{
		for (int i = 0; i < 10; i++)
		{
			System.out.println(i+") === Maven Parameter Test Called ====");
		}
		
		
	}
	
	
	
}
