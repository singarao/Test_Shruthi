package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.Browser;
import library.Screenshot;
import pages.Cart;
import pages.Country;
import pages.HomePage;

public class LoginTestCase {
	
	WebDriver driver;
	HomePage home;
	Cart cart;
	Country country;
	int i=0;
	@BeforeTest
	public void browserlaunch()
	{
		Browser.StartBrowser("Chrome", "https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//hp=new HomePage(driver);
		cart=new Cart(driver);
		country=new Country(driver);
		home=new HomePage(driver);
		
	}
	
	@Test (priority=1)
	public void searchdata()
	{
		home.enterDatainSearchBox("Water Melon");
		home.clickOnSearchIcon();
	}
	
	@Test (dependsOnMethods= {"searchdata"})
	public void addToCart()
	{
		home.addToCart();
	}
	
	@Test
	public void anotherdatasearch()
	{
		home.enterDatainSearchBox("carrot");
		home.clickOnSearchIcon();
		home.clickOnQuantityIncrement();
		home.addToCart();
	}
	
	@Test (dependsOnMethods= {"anotherdatasearch"})
	public void addToCart1()
	{
		home.addToCart();
	}
	
	// Taking Screen shot on test fail
    @AfterMethod
    public void screenshot(ITestResult result)
    {
               i = i+1;
               String name = "ScreenShot";
               String x = name+String.valueOf(i);
              if(ITestResult.FAILURE == result.getStatus())
                {
                               Screenshot.captureScreenShot(driver, x);
                 }
}
    
    

}
