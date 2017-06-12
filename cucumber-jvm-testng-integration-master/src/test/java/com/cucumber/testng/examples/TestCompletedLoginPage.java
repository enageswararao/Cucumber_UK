package com.cucumber.testng.examples;

import junit.framework.Assert;
 

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCompletedLoginPage {
	
	WebConnector  selenium=new WebConnector();
 
	@Given("I go to \"([^\"]*)\" and with \"([^\"]*)\"")
	public void I_go_to_url_and_with_chrome(String url,String browser ){
		
		System.out.println("I go to url and with chrome.....");
		selenium.openBrowser(browser);
		selenium.navigateURL(url);
	//	selenium.takeScreenShot("");
		
	}

	@When("I enter \"([^\"]*)\" in the \"([^\"]*)\"")
	public void I_enter(String username,String txtbox ){
		
		System.out.println("I enter username......."+username + "---"+txtbox);
		
		selenium.enterText(txtbox, username);
	//	selenium.takeScreenShot("");

	}
	
	 
	
	@And("I click on \"([^\"]*)\" button")
	public void I_click_on_login_button(String locator){
		
		System.out.println("I click on login button......");
		
		selenium.click(locator);
	}
	
	@Then("I validate \"([^\"]*)\" the Logged successful")
	public void I_validate_the_Logged_successful(String viewallorder){
		
		System.out.println("I validate the Logged successful.....");
		boolean actualresult=selenium.isElementPresent(viewallorder);
		
		//Junit
		Assert.assertTrue(actualresult);
		
	}
	
	@Then("I verified \"([^\"]*)\" is displayed")
	 public void I_verified_message(String errormessage){
	  System.out.println("I verified " + errormessage);
	 selenium.verifyText2(errormessage);
	 Assert.assertTrue(selenium.verifyText2(errormessage));
	}
	@Then("I verified \"([^\"]*)\" page title")
	public void verifypageTitle(String exppageTitle){
		
	   Assert.assertEquals(exppageTitle, selenium.getTitle());	
	}
	
	@And("I close Browser")
	public void closeBr( ){
		
		  selenium.closeBr();
		}
	
}
