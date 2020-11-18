package com.TestCase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Common.BaseClass;

public class TC_3 extends BaseClass 
{
  @Test(description= "Validates Mini Statement with Submit Button & invalid_data_Account no with special characters")
  public void TestCase3() 
  {
	  WebElement AccountNo=driver.findElement(By.name("accountno"));
	  WebElement SubmitBtn=driver.findElement(By.name("AccSubmit"));
	  
	  AccountNo.sendKeys("&*");
	  SubmitBtn.click();
	  

	  Alert alt=driver.switchTo().alert();
	  
	  String expectedAlert="Please fill all fields";
	  String alertmsg=alt.getText();
	  
	  if(expectedAlert.contains(alertmsg))
	  {
		  System.out.println("Test case passed");
	  }
	  
	  else
	  {
		  System.out.println("Test case failed");
	  }
	  
	  
  }
}
