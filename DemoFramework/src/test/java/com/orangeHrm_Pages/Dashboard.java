package com.orangeHrm_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.baseClass;

public class Dashboard extends baseClass{

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement dashboardText;
	
	@FindBy(xpath = "(//*[name()='svg'])[22]")
	private WebElement mytimesheetlogo;
	
	@FindBy(xpath = "//button[@title='My Timesheet']")
	private WebElement mytimesheetBtn;
	
	public Dashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyDashbordPage() {
		return dashboardText.getText();
	}
	
	public Boolean verifyMytimeSheetLogo() {
		return mytimesheetlogo.isDisplayed();
	}
	
	
}
