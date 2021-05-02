package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import driver.Driver;
import pages.wallethub.WallethubHomePage;
import pages.wallethub.WallethubReviewPage;

public class Tc_Wallethub_Review extends Driver{

	WallethubHomePage homePage;
	WallethubReviewPage reviewPage;
	@Test
	public void writeYourReview() 
	{
		homePage=new WallethubHomePage(dr);
		
		//Hover over all the stars
		homePage.hoverMouseCursorOverAllTheStars();
		
		//Click on 4th star
		homePage.clickStar(4);
		
		//Verify submit review page is displayed
		reviewPage=new WallethubReviewPage(dr);
		
		Assert.assertTrue(reviewPage.isReviewPageDisplayed(), "Submit Review page is not displayed");
		
		//Select policy
		reviewPage.selectPolicy("Health Insurance");
		
		//write your review
		reviewPage.writeYourReview(200);
		
		reviewPage.clickSubmit();
	}
}
