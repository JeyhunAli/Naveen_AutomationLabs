package com.automationlabs.tests;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationlabs.base.BaseTest;
import com.automationlabs.pages.ContacUsPage;
import com.automationlabs.pages.MeetingPage;
import com.automationlabs.pages.NaveenPage;
import com.automationlabs.utility.ConstantsUtility;
import com.automationlabs.utility.ExcelUtility;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic number - 1010 passing data from excel")
@Story("Story number - 788 validate excel file data passing and timeout after each and every comments")
public class MeetingPageTest extends BaseTest {

	ContacUsPage contactsPage;
	NaveenPage naveenPage;
	MeetingPage meetingPage;

	
	@BeforeClass
	public void MeetingPageSetUP() {

		// welcomepage.close_popUp();
		contactsPage = welcomepage.goClickContactUsButton();
		naveenPage = contactsPage.getsearchTextField(prop.getProperty("value"));
		meetingPage = naveenPage.click_and_GO_Meeting();
		// naveenPage = contactsPage.goToNaveenPage();
	}
	
	@DataProvider
	public Object[][] getTestDataTest() {
		Object[][] data = ExcelUtility.getTestData(ConstantsUtility.ExcelSheet_Data);
		return data;
		
	}
	@Severity(SeverityLevel.NORMAL)
@Description("this method is providing with the data from excel file")
	@Test(priority = 1, dataProvider = "getTestDataTest")
	public void fillTheMeetingFormTest(String comment, String name, String email, String website) {
		meetingPage.fillTheMeetingForm(comment, name, email, website);

	}

}
