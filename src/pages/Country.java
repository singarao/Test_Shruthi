package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class Country {

	WebDriver driver;
	SoftAssert sAssert= new SoftAssert();
	public Country(WebDriver driver)
	{
		this.driver=driver;
	}


	//Locator for Country dropdown
	By country=By.xpath("//label[contains(text(),'Choose Country')]//following::select");

	//Locator for Terms and Conditions checkbox
	By TC_Checkbox=By.xpath("//input[@class='chkAgree']");

	//Locator for Terms and Conditions Error message
	By TermsAndcondErrorMessage=By.xpath("//span[@class='errorAlert']//b");

	//Locator for Proceed button
		By proceed_button=By.xpath("//button[contains(text(),'Proceed')]");

	//Locator for Order Success message
		By orderSuccess_Message=By.xpath("//div[@class='products']//span");
		
	//Method to select the country dropdown value

	public void selectCountryDropdown(String CountryName)
	{
		Select s=new Select(driver.findElement(country));
		s.selectByVisibleText(CountryName);
	}

	public void verifyTCErrorMessage() {
		String Expected_error="Please accept Terms & Conditions - Required";
		String Actual_error=driver.findElement(TermsAndcondErrorMessage).getText();

		sAssert.assertEquals(Actual_error,Expected_error);
	}

	public void selectAgreeTermsCheckBox()
	{
		driver.findElement(TC_Checkbox).click();
	}

	public void clickOnProceed()
	{
		try {
			driver.findElement(proceed_button).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.findElement(proceed_button).click();
		}
	}
	public void verifyOrderSuccessMessage()
	{
		String expected_SuccessMessage="Thank you, your order has been placed successfully";
		String actual_SuccessMessage=driver.findElement(orderSuccess_Message).getText();
		System.out.println("The success Message is" + actual_SuccessMessage);
		sAssert.assertEquals(actual_SuccessMessage, expected_SuccessMessage);
		if(expected_SuccessMessage.equalsIgnoreCase(actual_SuccessMessage))
		{
			System.out.println("The error message is displayin as expected" + actual_SuccessMessage);
		}
		else
		{
			System.out.println("The error message is not displayin as expected" + actual_SuccessMessage);
			
		}
	}
}
