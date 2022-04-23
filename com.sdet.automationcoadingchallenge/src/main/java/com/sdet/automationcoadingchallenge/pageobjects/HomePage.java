package com.sdet.automationcoadingchallenge.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdet.automationcoadingchallenge.actiondriver.Action;
import com.sdet.automationcoadingchallenge.base.BaseClass;


public class HomePage extends BaseClass{

	
	@FindBy (id = "nav-hamburger-menu" )
	WebElement humburgerMenu;
	
	@FindBy (xpath = "//a[@data-menu-id='9']")
	WebElement tvAppliancesElectronics;
	
	@FindBy (xpath = "//*[@id='hmenu-content']/ul[9]/li[3]/a")
	WebElement television;
	
	
	public HomePage() {//constructor created for HomePage class
		
		PageFactory.initElements(driver, this);
	}
	
	public TelevisionPage actionsMethodsInHomePage() throws Exception {
		Action.clickElement(driver, humburgerMenu);
		Action.clickElement(driver, tvAppliancesElectronics);
		Action.clickElement(driver, television);
		return new TelevisionPage();
	}
	
}