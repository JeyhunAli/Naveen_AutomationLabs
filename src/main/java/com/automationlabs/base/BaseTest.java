package com.automationlabs.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.automationlabs.pages.WelcomePage;

public class BaseTest {
	
	public WebDriver driver;
	public BasePage basepage;
	public Properties prop;
	public WelcomePage welcomepage;

	
	@BeforeTest
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.initialize_prop();
		//it will create obj of prop class, it will create file input stream, it will make connection 
		//config.properties file and then it will load the properties
		driver = basepage.initialize_driver(prop);
		welcomepage = new WelcomePage(driver);

	}
	
	
	@AfterTest(enabled = false)
	public void tearDown() {
		driver.quit();
	}

	

}
