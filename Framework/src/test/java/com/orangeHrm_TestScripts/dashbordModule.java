package com.orangeHrm_TestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.orangeHrm_Pages.Dashboard;
import com.orangeHrm_Pages.login_logout;

import utility.baseClass;

public class dashbordModule extends baseClass{
	
	@Test(priority = 1)
	public void validateDashbordPage() throws IOException, InterruptedException {
		login_logout app = new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		Dashboard bord = new Dashboard(driver);
		String result = bord.verifyDashbordPage();
		String expected = "Dashboard";         
		assertEquals(result, expected);  
		app.logout();                                                        
	}     
	
	@Test(priority = 2)
	public void validateMytimeSheetLogo() throws IOException, InterruptedException {
		login_logout app = new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		Dashboard bord = new Dashboard(driver);
		Boolean result = bord.verifyMytimeSheetLogo();
		assertTrue(result);
		app.logout();
	}                                      
                    
}  
            