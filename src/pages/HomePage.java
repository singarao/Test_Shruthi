package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePage {

	WebDriver driver;
	SoftAssert sAssert= new SoftAssert();
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	//Locator for search box
	By searchBox= By.xpath("//input[@class='search-keyword']");

	//Locator for search button
	By searchButton= By.xpath("//button[@class='search-button']");

	//Locator for Add to cart button
	By addToCart= By.xpath("//button[contains(text(),'ADD TO CART')]");

	//Locator for Quantity decrement
	By quantity_decrement=By.xpath("//a[@class=''decrement]");

	//Locator for Quantity increment
	By quantity_increment=By.xpath("//a[@class='increment']");

	//Locator for bag sign
	By bagSign=By.xpath("//a[@class='cart-icon']/img");

	//Locator for PROCEED TO CHECKOUT button
	By checkOutButton= By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");

		
	//Method to enter data in search box
	public void enterDatainSearchBox(String search)
	{
		driver.findElement(searchBox).clear();
		driver.findElement(searchBox).sendKeys(search);
	}
	//Method to click on Search icon
	public void clickOnSearchIcon()
	{
		driver.findElement(searchButton).click();
	}

	//Method for Add to cart button
	public void addToCart()
	{
		try {
			WebElement element =driver.findElement(addToCart);
			element.click();
			/*JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", element);*/
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			WebElement element =driver.findElement(addToCart);
			element.click();
		}
		
	}

	//Method for Quantity decrement button
	public void clickOnQuantityDecrement()
	{
		driver.findElement(quantity_decrement).click();
	}

	//Method for Quantity increment button
	public void clickOnQuantityIncrement()
	{
		driver.findElement(quantity_increment).click();
	}

	//Method for click on bagSign
	public void clickOnBagSign() {
		driver.findElement(bagSign).click();

	}

	//Method for click on Proceed to checkout button
	public void clickOnCheckout() {
		driver.findElement(checkOutButton).click();

	}

	}
