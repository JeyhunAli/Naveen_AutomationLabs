package com.automationlabs.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.automationlabs.utility.JavaScriptUtil;
import com.automationlabs.utility.WebElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author jey
 *
 */

public class BasePage {

	/**
	 * this class is responsible of the web driver concept so all the initialization
	 * form will take browser from this class
	 */

	WebDriver driver;
	Properties prop;
	public WebElementUtil eleUtil;
	public JavaScriptUtil jsUtil;

	// creating publicly static in a class level object of thread local
	// this concept works with first setting and getting driver methods
	// synchronized - its providing synchronization means while executing other
	// threads will not disturb the current running thread
	// its awesome future when we dealing multiple browser executing
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	public WebDriver initialize_driver(Properties prop) {

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
			tldriver.set(new ChromeDriver());

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
			tldriver.set(new FirefoxDriver());

		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			// driver = new SafariDriver();
			tldriver.set(new SafariDriver());

		}

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

		getDriver().get(prop.getProperty("url"));

		return getDriver();

	}

	/**
	 * this method is one of most important method in framework which is giving us
	 * complete control of the config file FileInputStream class make the connection
	 * with config file prop.load method loading FileInputStream
	 * 
	 * @return properties
	 */

	public Properties initialize_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/automationlabs/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

	/**
	 * this method is responsible for taking screenShot and connected with
	 * listener/Interface
	 * 
	 * @return
	 */

	public String takeScreenShot() {

		File scr = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String projectPath = System.getProperty("user.dir") + "/screenShot/" + System.currentTimeMillis() + ".png";

		File destination = new File(projectPath);

		try {
			FileUtils.copyDirectory(scr, destination);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return projectPath;

	}

}