package com.orangeHrm_TestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangeHrm_Pages.login_logout;
import com.orangeHrm_Pages.myTimeSheet;

import utility.baseClass;


public class myTimeSheetModule extends baseClass{



	@Test(priority = 1)
	public void validateMytimeSheetPage() throws IOException, InterruptedException {
		login_logout app = new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		myTimeSheet my = new myTimeSheet(driver);
		String actual = my.verifyMyTimeSheetPage();
		String expected = "My Timesheet";
		assertEquals(actual, expected);
		Thread.sleep(2000);               
		app.logout();     
		
               
	}   

	@Test(priority = 2)
	public void validateCalanderBtn() throws IOException, InterruptedException {
		login_logout app = new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		myTimeSheet my = new myTimeSheet(driver);
		boolean result = my.verifyCalendarBtn();
		assertTrue(result);
		Thread.sleep(2000);
		app.logout();

	}
	@Test(priority = 3)
	public void validateCalanderTodayBtn() throws InterruptedException, IOException {
		login_logout app = new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		myTimeSheet my = new myTimeSheet(driver);
		String actualdate = my.verify_the_calander_today_btn();
		String expecteddate = LocalDate.now().toString();
		if(actualdate.contains(expecteddate)) {
			assertTrue(true);
		}
		Thread.sleep(2000);
		app.logout();


	}

	@Test(priority = 4)
	public void validateCalenderCloseBtn() throws IOException, InterruptedException {
		login_logout app = new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		myTimeSheet my = new myTimeSheet(driver);
		boolean result = my.verify_the_calander_closebtn();
		assertTrue(result);
		Thread.sleep(2000);  
		app.logout();


	}
	
	@Test(priority = 5)
	
	public void validateDate() throws IOException, InterruptedException {
		login_logout app = new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		myTimeSheet my = new myTimeSheet(driver);
		my.selectDate(getValues().getProperty("date"));
		String sd = takeScreenShot("CalenderTodayDate");
		test.addScreenCaptureFromPath(sd);
		
		
	}  
                                             
                               
}
