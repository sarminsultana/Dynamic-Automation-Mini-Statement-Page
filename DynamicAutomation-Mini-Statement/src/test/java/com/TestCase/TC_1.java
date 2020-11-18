package com.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Common.BaseClass;

public class TC_1 extends BaseClass{
	
  @Test(description= "Validates Mini Statement with Submit Button & valid_data")
  public void TestCase1() 
  {
	  WebElement AccountNo=driver.findElement(By.name("accountno"));
	  WebElement SubmitBtn=driver.findElement(By.name("AccSubmit"));
	  
	  AccountNo.sendKeys("87272");
	  SubmitBtn.click();
	  
	  String Expectedmsg="Last Five Transaction Details for Account No: 87272";
	  String Actualmsg=driver.findElement(By.cssSelector("body > table > tbody > tr:nth-child(1) > td > p")).getText();
	  
		if(Expectedmsg.contains(Actualmsg)) 
		{
			System.out.println("Test case passed");
		}
		
		else
		{
			System.out.println("Test case failed");
		}
	  
  }
}
