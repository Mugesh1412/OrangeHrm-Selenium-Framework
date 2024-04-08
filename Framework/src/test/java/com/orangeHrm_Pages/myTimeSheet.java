package com.orangeHrm_Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.baseClass;

public class myTimeSheet extends baseClass{
	
	@FindBy(xpath = "//h6[.='My Timesheet']")
	private WebElement mytimesheettext;
	
	@FindBy(xpath = "(//button[@class='oxd-icon-button orangehrm-quick-launch-icon'])[6]")
	private WebElement mytimesheetbtn;

	@FindBy(xpath = "//i[@class='oxd-icon bi-calendar oxd-date-input-icon']")
	private WebElement calenderBtn;
	
	@FindBy(xpath = "//div[@class='oxd-date-input-calendar']")
	private WebElement calander;
	
	@FindBy(xpath = "//div[text()='Today']")
	private WebElement calendarTodayBtn;
	
	@FindBy(xpath = "//div[text()='Close']")
	private WebElement calander_closebtn;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement dateSearch;
	
	public myTimeSheet(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyMyTimeSheetPage() {
		mytimesheetbtn.click();
		return mytimesheettext.getText();
	}
	
	public boolean  verifyCalendarBtn() {
		mytimesheetbtn.click();
		calenderBtn.click();
		return calander.isDisplayed();
	}
	
	public  String verify_the_calander_today_btn() throws InterruptedException {
		mytimesheetbtn.click();
		calenderBtn.click();
		Thread.sleep(2000);
		calendarTodayBtn.click();
		mytimesheettext.click();
		Thread.sleep(2000);
		 return dateSearch.getText();
			
	}
	
	public  boolean verify_the_calander_closebtn() throws InterruptedException {
		mytimesheetbtn.click();
		calenderBtn.click();
		Thread.sleep(2000);
		boolean before = calander_closebtn.isEnabled();
		calander_closebtn.click();
		boolean after = calander_closebtn.isEnabled();
		if(before==after) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public void selectDate(String date) throws InterruptedException {
		
		
		mytimesheetbtn.click();
		Thread.sleep(2000);
		dateSearch.sendKeys(Keys.chord(Keys.CONTROL,"a"),""+date+"");
		
	}
	
	
	
	
	
	
	
}
