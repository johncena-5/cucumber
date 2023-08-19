package stepDefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import genricLibrary.BaseClass;
import genricLibrary.PropertyFileLibrary;
import genricLibrary.WebDriverLibrary;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomPage.LoginPage;

public class LoginStep extends BaseClass {

	
	public WebDriver driver;
	public PropertyFileLibrary pLib; 
	public WebDriverLibrary wLib;
	public LoginPage login;
	public long time;
	
	
	@Before
	public void before() {
		wLib = new WebDriverLibrary();
		pLib = new PropertyFileLibrary();
		time = Long.parseLong(pLib.fetchDataFromPropertyFile("time"));
		driver = wLib.launchBrowser(pLib.fetchDataFromPropertyFile("browser"), pLib, time);
		login = new LoginPage(driver);
	}

	@After
	public void after() {

		driver.close();

	}

	@When("provide username and password")
	public void provide_username_and_password() {

		login.loginToApp(pLib.fetchDataFromPropertyFile("username"), pLib.fetchDataFromPropertyFile("password"));

	}

	@When("click on login button")
	public void click_on_login_button() {
		login.clickOnLoginButton();

	}

	@Then("home page should display")
	public void home_page_should_display() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
	}
}
