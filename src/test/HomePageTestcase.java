package test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import common.PrintUtils;
import common.PropertiesFile;
import testRunner.BaseRunner;


public class HomePageTestcase extends BaseRunner 

{	
	PropertiesFile prop= null;
	@BeforeClass
	public void beforeClass()
	{
		prop= new PropertiesFile("HomePage.properties");
	}
	
	@Test(enabled=true, priority=1)
	public void verifyHomePageTitle()
	{
		PrintUtils.logMessage("To verify Home page");
		//click Profile Link
		webdriverGenarics.click(driver, "xpath", prop.getProp("HomeLink"));
		
		//Validation
		String currentURL = webdriverGenarics.getCurrentURL(driver);
		if(currentURL.contains("https://www.facebook.com/"))
		{
			PrintUtils.logMessage("Home page Navigated successfully");
			sa.assertTrue(true);
		}else
		{
			PrintUtils.logError("Home Page not navigated sussfully");
			sa.assertFalse(false);
		}
		
		// End testcase
		sa.assertAll();
	}
	
	@Test(enabled=false, priority=2)
	public void verifyLogoutFunctionality()
	{
		PrintUtils.logMessage("To verify Logout functionality");
		
		webdriverGenarics.click(driver, "id",prop.getProp("LogoutNavigationLink"));
		
		webdriverGenarics.moveToElementAndClick(driver, "", prop.getProp("Logout"));
		
		//Validation
		String pageTitle = webdriverGenarics.getParentWindow(driver);
		if(pageTitle.equals("LoginPage"))
		{
			PrintUtils.logMessage("Login page title  mached");
			sa.assertTrue(true);
		}else
		{
			PrintUtils.logError("Login page title not mached");
			sa.assertFalse(false);
		}
		
		// End testcase
		sa.assertAll();
	}
}
