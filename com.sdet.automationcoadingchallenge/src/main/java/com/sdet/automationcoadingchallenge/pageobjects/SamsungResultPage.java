package com.sdet.automationcoadingchallenge.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sdet.automationcoadingchallenge.actiondriver.Action;
import com.sdet.automationcoadingchallenge.base.BaseClass;



public class SamsungResultPage extends BaseClass{


	@FindBy (id="s-result-sort-select")
	WebElement Sort;
	
	@FindBy (xpath ="//*[@class='a-dropdown-item']//*[text()='Price: High to Low']")
	WebElement sortPriceHightoLow;
	
	@FindBy (xpath ="//*[@data-index='2']//a")
	WebElement secondItemList;
	
	public SamsungResultPage() {//constructor created for HomePage class
		
		PageFactory.initElements(driver, this);
	}
	
	public SelectedProductPage getSecondLargestPricedProduct() throws Exception {
		Action.clickElement(driver, Sort);
		Action.clickElement(driver, sortPriceHightoLow);
		Action.explicitWait(driver, secondItemList, Duration.ofSeconds(12));
		Action.clickElement(driver, secondItemList);
		Action.switchToNewWindow(driver);
		return new SelectedProductPage();
		
	}
}