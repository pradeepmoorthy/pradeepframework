package testRunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import common.PropertiesFile;
import common.WebdriverGenarics;

public class BaseRunner
{

	public WebDriver driver =null;
	public WebdriverGenarics webdriverGenarics = new WebdriverGenarics();
	public PropertiesFile PropObj= null;
	public SoftAssert sa = null;
	public String CurrentURL =null;

	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite method called");	
		PropObj= new PropertiesFile("Application.properties");
	}

	@Parameters({"Browser"})
	@BeforeTest
	public void appLogin(String browser )
	{
		driver=webdriverGenarics.launchBrowser(driver, browser, PropObj.getProp("Application.URL"));

		// username
		webdriverGenarics.enterText(driver, "Id", "email", PropObj.getProp("App.userName"));
		//Password
		webdriverGenarics.enterText(driver, "Id", "pass", PropObj.getProp("App.password"));
		//submit
		webdriverGenarics.click(driver, "xpath", "//input[@value='Log In']");
		
		CurrentURL=webdriverGenarics.getCurrentURL(driver);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		sa= new SoftAssert();
	}

	@AfterMethod
	public void afterMethod()
	{
		webdriverGenarics.navigateTo(driver, CurrentURL);
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
