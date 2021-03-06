package br.com.AutomationWeb.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;

	private static String URL_HOME_PAGE = "http://advantageonlineshopping.com/#/";

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public CreateNewAccountPage VistiCreateNewAccount() {
		driver.get(URL_HOME_PAGE);

		this.WaitLoadHomePage();
		WebElement btnMenuUser = driver.findElement(By.id("menuUser"));
		WebElement btnCreatNewAccount = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		btnMenuUser.click();

		this.WaitLoadMenuUser();
		btnCreatNewAccount.click();

		return new CreateNewAccountPage(driver);
	}

	public void WaitLoadHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("special_offer_items")));
	}

	public void WaitLoadMenuUser() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")));
	}
	
	public boolean isHomepage() {
		return this.driver.getCurrentUrl().endsWith("/#/");
	}
	
	public String UserLogged() {
		return driver.findElement(By.id("menuUserLink")).getText();
	}

}
