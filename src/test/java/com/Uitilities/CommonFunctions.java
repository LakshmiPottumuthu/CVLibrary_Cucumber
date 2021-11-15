package com.Uitilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	
	public WebDriver driver;
	public JavascriptExecutor executor ;
	public CommonFunctions(WebDriver rdriver)
    {
    	this.driver = rdriver;	    	
   	

    }

	public void Wait_Explicit_till_element_clickable(WebElement element,long timeOutInSeconds)
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver , timeOutInSeconds);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void javaScriptExecutorClick(WebElement element)
	{
		  executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", element);	
	}
	
	public void switchToFrame(WebElement frameId)
	{
		  driver.switchTo().frame(frameId);
	}
	
	public void switchToDefaultContent()
	{
		  driver.switchTo().defaultContent();
	}
	
}
