package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class SignUpStepDefinitions {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	
	
	public SignUpStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}


	@Given("User is on sign up page")
	public void user_is_on_sign_up_page() {
		testContextSetup.driver = new ChromeDriver();
		testContextSetup.driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
		testContextSetup.driver.manage().window().maximize();

	}

	@When("^User entered his personal informaton (.+) (.+) (.+) (.+) (.+)$")
	public void entered_personal_informaton(String fname, String lname, String email, String password,
			String c_password) {
		testContextSetup.driver.findElement(By.id("firstname")).sendKeys(fname);
		testContextSetup.driver.findElement(By.id("lastname")).sendKeys(lname);
		testContextSetup.driver.findElement(By.id("email_address")).sendKeys(email);
		testContextSetup.driver.findElement(By.id("password")).sendKeys(password);
		testContextSetup.driver.findElement(By.id("password-confirmation")).sendKeys(c_password);

	}

	@When("Clicked create an account")
	public void clicked_create_an_account() throws InterruptedException {
		testContextSetup.driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
		Thread.sleep(5000);
		
	}

	@Then("Validate successful sign up and welcome message")
	public void validate_successful_sign_up_and_welcome_message() {
		String expectedmsg1 = "Thank you for registering with Main Website Store.";
		String actualmsg1 = testContextSetup.driver.findElement(By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
		Assert.assertTrue(actualmsg1.contains(expectedmsg1), "Does not contain thank you for registering message");
	}	
}

