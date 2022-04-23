package com.sdet.automationcoadingchallenge.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet.automationcoadingchallenge.actiondriver.Action;
import com.sdet.automationcoadingchallenge.base.BaseClass;


public class TelevisionPage extends BaseClass{

	
	@FindBy(xpath = "//*[@class='a-link-normal']//*[contains(text(),'Samsung')]")
	WebElement samsungCheckBox;
	
	public TelevisionPage() {
		PageFactory.initElements(driver, this);
	}
	
	public SamsungResultPage samsungCheckBoxSelection() throws InterruptedException {
		Action.mouseOverElement(driver, samsungCheckBox);
		Action.clickElement(driver, samsungCheckBox);
		return new SamsungResultPage();
	}
}