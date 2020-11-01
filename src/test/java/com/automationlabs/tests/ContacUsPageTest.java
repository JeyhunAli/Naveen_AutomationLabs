package com.automationlabs.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationlabs.base.BaseTest;
import com.automationlabs.pages.ContacUsPage;
import com.automationlabs.utility.ConstantsUtility;

public class ContacUsPageTest extends BaseTest {

	ContacUsPage contactsPage;
	

	@BeforeClass
	public void setUpContactsUsPage() {

		//welcomepage.close_popUp();
		contactsPage = welcomepage.goClickContactUsButton();
		

	}

	@Test
	public void ContactusPageTitleTest() {
		String titletext = contactsPage.getContactusPageTitle();
		System.out.println("ContactsUs Page title is: " + titletext);
		Assert.assertEquals(titletext, ConstantsUtility.CONTACTS_PAGE_TITLE, "not found");

	}

	@Test
	public void ContactusPageHeaderTest() {
		String headerText = contactsPage.getContactusPageHeader();
		System.out.println(headerText);
		Assert.assertEquals(headerText, ConstantsUtility.CONTACS_PAGE_HEADER, "not found");
	}

	@Test
	public void IncaseTextTest() {
		String InCaseText = contactsPage.getIncasetext();
		System.out.println(" in case text in contactsUs page is:  " + InCaseText);
	}
	
    @Test(enabled = true)
	public void getLinkTest() {
		String linkText = contactsPage.getLink();
		System.out.println(linkText);
		Assert.assertEquals(linkText, ConstantsUtility.CONTACTS_LINK_TEXT, "not found");

	}

	@Test
	public void SearchKeywordTest() {
		String searchKeyword = contactsPage.getSearchKeyword();
		System.out.println("searchKeyword in contacts us page is " + searchKeyword);
	}

	@Test
	public void searchTextFieldTest() {
		contactsPage.getsearchTextField(prop.getProperty("value"));

	}
	
//	@Test(enabled = true)
//	public void clicksearchbuttonTest() {
//		contactsPage.clicksearchbutton();
//	}

}

