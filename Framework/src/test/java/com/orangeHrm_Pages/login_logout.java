package com.orangeHrm_Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.baseClass;

public class login_logout extends baseClass {

	@FindBy(name = "username")
	private WebElement unbox;

	@FindBy(name = "password")
	private WebElement pwdbox;

	@FindBy(xpath = "//button[.=' Login ']")
	private WebElement loginbtn;

	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement down;

	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutbtn;

	@FindBy(xpath = "//img[@alt='client brand banner']")
	private WebElement hrmimg;

	@FindBy(xpath = "//p[.='Invalid credentials']")
	private WebElement err_msg;
	
	
	
	public login_logout(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	 public void loginIntoApp(String username,String password) throws IOException, InterruptedException {
		  //unbox.sendKeys(data.getProperty("UserName"));
		// unbox.sendKeys(value.getValues().getProperty("UserName"));
		 // pwdbox.sendKeys(data.getProperty("Password"));
		 //pwdbox.sendKeys(value.getValues().getProperty("Password"));
		 /*System.out.println("Properties: " + getValues());


			    String username = getValues().getProperty("UserName");
			    String password = getValues().getProperty("Password");
			    System.out.println(username + password );

			    if (username != null && password != null) {
			        unbox.sendKeys(username);
			        pwdbox.sendKeys(password);
			    } else {
			        System.out.println("Handle null values appropriately (e.g., log an error)");
			    }
			    // ... other login logic*/
			

		 
		//unbox.sendKeys(getValues().getProperty("UserName"));
		//unbox.sendKeys("Admin");
		//pwdbox.sendKeys("admin123");
		//pwdbox.sendKeys(getValues().getProperty("Password"));
		 
		 unbox.sendKeys(username);
		 pwdbox.sendKeys(password);
		 
		  loginbtn.click();
		  Thread.sleep(2000);
	  }
	 public void logout() {
		  down.click();
		  logoutbtn.click();
	  }
	  public boolean logo() {
		  return hrmimg.isDisplayed();
	  }
	  public String err() {
		  return err_msg.getText();
	  }
	  

}
