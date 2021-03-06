package br.com.AutomationWeb.steps;



import org.junit.Assert;
import br.com.AutomationWeb.PageObject.Browser;
import br.com.AutomationWeb.PageObject.CreateNewAccountPage;
import br.com.AutomationWeb.PageObject.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewAccountSteps {

	private Browser browser;
	private HomePage homePage;
	private CreateNewAccountPage createNewAccountPage;

	@Given("the user acces the menu user")
	public void acess_the_website() {
		browser = new Browser();
		homePage = browser.getHomePage();
	}

	@When("click in create new account")
	public void click_in_create_new_account() {
		createNewAccountPage = this.homePage.VistiCreateNewAccount();
	}

	@Then("should access the Create account Page")
	public void should_access_the_create_account_page() {
		Assert.assertTrue(this.createNewAccountPage.IsOnCreateNewAcountPage());
		browser.clean();
	}

	@Then("should access the home Page")
	public void should_access_the_new_account() {
		Assert.assertTrue(this.homePage.isHomepage()); 
	}

	@Then("show user correctly")
	public void show_user_correctly() {
		Assert.assertEquals("user0102", this.homePage.UserLogged());
		browser.clean();
	}
	
	@When("insert {string}")
	public void insert(String string) {
		this.createNewAccountPage.RegisterDatas(string);
	}
	@When("finalize registration")
	public void finalize_registration() {
		this.createNewAccountPage.CreateANewAccount();
	}




}
