package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pages.Cart;
import pages.Country;
import pages.HomePage;

public class End2End {
	
	public static void main(String args[])
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//creating object of home page
		HomePage home=new HomePage(driver);
		
		//creating object of Cart page
		Cart cart=new Cart(driver);
		
		//creating object of Country page
		Country country= new Country(driver);
		
		home.enterDatainSearchBox("Water Melon");
		home.clickOnSearchIcon();
		home.addToCart();
		
		home.enterDatainSearchBox("carrot");
		home.clickOnSearchIcon();
		home.clickOnQuantityIncrement();
		home.addToCart();
		
		home.clickOnBagSign();
		home.clickOnCheckout();
		
		cart.validate_TotalPrice_inEachRow();
		cart.validate_SumOfTotal();
		cart.ClickPlaceOrderButton();
		country.selectCountryDropdown("India");
		country.clickOnProceed();
		country.verifyTCErrorMessage();
		country.selectAgreeTermsCheckBox();
		country.clickOnProceed();
		country.verifyOrderSuccessMessage();
		
	}

}
