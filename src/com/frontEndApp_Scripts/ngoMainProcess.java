package com.frontEndApp_Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.frontEndApp_pages.HomePage;



public class ngoMainProcess extends setBrowser {

	@Test (priority=1)
	public void loginNGO() {
		HomePage portal = new HomePage(driver);
		Assert.assertEquals("you have been logged into McKesson Portal", portal.logIn(data.User, data.pwd));
		System.out.println("-----Passed---1----------");
	}
	
	@Test (priority=2)
	public void paginationNGO() {
		HomePage portal = new HomePage(driver);
		Assert.assertEquals("you have been logged into McKesson Portal", portal.paginationNGO());
		System.out.println("\"-----Passed---2-----------");
		
	}
	
	/*@Test (priority=3)
	public void logoutNGO(){
		HomePage portal = new HomePage(driver);
		Assert.assertEquals("You are now logging out!", portal.logOutApp());
		System.out.println("\"-----ENd---------");
			
	}*/
		
	
	
}
