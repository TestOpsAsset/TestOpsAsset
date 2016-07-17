package com.frontEndApp_Scripts;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.frontEndApp_pages.HomePage;
import com.frontEndApp_pages.ListofUsersPage;
import com.frontEndApp_pages.NewPwdPage;
import com.frontEndApp_pages.NewUserPage;

public class MainProcess extends setBrowser{

	@Test (priority=1)
	public void signIn(){
		HomePage hp = new HomePage(driver);
		Assert.assertEquals("You are logged in as user \"admin\"." , hp.logIn(data.User, data.pwd));
		System.out.println("--------------------------------------------");
	}
	
	@Test (priority=2)
	public void addnewuser(){
		NewUserPage user = new NewUserPage(driver);
		int serial = (int)(Math.random()*500+1);
		String emailtemp = data.new_FName +"."+ data.new_LName + serial +"@accenture.com";
		String actual = user.insertData(data.new_User + serial, data.new_FName + serial,data.new_LName,emailtemp, serial);
		
		//Printing results in console
		System.out.println("Actual result: " + actual);
		String expected = "A user is created with identifier " + data.new_User + serial;
		System.out.println("Expected result: " + expected);

		//--- Assertion ----
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority=3)
	public void newpassword(){
		NewPwdPage cp = new NewPwdPage(driver);
		String actual = cp.changePassword();
		Assert.assertEquals(actual, "Password changed!");
		System.out.println("Actual message: " + actual);
		System.out.println("-------------------------------------");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}	
		
	@Test (priority=4)
	public void listofUsers(){
		ListofUsersPage userlist = new ListofUsersPage(driver);
		Boolean actual= userlist.createListofUsers();
		Assert.assertTrue(actual);
		System.out.println("A list of users has been printed");
		}		
	
}
