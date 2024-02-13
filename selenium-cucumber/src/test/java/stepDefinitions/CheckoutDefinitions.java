package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class CheckoutDefinitions {

	TestContextSetup testContextSetup;
	WebDriver driver;

	public CheckoutDefinitions(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;
	}

	@Given("User adds items to cart")
	public void add_items_to_cart() throws InterruptedException {
		Thread.sleep(3000);
		testContextSetup.driver.findElement(By.id("ui-id-5")).click();
		Thread.sleep(5000);
		testContextSetup.driver.findElement(By.xpath("//a[contains(text(),'Hoodies & Sweatshirts')]")).click();
		Thread.sleep(5000);
		// Add 1st item
		testContextSetup.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/a/span/span/img")).click();
		Thread.sleep(5000);
		testContextSetup.driver.findElement(By.xpath("//div[@id='option-label-size-143-item-168']")).click();
		Thread.sleep(2000);
		testContextSetup.driver.findElement(By.xpath("//div[@id='option-label-color-93-item-50']")).click();
		Thread.sleep(2000);
		testContextSetup.driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		Thread.sleep(5000);
		testContextSetup.driver.navigate().back();

	}

	@When("^User process to checkout with details (.+) (.+) (.+) (.+) (.+)$")
	public void proceed_to_checkout(String addline1, String addline2, String City, String Zipcode, String Phone)
			throws InterruptedException {
		Thread.sleep(2000);
		testContextSetup.driver.findElement(By.xpath("//a[@class='action showcart']")).click();
		Thread.sleep(5000);
		testContextSetup.driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']")).click();
		Thread.sleep(5000);
		/*
		 * if (testContextSetup.driver
		 * .findElement(By.xpath("//*[@id="checkout-step-shipping"]/div[2]/button/span")).
		 * isDisplayed()) { Thread.sleep(2000); testContextSetup.driver.findElement(By.
		 * xpath("//button[@class='button action continue primary']")).click();
		 * Thread.sleep(5000); testContextSetup.driver.findElement(By.
		 * xpath("//button[@class='action primary checkout']")).click(); } else {
		 */
			Thread.sleep(2000);
			testContextSetup.driver.findElement(By.xpath("//input[@name='street[0]']")).sendKeys(addline1);
			Thread.sleep(1000);
			testContextSetup.driver.findElement(By.xpath("//input[@name='street[1]']")).sendKeys(addline2);
			Thread.sleep(1000);
			WebElement countrydrop = testContextSetup.driver.findElement(By.xpath("//select[@name='country_id']"));
			Select country = new Select(countrydrop);
			country.selectByValue("IN");
			Thread.sleep(1000);
			WebElement statedrop = testContextSetup.driver.findElement(By.xpath("//select[@name='region_id']"));
			Select state = new Select(statedrop);
			state.selectByValue("549");
			Thread.sleep(1000);
			testContextSetup.driver.findElement(By.xpath("//input[@name='city']")).sendKeys(City);
			Thread.sleep(1000);
			testContextSetup.driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys(Zipcode);
			Thread.sleep(1000);
			testContextSetup.driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys(Phone);
			Thread.sleep(1000);
			testContextSetup.driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();
			Thread.sleep(5000);
			testContextSetup.driver.findElement(By.xpath("//button[@title='Place Order']")).click();
			Thread.sleep(3000);
		}
	
	
	@When("^User adds new address with details (.+) (.+) (.+) (.+) (.+)$") 
	public void multiple_address(String addline1, String addline2, String City, String Zipcode, String Phone) throws InterruptedException {
		Thread.sleep(2000);
		testContextSetup.driver.findElement(By.xpath("//a[@class='action showcart']")).click();
		Thread.sleep(5000);
		testContextSetup.driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']")).click();
		Thread.sleep(5000);
		testContextSetup.driver.findElement(By.xpath("//*[@id='checkout-step-shipping']/div[2]/button/span")).click();
		
		
		Thread.sleep(2000);
		testContextSetup.driver.findElement(By.xpath("//input[@name='street[0]']")).sendKeys(addline1);
		Thread.sleep(1000);
		testContextSetup.driver.findElement(By.xpath("//input[@name='street[1]']")).sendKeys(addline2);
		Thread.sleep(1000);
		WebElement countrydrop = testContextSetup.driver.findElement(By.xpath("//select[@name='country_id']"));
		Select country = new Select(countrydrop);
		country.selectByValue("IN");
		Thread.sleep(1000);
		WebElement statedrop = testContextSetup.driver.findElement(By.xpath("//select[@name='region_id']"));
		Select state = new Select(statedrop);
		state.selectByValue("549");
		Thread.sleep(1000);
		testContextSetup.driver.findElement(By.xpath("//input[@name='city']")).sendKeys(City);
		Thread.sleep(1000);
		testContextSetup.driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys(Zipcode);
		Thread.sleep(1000);
		testContextSetup.driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys(Phone);
		Thread.sleep(1000);
		testContextSetup.driver.findElement(By.xpath("//button[@class='action primary action-save-address']")).click();
		Thread.sleep(5000);
		testContextSetup.driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();
		Thread.sleep(5000);
		testContextSetup.driver.findElement(By.xpath("//button[@title='Place Order']")).click();
		Thread.sleep(3000);
		
	}


	@Then("Verify order success")
	public void verify_order_success() throws InterruptedException {
		Thread.sleep(5000);
		String expectedmsg1 = "Thank you for your purchase!";
		String actualmsg1 = testContextSetup.driver.findElement(By.xpath("//h1[@class='page-title']")).getText();
		System.out.println("This is the message received"+actualmsg1);
		Assert.assertTrue(actualmsg1.contains(expectedmsg1), "Confirmation message not found.");
	}

	@Then("Validate in my account order section")
	public void validate_order_in_my_account() throws InterruptedException {
		String orderconf = testContextSetup.driver.findElement(By.xpath("//a[@class='order-number']")).getText();
		System.out.println("This is the order number on conf page: "+orderconf);
		testContextSetup.driver.findElement(By.xpath("//button[@class='action switch']")).click();
		Thread.sleep(5000);
		testContextSetup.driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		Thread.sleep(5000);
		String from_account = testContextSetup.driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[1]")).getText();
		System.out.println("This is the text from account: "+from_account);
		Assert.assertTrue(from_account.contains(orderconf), "Confirmation message not found.");

	}

}
