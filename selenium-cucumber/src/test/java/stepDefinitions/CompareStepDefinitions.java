package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class CompareStepDefinitions {
	TestContextSetup testContextSetup;
	WebDriver driver;

	public CompareStepDefinitions(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;
	}

	@When("User adds items to compare list")
	public void add_to_compare() throws InterruptedException {
		testContextSetup.driver.findElement(By.id("ui-id-5")).click();
		Thread.sleep(3000);
		testContextSetup.driver.findElement(By.xpath("//a[contains(text(),'Hoodies & Sweatshirts')]")).click();
		Thread.sleep(3000);
		testContextSetup.driver.findElement(By.xpath("//img[contains(@alt,'Ajax Full-Zip Sweatshirt')]")).click();
		Thread.sleep(5000);
		testContextSetup.driver.findElement(By.xpath("//a[@class='action tocompare']")).click();
		// go back
		Thread.sleep(5000);
		testContextSetup.driver.navigate().back();
		Thread.sleep(3000);
		testContextSetup.driver.findElement(By.xpath("//a[contains(text(),'Hoodies & Sweatshirts')]")).click();
		Thread.sleep(3000);
		// Add second item
		testContextSetup.driver.findElement(By.xpath("//img[@alt='Marco Lightweight Active Hoodie']")).click();
		Thread.sleep(3000);
		testContextSetup.driver.findElement(By.xpath("//a[@class='action tocompare']")).click();
		Thread.sleep(3000);
	}

	@Then("Validate items present in compare list")
	public void validate_compare_list() {
		testContextSetup.driver.findElement(By.linkText("comparison list")).click();
		WebElement item1 = testContextSetup.driver.findElement(By.xpath("//img[contains(@alt,'Ajax Full-Zip Sweatshirt')]"));
		Assert.assertTrue(item1.isDisplayed(), "Item1 Missing");
		WebElement item2 = testContextSetup.driver.findElement(By.xpath("//img[@alt='Marco Lightweight Active Hoodie']"));
		Assert.assertTrue(item2.isDisplayed(), "Item2 Missing");
	}
}
