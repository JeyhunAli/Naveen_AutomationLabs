package com.automationlabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationlabs.base.BasePage;
import com.automationlabs.utility.WebElementUtil;

public class ContacUsPage extends BasePage {

	private WebDriver driver;

	// By contact = By.xpath("(//a[.='Contact Us'])[1]");
	By header = By.cssSelector("h1.post-title.entry-title");
	By inCase = By.xpath("//span[contains(text(),'In case of any query on training and automation solution.')]");
	By link = By.linkText("https://www.facebook.com/groups/naveenqtpexpert");
	By searchKeyword = By.xpath("//div/h3[@class='widget-title' and contains(text(), 'Search with Keyword')]");
	By searchtext = By.xpath("(//div/input[@id='s'])[2]");
	By searchButton = By.xpath("(//input[@id='searchsubmit'])[last()]");

	public ContacUsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new WebElementUtil(driver);

	}

	public String getContactusPageTitle() {
		// return
		// eleUtil.waitFor_Full_TitleToBePresent(ConstantsUtility.CONTACTS_PAGE_TITLE,
		// 10);
		return driver.getTitle();

	}

	public String getContactusPageHeader() {
          return eleUtil.getElement(header).getText();

	}

	public String getIncasetext() {
         if (eleUtil.getElement(inCase).isDisplayed()) {
		}
		return driver.findElement(inCase).getText();

	}

	public String getLink() {
        if (eleUtil.getElement(link).isDisplayed()) {

		}
		return eleUtil.doGetText(link);
	}

	public String getSearchKeyword() {
		return eleUtil.getElement(searchKeyword).getText();
	}
	
	

	public NaveenPage getsearchTextField(String searchtext) {
         eleUtil.doSendkeys(this.searchtext, searchtext);
         clicksearchbutton();
         return new NaveenPage(driver);
	}

//	public NaveenPage goToNaveenPage() {
//		clicksearchbutton();
//		return new NaveenPage(driver);
//	}

	private void clicksearchbutton() {
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(searchButton).click();
	}

}
