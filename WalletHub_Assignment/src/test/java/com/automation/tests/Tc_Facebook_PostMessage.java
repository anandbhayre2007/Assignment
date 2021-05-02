package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.Driver;
import pages.facebook.FacebookHomePage;
import pages.facebook.FacebookLoginPage;

public class Tc_Facebook_PostMessage  extends Driver{

	FacebookLoginPage loginPage;
	FacebookHomePage homePage;
	
	@Test
	@Parameters({"userName","password"})
	public void postMessage(String userName, String password) throws InterruptedException
	{
		loginPage= new FacebookLoginPage(dr);
		
	    //login to application
	    loginPage.loginToFacebook(userName, password);

	    // go the next page
	    homePage = new FacebookHomePage(dr);

	    //Verify HomePage is displayed
	    Assert.assertTrue(homePage.isPostTextboxDisplayed(), "Home page is not displayed");
		
	    //Open post message box
	    homePage.openPostMessagePopup();
	    
	    //Post a message
	    String message="Automation Testing";
	    homePage.postMessage(message);
	    
	   //Post the message
	    homePage.clickPost();
	    
	    //Verify posted message is displayed
	    Assert.assertEquals(homePage.isMessageDisplayed(),message, "Posted message is not displayed");
		
	}
	
}
