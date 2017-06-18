package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.PrintUtils;
import testRunner.BaseRunner;

public class HomePageTestcase extends BaseRunner 

{

	@Test
	public void verifyHomePageTitle()
	{
		//PrintUtils.logMessage("Inside ForgetPassword testcase");
		//webdriverGenarics.click(driver, "id","12344");
		System.out.println(webdriverGenarics.getTitle(driver));
		if(webdriverGenarics.getTitle(driver).equals("Facebook"))

			//	  if(10==12)
				  {
					  PrintUtils.logMessage("testcase Passed");
				  }else
				  {
					  PrintUtils.logError("Testcase failed");
					  Assert.fail();
				  }

			PrintUtils.logMessage("Testcase ends");

	}
	
	@Test(enabled=false)
	public void verifyFriendPageTitle()
	{
		PrintUtils.logMessage("Inside verifyFriendPageTitle testcase");
		
		if(webdriverGenarics.getTitle(driver).equals("forgetLinke"))

			//	  if(10==12)
				  {
					  PrintUtils.logMessage("testcase Passed");
				  }else
				  {
					  PrintUtils.logError("Testcase failed");
					  Assert.fail();
				  }

			PrintUtils.logMessage("Testcase ends");

	}
	
	/**
	 * @throws InterruptedException 
	 * 
	 */
	@Test
	public void verifySearchFunctionality() throws InterruptedException
	{
	
	      webdriverGenarics.enterText(driver, "xpath", "//input[@class='_1frb']", "selenium");
	      webdriverGenarics.click(driver, "xpath", "(//button[@type='submit'])[1]");
	      
	      //click see all
	      
	      webdriverGenarics.click(driver, "xpath", "(//div[@class='_5dw9 _5dwa _4-u3']/span[2]/a)[1]");
	      
	      // list of webelements
	      List<WebElement> lists = driver.findElements(By.xpath("//div[@class='_52eh _5bcu']"));
	      System.out.println(lists.size());
	      for (WebElement Element : lists) 
	      {
	    	  String ActualValue=Element.getText();
	    	  if(ActualValue.equals("Share Selenium"))
	    	  {
	    		  Element.click();
	    		  break;
	    	  }
		}
	      
	      webdriverGenarics.click(driver, "xpath", "(//div[@class='_4bl9'])[9]");
	      
	      webdriverGenarics.click(driver, "classname", "_50f4");
	      
	      //webdriverGenarics.switchToParentWindow(driver, "Parentwindow");
	      //System.out.println("Parentwindow");
	      //Thread.sleep(1000);
	      //webdriverGenarics.moveToElementAndClick(driver, "xpath", "//a[text()='Selenium Webdriver']");
	      
	      String Title=webdriverGenarics.getTitle(driver);
	      
	      if(Title.equals("Share Selenium - Home"))
	      {
	    	  System.out.println("Title is :" + Title);
	    	webdriverGenarics.back(driver);
	      }
	}
	
	
	
	
}