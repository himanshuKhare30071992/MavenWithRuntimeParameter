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
	
	
	@BeforeTest(enabled=false)
	public void readProperties() throws Exception
	{
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		browserName = prop.getProperty("browser");
	}
	
	
	
	@Parameters("browser")
	@BeforeClass	
	public void setUp(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.quit();
	}
	

	@Test
	public void Test1()
	{
		System.out.println("===Maven Parameter Test Called====");
		System.out.println("===Maven Parameter Test Called====");
		System.out.println("===Maven Parameter Test Called====");
		System.out.println("===Maven Parameter Test Called====");
		System.out.println("===Maven Parameter Test Called====");
		System.out.println("===Maven Parameter Test Called====");
	}
	
	
	
}
