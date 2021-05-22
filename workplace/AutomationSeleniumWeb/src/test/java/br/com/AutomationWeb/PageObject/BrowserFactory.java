package br.com.AutomationWeb.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public WebDriver createWebDriver() {
		String webdriver = System.getProperty("browser", "chrome");
		switch (webdriver) {
		case "firefox":
			return initFirefoxDriver();
		case "chrome":
			return initChromeDriver();
		}
		return null;
	}

	private WebDriver initChromeDriver() {
		System.setProperty("webdriver.chrome.driver",
				"/C:\\Users\\Yron Hayashida\\Downloads\\sts-4.10.0.RELEASE\\workplace\\AutomationSeleniumWeb\\drivers\\chromedriver.exe");
		return new ChromeDriver();
	}

	private WebDriver initFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Yron Hayashida\\Downloads\\sts-4.10.0.RELEASE\\workplace\\AutomationSeleniumWeb\\drivers\\geckodriver.exe");
		return new FirefoxDriver();
	}
}
