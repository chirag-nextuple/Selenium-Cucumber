package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class WishlistStepDefinitions {

	TestContextSetup testContextSetup;
	WebDriver driver;

	public WishlistStepDefinitions(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;
	}

	@Given("User goes to wishlist")
	public void go_to_wishlist() throws InterruptedException {
		Thread.sleep(5000);
		testContextSetup.driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
		Thread.sleep(5000);
		testContextSetup.driver.findElement(By.xpath("//li[@class='link wishlist']")).click();

	}

	@When("User adds items to wishlist")
	public void user_adds_items_to_wishlist() throws InterruptedException {
		// Click men's dropdown and go to hoodies and sweatshirts
		Thread.sleep(3000);
		testContextSetup.driver.findElement(By.id("ui-id-5")).click();
		Thread.sleep(5000);
		testContextSetup.driver.findElement(By.xpath("//a[contains(text(),'Hoodies & Sweatshirts')]")).click();
		Thread.sleep(3000);
		// Add 1st item
		testContextSetup.driver.findElement(By.xpath("//img[contains(@alt,'Ajax Full-Zip Sweatshirt')]")).click();
		Thread.sleep(5000);
		testContextSetup.driver.findElement(By.xpath("//a[@class='action towishlist']")).click();
		// go back
		Thread.sleep(5000);
		testContextSetup.driver.navigate().back();
		Thread.sleep(3000);
		// Add second item
		testContextSetup.driver.findElement(By.xpath("//a[contains(text(),'Hoodies & Sweatshirts')]")).click();
		Thread.sleep(3000);
		testContextSetup.driver.findElement(By.xpath("//img[@alt='Marco Lightweight Active Hoodie']")).click();
		Thread.sleep(3000);
		testContextSetup.driver.findElement(By.xpath("//a[@class='action towishlist']")).click();
		Thread.sleep(3000);
	}



	@When("User deletes an item")
	public void del_item() throws InterruptedException {
		/*
		 * WebElement item1 = testContextSetup.driver.findElement(By.
		 * xpath("//img[contains(@alt,'Ajax Full-Zip Sweatshirt')]")); Actions action =
		 * new Actions(testContextSetup.driver);
		 * action.moveToElement(item1).build().perform();
		 */
		Thread.sleep(1000);
		testContextSetup.driver.findElement(By.xpath("//*[@id=\"wishlist-sidebar\"]/li[1]/div/div/div[2]/div[2]/a")).click();

	}

	@Then("Verify same items present")
	public void verify_same_items_present() {
		WebElement item1 = testContextSetup.driver.findElement(By.xpath("//img[contains(@alt,'Ajax Full-Zip Sweatshirt')]"));
		Assert.assertTrue(item1.isDisplayed(), "Item1 Missing");
		WebElement item2 = testContextSetup.driver.findElement(By.xpath("//img[@alt='Marco Lightweight Active Hoodie']"));
		Assert.assertTrue(item2.isDisplayed(), "Item2 Missing");

	}

	@Then("Verify item deleted")
	public void verify_item_del() throws InterruptedException {
		Thread.sleep(3000);
		
		String expectedremoval = "Marco Lightweight Active Hoodie has been removed from your Wish List.";
		String actualremoval = testContextSetup.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
		System.out.println("This is the text received after removal: "+actualremoval);
		Assert.assertTrue(actualremoval.contains(expectedremoval), "Successful removal message not found.");

		/*
		 * if( ! testContextSetup.driver.findElement(By.
		 * xpath("//a[@title='Marco Lightweight Active Hoodie']")).isDisplayed()){
		 * System.out.println("Item is removed successfully"); }else {
		 * System.out.println("Item not removed."); }
		 */
		//WebElement item1 = testContextSetup.driver.findElement(By.xpath("//img[contains(@alt,'Ajax Full-Zip Sweatshirt')]"));
		//Assert.assertFalse(testContextSetup.driver.findElement(By.xpath("//img[contains(@alt,'Ajax Full-Zip Sweatshirt')]")).isDisplayed(), "Item1 Present");

	}
}
