package com.orangeHrm_TestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.orangeHrm_Pages.login_logout;

import utility.baseClass;

public class loginModule extends baseClass {
	@Test(priority = 1)
	public void loginWithVaildCredentials() throws IOException, InterruptedException {                                                                                  
		login_logout app = new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		//app.(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		boolean result = app.logo();
		assertTrue(result);
		app.logout();   
	}
	@Test(priority = 2)
	public void loginWithInVaildCredentials() throws IOException, InterruptedException {
		login_logout app = new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("wrongUN"), getValues().getProperty("wrongPw"));
		String result = app.err();
		String expected = "Invalid credentials";
		assertEquals(result, expected);
		
	}
	
	
}       
                                                   
                    
                                                                                                    