package com.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Common.BaseClass;

public class TC_6 extends BaseClass
{
  @Test(description= "Validates Mini Statement with invalid_data_Account no is blank")
  public void TestCase6()
  {
	  WebElement AccountNo=driver.findElement(By.name("accountno"));
	  //WebElement SubmitBtn=driver.findElement(By.name("AccSubmit"));
	  
	  AccountNo.sendKeys("");
	  //SubmitBtn.click();
	  
	  String Actualmsg="Account Number must not be blank";
	  String Expectedmsg=driver.findElement(By.cssSelector("#message2")).getText();
	  
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
