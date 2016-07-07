package com.frontEndApp_Scripts;

import org.testng.annotations.Test;

import com.frontEndApp_pages.HomePage;
import com.frontEndApp_pages.NewUserPage;

public class AddUser extends setBrowser{
	
	
	@Test (priority=1)
	public void signIn(){
		HomePage hp =  new HomePage(driver);
		hp.logIn(data.User, data.pwd);
	}
		
	@Test (priority=2)
	public void addnewuser(){
		NewUserPage user = new NewUserPage(driver);
		int serial = (int)(Math.random()*500+1);
		String emailtemp = data.new_FName +"."+ data.new_LName + serial +"@accenture.com";
		user.insertData(data.new_User + serial, data.new_FName + serial,data.new_LName,emailtemp, serial);
	}
	
	
}
