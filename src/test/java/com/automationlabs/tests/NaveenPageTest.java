package com.automationlabs.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationlabs.base.BaseTest;
import com.automationlabs.pages.ContacUsPage;
import com.automationlabs.pages.NaveenPage;
import com.automationlabs.utility.ConstantsUtility;

public class NaveenPageTest extends BaseTest {

	ContacUsPage contactsPage;
	NaveenPage naveenPage;

	@BeforeClass
	public void NavenPageSetUP() {

		// welcomepage.close_popUp();
		contactsPage = welcomepage.goClickContactUsButton();
		naveenPage = contactsPage.getsearchTextField(prop.getProperty("value"));
		// naveenPage = contactsPage.goToNaveenPage();

	}

	@Test
	public void NaveenPageTitleTest() {
		String title = naveenPage.NaveenPageTitle();
		System.out.println("Naveen Page title is: " + title);
		Assert.assertEquals(title, ConstantsUtility.NaveenPageTitle, "title not found please pass correct title");
	}

	@Test(enabled = true)
	public void Link_NaveenAutomationLabs_Test() {
		WebElement linkele = naveenPage.NaveenAutomationLabsLink();

		String linkTex = linkele.getText();
		System.out.println("linkText is " + linkTex);
		Assert.assertEquals(linkTex, ConstantsUtility.NaveenPageHeader);
	}

	@Test(enabled = false)
	public void lifeMottoText_Test() {

		String text = naveenPage.lifeMottoText();
		System.out.println("life motto text is: " + text + "\n");
		Assert.assertEquals(text, ConstantsUtility.MottoText, "404 not fount please pass correct mootoText");

	}

	@Test(enabled = true)
	public void click_and_GO_Meeting_Test() {

		naveenPage.click_and_GO_Meeting();
	}

}
