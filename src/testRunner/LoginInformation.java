package testRunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import common.PropertiesFile;
import common.WebdriverGenarics;

public class LoginInformation {
	
	public PropertiesFile PropObj = null;
	public WebDriver driver = null;
	public WebdriverGenarics webdriverGenarics = new WebdriverGenarics();
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before suite method called");
		PropObj = new PropertiesFile("ToolsStore.properties");
		
	}
	@Parameters({"Browser"})
	@BeforeTest
	public void WebLogin(String browser)
	{
		driver=webdriverGenarics.launchBrowser(driver, browser, PropObj.getProp("URL") );
	}
	
	
	//public void 
}
