package com.StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseClass {
	
	String fileName = "config.properties";
	String location = null;
	String keyWord = null;
	String typeOfJob = null;
	@Before()
	public void launchBrowser() throws IOException
	{
		 FileInputStream fis = null;
	     Properties prop = null;		
		try 
		{
			 fis = new FileInputStream(fileName);
			 prop = new Properties();
	         prop.load(fis);
	    } 
		catch(FileNotFoundException fnfe)
		{
	         fnfe.printStackTrace();
	    } 
	    finally 
	    {
	         fis.close();
	      }
		
		String browserName = prop.getProperty("browserName");
		
		if(browserName.toLowerCase().trim().equalsIgnoreCase("Chrome".trim()))
		   {
			   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+prop.getProperty("chromeDriverPath"));
			   driver = new ChromeDriver();
			   driver.manage().window().maximize();
		   }
		   else if(browserName.toLowerCase().trim().equalsIgnoreCase("Firefox".trim()))
		   {
			   System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+prop.getProperty("firefoxDriverPath"));
			   driver = new FirefoxDriver();
			   driver.manage().window().maximize();
		   }
		   else if(browserName.toLowerCase().trim().equalsIgnoreCase("IE".trim()))
		   {
			   System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+prop.getProperty("ieDriverPath"));
			   driver = new InternetExplorerDriver();
			   driver.manage().window().maximize();
		   }
		
	}
	
	@When("Navigate to home page using {string}")
	public void navigate_to_home_page_using(String url) {
		homePage = new HomePage(driver);
		homePage.launchApplication(url);

	}
	
	@Then("Verify the title of Page is {string}")
	public void verify_the_title_of_page_is(String expectedTitle) {
		String actualTitle = homePage.getTitleOfPage(); 	
		Assert.assertTrue(actualTitle.trim().equals(expectedTitle.trim()));
	}
	
	@When("I Click on More Search Option button on Home Page")
	public void i_click_on_more_search_option_button_on_home_page()  throws InterruptedException{
		homePage.clickOnMoreSearchOptionButton();
	}
	
	@Then("Enter the {string} in Keywords ,Job Title and Job Ref Search Box")
	public void enter_the_in_keywords_job_title_job_ref_search_box(String keyWordText) {
		keyWord = keyWordText;
		homePage.enterKeyWords(keyWordText);
	}
	

	@Then("Enter the {string} in Location Search Box")
	public void enter_the_in_location_search_box(String locationText) {
		 location = locationText;
		 homePage.enterLocation(locationText);
	}
	
	@Given("Select {string} from Distance DropDown")
	public void select_from_distance_drop_down(String dropDownText) {
	       homePage.selectDistance(dropDownText);
	}

	@Then("Enter {string} in Salary Min SearchBox")
	public void enter_in_salary_min_search_box(String minSalary) {
		homePage.enterMinimumSalary(minSalary);
	}
	@Then("Enter {string} in Salary Max SearchBox")
	public void enter_in_salary_max_search_box(String maxSalary) {
		homePage.enterMaximumSalary(maxSalary);
	}
	@Then("Select {string} from Salary Type DropDown")
	public void select_from_salary_type_drop_down(String salaryType) {
		homePage.selectSalaryType(salaryType);
	}
	@Then("Select {string} from Job Type DropDown")
	public void select_from_job_type_drop_down(String jobType) {
		typeOfJob = jobType;
		homePage.selectJobType(jobType);
	}
	@When("I Click on Find Jobs Button")
	public void i_click_on_find_jobs_button() {
		homePage.clickOnFindJobs();
	}
	@Then("Verify The Search Results Page Header")
	public void verify_the_search_results() {
		
		String actualSearchResultsHeaderText = homePage.verifySearchResults();	
		if(!typeOfJob.isEmpty() && 
			!keyWord.isEmpty() &&
			!location.isEmpty())
		{
			Assert.assertTrue(actualSearchResultsHeaderText.trim().equals((typeOfJob + " " + keyWord + " jobs in " + location).trim()));
		}
		else if(!keyWord.isEmpty() &&
				!location.isEmpty())
		{
			Assert.assertTrue(actualSearchResultsHeaderText.trim().equals((keyWord + " jobs in " + location).trim()));
		}
		
		else if(!location.isEmpty())
		{
			Assert.assertTrue(actualSearchResultsHeaderText.trim().equals((" jobs in " + location).trim()));
		}
		else if(typeOfJob.isEmpty() && 
				keyWord.isEmpty() &&
				location.isEmpty())
		{
				Assert.assertTrue(actualSearchResultsHeaderText.trim().equals("All jobs and vacancies".trim()));
		}
				

	}

	@After()
	public void closeBrowser()
	{
		driver.quit();
	}

}
