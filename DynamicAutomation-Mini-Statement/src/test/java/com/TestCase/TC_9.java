package com.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Common.BaseClass;

public class TC_9 extends BaseClass
{
  @Test(description= "Validates Mini Statement with Reset button")
  public void TestCase9()
  {
	  WebElement AccountNo=driver.findElement(By.name("accountno"));
	  WebElement resetBtn=driver.findElement(By.name("res"));
	  
	  AccountNo.sendKeys("87272");
	  resetBtn.click();
	  
	  String Actualmsg="System displays blank inputs";
	  String Expectedmsg=driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(11) > td:nth-child(2) > input[type=reset]:nth-child(2)")).getText();
	  
		if(Actualmsg.contains(Expectedmsg)) 
		{
			System.out.println("Test case passed");
		}
		
		else
		{
			System.out.println("Test case failed");
		}
	  
	  
	  
	  
  }
}
