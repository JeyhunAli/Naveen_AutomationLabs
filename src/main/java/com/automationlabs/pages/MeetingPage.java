package com.automationlabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationlabs.base.BasePage;
import com.automationlabs.utility.WebElementUtil;

import io.qameta.allure.Step;

public class MeetingPage extends BasePage {

	private static WebDriver driver;

	By comment = By.xpath("//textarea[@id='comment']");
	By name = By.xpath("//input[@id='author']");
	By email = By.xpath("//input[@id='email']");
	By website = By.xpath("//input[@id='url']");

	public MeetingPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new WebElementUtil(driver);
	}

	@Step("stepNumber 88 providing with excel passing data")
	public void fillTheMeetingForm(String comment, String name, String email, String website) {
		
		eleUtil.DoActionSendKEys(this.comment, comment);
		
		eleUtil.DoActionSendKEys(this.name, name);
		
		eleUtil.DoActionSendKEys(this.email, email);
		
		eleUtil.DoActionSendKEys(this.website, website);
		

		eleUtil.doWaitWithThread_sleep(5000);
		
		eleUtil.docleartext(this.comment);
		eleUtil.docleartext(this.name);
		eleUtil.docleartext(this.email);
		eleUtil.docleartext(this.website);

	}

}
