package com.sdet.automationcoadingchallenge.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet.automationcoadingchallenge.actiondriver.Action;
import com.sdet.automationcoadingchallenge.base.BaseClass;


public class SelectedProductPage extends BaseClass{

	@FindBy (id ="feature-bullets")
	WebElement aboutThisItem;
	
	public SelectedProductPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyAboutThisItemElement() {
		return Action.isDisplayed(driver, aboutThisItem);
	}
	public void printAboutThisItem() {
		String aboutThisItemText = aboutThisItem.getText();
		System.out.println("ABOUT THIS ITEM TEXT IS "+ aboutThisItemText);
	}
	
}