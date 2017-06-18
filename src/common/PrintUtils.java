package common;

import org.testng.Reporter;

public class PrintUtils
{

	public static void logMessage(String value)
	{
		System.out.println(value);
		Reporter.log(value);
	}
	

	public static void logError(String value)
	{
		System.err.println(value);
		Reporter.log(value);
	}
}
