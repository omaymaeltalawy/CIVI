package sf.steps.utils;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.WebElementFacade;


public class window{
	public static void scroll(WebDriver driver, WebElementFacade element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void setTargetLink(WebDriver driver, WebElementFacade element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element,"target","self");
	}
	
	public static String switchWindow(WebDriver driver) throws InterruptedException
	{
		String parentWindow = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		  
		set.remove(parentWindow);
		assert set.size() == 1;
		driver.switchTo().window((String) set.toArray()[0]);
		return parentWindow; 
		//close the window
		//driver.close();
		//driver.switchTo().window(base);
		 
		// handle windows change and switch back to the main window
		//Thread.sleep(2500);
		//for (String winHandle : driver.getWindowHandles()) {
		//	driver.switchTo().window(winHandle);
		//	}
	}
	
	public static void openNewWindow(WebDriver driver, String url)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("$(window.open(arguments[0]))", url);
		try {
			switchWindow(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
