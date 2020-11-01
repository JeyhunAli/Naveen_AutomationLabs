package com.automationlabs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationlabs.base.BaseTest;
import com.automationlabs.pages.WelcomePage;
import com.automationlabs.utility.ConstantsUtility;

public class WelcomePageTest extends BaseTest{
	
	//WelcomePage welcomepage;

	@Test(priority = 1, enabled = false)
	public void closePopUpTest() {
             welcomepage.close_popUp();
	}

	@Test(priority = 2)
	public void verifywelcomepageTitle_Test() {
		String title = welcomepage.getwelcomePageTitle();
		System.out.println("welcome page title is " + title);
		Assert.assertEquals(title, ConstantsUtility.WELCOME_PAGE_TITLE, "title is not correct please check ....");
	}

	@Test(priority = 3)
	public void verify_naveenAutomationlabs_link_test() {
		Assert.assertTrue(welcomepage.naveenAutomationlabs_link(), "link is not displayed please check .....");
	}

	@Test(priority = 4)
	public void verify_learnTechnology_TexTest() {
		Assert.assertTrue(welcomepage.learnTechnology_Text(), "text is not displayed please check .....");

	}

	@Test(enabled = false)
	public void clickContactUsButtonTest() {
		welcomepage.goClickContactUsButton();
	}

	
	
	

}
