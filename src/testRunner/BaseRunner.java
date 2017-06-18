package testRunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import common.WebdriverGenarics;

public class BaseRunner
{

	public WebDriver driver =null;
	public WebdriverGenarics webdriverGenarics = new WebdriverGenarics();

	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite method called");	
	}
	
	@Parameters({"Browser"})
	@BeforeTest
	public void appLogin(String browser )
	{
	driver=webdriverGenarics.launchBrowser(driver, browser, "https://www.facebook.com/");
	System.out.println(driver);
	// username
	webdriverGenarics.enterText(driver, "Id", "email", "pradeepit16@gmail.com");
	
	
	//Password
	webdriverGenarics.enterText(driver, "Id", "pass", "janamanagana");
	
	//submit
	webdriverGenarics.click(driver, "xpath", "//input[@value='Log In']");
	
	
	}

	@AfterTest
	public void appQuit()
	{
		webdriverGenarics.close(driver);
	}


	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("Aftere Suite method called");	
	}
	
}
