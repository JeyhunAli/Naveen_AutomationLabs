package com.automationlabs.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testexample {

	public static void main(String[] args) {

WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://naveenautomationlabs.com/");
		
		driver.findElement(By.xpath("(//div[@role='button'])[2]")).click();
		
		driver.findElement(By.xpath("(//a[contains(text(), 'Contact Us')])[1]")).click();

		
	}

}
