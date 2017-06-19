package test;

import java.io.IOException;

import org.testng.annotations.Test;

import testRunner.BaseRunner;

public class AutoIT_windowHandle extends BaseRunner {

	
	@Test
	public void handleAuoIT() throws InterruptedException, IOException
	{
	
		webdriverGenarics.navigateTo(driver, "http://toolsqa.com/automation-practice-form/");
		// click Upload Button
		webdriverGenarics.click(driver, "id", "photo");
		Thread.sleep(5000);
		// To call Autoit Exe file 
		Runtime.getRuntime().exec("C:\\Users\\Balamurugan\\Desktop\\MarchBatchAutoitTrial.exe");
		
		Thread.sleep(10000);
	}
}
