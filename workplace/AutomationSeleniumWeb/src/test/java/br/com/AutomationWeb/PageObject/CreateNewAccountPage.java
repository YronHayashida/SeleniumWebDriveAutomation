package br.com.AutomationWeb.PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class CreateNewAccountPage {

	private WebDriver driver;
	private Faker random = new Faker();

	private static String PAGE_URL = "http://advantageonlineshopping.com/#/register";

	CreateNewAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		driver.get(PAGE_URL);
	}

	public boolean IsOnCreateNewAcountPage() {
		this.WaitLoadCreateNewAccount();
		return this.driver.getCurrentUrl().endsWith("/register");
	}
	
	public void RegisterDatas(String data) {
		switch (data.toLowerCase()) {
		case "account details":

			WebElement cmpUserName = driver.findElement(By.name("usernameRegisterPage"));
			WebElement cmpEmail = driver.findElement(By.name("emailRegisterPage"));
			WebElement cmpPassword = driver.findElement(By.name("passwordRegisterPage"));
			WebElement cmpConfirmPassword = driver.findElement(By.name("confirm_passwordRegisterPage"));

			cmpUserName.sendKeys("user0102");
			cmpEmail.sendKeys(random.internet().emailAddress());
			cmpPassword.sendKeys("Senha@13");
			cmpConfirmPassword.sendKeys("Senha@13");
			break;

		case "personal details":

			WebElement cmpFirstName = driver.findElement(By.name("first_nameRegisterPage"));
			WebElement cmpLastName = driver.findElement(By.name("last_nameRegisterPage"));
			WebElement cmpPhoneNumber = driver.findElement(By.name("phone_numberRegisterPage"));

			cmpFirstName.sendKeys(random.name().firstName());
			cmpLastName.sendKeys(random.name().lastName());
			cmpPhoneNumber.sendKeys("114266378");
			break;
			
		case "address":
			WebElement cmpCity = driver.findElement(By.name("cityRegisterPage"));
			WebElement cmpCountry = driver.findElement(By.name("countryListboxRegisterPage"));
			WebElement cmpAddress = driver.findElement(By.name("addressRegisterPage"));
			WebElement cmpState = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
			WebElement cmpPostalCode = driver.findElement(By.name("postal_codeRegisterPage"));
			
			cmpCity.sendKeys(random.address().city());
			cmpAddress.sendKeys(random.address().streetAddress());
			cmpState.sendKeys(random.address().state());
			cmpPostalCode.sendKeys(random.address().zipCode());
			cmpCountry.sendKeys("Brazil");
			break;
		}
	}

	public HomePage CreateANewAccount() {
		this.WaitLoadCheckIAgree();
		WebElement checkboxAgree = driver.findElement(By.name("i_agree"));
		WebElement btnRegister = driver.findElement(By.name("id register_btnundefined"));

		checkboxAgree.click();
		btnRegister.click();
		return new HomePage(driver);
	}

	public void WaitLoadCreateNewAccount() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"registerPage\"]/article/h3")));
	}

	public void WaitLoadAdress() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formCover\"]/div[3]")));
	}
	
	public void WaitLoadCheckIAgree() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("i_agree")));
	}

}
