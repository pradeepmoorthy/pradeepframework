package common;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class WebdriverGenarics 
{
	/*
	 * Created By bala
	 * */
	
	public WebDriver launchBrowser(WebDriver driver , String BrowserName, String URL)
	{
		switch (BrowserName.toUpperCase())
		{
		case "IE":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/ie.exe");
			driver= new InternetExplorerDriver();
			break;

		case "CHROME":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver= new ChromeDriver();
			break;

		case "FIREFOX":
			System.setProperty("webdriver.greko.driver", System.getProperty("user.dir")+"/drivers/greko.exe");
			driver= new FirefoxDriver();
			break;

		default:System.out.println("Please provide valid browser name");
		break;
		}

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;	
	}
	
	public WebElement getElement(WebDriver driver,String LocatorType, String LocatorValue)
	{
		WebElement element=null;
		switch (LocatorType.toUpperCase()) 
		{
		case "ID":element= driver.findElement(By.id(LocatorValue));
		break;
		case "NAME":element= driver.findElement(By.name(LocatorValue));
		break;

		case "CLASSNAME":element= driver.findElement(By.className(LocatorValue));
		break;

		case "XPATH":element= driver.findElement(By.xpath(LocatorValue));
		break;

		case "TAGNAME":element= driver.findElement(By.tagName(LocatorValue));
		break;

		case "LINKTEXT":element= driver.findElement(By.linkText(LocatorValue));
		break;
		case "PARTIALLINKTEXT":element= driver.findElement(By.partialLinkText(LocatorValue));
		break;
		case "CSS":element= driver.findElement(By.cssSelector(LocatorValue));
		break;
		}
		return element;

	}


	public void enterText(WebDriver driver, String LocatorType,String LocatorValue, String text)
	{
		try
		{
			WebElement element =getElement(driver, LocatorType, LocatorValue);
			element.clear();
			element.sendKeys(text);
			PrintUtils.logMessage("Text entered as ::"+text);

		} catch (ElementNotFoundException e)
		{
			PrintUtils.logError("enterText :: Exception occured with given Locator Type and Value::"+LocatorType+" and "+LocatorValue);
		}
	}

	public void click(WebDriver driver, String LocatorType,String LocatorValue)
	{
		try
		{
			WebElement element = getElement(driver, LocatorType, LocatorValue);
			element.click();
			PrintUtils.logMessage("Element clicked"+LocatorValue);

		} catch (ElementNotFoundException e)
		{
			PrintUtils.logError("click :: Exception occured element not clicked with given LocatorType and LocatorValue::"+LocatorType+" and "+LocatorValue);
		}
	}


	public void selectByValue(WebDriver driver,String LocatorType, String LocatorValue, String Value)
	{
		try{
			Select st = new Select(getElement(driver, LocatorType, LocatorValue));
			st.selectByValue(Value);
			PrintUtils.logMessage("Selected value is ::"+Value);
		} catch (Exception e)
		{
			PrintUtils.logError("selectByValue:: Exception occured with given locatorValue ::"+LocatorValue);
		}
	}
	
	public void selectByVisibleText(WebDriver driver,String LocatorType, String LocatorValue, String Value)
	{
		try{
			Select st = new Select(getElement(driver, LocatorType, LocatorValue));
			st.selectByVisibleText(Value);
			PrintUtils.logMessage("Selected value is ::"+Value);
		} catch (Exception e)
		{
			PrintUtils.logError("selectByVisibleText:: Exception occured with given locatorValue ::"+LocatorValue);
		}
	}
	
	public void selectByIndex(WebDriver driver,String LocatorType, String LocatorValue, int indexValue)
	{
		try{
			Select st = new Select(getElement(driver, LocatorType, LocatorValue));
			st.selectByIndex(indexValue);
			PrintUtils.logMessage("Selected value is ::"+indexValue);
		} catch (Exception e)
		{
			PrintUtils.logError("selectByIndex:: Exception occured with given locatorValue ::"+LocatorValue);
		}
	}

	public void frameByIndex(WebDriver driver , int indexValue)
	{
		driver.switchTo().frame(indexValue);
	}

	public void frameByNameOrID(WebDriver driver , String Value)
	{
		driver.switchTo().frame(Value);
	}
	
	public void frameByWebElement(WebDriver driver , WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void  defaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	public String getText(WebDriver driver , String LocatorType, String LocatorValue)
	{
		String value =null;
		WebElement element = getElement(driver, LocatorType, LocatorValue);
		value=element.getText();
		return value;	
	}
	
	public String getAttributeValue(WebDriver driver , String LocatorType, String LocatorValue, String AttributeName)
	{
		String value =null;
		WebElement element = getElement(driver, LocatorType, LocatorValue);
		value=element.getAttribute(AttributeName);
		return value;	
	}
	
	public String getCurrentURL(WebDriver driver)
	{
		String value =null;
		value=driver.getCurrentUrl();
		return value;	
	}
	
	public String getTitle(WebDriver driver)
	{
		String value =null;
		value=driver.getTitle();
		return value;	
	}
	public void close(WebDriver driver)
	{
		driver.close();
	}
	
	public void quit(WebDriver driver)
	{
		driver.quit();
	}
	

	public void refresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
	public void back(WebDriver driver)
	{
		driver.navigate().back();
	}
	public void forward(WebDriver driver)
	{
		driver.navigate().forward();
	}
	public void navigateTo(WebDriver driver, String URL)
	{
		driver.navigate().to(URL);
	}
	
	public boolean isDisplayed(WebDriver driver, String LocatorType, String LocatorValue)
	{
		boolean value =true;
		WebElement element = getElement(driver, LocatorType, LocatorValue);
		try
		{
		if(element.isDisplayed())
		{
			PrintUtils.logMessage("Element is displayed");
			value=true;
		} }
		catch(Exception e)
		{
			PrintUtils.logError("Element is not displayed::"+LocatorValue);
			value=false;
		}
		return value;
	}
	
	public boolean isEnabled(WebDriver driver, String LocatorType, String LocatorValue)
	{
		boolean value =true;
		WebElement element = getElement(driver, LocatorType, LocatorValue);
		if(element.isEnabled())
		{
			PrintUtils.logMessage("Element is Enabled");
			value=true;
		}
		else
		{
			PrintUtils.logError("Element is not enabled::"+LocatorValue);
			value=false;
		}
		return value;
	}
	
	public boolean isSelected(WebDriver driver, String LocatorType, String LocatorValue)
	{
		boolean value =true;
		WebElement element = getElement(driver, LocatorType, LocatorValue);
		if(element.isSelected())
		{
			PrintUtils.logMessage("Element is Selected");
			value=true;
		}
		else
		{
			PrintUtils.logError("Element is not Selected::"+LocatorValue);
			value=false;
		}
		return value;
	}
	
	public void doubleclick(WebDriver driver , String LocatorType, String LocatorValue)
	{
		Actions act = new Actions(driver);
		act.moveToElement(getElement(driver, LocatorType, LocatorValue)).doubleClick().build().perform();
	}
	
	public void moveToElementAndClick(WebDriver driver , String LocatorType, String LocatorValue)
	{
		Actions act = new Actions(driver);
		act.moveToElement(getElement(driver, LocatorType, LocatorValue)).click().build().perform();
	}
	
	public void rightClick(WebDriver driver , String LocatorType, String LocatorValue)
	{
		Actions act = new Actions(driver);
		act.moveToElement(getElement(driver, LocatorType, LocatorValue)).contextClick().build().perform();
	}
	
	public void takeScreenShot(WebDriver driver , String imageName) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// now copy the  screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/Screenshot/"+imageName+".png"));
	}
	
	public String getParentWindow(WebDriver driver)
	{
		String value =driver.getWindowHandle();
		return value;
	}
	
	public void switchToParentWindow(WebDriver driver, String parentWinSessionID)
	{
		driver.switchTo().window(parentWinSessionID);
	}
	
	public void switchToLastWindow(WebDriver driver)
	{
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows)
		{
		driver.switchTo().window(win);	
		}
	}
	
	public void closeChildWindows(WebDriver driver, String ParentWinSessionID)
	{
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows)
		{
		if(!ParentWinSessionID.equals(win))
		{
			driver.switchTo().window(win);
			driver.close();
		}
		}
	}
	
	public void setWindowSize(WebDriver driver, int width, int height)
	{
		driver.manage().window().setSize(new Dimension(width, height));
	}
	

	/*entertext = 8methods
	 * click =8 method
	 * framebyIndex
	 * framebyNameOrID
	 * frameByEelement
	 * acceptAlert
	 * dismissAlert
	 * enterTextAlert
	 * getTextAlert - string
	 * getText --string
	 * close
	 * quit
	 * refresh
	 * forward
	 * back
	 * screenshot(String imagename)
	 * moveToElementandClick
	 * rightclick
	 * doubleclick
	 * dragandDrop
	 * switchtoLastWindow
	 * getParentWindowSessionid =string
	 * selectByvalue
	 * SelectByindex
	 * SelectbyVisibleText
	 * isdisplayed = boolean
	 * isenable =boolean
	 * isselected= boolean
	 * 
	 * 
	 * */











}
