package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Uitilities.CommonFunctions;

public class HomePage {
	
   WebDriver ldriver;
   CommonFunctions commonFunctions;
    
	public HomePage(WebDriver rdriver)
    {
    	ldriver = rdriver;	    	
    	PageFactory.initElements(ldriver, this);   	
    	commonFunctions = new CommonFunctions(ldriver);
    }
	
	@FindBy(id = "gdpr-consent-notice")
    WebElement FrameId;
	
	@FindBy(xpath = "//span[text()='Accept All']")
    WebElement AcceptAllButtonLocator;
	
	@FindBy(id = "toggle-hp-search")
    WebElement MoreSearchOptionButtonLocator;
	
	@FindBy(id = "keywords")
    WebElement KeyWordSearchBoxLocator;
	
	@FindBy(id = "location")
    WebElement LocationSearchBoxLocator;
	
	@FindBy(id = "distance")
    WebElement DisanceDropDownLocator;
	
	@FindBy(id = "salarymin")
    WebElement SalaryMinSearchBoxLocator;
	
	@FindBy(id = "salarymax")
    WebElement SalaryMaxSearchBoxLocator;
	
	@FindBy(id = "salarytype")
    WebElement SalaryTypeDropDownLocator;
	
	@FindBy(id = "tempperm")
    WebElement JobTypeDropDownLocator;
	
	@FindBy(id = "hp-search-btn")
    WebElement FindJobsButtonLocator;
	
	@FindBy(xpath = "//div[@class='search-header__title']/h1")
    WebElement SearchResultPageHeader;
	
	public void launchApplication(String url)
	{
		ldriver.get(url);
	}
	public String getTitleOfPage()
	{
		return ldriver.getTitle();
	}
	
	public void clickOnMoreSearchOptionButton() throws InterruptedException
	{
		
		commonFunctions.Wait_Explicit_till_element_clickable(FrameId , 100);
		commonFunctions.switchToFrame(FrameId);
		commonFunctions.javaScriptExecutorClick(AcceptAllButtonLocator);
		Thread.sleep(3000);
        commonFunctions.switchToDefaultContent();
        commonFunctions.Wait_Explicit_till_element_clickable(MoreSearchOptionButtonLocator , 60);
        MoreSearchOptionButtonLocator.click();
        commonFunctions.Wait_Explicit_till_element_clickable(JobTypeDropDownLocator , 60);
        
	}
	public void enterKeyWords(String keyWord) 
	{
		KeyWordSearchBoxLocator.sendKeys(keyWord);
	}
	
	public void enterLocation(String location)
	{
		LocationSearchBoxLocator.sendKeys(location);
	}
	
	public void selectDistance(String distance)
	{
		Select distancedd = new Select(DisanceDropDownLocator);
		distancedd.selectByVisibleText(distance);		
	}
	
	public void enterMinimumSalary(String minSalary)
	{
		SalaryMinSearchBoxLocator.sendKeys(minSalary);
	}
	
	public void enterMaximumSalary(String maxSalary)
	{
		SalaryMaxSearchBoxLocator.sendKeys(maxSalary);
	}
	
	public void selectSalaryType(String salaryType)
	{
		Select salaryTypedd = new Select(SalaryTypeDropDownLocator);
		salaryTypedd.selectByVisibleText(salaryType);		
	}
	
	public void selectJobType(String jobType)
	{
		Select jobTypedd = new Select(JobTypeDropDownLocator);
		jobTypedd.selectByVisibleText(jobType);		
	}
		
	public void clickOnFindJobs()
	{
		FindJobsButtonLocator.click();
	}
	
	public String verifySearchResults()
	{
		commonFunctions.Wait_Explicit_till_element_clickable(SearchResultPageHeader, 60);
		return  SearchResultPageHeader.getText();
		
	}
	

}
