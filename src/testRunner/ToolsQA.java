package testRunner;

import org.testng.annotations.BeforeClass;

import common.PropertiesFile;

public class ToolsQA extends LoginInformation
{	
	PropertiesFile prop= null;
	@BeforeClass
	public void beforeClass()
	{
		prop= new PropertiesFile("Logindetails.properties");
	}
	
	public void login()
	
	{
		webdriverGenarics.
	}
}
