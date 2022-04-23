package com.sdet.automationcoadingchallenge.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sdet.automationcoadingchallenge.base.BaseClass;
import com.sdet.automationcoadingchallenge.log.Log;
import com.sdet.automationcoadingchallenge.pageobjects.HomePage;
import com.sdet.automationcoadingchallenge.pageobjects.SamsungResultPage;
import com.sdet.automationcoadingchallenge.pageobjects.SelectedProductPage;
import com.sdet.automationcoadingchallenge.pageobjects.TelevisionPage;


public class ProductTest extends BaseClass{
	
	TelevisionPage televisionPageObj;
	SamsungResultPage samsungResultPageObj;
	SelectedProductPage selectedProductPageObj;
	

	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test
	public void homePageTest() throws Exception {
		Log.startTestCase("Verify HomePage - ");
		HomePage homepgObj = new HomePage();
		Log.info("Action methods are going to be executed");
		televisionPageObj = homepgObj.actionsMethodsInHomePage();
		samsungResultPageObj = televisionPageObj.samsungCheckBoxSelection();
		Log.info("Samsung check box have been clicked");
		selectedProductPageObj = samsungResultPageObj.getSecondLargestPricedProduct();
		Log.info("Second largest priced item has been selected");
		selectedProductPageObj.printAboutThisItem();
		Log.info("About this item text has been printed on the console");
		boolean result = selectedProductPageObj.verifyAboutThisItemElement();
		Assert.assertTrue(result);
		Log.endTestCase("Test Completed");
	}
	
}