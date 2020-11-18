package com.Common;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void browser_Config(String br) throws IOException
	{
		
		if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}

	
	@Test(description="login goes to manager pager")
	public void login()
	{
		driver.get("http://demo.guru99.com/V4/");
		
		WebElement UserID=driver.findElement(By.name("uid"));
		WebElement Password=driver.findElement(By.name("password"));
		WebElement LoginBtn=driver.findElement(By.name("btnLogin"));
		
		UserID.sendKeys("mngr294817");
		Password.sendKeys("ybajAqe");
		LoginBtn.click();
		
		String Expectedmsg="Manger Id : mngr294817";
		

		String Actualmsg=driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr.heading3 > td")).getText();
		if(Expectedmsg.contains(Actualmsg)) 
		{
			System.out.println("Login success");
		}
		
		else
		{
			System.out.println("Test case failed");
		}
		
		 driver.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li:nth-child(13) > a")).click();
		
		
	}	

}
