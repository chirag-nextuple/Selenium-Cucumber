package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class LoginStepDefinitions {

	WebDriver driver;
	TestContextSetup testContextSetup;

	public LoginStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		testContextSetup.driver = new ChromeDriver();
		testContextSetup.driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
		testContextSetup.driver.manage().window().maximize();
	}

	@Given("^User login with (.+) (.+)$")
	public void user_login(String email, String password) {
		login(email, password);
	}

	@When("^User enters email (.+) and password (.+)$")
	public void user_enters_email_and_password(String email, String password) throws InterruptedException {
		login(email, password);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(5000);
	}


	@Then("^Verify successful login of user (.+) (.+)$")
	public void verify_successful_login(String fname, String lname) {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String expectedmsg = "Welcome, Chirag Sharda!";
		String actualmsg = testContextSetup.driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in']")).getText();		
		String expectedname = "Chirag Sharda";
		String expectedemail = "gehomibrunne-6442@yopmail.com";
		String info = testContextSetup.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[2]/div/div[1]")).getText();
		Assert.assertTrue(actualmsg.contains(expectedmsg), "Welcome message not found.");
		Assert.assertTrue(info.contains(expectedname), "Welcome message not found.");
		Assert.assertTrue(info.contains(expectedemail), "Welcome message not found.");
	}

	public void login(String email, String password) {
		testContextSetup.driver.findElement(By.id("email")).sendKeys(email);
		testContextSetup.driver.findElement(By.id("pass")).sendKeys(password);
		testContextSetup.driver.findElement(By.xpath("//button[@id='send2']")).click();
	}

}
